package com.randysoft.playfabtest.ui.leaderboard

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.randysoft.playfabtest.R
import com.randysoft.playfabtest.adapters.LeaderBoardAdapter
import com.randysoft.playfabtest.adapters.LeaderBoardEvents
import com.randysoft.playfabtest.model.requests.LeaderBoardReq
import com.randysoft.playfabtest.model.responses.LeaderBoardRes
import com.randysoft.playfabtest.model.responses.Profile
import com.randysoft.playfabtest.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.leaderboard_fragment.*

@AndroidEntryPoint
class LeaderboardFragment : Fragment(), LeaderBoardEvents {

    companion object {
        fun newInstance() = LeaderboardFragment()
    }

    private val viewModel: LeaderboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.leaderboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init(){
        viewModel.getLeaderBoard(LeaderBoardReq("0","leaderBoard")).observe(viewLifecycleOwner,
            {
                when(it){
                    is DataState.Success<LeaderBoardRes>->{
                        Log.e("LeaderBoard",it.toString())
                        rv_leader.layoutManager = LinearLayoutManager(requireContext())
                        rv_leader.adapter = LeaderBoardAdapter(it.data.data.Leaderboard,this)
                    }
                    is DataState.Loading->{
                        Log.e("LeaderBoard","Loading")
                    }
                    is DataState.Error->{
                        Log.e("LeaderBoard","Error")
                    }
                }
            })
    }
    override fun OnShowProfileClicked(profile: Profile) {
        AlertDialog.Builder(requireContext())
            .setTitle(profile.DisplayName)
            .setMessage("Player Id : ${profile.PlayerId} \n Publisher id : ${profile.PublisherId} \n Title id :  ${profile.TitleId}")
            .setPositiveButton("Ok"
            ) { dialog, which -> dialog.dismiss()}
            .show()
    }
}
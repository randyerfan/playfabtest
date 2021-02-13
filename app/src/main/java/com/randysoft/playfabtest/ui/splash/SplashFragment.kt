package com.randysoft.playfabtest.ui.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.randysoft.playfabtest.R
import com.randysoft.playfabtest.model.requests.LoginReq
import com.randysoft.playfabtest.model.responses.LoginResponse
import com.randysoft.playfabtest.utils.DataState
import com.randysoft.playfabtest.utils.SharedPrefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by viewModels()
    @Inject lateinit var sharedPrefEditor  : SharedPrefs
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginToPlayFab(LoginReq("userTesti","Salam@99@Test","3766A"))
            .observe(viewLifecycleOwner, {
                when (it) {
                    is DataState.Loading -> {
                        Log.e("PlayFab","Loading")
                    }
                    is DataState.Success<LoginResponse?> -> {
                        Log.e("PlayFab","Response ${it}")
                        if (it.data != null) {
                            sharedPrefEditor.saveToken(it.data.data.SessionTicket)

                            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLeaderboardFragment())
                        }
                    }
                    is DataState.Error -> {
                        Log.e("PlayFab","Error")
                    }
                }
            })

    }
}
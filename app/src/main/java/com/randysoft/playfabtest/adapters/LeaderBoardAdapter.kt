package com.randysoft.playfabtest.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.randysoft.playfabtest.R
import com.randysoft.playfabtest.model.responses.LeaderBoardData
import com.randysoft.playfabtest.model.responses.Leaderboard
import com.randysoft.playfabtest.model.responses.Profile

class LeaderBoardAdapter(val items : List<Leaderboard>, val listener : LeaderBoardEvents) : RecyclerView.Adapter<LeaderBoardAdapter.LeaderViewHolder>() {

    inner class LeaderViewHolder(val item : View) : RecyclerView.ViewHolder(item){
        val displayName = item.findViewById<TextView>(R.id.txt_display_name)
        val idField = item.findViewById<TextView>(R.id.txt_id)
        val positionField = item.findViewById<TextView>(R.id.txt_position)
        val statValue = item.findViewById<TextView>(R.id.txt_stat_value)
        val btnShowProf = item.findViewById<Button>(R.id.btn_show_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderViewHolder = LeaderViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.leaderboard_item,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LeaderViewHolder, position: Int) {
        val item = items[position]
        holder.displayName.text = "name : ${item.DisplayName}"
        holder.idField.text = "id : ${item.PlayFabId}"
        holder.statValue.text = "Stat : ${item.StatValue}"
        holder.positionField.text = "Position : ${item.Position}"
        holder.btnShowProf.setOnClickListener {
            listener.OnShowProfileClicked(item.Profile)
        }
    }

    override fun getItemCount(): Int = items.size
}

interface LeaderBoardEvents{
    fun OnShowProfileClicked(profile : Profile)
}
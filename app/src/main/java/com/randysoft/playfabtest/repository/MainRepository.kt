package com.randysoft.playfabtest.repository

import com.randysoft.playfabtest.model.requests.LeaderBoardReq
import com.randysoft.playfabtest.model.requests.LoginReq
import com.randysoft.playfabtest.model.responses.LoginResponse
import com.randysoft.playfabtest.network.MainRetrofit
import com.randysoft.playfabtest.utils.DataState
import com.randysoft.playfabtest.utils.SharedPrefs
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class MainRepository(private val mainRetrofit: MainRetrofit,private val prefs : SharedPrefs) {

    suspend fun loginPlayFab(loginReq : LoginReq) = mainRetrofit.loginToPlayfab(loginReq)

    suspend fun getLeaderboard(leaderReq : LeaderBoardReq) = mainRetrofit.getLeaderboard(prefs.readToken()!!,leaderReq)
}
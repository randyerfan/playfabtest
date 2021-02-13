package com.randysoft.playfabtest.network

import com.randysoft.playfabtest.model.requests.LeaderBoardReq
import com.randysoft.playfabtest.model.requests.LoginReq
import com.randysoft.playfabtest.model.responses.LeaderBoardRes
import com.randysoft.playfabtest.model.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface MainRetrofit {
    @POST("LoginWithPlayFab")
    suspend fun loginToPlayfab(@Body loginReq : LoginReq) : Response<LoginResponse>

    @POST("GetLeaderboard")
    suspend fun getLeaderboard(@Header("X-Authorization") token : String , @Body leaderReq : LeaderBoardReq) : Response<LeaderBoardRes>
}
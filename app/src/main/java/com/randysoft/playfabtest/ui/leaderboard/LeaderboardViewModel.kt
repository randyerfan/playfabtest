package com.randysoft.playfabtest.ui.leaderboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.randysoft.playfabtest.model.requests.LeaderBoardReq
import com.randysoft.playfabtest.model.responses.LeaderBoardRes
import com.randysoft.playfabtest.model.responses.Leaderboard
import com.randysoft.playfabtest.repository.MainRepository
import com.randysoft.playfabtest.utils.DataState
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

class LeaderboardViewModel
@ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {


    fun getLeaderBoard(leaderReq: LeaderBoardReq): LiveData<DataState<LeaderBoardRes>> {
        return liveData {
            try {
                val res = mainRepository.getLeaderboard(leaderReq)
                emit(DataState.Success(res.body()!!))

            } catch (e: Exception) {
                emit(DataState.Error(e))
            } catch (e: IOException) {
                emit(DataState.Error(e))
            }
        }

    }
}
package com.randysoft.playfabtest.ui.splash

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.randysoft.playfabtest.model.requests.LoginReq
import com.randysoft.playfabtest.model.responses.LoginResponse
import com.randysoft.playfabtest.repository.MainRepository
import com.randysoft.playfabtest.utils.DataState
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import java.lang.Exception

class SplashViewModel
@ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {

    fun loginToPlayFab(loginReq: LoginReq): LiveData<DataState<LoginResponse?>> {
        return liveData(Dispatchers.IO) {
            emit(DataState.Loading)
            try {
                val res = mainRepository.loginPlayFab(loginReq)
                emit(DataState.Success(res.body()))
            }catch (e : Exception){
                e.printStackTrace()
                emit(DataState.Error(e))
            }catch (e : IOException){
                e.printStackTrace()
                emit(DataState.Error(e))
            }

        }
    }

}
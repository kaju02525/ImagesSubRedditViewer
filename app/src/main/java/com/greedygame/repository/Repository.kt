package com.greedygame.repository

import androidx.lifecycle.MutableLiveData
import com.greedygame.model.ApiResponse
import com.greedygame.network.ApiStatus.isCheckAPIStatus
import com.greedygame.network.RestClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.launch


class Repository  {

    val response = MutableLiveData<ApiResponse>()
    val errorMess = MutableLiveData<String>()

    init {
        getApiCall()
    }
        private fun getApiCall() {
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    RestClient.webServices().getAsync().await().let {
                        if (it.isSuccessful)
                            response.value = it.body()!!
                        else
                            errorMess.value=isCheckAPIStatus(it.code(),it.errorBody())
                    }
                }
                catch (e:Exception){
                    e.printStackTrace()
                    errorMess.value="Internet not available!!"
                }
            }
        }
}
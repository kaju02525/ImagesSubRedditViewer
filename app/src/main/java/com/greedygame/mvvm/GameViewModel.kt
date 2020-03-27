package com.greedygame.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greedygame.model.ApiResponse
import com.greedygame.repository.Repository

class GameViewModel : ViewModel() {

    var responseData = MutableLiveData<ApiResponse>()
    var errorData = MutableLiveData<String>()
    init {
        responseData= Repository().response
        errorData= Repository().errorMess
    }
}
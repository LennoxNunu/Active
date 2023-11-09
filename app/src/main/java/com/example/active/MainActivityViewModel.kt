package com.example.active

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.active.model.User
import com.example.active.model.UserRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRespository = UserRespository()
    var users: MutableLiveData<List<User>?> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO){
                result = userRespository.getUsers()
            }
            users.value = result
        }
    }
}
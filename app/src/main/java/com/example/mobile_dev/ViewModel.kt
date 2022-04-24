package com.example.mobile_dev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _loginEmail = MutableLiveData<String>("ys23n21@soton.ac.uk")
    val loginEmail: LiveData<String> get() = _loginEmail
    private val _loginPwd = MutableLiveData<String>("syt1234")
    val loginPwd: LiveData<String> get() = _loginPwd
    private val _nickname = MutableLiveData<String>("Yutong")
    val nickname: LiveData<String> get() = _nickname


}
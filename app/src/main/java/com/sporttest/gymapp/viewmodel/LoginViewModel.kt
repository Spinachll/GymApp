package com.sporttest.gymapp.viewmodel


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sporttest.gymapp.network.login.LoginDto
import com.sporttest.gymapp.repository.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: LoginRepository
) : ViewModel() {

    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    private val loginRequestLiveData = MutableLiveData<Boolean>()

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                //val authService = RetrofitHelper.getAuthService()
                //val responseService = authService.getLogin(LoginDto(email = email, password = password))

                val response = repo.login(
                    LoginDto(
                        login = email,
                        password = password
                    )
                )

                if (response.isSuccessful) {
                    delay(1500L)
                    isSuccessLoading.value = true
                    response.body()?.let { tokenDto ->
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                    }
                } else {
                    response.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }
                }

                loginRequestLiveData.postValue(response.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }
}
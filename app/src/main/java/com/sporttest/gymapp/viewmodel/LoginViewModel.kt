package com.sporttest.gymapp.viewmodel


import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.network.login.LoginDto
import com.sporttest.gymapp.network.user.UserDto
import com.sporttest.gymapp.network.user.UserDtoMutable
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

    // TODO Try to move it to another viewModel
    val userToken = mutableStateOf(value = "")
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    val registerUser = mutableStateOf(value = UserDtoMutable())
    private val loginRequestLiveData = MutableLiveData<Boolean>()


    fun login(email: String, password: String, context: Context) {
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
                    val dataStore = AppValuesStore(context)
                    delay(1500L)
                    response.body()?.let { tokenDto ->
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                        dataStore.saveUserToken(tokenDto.sessionToken)
                    }
                    isSuccessLoading.value = true
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

    fun register(userDto: UserDto, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                //val authService = RetrofitHelper.getAuthService()
                //val responseService = authService.getLogin(LoginDto(email = email, password = password))

                val response = repo.register(
                    userDto
                )

                if (response.isSuccessful) {
                    println("Register is good")
                    val dataStore = AppValuesStore(context)
                    delay(1500L)
                    response.body()?.let { registerDto ->
                        Log.d("Logging", "Response TokenDto: $registerDto")
                    }
                    isSuccessLoading.value = true
                } else {
                    println("Register is bad")
                    response.errorBody()?.let { error ->
                        delay(1500L)
                    }
                }
                progressBar.value = false
            } catch (e: Exception) {
                progressBar.value = false
                Log.d("Logging", "Error Authentication", e)
            }
        }
    }
}
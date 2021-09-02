package uz.mobiler.coroutines.repository

import uz.mobiler.coroutines.retrofit.ApiService

class UserRepository(val apiService: ApiService) {

    suspend fun getUsersFromJsonPlaceHolder() = apiService.getUsersFromJsoPlaceHolder()
    suspend fun getUsersFromGithub() = apiService.getUsersFromGithub()
}
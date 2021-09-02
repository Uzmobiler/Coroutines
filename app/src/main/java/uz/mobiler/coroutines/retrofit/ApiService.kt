package uz.mobiler.coroutines.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import uz.mobiler.coroutines.models.GithubUser
import uz.mobiler.coroutines.models.User

interface ApiService {

    @GET("users")
    suspend fun getUsersFromJsoPlaceHolder(): List<User>

    @GET("users")
    suspend fun getUsersFromGithub(): List<GithubUser>
}
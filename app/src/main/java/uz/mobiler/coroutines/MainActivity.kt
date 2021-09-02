package uz.mobiler.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import uz.mobiler.coroutines.databinding.ActivityMainBinding
import uz.mobiler.coroutines.models.User
import uz.mobiler.coroutines.retrofit.ApiClient
import uz.mobiler.coroutines.utils.Status
import uz.mobiler.coroutines.viewmodels.UserViewModel
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
                Status.SUCCESS -> {
                    binding.tv.text = it.data
                }
            }
        })
    }

}
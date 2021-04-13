package com.riskpace.demo.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.riskpace.demo.R
import com.riskpace.demo.data.preferences.PreferenceManager
import com.riskpace.demo.data.roomdatabase.AppDatabase.Companion.getDatabase
import com.riskpace.demo.data.roomdatabase.userdata.UserDataDao
import com.riskpace.demo.data.roomdatabase.userdata.UserDataItem
import com.riskpace.demo.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var viewModel: AuthenticationViewModel
    private lateinit var tName: TextView
    private lateinit var tPass: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        tName = root.findViewById(R.id.name)
        tPass = root.findViewById(R.id.password)

        val name = viewModel.userName()
        tName.text = "User-name: $name"
        val pass = viewModel.userPass()
        tPass.text = "Password: $pass"

//        val name = getPreference.getString("name", null).toString()
//        val password = sharedPreferences.getString("password", null).toString()
//        val email = sharedPreferences.getString("email", null).toString()

//        when {
//            item == null -> isLogin?.invoke(AuthenticationViewModel.USER_NOT_EXIST)
//            else -> {
//                getPreference().putString(PreferenceManager.USER_NAME, userName)
//                getPreference().putString(PreferenceManager.PASSWORD, password)
//                isLogin?.invoke(AuthenticationViewModel.SUCCESS)
//            }
//        }
//    }
//        tEmail.text = "Your Email: $email"
//        tPass.text = "Your Password: $password"
        return root
    }
}
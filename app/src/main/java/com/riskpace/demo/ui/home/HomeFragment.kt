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
import com.riskpace.demo.viewmodel.AuthenticationViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var userdata: UserDataDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val tName: TextView = root.findViewById(R.id.name)
        val tEmail: TextView = root.findViewById(R.id.email)
        val tPass: TextView = root.findViewById(R.id.password)
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val item = getDatabase().getUserDetailDao()
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
        tName.text = "Your Name: $item"
//        tEmail.text = "Your Email: $email"
//        tPass.text = "Your Password: $password"
        return root
    }
}
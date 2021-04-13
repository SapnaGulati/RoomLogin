package com.riskpace.demo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.riskpace.demo.R
import com.riskpace.demo.viewmodel.AuthenticationViewModel

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
        tName.text = "User-name : $name"
        val pass = viewModel.userPass()
        tPass.text = "Password : $pass"
        return root
    }
}
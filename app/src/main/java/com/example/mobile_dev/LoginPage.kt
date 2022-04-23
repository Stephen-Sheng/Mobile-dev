package com.example.mobile_dev

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobile_dev.databinding.LoginPageFragmentBinding


class LoginPage : Fragment() {
    private var _binding: LoginPageFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = LoginPage()
    }
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginPageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("LOGIN", "onCLick2")
        binding.LoginBtn.setOnClickListener {
            // Button Tapped
            loginBtnOnClick()
        }

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        // TODO: Use the ViewModel

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun loginBtnOnClick(){
        val text = "Hello toast!"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(context, text, duration).show()

    }

}
package com.example.mobile_dev

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobile_dev.databinding.LoginPageFragmentBinding


class LoginPage : Fragment() {
    private var _binding: LoginPageFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = LoginPage()
    }

    // delegate by viewModels, to prevent lose the state of view model
    private val viewModel: ViewModel by activityViewModels()

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
//        viewModel = ViewModelProvider(this)[ViewModel::class.java]
//        // TODO: Use the ViewModel

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun loginBtnOnClick(){

        //yutong
        val texts = "Welcome! ${viewModel.nickname.value}"
        val textf = "Invalid email or password,please try again"
        val duration = Toast.LENGTH_SHORT
        val emailInput = binding.editTextTextEmailAddress.text.toString()
        val pwdInput = binding.editTextTextPassword.text.toString()
        //zhihong
        val texts_zhihong = "Welcome! ${viewModel.nickname2.value}"
        if(emailInput == viewModel.loginEmail.value && pwdInput == viewModel.loginPwd.value){
            Toast.makeText(context, texts, duration).show()
            findNavController().navigate(R.id.action_loginPage_to_projectListPageFragment)
        }
        //zhihong
        else if(emailInput == viewModel.loginEmail2.value && pwdInput == viewModel.loginPwd2.value){
            Toast.makeText(context, texts_zhihong, duration).show()
            findNavController().navigate(R.id.action_loginPage_to_employeeTaskListFragment)
        } //zhihong

        else{
            Toast.makeText(context, textf, duration).show()
        }




    }

}
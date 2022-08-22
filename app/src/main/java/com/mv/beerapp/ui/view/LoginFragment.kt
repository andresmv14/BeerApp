package com.mv.beerapp.ui.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.mv.beerapp.R
import com.mv.beerapp.ui.viewmodel.LoginViewModel
import kotlin.system.exitProcess


class LoginFragment : Fragment() {
    private lateinit var etUser: TextInputLayout
    private lateinit var etPass: TextInputLayout
    private lateinit var btnLogin:Button
    private lateinit var btnRegisterBeer: Button
    private val viewModel:LoginViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        etUser = view.findViewById(R.id.etUsuario)
        etPass = view.findViewById(R.id.etPass)

        btnLogin = view.findViewById(R.id.btnLogin)
        btnRegisterBeer = view.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            if (etUser.editText?.text.toString().isNotEmpty() and etPass.editText?.text.toString().isNotEmpty()) {
                viewModel.loginUser(
                    etUser.editText?.text.toString(),
                    etPass.editText?.text.toString()
                )
                viewModel.loginCorrecto.observe(viewLifecycleOwner) {
                    if (it) {
                        view!!.findNavController().navigate(R.id.action_loginFragment_to_navb)
                    } else {
                        etUser.isErrorEnabled = true
                        etPass.isErrorEnabled = true
                        etUser.error = "Usuario o contraseña incorrecta"
                    }


                }
            }else{
                etUser.isErrorEnabled = true
                etPass.isErrorEnabled = true
                etUser.error = "Rellene todos los campos"
            }

        }

        btnRegisterBeer.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerBeer)
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    activity?.finish()
                    exitProcess(0)

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }


}
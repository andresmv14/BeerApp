package com.mv.beerapp.ui.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.mv.beerapp.R
import com.mv.beerapp.ui.viewmodel.RegistroViewModel


class RegisterBeer : Fragment() {

    private lateinit var etUser:TextInputLayout
    private lateinit var etPass:TextInputLayout
    private lateinit var btnRegistrar:Button
    private val viewModel: RegistroViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_beer, container, false)

        etUser = view.findViewById(R.id.etUserR)
        etPass = view.findViewById(R.id.etPassR)
        btnRegistrar = view.findViewById(R.id.btnRegister)

        btnRegistrar.setOnClickListener {
            if (etUser.editText?.text.toString().isNotEmpty() and etPass.editText?.text.toString().isNotEmpty()){
                viewModel.guardarUsuario(etUser.editText?.text.toString(), etPass.editText?.text.toString())
            viewModel.operacionExistosa.observe(viewLifecycleOwner){
                if (it){
                    Toast.makeText(requireContext(),"Usuario Creado",Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_registerBeer_to_loginFragment)
                }else{
                    Toast.makeText(requireContext(),"Usuario no creado",Toast.LENGTH_LONG).show()
                }
            }
        }else{
                etUser.isErrorEnabled = true
                etPass.isErrorEnabled = true
                etUser.error = "Rellene todos los campos"
            }
        }
        // Inflate the layout for this fragment
        return view
    }


}
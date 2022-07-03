package com.mv.beerapp.ui.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.mv.beerapp.R
import com.mv.beerapp.databinding.ActivityMainBinding
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.mv.beerapp.ui.viewmodel.RegistroViewModel


class RegisterBeer : Fragment() {

    lateinit var etUser:TextInputLayout
    lateinit var etPass:TextInputLayout
    lateinit var btnRegistrar:Button
    private val viewModel: RegistroViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_beer, container, false)

        etUser = view.findViewById<TextInputLayout?>(R.id.etUser)
        etPass = view.findViewById(R.id.etPass)
        btnRegistrar = view.findViewById(R.id.btnRegister)

        btnRegistrar.setOnClickListener {
                viewModel.guardarUsuario(etUser.editText?.text.toString(), etPass.editText?.text.toString())
            viewModel.operacionExistosa.observe(viewLifecycleOwner, Observer {
                if (it){
                    Toast.makeText(requireContext(),"Usuario Creado",Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_registerBeer_to_loginFragment)
                }else{
                    Toast.makeText(requireContext(),"Usuario no creado",Toast.LENGTH_LONG).show()
                }
            })
        }
        // Inflate the layout for this fragment
        return view
    }


}
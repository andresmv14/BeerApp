package com.mv.beerapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.mv.beerapp.R


class loginFragment : Fragment() {
    lateinit var btnLogin:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        btnLogin = view.findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            findNavController().navigate(R.id.loginToPrincipal)
        }
        // Inflate the layout for this fragment
        return view
    }


}
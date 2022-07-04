package com.mv.beerapp.ui.view


import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.activity.OnBackPressedCallback
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext

import androidx.fragment.app.activityViewModels

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mv.beerapp.R

import com.mv.beerapp.ui.view.adapter.BeerAdapter

import com.mv.beerapp.ui.viewmodel.BeerViewModel


class principalFragment : Fragment()  {
    lateinit var btnSalir:Button
    lateinit var btnFavoritos:Button
    private val beerViewModel: BeerViewModel by activityViewModels()
    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_principal, container, false)

        btnFavoritos = view.findViewById(R.id.btnfavoritos)
        btnFavoritos.setOnClickListener {
            findNavController().navigate(R.id.action_principalFragment_to_favoritos2)
        }
        btnSalir = view.findViewById(R.id.salir)
        btnSalir.setOnClickListener {
            view.findViewById<ComposeView>(R.id.compose_view).setContent { alertDialog() }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerBeer)
        recyclerView.layoutManager =LinearLayoutManager(requireContext())
        beerViewModel.onCreate()
        beerViewModel.beerModel.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = BeerAdapter(it,{beerItem -> beerViewModel.onBeerClicked(beerItem)
                findNavController().navigate(R.id.prinToDeta)})

        })



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
                    System.exit(0)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    @Composable
    fun alertDialog(){
        val openDialog = remember{ mutableStateOf(true)}

        if (openDialog.value){
            AlertDialog(
                onDismissRequest = {openDialog.value = false},
                title = { Text(text = "Alerta", color = Color.Black) },
                text = {Text(text = "¿Estas seguro que deseas salir?", color = Color.Black)},
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            activity?.finish()
                            System.exit(0)
                        }) {
                        Text(text = "Confirmar", color = Color.Black)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text(text ="Calcelar", color = Color.Black)
                    }
                },
            )
        }

    }



}
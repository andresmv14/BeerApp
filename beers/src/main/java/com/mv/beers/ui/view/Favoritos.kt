package com.mv.beers.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mv.beers.R
import com.mv.beers.ui.view.adapter.adapter.FavAdapter
import com.mv.beers.ui.viewmodel.FavoritosViewModel


class Favoritos : Fragment() {
    private lateinit var btnRegresar:Button
    private val viewModel: FavoritosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoritos, container, false)
        btnRegresar = view.findViewById(R.id.btnSalir)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerFavoritos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.onCreate()
        viewModel.beerFavoritos.observe(viewLifecycleOwner) {
            recyclerView.adapter = FavAdapter(it)

        }

        btnRegresar.setOnClickListener {
            findNavController().navigate(R.id.action_favoritos_to_principalFragment)
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
                    findNavController().navigate(R.id.action_favoritos_to_principalFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }


}
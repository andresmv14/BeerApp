package com.mv.beerapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.databinding.ActivityMainBinding
import com.mv.beerapp.ui.view.adapter.BeerAdapter
import com.mv.beerapp.ui.viewmodel.BeerViewModel


class principalFragment : Fragment()  {
    lateinit var miRecycler: RecyclerView
    lateinit var adaptador:BeerAdapter
    private lateinit var binding: ActivityMainBinding
    private val beerViewModel: BeerViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_principal, container, false)



        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerBeer)
        recyclerView.layoutManager =LinearLayoutManager(requireContext())
        beerViewModel.onCreate()
        beerViewModel.beerModel.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = BeerAdapter(it)
        })



        // Inflate the layout for this fragment
            return view
    }



}
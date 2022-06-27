package com.mv.beerapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerDescription
import com.mv.beerapp.ui.viewmodel.BeerDetailModel
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.squareup.picasso.Picasso


class ventanaDetalles : Fragment() {
    lateinit var ivDImage:ImageView
    lateinit var tvDname:TextView
    lateinit var tvDescription:TextView
    lateinit var tvdTagLine:TextView
    lateinit var btnRetroceso:Button
    private val beerViewModel: BeerViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ventana_detalles, container, false)
        btnRetroceso = view.findViewById(R.id.retroceso)
        ivDImage = view.findViewById(R.id.tvDImage)
        tvDname = view.findViewById(R.id.tvDName)
        tvDescription = view.findViewById(R.id.tvDdescription)
        tvdTagLine = view.findViewById(R.id.tvDTagline)

        beerViewModel.beerDetail.observe(viewLifecycleOwner, Observer {
            tvDname.text = it.name
            tvDescription.text = it.description
            tvdTagLine.text = it.tagLine
            Picasso.get().load(it.image).into(ivDImage)
        })
        btnRetroceso.setOnClickListener {
            findNavController().navigate(R.id.action_ventanaDetalles_to_principalFragment)
        }

        // Inflate the layout for this fragment
        return view


    }


}
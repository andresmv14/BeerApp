package com.mv.beerapp.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mv.beerapp.R
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.squareup.picasso.Picasso



class ventanaDetalles : Fragment() {
    lateinit var ivDImage: ImageView
    lateinit var tvDname: TextView
    lateinit var tvDescription: TextView
    lateinit var tvdTagLine: TextView
    lateinit var btnRetroceso: Button
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
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_ventanaDetalles_to_principalFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

}

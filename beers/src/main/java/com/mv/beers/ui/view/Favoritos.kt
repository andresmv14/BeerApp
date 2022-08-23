package com.mv.beers.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mv.beers.R
import com.mv.beers.common.Event
import com.mv.beers.domain.entity.FavoriteBeer
import com.mv.beers.ui.view.adapter.adapter.FavAdapter
import com.mv.beers.ui.viewmodel.FavoriteViewModel


class Favoritos : Fragment() {

    private val viewModel: FavoriteViewModel by viewModels()

    private lateinit var btnBack: Button
    private lateinit var tvEmptyList: TextView
    private lateinit var rvFavoriteList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.viewModel.events.observe(this, Observer(this::validateEvents))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoritos, container, false)

        this.initFragment(view)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.getFavoriteList()
        this.setupButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_favoritos_to_principalFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    private fun initFragment(view: View) {
        this.btnBack = view.findViewById(R.id.btnBack)
        this.rvFavoriteList = view.findViewById(R.id.rvFavorites)
        this.tvEmptyList = view.findViewById(R.id.tvEmptyList)

        this.viewModel.setAdapterInRecyclerView(this.rvFavoriteList)
    }

    private fun setupButton() {
        this.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_favoritos_to_principalFragment)
        }
    }

    private fun getFavoriteList() {
        this.viewModel.getAllFavoriteList()
    }

    private fun validateIfListIsEmpty(lstItems: List<FavoriteBeer>) {
        this.viewModel.setItemsIntoRecycler(lstItems)

        this.tvEmptyList.visibility = if (lstItems.isEmpty()) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    private fun validateEvents(events: Event<FavoriteViewModel.FavoritesAction>) {
        events.getContentIfNotHandled()?.let { event ->
            when (event) {
                is FavoriteViewModel.FavoritesAction.GetAllFavoriteListResponse -> {
                    event.run {
                        validateIfListIsEmpty(this.response)
                    }
                }
                FavoriteViewModel.FavoritesAction.EmptyList -> {
                    this.validateIfListIsEmpty(listOf())
                }
            }
        }
    }
}
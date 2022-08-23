package com.mv.beers.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.mv.beers.common.Event
import com.mv.beers.domain.entity.FavoriteBeer
import com.mv.beers.domain.use_case.FavoriteUseCase
import com.mv.beers.ui.view.adapter.adapter.FavAdapter
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val useCase = FavoriteUseCase()

    private val _events = MutableLiveData<Event<FavoritesAction>>()
    val events: LiveData<Event<FavoritesAction>> get() = _events

    private lateinit var adapter: FavAdapter

    fun getAllFavoriteList() {
        viewModelScope.launch {
            val response = useCase.getAllFavoritesBeer()

            if (response.isNotEmpty()) {
                _events.postValue(
                    Event(
                        FavoritesAction.GetAllFavoriteListResponse(
                            response = response
                        )
                    )
                )
            } else {
                _events.postValue(
                    Event(
                        FavoritesAction.EmptyList
                    )
                )
            }
        }
    }

    fun setAdapterInRecyclerView(
        recycler: RecyclerView
    ) {
        recycler.apply {
            val adapter = FavAdapter()

            this.adapter = adapter
            this@FavoriteViewModel.adapter = adapter
        }
    }

    fun setItemsIntoRecycler(lstFavBeer: List<FavoriteBeer>) {
        this.adapter.setDataInRecycler(lstFavBeer)
        this.adapter.notifyDataSetChanged()
    }

    sealed class FavoritesAction {
        class GetAllFavoriteListResponse(
            val response: List<FavoriteBeer>
        ) : FavoritesAction()

        object EmptyList: FavoritesAction()
    }
}
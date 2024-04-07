package com.jhonny.punkbeer.presenter.favorites

import com.jhonny.punkbeer.presenter.MainActivity
import com.jhonny.punkbeer.presenter.base.BaseViewModel
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor() : BaseViewModel() {
    private val _beer = MutableStateFlow<List<CocktailPresentation?>>(emptyList())
    val beer: StateFlow<List<CocktailPresentation?>> = _beer

    private val _errorHandling = MutableStateFlow(Exception())
    val errorHandling: StateFlow<Exception> = _errorHandling
    var name: String = ""

    fun getCocktails() {
        _beer.value = MainActivity.FavoritesSingletonList.instance
    }

    fun isFavorite(cocktail: CocktailPresentation) =
        _beer.value.find { it?.strDrink == cocktail.strDrink }?.isFavorite

     fun updateFavoriteList(cocktail: CocktailPresentation) {
         cocktail.isFavorite = !cocktail.isFavorite
         if(cocktail.isFavorite) {
             if (MainActivity.FavoritesSingletonList.instance.find { cocktail.strDrink == it.strDrink } == null)
                 MainActivity.FavoritesSingletonList.instance.add(cocktail)
         }  else
             MainActivity.FavoritesSingletonList.instance.remove(MainActivity.FavoritesSingletonList.instance.find { cocktail.strDrink == it.strDrink })
         _beer.value.find { it?.strDrink == cocktail.strDrink }?.isFavorite = cocktail.isFavorite
     }

    fun updateLocalList() {
        MainActivity.FavoritesSingletonList.instance.forEach{ favorite ->
            _beer.value.find { favorite.strDrink == it?.strDrink }?.isFavorite = true
        }
    }

}


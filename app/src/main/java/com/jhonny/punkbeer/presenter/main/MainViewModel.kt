package com.jhonny.punkbeer.presenter.main

import android.util.Log
import com.jhonny.punkbeer.data.dataOrNull
import com.jhonny.punkbeer.data.getError
import com.jhonny.punkbeer.data.isError
import com.jhonny.punkbeer.data.isSuccess
import com.jhonny.punkbeer.domain.usecases.GetCocktailsByNameUseCase
import com.jhonny.punkbeer.domain.usecases.GetCocktailsUseCase
import com.jhonny.punkbeer.extensions.launch
import com.jhonny.punkbeer.presenter.MainActivity
import com.jhonny.punkbeer.presenter.base.BaseViewModel
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCocktailsUseCase: GetCocktailsUseCase,
    private val getCocktailsByNameUseCase: GetCocktailsByNameUseCase,
) : BaseViewModel() {
    private val _beer = MutableStateFlow<List<CocktailPresentation?>>(emptyList())
    val beer: StateFlow<List<CocktailPresentation?>> = _beer
    private val _favorites = MutableStateFlow<List<CocktailPresentation?>>(emptyList())
    val favorites: StateFlow<List<CocktailPresentation?>> = _favorites

    private val _errorHandling = MutableStateFlow(Exception())
    val errorHandling: StateFlow<Exception> = _errorHandling
    var name: String = ""
    private var textToSearch: String = ""

    fun getDrinks() = beer
    fun setDrinks(beer: List<CocktailPresentation>){
        _beer.value = beer
    }

    fun getCocktails() {
        if (textToSearch.isEmpty())
            launch {
                getCocktailsUseCase(name).let { result ->
                    when {
                        result.isSuccess ->
                            result.dataOrNull()?.let { cocktailPresentation ->
                                _beer.value = cocktailPresentation.list ?: emptyList()
                                updateLocalList()
                            }
                        result.isError -> {
                            _errorHandling.value = result.getError()
                        }
                        else -> {}
                    }
                }
            }
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

            fun geBeersByName(beerName: String) {
                _beer.value = emptyList()
                textToSearch = beerName
                if (textToSearch.isNotEmpty()) {
                    launch {
                        getCocktailsByNameUseCase(beerName).let { result ->
                            when {
                                result.isSuccess ->
                                    result.dataOrNull()?.let { beerPresentation ->
                                        _beer.value = beerPresentation.list ?: emptyList()
                                        updateLocalList()
                                    }

                                result.isError -> {
                                    _errorHandling.value = result.getError()
                                }
                            }
                        }

                    }
                }
            }

}


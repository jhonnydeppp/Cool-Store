package com.jhonny.punkbeer

import com.jhonny.punkbeer.domain.usecases.GetCocktailsByNameUseCase
import com.jhonny.punkbeer.domain.usecases.GetCocktailsUseCase
import com.jhonny.punkbeer.presenter.MainActivity
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import com.jhonny.punkbeer.presenter.main.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * This is a good test
 *
 * This is a complex test
 */
@ExperimentalCoroutinesApi
class CocktailUnitTest {

    private lateinit var viewModel: MainViewModel
    private val getCocktailsUseCase: GetCocktailsUseCase = mockk()
    private val getCocktailsByNameUseCase: GetCocktailsByNameUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = MainViewModel(getCocktailsUseCase, getCocktailsByNameUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test updateFavoriteList when cocktail is favorite`() = runBlockingTest {
        // Given
        val cocktail = CocktailPresentation("Mojito", "drum", isFavorite = true)
        MainActivity.FavoritesSingletonList.instance.add(cocktail)

        // When
        viewModel.updateFavoriteList(cocktail)

        // Then
        assert(!cocktail.isFavorite)
        assert(MainActivity.FavoritesSingletonList.instance.firstOrNull { it.strDrink == "Mojito" } == null)
    }

    @Test
    fun `test updateFavoriteList when cocktail is not in favorites`() = runBlockingTest {
        // Given
        val cocktail = CocktailPresentation("Mojito", "drum", isFavorite = false)
        viewModel.setDrinks(listOf(cocktail))

        // When
        viewModel.updateFavoriteList(cocktail)

        // Then
        assert(cocktail.isFavorite)
        assert(MainActivity.FavoritesSingletonList.instance.firstOrNull { it.strDrink == "Mojito" } == cocktail)
    }

}
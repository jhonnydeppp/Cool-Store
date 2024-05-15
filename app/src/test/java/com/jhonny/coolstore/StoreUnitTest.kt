package com.jhonny.coolstore

import com.jhonny.coolstore.domain.usecases.GetProductsUseCase

import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import com.jhonny.coolstore.presenter.resume.ResumeViewModel
import com.jhonny.coolstore.presenter.main.MainViewModel
import io.mockk.clearAllMocks
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

/**
 * This is a good test
 */
@ExperimentalCoroutinesApi
class StoreUnitTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var resumeViewModel: ResumeViewModel
    private val getProductsUseCase: GetProductsUseCase = mockk()
    private val productList = listOf(ProductPresentationItem(code="VOUCHER", name = "Cabify Voucher", price = 5f, number = 0 ),
        ProductPresentationItem(code="TSHIRT", name = "Cabify T-Shirt", price = 20f, number = 0 ),
        ProductPresentationItem(code="MUG", name = "Cabify Coffee Mug", price = 7.5f, number = 0 ))
    @Before
    fun setUp() {
        viewModel = MainViewModel(getProductsUseCase)
        resumeViewModel = ResumeViewModel()
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `TSHIRT offer test`() = runBlockingTest {
        val product = productList.find { it.code== "TSHIRT" }
        val interactions =Random.nextInt(0, 100)
        repeat(interactions) {
            val randomNumber = Random.nextInt(0, 100)
            product?.number = randomNumber
            val totalOffer = resumeViewModel.calculateOffer(product)

            var verifyOffer: Float = (product?.price?: 0).toFloat() * (product?.number?: 0).toFloat()
            if((product?.number ?: 0) >= 3) {
                verifyOffer-= product?.number?: 0
            }

            println("$totalOffer = $verifyOffer")
            assertEquals(totalOffer , verifyOffer)
        }
        println("interactions = $interactions")
    }

    @Test
    fun `VOUCHER offer test`() = runBlockingTest {
        val product = productList.find { it.code== "VOUCHER" }
        val interactions =Random.nextInt(0, 100)
        repeat(interactions) {
            val randomNumber = Random.nextInt(0, 100)
            product?.number = randomNumber
            val totalOffer = resumeViewModel.calculateOffer(product)

            var verifyOffer: Float = (product?.price?: 0).toFloat() * (product?.number?: 0).toFloat()

            if((product?.number ?: 0) >= 2) {
                verifyOffer-= (product?.price ?: 0).toFloat() * ((product?.number ?: 0) / 2)
            }

            println("$totalOffer = $verifyOffer")
            assertEquals(totalOffer , verifyOffer)
        }
        println("interactions = $interactions")
    }


}
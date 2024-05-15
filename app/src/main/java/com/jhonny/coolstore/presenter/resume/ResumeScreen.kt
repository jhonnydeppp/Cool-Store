package com.jhonny.coolstore.presenter.resume

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jhonny.coolstore.extensions.isScrolledToTheEnd
import com.jhonny.coolstore.presenter.composables.AlertDialogExample
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import com.jhonny.coolstore.presenter.navigation.AppScreens
import com.jhonny.coolstore.ui.theme.MainTheme
import com.jhonny.coolstore.util.IMAGE_LIST
import com.jhonny.coolstore.util.orEmpty
import com.jhonny.coolstore.util.setStyleBold
import com.jhonny.coolstore.util.setStyleBoldRed


private lateinit var viewModel: ResumeViewModel
@Composable
fun ResumeScreen(navController: NavController) {
    viewModel = hiltViewModel()
    viewModel.getProducts()
    val productList by viewModel.products.collectAsState()
    val errorHandling by viewModel.errorHandling.collectAsState()
    val purchase by viewModel.purchase.collectAsState()
    MainTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                if (errorHandling.message != null) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = "https://cdn0.iconfinder.com/data/icons/tools-41/432/not-found-512.png",
                            contentDescription = "empty image",
                            modifier = Modifier
                                .size(128.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(24.dp))
                        )
                    }
                } else {
                    ProductList(productList, navController)

                    Spacer(modifier = Modifier.weight(1.0F))
                    Text(setStyleBold("Importe Total: ", viewModel.calculateTotal().toString()),
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End))
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        viewModel.setPurchase(true)
                    },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        modifier = Modifier
                            .padding(vertical = 6.dp, horizontal = 8.dp)
                            .fillMaxWidth()) {
                        Text("Pagar")
                    }
                    Button(onClick = {
                        navController.popBackStack()
                    },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        modifier = Modifier
                            .padding(vertical = 6.dp, horizontal = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Regresar")
                    }
                }
            }
        }
        if(purchase){


            val actionDescription =
            if(viewModel.calculateTotal() == 0.0f)
                "Todavia no tiene articulos para comprar"
            else
                "Gracias por su compra"

            AlertDialogExample({
                viewModel.resetQuantities()
                navController.popBackStack()
                               },"Información",actionDescription)
        }
    }
}

@Composable
fun ProductList(productList: List<ProductPresentationItem?>, navController: NavController?) {
    val state = rememberLazyListState()
    LazyColumn(state = state, modifier = Modifier.padding(start = 16.dp, end = 8.dp) ) {
        items(productList) { cocktailItem ->
            ProductItem(cocktailItem, navController)
        }
    }
    if(state.isScrolledToTheEnd()){
        // load more paginated
    }
}

@Composable
fun ProductItem(product: ProductPresentationItem?, navController: NavController?) {

    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .clickable {
                navController?.currentBackStackEntry?.savedStateHandle?.set(
                    key = "beer",
                    value = product
                )
                navController?.navigate("${AppScreens.DetailScreen.route}/${product?.name}")
            }
    ) {

        AsyncImage(
            model = IMAGE_LIST.find { it.code == product?.code }?.image,
            contentDescription = "product image",
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(24.dp))
        )


        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .heightIn(min = 128.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Nombre: ", product?.name.orEmpty()))
            Spacer(modifier = Modifier.weight(0.5F))
            Text(setStyleBold("Codigo: ", product?.code.orEmpty()))
            Spacer(modifier = Modifier.weight(0.5F))
            Text(setStyleBold("Precio: ", product?.price.orEmpty().toString()))
            Spacer(modifier = Modifier.weight(0.5F))
            Text(setStyleBold("Cantidad: ", product?.number.toString()))
            Spacer(modifier = Modifier.weight(0.5F))
            Text(setStyleBold("Total: ", viewModel.calculateOffer(product).toString()))

            Spacer(modifier = Modifier.weight(1.0F))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                product?.let {
                    Text(setStyleBoldRed("Oferta especial por: ",
                        viewModel.offerText(product)
                    ))
                    Spacer(modifier = Modifier.weight(0.5F))
                }
            }
            Spacer(modifier = Modifier.weight(1.0F))
        }
    }
}
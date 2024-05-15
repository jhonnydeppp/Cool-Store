package com.jhonny.coolstore.presenter.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import com.jhonny.coolstore.util.IMAGE_LIST
import com.jhonny.coolstore.util.orEmpty
import com.jhonny.coolstore.util.setStyleBold


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, productDetail: ProductPresentationItem) {
    Scaffold {
        Body(productDetail, navController)
    }
}

@Composable
fun Body(product: ProductPresentationItem, navController: NavController) {
    BeerDetail(product, navController)
}

@Composable
fun BeerDetail(product: ProductPresentationItem, navController: NavController) {
        Column(modifier = Modifier
            .heightIn(min = 128.dp)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1.0F))
            AsyncImage(
                model = IMAGE_LIST.find { it.code == product?.code }?.image,
                contentDescription = "beer image",
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Nombre: ", product.name.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Codigo: ", product.code.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Precio: ", product.price.orEmpty().toString()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("numero: ", product.number.orEmpty().toString()))
            Spacer(modifier = Modifier.weight(1.0F))

            Spacer(modifier = Modifier.weight(10.0F))
            Spacer(modifier = Modifier.weight(1.0F))
            Button(onClick = {
                navController.popBackStack()
            }, colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Regresar")
            }
            Spacer(modifier = Modifier.weight(1.0F))
        }
}
package com.jhonny.punkbeer.presenter.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import com.jhonny.punkbeer.util.setStyleBold


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, beerDetail: CocktailPresentation) {
    Scaffold {
        Body(beerDetail, navController)
    }
}

@Composable
fun Body(beer: CocktailPresentation, navController: NavController) {
    BeerDetail(beer, navController)
}

@Composable
fun BeerDetail(cocktail: CocktailPresentation, navController: NavController) {
        Column(modifier = Modifier
            .heightIn(min = 128.dp)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1.0F))
            AsyncImage(
                model = cocktail.strDrinkThumb.orEmpty(),
                contentDescription = "beer image",
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Nombre: ", cocktail?.strDrink.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Category: ", cocktail?.strCategory.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Alcoholic: ", cocktail?.strAlcoholic.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Instructions: ", cocktail?.strInstructions.orEmpty()))
            Spacer(modifier = Modifier.weight(1.0F))
            Text(setStyleBold("Ingredient  : ", cocktail?.strIngredient.orEmpty()))
            Spacer(modifier = Modifier.weight(10.0F))
            Spacer(modifier = Modifier.weight(1.0F))
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Regresar")
            }
            Spacer(modifier = Modifier.weight(1.0F))
        }
}
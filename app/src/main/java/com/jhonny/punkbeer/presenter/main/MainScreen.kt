package com.jhonny.punkbeer.presenter.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jhonny.punkbeer.extensions.isScrolledToTheEnd
import com.jhonny.punkbeer.presenter.composables.FavoriteButton
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import com.jhonny.punkbeer.presenter.navigation.AppScreens
import com.jhonny.punkbeer.ui.theme.MainTheme
import com.jhonny.punkbeer.util.setStyleBold

private lateinit var viewModel: MainViewModel

@Composable
fun MainScreen(navController: NavController) {
    viewModel = hiltViewModel()
    viewModel.getCocktails()
    val cocktailList by viewModel.beer.collectAsState()
    val errorHandling by viewModel.errorHandling.collectAsState()
    MainTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                SearchBar(viewModel)
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
                    CocktailList(cocktailList, navController)
                }
            }
        }
    }
}

@Composable
fun SearchBar(viewModel: MainViewModel?) {
    val (value, onValueChange) = remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 17.sp),
            leadingIcon = {
                IconButton(onClick = {
                    if (value.isNotEmpty()) {
                        viewModel?.geBeersByName(value)
                    }
                }) {
                    Icon(Icons.Filled.Search, null, tint = Color.Gray)
                }
            },
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp, end = 10.dp, top = 20.dp, bottom = 10.dp)
                .background(Color(0xFFE7F1F1), RoundedCornerShape(16.dp)),
            placeholder = { Text(text = "Search your drink") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )
    }
}
@Composable
fun CocktailList(cocktailList: List<CocktailPresentation?>, navController: NavController?) {
    val state = rememberLazyListState()
    LazyColumn(state = state, modifier = Modifier.padding(start = 16.dp, end = 8.dp) ) {
        items(cocktailList) { cocktailItem ->
            CocktailItem(cocktailItem, navController)
        }
    }
    if(state.isScrolledToTheEnd()){
       // load more paginated
    }
}

@Composable
fun CocktailItem(cocktail: CocktailPresentation?, navController: NavController?) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .clickable {
                navController?.currentBackStackEntry?.savedStateHandle?.set(
                    key = "beer",
                    value = cocktail
                )
                navController?.navigate("${AppScreens.DetailScreen.route}/${cocktail?.strDrink}")
            }
    ) {

        AsyncImage(
            model = cocktail?.strDrinkThumb.orEmpty(),
            contentDescription = "cocktail image",
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
                Text(setStyleBold("Nombre: ", cocktail?.strDrink.orEmpty()))
                Spacer(modifier = Modifier.weight(0.5F))
                Text(setStyleBold("Category: ", cocktail?.strCategory.orEmpty()))
                Spacer(modifier = Modifier.weight(0.5F))
                Text(setStyleBold("Alcoholic: ", cocktail?.strAlcoholic.orEmpty()))
                Spacer(modifier = Modifier.weight(1.0F))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    cocktail?.let {
                        FavoriteButton(viewModel.isFavorite(cocktail)?: false) {
                            //cocktail.isFavorite = !cocktail.isFavorite
                            viewModel.updateFavoriteList(cocktail)
                            viewModel.updateLocalList()
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1.0F))
            }
    }
}

@Preview(showBackground = true)
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBar(null)
            Text(text = "Search your Drink", textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp))
            CocktailList(
                listOf(CocktailPresentation(), CocktailPresentation(),CocktailPresentation()),
                null
                )
        }
    }
}

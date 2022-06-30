package com.flexcode.yummy.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.flexcode.yummy.domain.models.Meals
import com.flexcode.yummy.presentation.destinations.MealDetailsScreenDestination
import com.flexcode.yummy.presentation.destinations.MealsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MealItem(
    meals: Meals,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable {
                /*navigator.navigate(
                    MealDetailsScreenDestination(
                        Meals(idMeal = meals.idMeal)
                    )
                ){
                    popUpTo(route = MealsScreenDestination.routeId){
                        inclusive = true
                    }
                }*/
                navigator.navigate(MealDetailsScreenDestination(meals))
            }
        ,
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${meals.strMealThumb}")
                    .crossfade(true)
                    .build(),
                contentDescription = "${meals.strMeal}",
                contentScale = ContentScale.Inside,
                modifier = modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable {

                    }
                    .wrapContentSize(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Text(
                    text = "${meals.strMeal}",
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }


        }
    }

}


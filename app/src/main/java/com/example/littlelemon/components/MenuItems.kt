package com.example.littlelemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.littlelemon.database.MenuItemRoom
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlight

@Composable
fun MenuItems(menu: List<MenuItemRoom>) {
    LazyColumn {
        items(menu.size) { index ->
            Item(menuItem = menu[index])
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Item(menuItem: MenuItemRoom) {
    Card(
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = menuItem.title,
                    style = KarlaTypography.title,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
                Text(
                    text = menuItem.description,
                    style = KarlaTypography.leadText,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
                Text(
                    text = "$" + menuItem.price,
                    style = KarlaTypography.leadTextBold,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                )
            }
            GlideImage(
                model = menuItem.image,
                contentDescription = "dish image",
                loading = placeholder(ColorPainter(Color.Gray)),
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .align(CenterVertically)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        }
        Divider(thickness = 1.dp, color = highlight)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    val testItem = MenuItemRoom(
        1,
        "Greek Salad",
        "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
        12.99,
        "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
        "starters"
    )
    Item(menuItem = testItem)
}

@Preview(showBackground = true)
@Composable
fun MenuItemsPreview() {
    val menu = listOf(
        MenuItemRoom(
            1,
            "Greek Salad",
            "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            12.99,
            "",
            "starters"
        ),
        MenuItemRoom(
            2,
            "Lemon Desert",
            "Traditional homemade Italian Lemon Ricotta Cake.",
            7.99,
            "",
            "starters"
        ),
        MenuItemRoom(
            3,
            "Grilled Fish",
            "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
            20.00,
            "",
            "mains"
        )
    )
    MenuItems(menu)
}
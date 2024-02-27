package com.example.littlelemon.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlight
import com.example.littlelemon.ui.theme.highlightVariant
import com.example.littlelemon.ui.theme.primary
import com.example.littlelemon.ui.theme.secondary

@Composable
fun MenuCategory(onCategorySelected: (String) -> Unit) {
    val menuCategories = listOf("Starters", "Mains", "Desserts", "Drinks")
    var currentSelectedCategory by remember { mutableStateOf("") }

    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, highlight)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.order),
                style = KarlaTypography.sectionTitle
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                menuCategories.forEach {
                    Button(
                        onClick = {
                            currentSelectedCategory = if (currentSelectedCategory == it)
                                "all" else
                                it
                            onCategorySelected(currentSelectedCategory)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = highlightVariant,
                            containerColor = if (it == currentSelectedCategory) secondary else highlight
                        ),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(10.dp),
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = it,
                            style = KarlaTypography.categoryButton
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MenuCategoryPreview() {
    MenuCategory() { }
}
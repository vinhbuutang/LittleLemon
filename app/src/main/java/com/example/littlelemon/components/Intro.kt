package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlight
import com.example.littlelemon.ui.theme.karlaFamily
import com.example.littlelemon.ui.theme.markaziTextFamily
import com.example.littlelemon.ui.theme.primary
import com.example.littlelemon.ui.theme.primaryVariant


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Intro(searchPhrase: String, onSearchPhraseChange: (String) -> Unit) {
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(
            containerColor = primary,
            contentColor = highlight
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = ParagraphStyle(lineHeight = 44.sp)) {
                            withStyle(
                                style = SpanStyle(
                                    color = primaryVariant,
                                    fontSize = 64.sp,
                                    fontFamily = markaziTextFamily,
                                    fontWeight = FontWeight.Medium,
                                )
                            ) {
                                append(context.getString(R.string.little_lemon) + "\n")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = highlight,
                                    fontFamily = markaziTextFamily,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 44.sp
                                )
                            ) {
                                append(context.getString(R.string.location) + "\n")
                            }
                        }
                        withStyle(
                            style = ParagraphStyle(
                                lineHeight = 20.sp
                            )
                        ) {
                            withStyle(
                                style = SpanStyle(
                                    color = highlight,
                                    fontFamily = karlaFamily,
                                    fontWeight = FontWeight.ExtraLight,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("We are a family owned\n")
                                append("Mediterranean restaurant,\n")
                                append("focused on traditional\n")
                                append("recipes served with a\n")
                                append("modern twist.\n")
                            }
                        }
                    }
                )
            }

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = stringResource(id = R.string.hero_img_desc),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }

        OutlinedTextField(
            maxLines = 1,
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.search_icon_desc)
                )
            },
            label = { Text(text = stringResource(id = R.string.search_phrase)) },
            value = searchPhrase,
            onValueChange = onSearchPhraseChange,
            colors = TextFieldDefaults.textFieldColors(containerColor = highlight),
            textStyle = KarlaTypography.leadText,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun IntroPreview() {
    Intro("") { }
}
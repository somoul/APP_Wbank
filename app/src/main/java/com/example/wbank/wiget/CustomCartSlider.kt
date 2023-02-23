package com.example.wbank.wiget
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lens
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun CustomCartSlider(

    tiTile: String = "",
    nameCart: String = "",
    money: String = "",
    codeCart: String = "",
    number: String = "",
    startColor: Long = 0,
    centralColor: Long = 0,
    endColor: Long = 0,
    isNameCode: Boolean = false,

) {
    Box(
        modifier = Modifier
            .width(250.dp)
            .height(140.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(startColor),
                        Color(centralColor),
                        Color(endColor),
                    ),
                ),
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp, top = 11.dp, end = 13.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = tiTile,//"Banlence",
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.W500,
                        color = if (!isNameCode) {
                            Color(0xffE5E4E2)
                        } else {
                            Color.White
                        }
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                if (isNameCode) {
                    Box(Modifier.padding(top = 17.5.dp, end = 15.dp)) {
                        val textPadding = 12.dp
                        val overlayBoxHeight = 12.dp

                        Box(
                            Modifier
                                .height(overlayBoxHeight)
                                .width(14.dp)
                                .offset(x = textPadding / 3, y = -overlayBoxHeight)
                                .clip(shape = CircleShape)
                                .background(Color.Red.copy(alpha = 0.9f))
                        )
                        Box(
                            Modifier
                                .height(overlayBoxHeight)
                                .width(14.dp)
                                .offset(x = textPadding, y = -overlayBoxHeight)
                                .clip(shape = CircleShape)
                                .background(Color(0xffFFA500).copy(alpha = 0.8f))
                        )
                    }
                } else {
                    Text(
                        text = nameCart,// "VISA",
                        style = MaterialTheme.typography.h4.copy(
                            fontSize = 13.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W600
                        )
                    )
                }

            }
            Spacer(modifier = Modifier.height(3.dp))
            if (!isNameCode) {
                Text(
                    text = money,// "$92 049.99",
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W600
                    )
                )
            }
            Row {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.RssFeed,
                        "contentDescription",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(bottom = 18.dp, start = 15.dp)
                            .size(25.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            ) {
                if (!isNameCode) {
                    LazyRow(
                        modifier = Modifier
//                        .fillMaxWidth()
                            .height(200.dp)
                            .padding(top = 10.dp),
                    ) {
                        items(15) { item ->
                            if (item == 4 || item == 9 || item == 14) {
                                Spacer(modifier = Modifier.width(5.dp))
                                if (item == 14) {
                                    Text(
                                        text = codeCart,
                                        style = MaterialTheme.typography.h4.copy(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.W400,
                                            color = Color.White
                                        ),
                                        modifier = Modifier.padding(bottom = 0.dp)
                                    )
                                }

                            } else {
                                Icon(
                                    Icons.Filled.Lens,
                                    "contentDescription",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .padding(top = 6.dp)
                                        .size(5.5.dp)
                                )
                            }

                        }
                    }

                } else {
                    Text(
                        text = codeCart,
                        style = MaterialTheme.typography.h4.copy(
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.White
                        ),
//                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = number,
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W600
                    ),
                    modifier = if (!isNameCode) {
                        Modifier.padding(top = 10.dp)
                    } else {
                        Modifier.padding(top = 0.dp)
                    }
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}
package com.example.wbank.wiget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wbank.ui.theme.Purple200


@Composable
fun CustomCartTransactions(

    image: String = "",
    title: String = "",
    description: String = "",
    price: String = "",
    date: String = "",
    isPrice: Boolean,
    isMainCart: Boolean,
    nameCard:String="",
    onClick: () -> Unit,
    isClickCard:Boolean=false
) {
    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(if (isClickCard){ Purple200}else{ Color(0xffF9F8FF)}
            )
            .clickable {
                onClick( )
            }
    ) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            if (!isMainCart) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "Circle Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(37.dp)
                        .clip(shape = RoundedCornerShape(10.dp)) // clip to the circle shape
                    //optional
                )
            } else {
                Column(modifier = Modifier.padding(top = 18.dp)) {
                    Box(
                        Modifier
                            .height(26.dp)
                            .width(42.dp)
                            .clip(shape = RoundedCornerShape(7.dp))
                            .background(Color(0xff8340F0))
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .padding(start =if(nameCard=="Main card"){ 0.dp}else{ 8.dp} ,top =if(nameCard=="Main card"){ 16.dp}else{ 0.dp}, end = if(nameCard=="Main card"){ 15.dp}else{ 7.dp})
                    ) {
                        val textPadding = 12.dp
                        val overlayBoxHeight = 9.dp
                        if(nameCard=="Main card"){
                            Box(
                                Modifier
                                    .height(overlayBoxHeight)
                                    .width(11.dp)
                                    .offset(x = textPadding / 3, y = -overlayBoxHeight)
                                    .clip(shape = CircleShape)
                                    .background(Color.Red.copy(alpha = 0.9f))
                            )
                            Box(
                                Modifier
                                    .height(overlayBoxHeight)
                                    .width(11.dp)
                                    .offset(x = textPadding, y = -overlayBoxHeight)
                                    .clip(shape = CircleShape)
                                    .background(Color(0xffFFA500).copy(alpha = 0.8f))
                            )
                        }else{
                            Text(
                                text = "VISA",
                                style = MaterialTheme.typography.h4.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 8.5.sp
                                ),
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                if (!isMainCart) {
                    Text(
                        text = title,//"Spotify",
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.Black.copy(alpha = 0.75f),
                            fontWeight = FontWeight.W500,
                        ),

                        )
                } else {
                    Text(
                        text = title,//"Spotify",
                        style = MaterialTheme.typography.h4.copy(
                            fontSize = 12.sp,
                            color = Color.Black.copy(alpha = 0.9f),
                            fontWeight = FontWeight.W500,
                        ),
                        modifier = Modifier.padding(top = 15.dp)

                    )
                }
                Spacer(modifier = Modifier.height(0.dp))

                if (!isMainCart) {
                    Text(
                        text = description,// "Subscription",
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.Black.copy(alpha = 0.4f),
                            fontSize = 12.sp,

                            fontWeight = FontWeight.W500,
                        ),


                        )
                } else {

                    LazyRow(
                        modifier = Modifier
//                        .fillMaxWidth()
                            .height(200.dp)
                            .padding(top = 0.dp),
                    ) {
                        items(5) { item ->
                            if (item < 4) {
                                Icon(
                                    Icons.Filled.Lens,
                                    "contentDescription",
                                    tint = Color.Black.copy(alpha = 0.6f),
                                    modifier = Modifier
                                        .padding(top = 6.dp)
                                        .size(4.dp)
                                )
                            } else {
                                Text(
                                    text = description,// "Subscription",
                                    style = MaterialTheme.typography.h4.copy(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        fontSize = 11.sp,

                                        fontWeight = FontWeight.W500,
                                    ),
                                    modifier = Modifier.padding(bottom = 12.dp)
                                )


                            }

                        }
                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                if (!isMainCart) {
                    Text(
                        text = price,/// "-5.49$",
                        style = MaterialTheme.typography.h4.copy(
                            color = if (isPrice) {
                                Color.Red
                            } else {
                                Color.Black.copy(alpha = 0.75f)
                            },
                            fontWeight = FontWeight.W500,
                        ), modifier =if (isPrice) {Modifier.padding(start = 85.dp)}else{Modifier.padding(start = 30.dp)}
                    )
                } else {
                    Text(
                        text = "$$price ",/// "-5.49$",
                        style = MaterialTheme.typography.h4.copy(
                            color =  Color.Black.copy(alpha = 0.75f),
                            fontWeight = FontWeight.W500,
                        ), modifier = Modifier.padding(start = 97.dp, top = 15.dp)
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = date,//"01 May 19:29",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 12.sp,

                        fontWeight = FontWeight.W500,
                    ),
                    modifier = if (isPrice) {
                        Modifier.padding(start = 98.dp)
                    } else {
                        Modifier.padding(start = 0.dp)
                    },

                    )
                Spacer(modifier = Modifier.height(3.dp))
            }
        }
    }
}
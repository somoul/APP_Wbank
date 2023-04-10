import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material.icons.rounded.Computer
import androidx.compose.material.icons.rounded.Mode
import androidx.compose.material.icons.rounded.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavoritesScreen() {
    val navHostController = rememberNavController()
    Scaffold {
        PlayConstraintLayout(navHostController)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayConstraintLayout(navHostController: NavHostController) {

    Scaffold(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                val (learnIconBack, title, actionIcon) = createRefs()
                val (my_goals, icon) = createRefs()
                val (functionCart) = createRefs()
                val (cardSlider) = createRefs()
                val (cardFoldingCell) = createRefs()
                val (cardDetail) = createRefs()
                Text(
                    text = "Statistics", style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .constrainAs(title) {
//                        width = Dimension.fillToConstra
                            top.linkTo(parent.top, 8.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = 15.dp)
                )
                Text(
                    text = "My goals",
                    style = MaterialTheme.typography.h6.copy(
                        fontSize = 14.sp,
                        color = Color.Black.copy(alpha = 0.9f),
                        fontWeight = FontWeight.W600
                    ),
                    modifier = Modifier
                        .constrainAs(my_goals) {
                            start.linkTo(learnIconBack.end)
                            top.linkTo(parent.top, 50.dp)
//                        bottom.linkTo(april.start)
                            width = Dimension.fillToConstraints
                        }
                        .padding(top = 15.dp)
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier.constrainAs(icon) {
                        width = Dimension.preferredWrapContent
                        top.linkTo(my_goals.top)
                        end.linkTo(parent.end)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Mode,
                        contentDescription = "Click to share",
                        tint = Color.Black.copy(alpha = 0.8f),
                        modifier = Modifier.height(20.dp)
                    )
                }
                CartSaving(
                    modifier = Modifier.constrainAs(functionCart) {
                        start.linkTo(my_goals.start)
                        top.linkTo(my_goals.bottom)
//                      end.linkTo(parent.end)
                    }
                )
                CardSlider(
                    modifier = Modifier.constrainAs(cardSlider) {
                        start.linkTo(functionCart.start)
                        top.linkTo(functionCart.bottom, 30.dp)
                    }
                )
                CardFoldingCell(modifier = Modifier.constrainAs(cardFoldingCell) {
                    start.linkTo(cardSlider.start)
                    top.linkTo(cardSlider.bottom, 15.dp)
                    bottom.linkTo(cardDetail.top)
                })

                CardDetail(modifier = Modifier.constrainAs(cardDetail) {
                    start.linkTo(cardFoldingCell.start)
                    top.linkTo(cardFoldingCell.bottom, 15.dp)
                    bottom.linkTo(cardFoldingCell.top)
                })
//                CardFoldingCell(modifier = Modifier.constrainAs(cardDetail) {
//                    start.linkTo(cardFoldingCell.start)
//                    top.linkTo(cardFoldingCell.bottom, 15.dp)
//                    bottom.linkTo(cardFoldingCell.top)
//                })

            }
        }
    }

//    ConstraintLayout(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//            .fillMaxHeight()
////            .clip(shape = RoundedCornerShape(10.dp))
//            .background(Color.Blue.copy(alpha = 0.3f))
//    ) {
//        val (image, id, name, day, time, aa, bb) = createRefs()
//
////        Image(painter = rememberAsyncImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHDRlp-KGr_M94k_oor4Odjn2UzbAS7n1YoA&usqp=CAU"),
////            contentDescription = "Circle Image",
////            contentScale = ContentScale.Crop,
////            modifier = Modifier
////                .aspectRatio(1f)
////                .fillMaxHeight()
////                .padding(top = 16.dp, bottom = 16.dp)
////                .constrainAs(image) {
////                    start.linkTo(parent.start, 16.dp)
////                    top.linkTo(parent.top, 16.dp)
////                    bottom.linkTo(parent.bottom, 16.dp)
////                }
////                .clip(shape = RoundedCornerShape(10.dp)) // clip to the circle shape
////        )
//        Text(text = "ID : 00000 11111", style = TextStyle(
//            fontSize = 14.5.sp,
//            color = Color.Blue.copy(alpha = 0.4f),
//            fontWeight = FontWeight.W500
//        ), modifier = Modifier
//            .constrainAs(id) {
//                width = Dimension.fillToConstraints
//                start.linkTo(image.end, 16.dp)
//                end.linkTo(parent.end, 16.dp)
//                top.linkTo(image.top)
//                bottom.linkTo(name.top)
//            })
////        Text(text = "Name : Bav SomOul", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier.constrainAs(name) {
////            width = Dimension.fillToConstraints
////            start.linkTo(id.start)
////            end.linkTo(id.end)
////            top.linkTo(id.bottom)
////            bottom.linkTo(day.top)
////        })
////        Text(text = "Day : 01/05/2023", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier.constrainAs(day) {
////            width = Dimension.fillToConstraints
////            start.linkTo(id.start)
////            end.linkTo(id.end)
////            top.linkTo(name.bottom)
////            bottom.linkTo(time.top)
////        })
////        Text(text = "Time : 1:50 pm", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(time) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(day.bottom)
////                bottom.linkTo(aa.top)
////            }
////
////        )
////        Text(
////            text = "Time : 1:50 pm", style = TextStyle(
////                fontSize = 14.5.sp,
////                color = Color.Blue.copy(alpha = 0.4f),
////                fontWeight = FontWeight.W500
////            ), modifier = Modifier
////                .constrainAs(aa) {
////                    width = Dimension.fillToConstraints
////                    start.linkTo(id.start)
////                    end.linkTo(id.end)
////                    top.linkTo(time.bottom)
////                    bottom.linkTo(bb.bottom)
////                }
////
////        )
////        Text(
////            text = "Time : 1:50 pm", style = TextStyle(
////                fontSize = 14.5.sp,
////                color = Color.Blue.copy(alpha = 0.4f),
////                fontWeight = FontWeight.W500
////            ), modifier = Modifier
////                .constrainAs(bb) {
////                    width = Dimension.fillToConstraints
////                    start.linkTo(id.start)
////                    end.linkTo(id.end)
////                    top.linkTo(aa.bottom)
////                    bottom.linkTo(image.bottom)
////                }
////
////        )
////        Text(text = "ID : 00000 11111", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(id) {
////                width = Dimension.fillToConstraints
////                start.linkTo(image.end, 16.dp)
////                end.linkTo(parent.end, 16.dp)
////                top.linkTo(image.top)
////                bottom.linkTo(name.top)
////            })
////        Text(text = "ID : 00000 11111", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(id) {
////                width = Dimension.fillToConstraints
////                start.linkTo(image.end,16.dp)
////                end.linkTo(parent.end,16.dp)
////                top.linkTo(image.top,16.dp)
////                bottom.linkTo(name.top)
////
////            })
////        Text(text = "Name : BavSomOul", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(name) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(id.bottom)
//////
////                bottom.linkTo(day.top)
////
////            })
////        Text(text = "Day : 20/04/2023", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(day) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(name.bottom)
////                bottom.linkTo(time.top)
////
////            })
////        Text(text = "Time : 4:30 pm", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(time) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(day.bottom)
//////                bottom.linkTo(name.top)
////
////            })
////        Text(text = "AA :Test AA", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(aa) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(time.bottom)
////                bottom.linkTo(bb.top)
////
////            })
////        Text(text = "BB :Test BB", style = TextStyle(
////            fontSize = 14.5.sp,
////            color = Color.Blue.copy(alpha = 0.4f),
////            fontWeight = FontWeight.W500
////        ), modifier = Modifier
////            .constrainAs(bb) {
////                width = Dimension.fillToConstraints
////                start.linkTo(id.start)
////                end.linkTo(id.end)
////                top.linkTo(aa.top)
////                bottom.linkTo(image.bottom)
////
////            })
////
//
//
//
//
//
//
//    }

}

@Preview()
@Composable
fun ConstraintPreview() {
    val navHostController = rememberNavController()
    Surface {
        PlayConstraintLayout(navHostController = navHostController)
    }
}

@Composable
fun CartSaving(
    modifier: Modifier
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (clipCard, titleCard, descriptionCard, progressCard, priceCard) = createRefs()
        Box(modifier = Modifier
            .size(37.dp)
            .constrainAs(clipCard) {
                start.linkTo(parent.start, 18.dp)//my_goals.start
                top.linkTo(parent.top, 25.dp)//my_goals.bottom
            }) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                drawCircle(
                    color = Color(0xff0f9d58),
                    center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                    radius = size.minDimension / 2,
                    style = Stroke(6F)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Computer,
                    contentDescription = "Click to share",
                    tint = Color.Blue.copy(alpha = 0.8f),
                    modifier = Modifier.size(19.dp)
                )

            }

        }
        Text(
            text = "MacBook Pro",
            style = MaterialTheme.typography.h6.copy(
                fontSize = 13.sp,
                color = Color.Black.copy(alpha = 0.85f),
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier
                .constrainAs(titleCard) {
                    start.linkTo(clipCard.end, 13.dp)
                    top.linkTo(clipCard.top, 2.dp)
                    bottom.linkTo(descriptionCard.top)
                    width = Dimension.fillToConstraints
                }
//                    .padding(top = 15.dp, start = 15.dp)
        )

        Text(
            text = "$2 799.56 accumulated",
            style = MaterialTheme.typography.h6.copy(
                fontSize = 13.sp,
                color = Color.Black.copy(alpha = 0.4f),
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier
                .constrainAs(descriptionCard) {
                    width = Dimension.fillToConstraints
                    start.linkTo(titleCard.start)
                    bottom.linkTo(clipCard.bottom)

                }
        )
        Text(
            text = "83.34%",
            style = MaterialTheme.typography.h6.copy(
                fontSize = 13.sp,
                color = Color.Black.copy(alpha = 0.85f),
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier
                .constrainAs(progressCard) {
                    width = Dimension.preferredWrapContent
//                        start.linkTo(parent.end)
                    top.linkTo(titleCard.top)
                    end.linkTo(parent.end, 20.dp)//icon.end
                    bottom.linkTo(priceCard.top)

                }
        )
        Text(
            text = "$32 400 total",
            style = MaterialTheme.typography.h6.copy(
                fontSize = 13.sp,
                color = Color.Black.copy(alpha = 0.4f),
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier
                .constrainAs(priceCard) {
                    width = Dimension.wrapContent

                    top.linkTo(descriptionCard.top)
                    end.linkTo(progressCard.end)
                    bottom.linkTo(clipCard.bottom)

                }
        )


    }


}


@Composable
fun CardSlider(
    modifier: Modifier
) {


    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color(0xffB3A19E))
    ) {
        val (nameCard, numberCard, moneyReal, clip, detailCard, dateCard, cvv2, icon) = createRefs()
        Text(text = "IBOXBANK", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.White
        ),
            modifier = Modifier.constrainAs(nameCard) {
                start.linkTo(parent.start, 15.dp)
                top.linkTo(parent.top, 15.dp)
                bottom.linkTo(nameCard.top)
            }

        )
        Text(text = "PLATINUM", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.5.sp,
            color = Color.White.copy(alpha = 0.8f)
        ),
            modifier = Modifier.constrainAs(detailCard) {
                top.linkTo(nameCard.top)
                end.linkTo(parent.end, 15.dp)
//                bottom.linkTo(dateCard.top)

            }

        )
        Text(text = "....3043", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.6.sp,
            color = Color.White.copy(alpha = 0.9f)
        ),
            modifier = Modifier.constrainAs(numberCard) {
                height = Dimension.wrapContent
//                start.linkTo(parent.start,10.dp)
                top.linkTo(nameCard.bottom, 20.dp)
                start.linkTo(nameCard.start)
                bottom.linkTo(moneyReal.top)
            }

        )
        Text(text = "02//02/2023", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.6.sp,
            color = Color.White.copy(alpha = 0.9f)
        ),
            modifier = Modifier.constrainAs(dateCard) {
                height = Dimension.wrapContent
//                start.linkTo(parent.start,10.dp)
                top.linkTo(numberCard.top)
                end.linkTo(detailCard.end)
//                bottom.linkTo(
//                    detailCard.bottom)
            }

        )
        Text(text = "89 500 រ", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.6.sp,
            color = Color.White.copy(alpha = 0.9f)
        ),
            modifier = Modifier.constrainAs(moneyReal) {
                height = Dimension.wrapContent
//                start.linkTo(parent.start,10.dp)
                top.linkTo(numberCard.bottom, 20.dp)
                start.linkTo(numberCard.start)
//                bottom.linkTo(numberCard.bottom)

            }

        )
        Text(text = "CVV2", style = MaterialTheme.typography.h3.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.6.sp,
            color = Color.White.copy(alpha = 0.8f)
        ),
            modifier = Modifier.constrainAs(cvv2) {
                height = Dimension.wrapContent
//                start.linkTo(parent.start,10.dp)
                top.linkTo(numberCard.bottom, 20.dp)
                end.linkTo(dateCard.end)
//                start.linkTo(numberCard.start)
//                bottom.linkTo(numberCard.bottom)

            }

        )
        Box(
            Modifier
                .padding(top = 17.5.dp, end = 15.dp)
                .constrainAs(clip) {
                    height = Dimension.wrapContent
                    start.linkTo(moneyReal.start)
                    top.linkTo(moneyReal.bottom, 15.dp)
//            end.linkTo(dateCard.end)
//                start.linkTo(numberCard.start)
                    bottom.linkTo(parent.bottom)
                }


        ) {
            val textPadding = 12.dp
            val overlayBoxHeight = 17.dp

            Box(
                Modifier
                    .height(overlayBoxHeight)
                    .width(18.dp)
                    .offset(x = textPadding / 3, y = -overlayBoxHeight)
                    .clip(shape = CircleShape)
                    .background(Color.Red.copy(alpha = 0.9f))
            )
            Box(
                Modifier
                    .height(overlayBoxHeight)
                    .width(18.dp)
                    .offset(x = textPadding, y = -overlayBoxHeight)
                    .clip(shape = CircleShape)
                    .background(Color(0xffFFA500).copy(alpha = 0.8f))
            )
        }

        Icon(
            Icons.Filled.RssFeed,
            "contentDescription",
            tint = Color.White,
            modifier = Modifier
                .padding(bottom = 18.dp, start = 15.dp)
                .size(25.dp)
                .constrainAs(icon) {
                    end.linkTo(cvv2.end)
                    top.linkTo(clip.top)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Composable
fun CardFoldingCell(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
            .height(150.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color(0xffACC0DE).copy(alpha = 0.5f))
    ) {
        val (number, today, time, constrainLayout1, constrainLayout2, divider, location1, location2, coefficients, price, weight, coefficientPrice, pricePrice, weightPrice) = createRefs()
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .width(90.dp)
                .background(Color(0xff5B3D95).copy(alpha = 0.8f))
                .constrainAs(constrainLayout1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                }
        ) {
            Text(
                text = "5",
                style = MaterialTheme.typography.h3.copy(
                    Color.White.copy(alpha = 0.7f),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(
                        align = Alignment.CenterHorizontally
                    )
                    .constrainAs(number) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(top = 13.dp)
            )
            Text(text = "TODAY",
                style = MaterialTheme.typography.h3.copy(
                    Color.White.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(
                        align = Alignment.CenterHorizontally
                    )
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .constrainAs(today) {
                        top.linkTo(number.top, 20.dp)
                    }
            )
            Text(text = "06:30 pm",
                style = MaterialTheme.typography.h3.copy(
                    Color.White.copy(alpha = 0.6f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(
                        align = Alignment.CenterHorizontally
                    )
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .constrainAs(time) {
                        top.linkTo(today.top, 30.dp)
//                        bottom.linkTo(parent.bottom, 2.dp)
                    }
            )
        }
        ConstraintLayout(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                Color(0xffACC0DE).copy(alpha = 0.5f)
            )
            .constrainAs(
                constrainLayout2
            ) {
                start.linkTo(constrainLayout1.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }

        ) {
            Text(
                text = "W 85th st,New york ,10024",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.5.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .constrainAs(location1) {
//                        width = Dimension.fillToConstraints
                        start.linkTo(parent.start, 10.dp)
                        top.linkTo(parent.top, 14.dp)
//                        end.linkTo(parent.end)
                        bottom.linkTo(divider.top)
                    }
//                    .padding(start = 10.dp)

            )
            Divider(
                color = Color.Black.copy(alpha = 0.2f),
                thickness = 1.5.dp,
                modifier = Modifier
                    .constrainAs(divider) {
                        start.linkTo(location1.start)
                        top.linkTo(location1.bottom, 5.dp)
//                        end.linkTo(location1.end)
                        bottom.linkTo(location1.top)
                    }
                    .padding(end = 139.dp)
            )
            Text(
                text = "E 30th st , New York , 10016",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.5.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .constrainAs(location2) {
//                        width = Dimension.matchParent
                        start.linkTo(location1.start)
                        top.linkTo(divider.top, 5.dp)
                        bottom.linkTo(coefficients.top)
//                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = "PEQUSE",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.5.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .constrainAs(coefficients) {
                        width = Dimension.wrapContent

                        start.linkTo(location1.start)
                        top.linkTo(location2.bottom, 10.dp)
                        end.linkTo(price.start)
                        bottom.linkTo(coefficientPrice.top)
                    }
            )
            Text(
                text = "PRICE",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.5.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .constrainAs(price) {
                        width = Dimension.wrapContent
                        start.linkTo(coefficients.end, 24.dp)
                        top.linkTo(coefficients.top)
                        bottom.linkTo(price.top)

                    }
            )
            Text(
                text = "WEIGHT",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 18.5.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .constrainAs(weight) {
                        width = Dimension.wrapContent
                        start.linkTo(price.end, 24.dp)
                        top.linkTo(coefficients.top)
                        bottom.linkTo(weightPrice.top)
                    }
            )
            Text(
                text = "2",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)

                ),
                modifier = Modifier
                    .constrainAs(coefficientPrice) {
                        width = Dimension.fillToConstraints
                        start.linkTo(coefficients.start, 23.dp)
                        top.linkTo(coefficients.bottom, 2.dp)
                        bottom.linkTo(parent.bottom, 3.dp)

                    }
            )
            Text(
                text = "$1500",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .constrainAs(pricePrice) {
                        width = Dimension.fillToConstraints
                        start.linkTo(price.start)
                        top.linkTo(coefficients.bottom, 2.dp)
                        bottom.linkTo(parent.bottom, 3.dp)

                    }


            )
            Text(
                text = "Light",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 16.5.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.Black.copy(alpha = 0.3f)
                ),
                modifier = Modifier
                    .constrainAs(weightPrice) {
                        width = Dimension.fillToConstraints
                        start.linkTo(weight.start, 13.dp)
                        top.linkTo(weight.bottom)
                        bottom.linkTo(parent.bottom, 5.dp)
//                        end.linkTo(parent.end)
                    }
            )
        }

    }


}

@Composable
fun CardDetail(
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
//            .clip(shape = RoundedCornerShape(1.dp))
            .shadow(

                shape = RoundedCornerShape(13.dp),
                elevation = 0.5.dp,
                spotColor = Color.Blue,
                ambientColor = Color.Red,
                clip = true


            )
            .background(Color(0xffA4C8E1).copy(alpha = 0.5f))
    ) {

//        Text(text = "SomOul")
    }
}

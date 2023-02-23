package com.example.wbank.src.dashboard.homescreen.screen

import ConstantsShip
import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import coil.compose.rememberAsyncImagePainter
import com.example.wbank.src.dashboard.contactscreen.model.ConstantContact
import com.example.wbank.src.dashboard.homescreen.model.Constants
import com.example.wbank.wiget.CustomCartSlider
import com.example.wbank.wiget.CustomSetting
import com.example.wbank.wiget.CustomShip
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactsScreen() {
    val imageList = Constants.imageList
    val imageListShip = ConstantsShip.imageListShip
    val cardContactList = ConstantContact.cardContactList
    Scaffold {
        Column {
            Row(
                modifier = Modifier
                    .height(63.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)

                    .padding(start = 15.dp, top = 0.dp, end = 15.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://media.istockphoto.com/id/1300972574/photo/millennial-male-team-leader-organize-virtual-workshop-with-employees-online.jpg?b=1&s=170667a&w=0&k=20&c=96pCQon1xF3_onEkkckNg4cC9SCbshMvx0CfKl2ZiYs="),
                    contentDescription = "Circle Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(33.dp)
                        .clip(CircleShape) // clip to the circle shape
                        .border(1.dp, Color.Gray, CircleShape)//optional
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "John Doe", style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    ), modifier = Modifier.padding(top = 5.dp)
                )
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Notifications,
                        "contentDescription",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(bottom = 13.dp)
                            .size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.QrCodeScanner,
                        "contentDescription",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(bottom = 13.dp)
                            .size(20.dp)
                    )
                }
            }
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {

                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    text = "Total balance", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.W500, fontSize = 13.sp
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.height(35.dp)) {
                    Text(
                        text = "$112 418.48", style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.W600, fontSize = 15.sp
                        ), color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(Modifier.padding(top = 17.5.dp)) {
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
                    Spacer(modifier = Modifier.width(15.5.dp))
                    Text(
                        text = "... 7727", style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.W500, fontSize = 13.sp
                        ), color = Color.Black
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.KeyboardArrowDown,
                            "contentDescription",
                            tint = Color.Black.copy(alpha = 0.9f),
                            modifier = Modifier
                                .padding(bottom = 13.dp)
                                .size(20.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 65.dp)
            ) {
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(start = 15.dp, end = 15.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    repeat(imageList.size) { index ->
                        CustomCartSlider(
                            nameCart = imageList[index].nameCart,
                            tiTile = imageList[index].tiTile,
                            money = imageList[index].money,
                            isNameCode = imageList[index].isNameCart,
                            startColor = imageList[index].startColor,
                            centralColor = imageList[index].centralColor,
                            endColor = imageList[index].endColor,
                            codeCart = imageList[index].codeCart,
                            number = imageList[index].number,
                        )
                    }
                }
                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(41.dp)) {
                        repeat(imageListShip.size) { index ->
                            CustomShip(
                                nameShip = imageListShip[index].nameShip,
                                colorBackGround = imageListShip[index].colorBackGround,
                                icons = imageListShip[index].icons,
                                onClick = {
                                    when (index) {
                                        0 -> {}
                                        1 -> {
//                                            navController.navigate(Router.Transfer)
                                        }
                                        2 -> {
                                        }
                                        3 -> {
                                        }
                                        else -> {
                                        }
                                    }
                                },
                                isClickShip = false,
                                isExChang = false,
                                nameShipExchange = ""
                            )
                        }
                    }
                    Text(
                        text = "Settings", style = MaterialTheme.typography.h4.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.W500,
                        ), modifier = Modifier.padding(top = 13.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    repeat(times = cardContactList.size) { index ->
                        CustomSetting(
                            onClick = {},
                            title = cardContactList[index].title,
                            description = cardContactList[index].description,
                            isClickCard = cardContactList[index].isClickIcon
                        )
                    }
//                    // 2. DASH_PATH_EFFECT CIRCLE
//                   Box (modifier = Modifier
//                       .height(200.dp)
//                       .width(200.dp)
//                       .clip(shape = CircleShape)
//                       .drawWithCache {
//                           val brush = createStripeBrush(
//                               stripeColor = Color.Blue,
//                               stripeWidth = 5.dp,
//                               stripeToGapRatio = 2f
//                           )
//                           onDrawWithContent {
//                               drawArc(
//                                   brush = brush,
//                                   startAngle = 0f,
//                                   sweepAngle = -90f,
//                                   useCenter = false,
//                                   size = Size(width = 400f, height = 400f),
//                                   style = Stroke(width = 5f, cap = StrokeCap.Round),
//                                   colorFilter = ColorFilter.tint(
//                                       color = Color.Red,
//                                       blendMode = BlendMode.ColorBurn
//                                   )
//                               )
//                           }
//                       }
//                   ){
////                       Text(text = "100%", style = TextStyle(Color.Red, fontSize = 20.sp))
//
//                   }
//                    Switch2()   //

//                    Box(
//                        Modifier
//                            .height(1.dp)
//                            .fillMaxWidth()
//                            .background(Color.Gray, shape = DottedShape(step = 10.dp)
//
//                            ).drawWithCache {
//                                val brush = createStripeBrush(
//                                    stripeColor = Color.Blue,
//                                    stripeWidth = 5.dp,
//                                    stripeToGapRatio = 1.8f
//                                )
//                                onDrawWithContent {
//                                    drawArc(
//                                        brush = brush,
//                                        startAngle = 0f,
//                                        sweepAngle = -90f,
//                                        useCenter = false,
//                                        style = Stroke(width =  3f, cap = StrokeCap.Round)
//                                    )
//                                }
//                            }
//                    )
                }
            }
        }
    }
}
private fun Density.createStripeBrush(
    stripeColor: Color,
    stripeWidth: Dp,
    stripeToGapRatio: Float
): Brush {
    val stripeWidthPx = stripeWidth.toPx()
    val stripeGapWidthPx = stripeWidthPx / stripeToGapRatio
    val brushSizePx = stripeGapWidthPx + stripeWidthPx
    val stripeStart = stripeGapWidthPx / brushSizePx

    return Brush.linearGradient(
        stripeStart to Color.Transparent,
        stripeStart to stripeColor,
        start = Offset(0f, 0f),
        end = Offset(brushSizePx, brushSizePx),
        tileMode = TileMode.Repeated
    )
}
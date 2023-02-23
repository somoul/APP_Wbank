package com.example.wbank.wiget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbank.ui.theme.IconColorTopBar
import com.example.wbank.ui.theme.Purple200

@Composable
fun CustomShip(

    colorBackGround: Long,
    nameShip: String,
    nameShipExchange: String? = "",
    icons: ImageVector,
    onClick: () -> Unit,
    isExChang: Boolean = false,
    isClickShip: Boolean = false,

    ) {
    Column(modifier = Modifier.clickable { onClick() }) {
        Box(
            modifier = Modifier
                .height(
                    if (isExChang) {
                        60.dp
                    } else {
                        47.dp
                    }
                )
                .width(
                    if (isExChang) {
                        60.dp
                    } else {
                        47.dp
                    }
                )
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .border(
                    width = if (isExChang) {
                        2.dp
                    } else {
                        0.dp
                    },
                    color = if (isExChang) {
                        if (isClickShip) {
                            Purple200

                        } else {
                            Color.White
                        }

//                       Color(Purple200)
                    } else {
                        Color.White
                    },
                    shape = RoundedCornerShape(10.dp),
                )
                .background(
                    if (isExChang) (Color(colorBackGround).copy(alpha = 0.55f)) else {
                        Color(colorBackGround)
                    }
                )
                .wrapContentHeight(align = Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            ) {
                Icon(
                    imageVector = icons,
                    "contentDescription",
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .size(23.dp)
                )
                if (isExChang) {

                    Text(
                        text = nameShipExchange!!,
                        style = MaterialTheme.typography.h4.copy(
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.W500,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(start = 3.dp, top = 4.dp)

                    )
                }
            }
        }
        if (!isExChang) {
            Text(
                text = nameShip,
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = IconColorTopBar,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(start = 0.dp, top = 4.dp)
            )
        }

    }

}
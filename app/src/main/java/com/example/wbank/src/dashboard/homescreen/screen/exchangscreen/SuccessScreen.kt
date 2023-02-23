package com.example.wbank.src.dashboard.homescreen.screen.exchangscreen

import ConstantsShipDetail
import CustomButtomBack
import CustomButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.KeyboardReturn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wbank.src.dashboard.homescreen.model.Constants.imageList
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.wiget.CustomCartSlider
import com.example.wbank.wiget.CustomShip

@Composable
fun SuccessScreen(navHostController: NavHostController, id: Int) {
    val listShipDetail = ConstantsShipDetail.imageListShip
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp, top = 15.dp, end = 20.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
        ) {
            CustomButtomBack(navHostController, onClick = {
                navHostController.navigateUp()
            })
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Success ", style = MaterialTheme.typography.h4.copy(
                    color = Color.Black.copy(alpha = 0.9f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                ), modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Row(modifier = Modifier.padding(top = 40.dp)) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .height(220.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            ) {

                Box(modifier = Modifier.padding(top = 20.dp)) {
                    CustomCartSlider(
                        nameCart = imageList[id].nameCart,
                        tiTile = imageList[id].tiTile,
                        money = imageList[id].money,
                        isNameCode = imageList[id].isNameCart,
                        startColor = imageList[id].startColor,
                        centralColor = imageList[id].centralColor,
                        endColor = imageList[id].endColor,
                    )
                }
                Box(
                    modifier = Modifier
                        .height(170.dp)
                        .width(200.dp)
                        .padding(start = 40.dp, top = 10.dp)
                        .clip(shape = CircleShape)
                        .background(
                            Color.White
                                .copy(alpha = 0.9f)
                                .copy(alpha = 0.9f)
                        )
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)

                ) {
                    Icon(
                        imageVector = Icons.Rounded.Done, contentDescription = "Icon",
                        tint = Color(0xff7F3EF2),
                        modifier = Modifier
                            .height(100.dp)
                            .width(85.dp),
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Text(
            text = "Congratulation!",
            style = MaterialTheme.typography.h4.copy(
                color = Color.Black.copy(alpha = 0.9f),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 5.dp)
        )
        Text(
            text = "You have successfully transferred 100$ to Mike Sanders from your Debit MasterCart ---- 7727 ",
            style = MaterialTheme.typography.h4.copy(
                color = Color.Black.copy(alpha = 0.6f),
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 25.dp),

            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            repeat(3) { index ->
                if (index == 0) {
                    CustomShip(
                        nameShip = "Avoid",
                        colorBackGround = 0xff69B1D9,
                        icons = Icons.Rounded.KeyboardReturn,
                        onClick = {},
                        isExChang = false,
                        nameShipExchange = ""
                    )
                } else {
                    CustomShip(
                        nameShip = listShipDetail[index - 1].nameShip,
                        colorBackGround = listShipDetail[index - 1].colorBackGround,
                        icons = listShipDetail[index - 1].icons,
                        onClick = {},
                        isExChang = false,
                        nameShipExchange = ""
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(onClickButtom = {
            navHostController.navigateUp()
            navHostController.navigateUp()
        }, nameButtom = "Done", backgroundColor = ButtonColor)
        Spacer(modifier = Modifier.height(20.dp))
    }

}
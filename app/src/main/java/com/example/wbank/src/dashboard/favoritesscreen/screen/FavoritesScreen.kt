package com.example.wbank.src.dashboard.homescreen.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavoritesScreen() {
    Scaffold {
        PlayConstraintLayout()
    }
   }
@Composable
fun PlayConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.Blue.copy(alpha = 0.3f))
    ) {
        val (image, id, name, day, time) = createRefs()
        Image(painter = rememberAsyncImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHDRlp-KGr_M94k_oor4Odjn2UzbAS7n1YoA&usqp=CAU"),
            contentDescription = "Circle Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxHeight()
                .constrainAs(image) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                    bottom.linkTo(parent.bottom, 16.dp)
                }
                .clip(shape = RoundedCornerShape(10.dp)) // clip to the circle shape
        )
        Text(text = "ID : 00000 11111", style = TextStyle(
            fontSize = 14.5.sp,
            color = Color.Blue.copy(alpha = 0.4f),
            fontWeight = FontWeight.W500
        ), modifier = Modifier
            .background(Color.Red)
            .constrainAs(id) {
                width = Dimension.fillToConstraints
                start.linkTo(image.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                top.linkTo(image.top)
                bottom.linkTo(name.top)
            })
        Text(text = "Name : Bav SomOul", style = TextStyle(
            fontSize = 14.5.sp,
            color = Color.Blue.copy(alpha = 0.4f),
            fontWeight = FontWeight.W500
        ), modifier = Modifier.constrainAs(name) {
            width = Dimension.fillToConstraints
            start.linkTo(id.start)
            end.linkTo(id.end)
            top.linkTo(id.bottom)
            bottom.linkTo(day.top)
        })
        Text(text = "Day : 01/05/2023", style = TextStyle(
            fontSize = 14.5.sp,
            color = Color.Blue.copy(alpha = 0.4f),
            fontWeight = FontWeight.W500
        ), modifier = Modifier.constrainAs(day) {
            width = Dimension.fillToConstraints
            start.linkTo(id.start)
            end.linkTo(id.end)
            top.linkTo(name.bottom)
            bottom.linkTo(time.top)
        })
        Text(text = "Time : 1:50 pm", style = TextStyle(
            fontSize = 14.5.sp,
            color = Color.Blue.copy(alpha = 0.4f),
            fontWeight = FontWeight.W500
        ), modifier = Modifier.constrainAs(time) {
            width = Dimension.fillToConstraints
            start.linkTo(id.start)
            end.linkTo(id.end)
            top.linkTo(day.bottom)
            bottom.linkTo(image.bottom)
        })
    }

}

@Preview()
@Composable
fun ConstraintPreview() {
    Surface {
        PlayConstraintLayout()
    }
}

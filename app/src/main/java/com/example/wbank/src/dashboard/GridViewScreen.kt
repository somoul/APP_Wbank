package com.example.wbank.src.dashboard.homescreen.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GridViewScreen() {
    Scaffold {
        Column (modifier = Modifier.fillMaxSize().wrapContentHeight(align = Alignment.CenterVertically).wrapContentWidth(align =
        Alignment.CenterHorizontally)){
            Text(text = "GridView", style = TextStyle(Color.Black))
        }

    }
}

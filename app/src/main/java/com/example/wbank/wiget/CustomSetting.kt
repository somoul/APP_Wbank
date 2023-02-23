package com.example.wbank.wiget

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbank.ui.theme.divider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomSetting(
    title: String? = "",
    description: String? = "",
    isClickCard: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 15.dp, end = 15.dp)
            .wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Column {
            Text(
                text = title ?: "",
                style = MaterialTheme.typography.h4.copy(
                    color = Color.Black.copy(alpha = 0.9f),
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.W500,
                ),
            )
            Text(
                text = description ?: "",
                style = MaterialTheme.typography.h4.copy(
                    color = Color.Black.copy(alpha = 0.4f),
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.W400,
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (isClickCard) AppSwitch() else  Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "",
            modifier = Modifier.size(25.dp).padding(end = 10.dp).clickable {
                onClick()
            }
        )
//            IconButton(onClick = {
//            onClick()
//        }) {
//            Spacer(modifier = Modifier.weight(1f))
//            Icon(
//                imageVector = Icons.Filled.ArrowForwardIos,
//                contentDescription = "",
//                modifier = Modifier.size(15.dp)
//            )
//
//        }

    }
}

@ExperimentalMaterialApi
@Composable
fun AppSwitch(
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope(),
//    colors: SwitchColors = SwitchDefaults.colors(),
//    enabled: Boolean = true,
    checked: Boolean = false,
    onCheckedChange: ((Boolean) -> Unit)? = null,
) {
    val squareSize = 23.dp
    val defWidth = (squareSize * 2) - squareSize / 4//test
    val state = rememberSwipeableState(checked)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() - 13 }
    val anchors = mapOf(0f to false, sizePx to true)

    val surfaceColor: Color by animateColorAsState(
        if (state.offset.value > defWidth.times(0.75f).value) MaterialTheme.colors.primary else MaterialTheme.colors.divider
    )

    Box(
        modifier = modifier
            .height(squareSize)
            .defaultMinSize(minWidth = defWidth)
            .clip(RoundedCornerShape(squareSize))
            .background(surfaceColor)
            .swipeable(
                state = state,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .toggleable(
                value = state.currentValue,
                onValueChange = { newValue ->
                    onCheckedChange?.invoke(newValue)
                    scope.launch {
                        state.animateTo(newValue)
                    }
                }
            )
    ) {
        Box(
            Modifier
                .offset { IntOffset(state.offset.value.roundToInt(), 0) }
                .fillMaxHeight()
                .padding(squareSize * 0.1f)
                .aspectRatio(1f)
                .shadow(3.dp, shape = CircleShape, clip = true)
                .background(Color.White)
        )
    }
}





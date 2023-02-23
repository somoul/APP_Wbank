import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
fun Modifier.customPending(start:Dp,top:Dp,end:Dp,bottom:Dp ) =
    this.then(
        Modifier.fillMaxHeight()
            .padding(start =start , top = top, end =end , bottom =bottom )
        )


@Stable
fun Modifier.customPendingAll(horizontal:Dp,vertical:Dp ) =
    this.then(
        Modifier .padding(horizontal =horizontal, vertical = horizontal),
    )
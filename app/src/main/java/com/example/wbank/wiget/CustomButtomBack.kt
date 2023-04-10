import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CustomButtomBack(
    navController:NavController,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box() {
        IconButton(
            onClick =onClick, modifier = modifier.width(37.dp).height(37.dp).padding(end = 10.dp)

        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack, contentDescription = "Icon",
                tint = Color(0xff565656),
                modifier = Modifier.height(30.dp).width(30.dp),

            )
        }
    }
}

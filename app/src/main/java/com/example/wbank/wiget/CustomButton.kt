import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.ui.theme.DiscretionColor
import com.example.wbank.ui.theme.Shapes

@Composable
fun CustomButton(
    onClickButtom: () -> Unit,
    nameButtom:String,
    backgroundColor: Color
) {
    Button(colors = ButtonDefaults.textButtonColors(
        backgroundColor = backgroundColor,
        disabledContentColor = DiscretionColor,
        contentColor = DiscretionColor
    ), modifier = Modifier.height(55.dp).fillMaxWidth(),
        shape = Shapes.small,//RoundedCornerShape(20.dp),TicketShape(24.dp.toPx())
        onClick = onClickButtom,

        ) {
        Text(text =nameButtom , style = MaterialTheme.typography.button.copy(Color.White),)

    }

}
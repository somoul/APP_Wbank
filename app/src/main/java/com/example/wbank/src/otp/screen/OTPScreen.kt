import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booking_app.ui.theme.navigation.Router
import com.example.booking_app.ui.theme.navigation.navigate
import com.example.wbank.ui.theme.BackgroundColor
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.ui.theme.DiscretionColor
import com.example.wbank.ui.theme.WbankTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OtpScreen(navController: NavController) {

    var numberTextField by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .background(color = BackgroundColor)
    ) {
        Box() {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .customPending(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 25.dp),
            ) {
                CustomButtomBack(navController, onClick = {
                    navController.navigateUp()
                })
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = "Wbank",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
                Text(
                    text = "Check your messages for OTP code and enter in the form below",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .padding(start = 20.dp, top = 7.dp, end = 20.dp, )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row() {
//                    Spacer(modifier = Modifier.weight(1f))

                    DecoratedTextField(
                        value = numberTextField,
                        length = 6,
//                        modifier = Modifier.padding(start = 5.dp),
                        onValueChange = {
                            numberTextField = it
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Default
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                            }
                        )
                    )
//                    Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Didn't receive SMS?",
                    style = MaterialTheme.typography.overline.copy(fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.End)
                )

                Spacer(modifier = Modifier.weight(1f))
       CustomButton(
                   onClickButtom = {
                       navController.navigate(Router.Login.Dashboard)
//                        navController.navigate(Router.Login.Dashboard)

                   },
                   nameButtom = "Log In",
                   backgroundColor =
                   if (numberTextField.count() > 5) {
                       ButtonColor
                   } else DiscretionColor
               )

           }
            }


    }
}


@Composable
fun DecoratedTextField(
    value: String,
    length: Int,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 40.dp,
    boxHeight: Dp = 40.dp,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
) {
    val spaceBetweenBoxes = 15.dp
    BasicTextField(modifier = modifier.background(Color.White),
        value = value,
        singleLine = true,
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

        decorationBox = {
            Row(
                Modifier.size(width = (boxWidth + spaceBetweenBoxes) * length, height = boxHeight),
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenBoxes),
            ) {

                repeat(length) { index ->
                    Box(
                        modifier = Modifier
                            .size(boxWidth, boxHeight)
                            .border(
                                1.6.dp,
                                color = if (value
                                        .getOrNull(index)
                                        ?.toString() != null
                                ) {
                                    ButtonColor
                                } else {
                                    Color(0xffD6DBDF)
                                },
                                shape = RoundedCornerShape(14.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = value.getOrNull(index)?.toString() ?: "",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h2.copy(
                                color = ButtonColor,
                                fontWeight = FontWeight.W500
                            )
                        )
                    }
                }

            }
        })
}


@Preview(showSystemUi = true)
@Composable
fun ViewOtpScreen() {
    val navController = rememberNavController()
    WbankTheme {
        OtpScreen(navController)
    }
}


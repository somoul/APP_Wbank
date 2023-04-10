import ConstantsShip.imageListShip
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.wbank.src.dashboard.homescreen.model.ConstantsTransactionModel
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.ui.theme.DiscretionColor
import com.example.wbank.ui.theme.IconColorTopBar
import com.example.wbank.wiget.CustomCartTransactions
import com.example.wbank.wiget.CustomShip
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TransferScreen(
    navHostController: NavHostController, id: Int? = 0
) {
    val indexCard = remember { mutableStateOf(-1) }
    val moneyCart = remember { mutableStateOf(0.0) }
    val inClickShip = remember { mutableStateOf(-1) }
    var sliderPosition by remember { mutableStateOf(0f) }
    val priceKhmer = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 19.dp, top = 15.dp, end = 19.dp)
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
                },
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Exchange", style = MaterialTheme.typography.h4.copy(
                        color = Color.Black.copy(alpha = 0.9f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                    ), modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Row(modifier = Modifier.padding(top = 15.dp)) {
                Text(
                    text = "Choose cart",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.h4.copy(
                        color = IconColorTopBar,
                        fontWeight = FontWeight.W500,
                    ),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            repeat(3) { index ->
                CustomCartTransactions(
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwL1CoGAdxzkHzXerFGNIf8lASXVRycr07gQ&usqp=CAU",
                    title = ConstantsTransactionModel.imageListTransactionModel[index].nameCard,
                    description = ConstantsTransactionModel.imageListTransactionModel[index].code,
                    price = ConstantsTransactionModel.imageListTransactionModel[index].balance,
                    date = ConstantsTransactionModel.imageListTransactionModel[index].date,
                    isPrice = true,
                    isMainCart = true,
                    nameCard = ConstantsTransactionModel.imageListTransactionModel[index].nameCard,
                    onClick = {
                        if (indexCard.value == index) {
                            indexCard.value = -1
                            moneyCart.value = 0.0
                            sliderPosition = 0f
                        } else {
                            sliderPosition = 0f
                            indexCard.value = index
                            val amount =
                                ConstantsTransactionModel.imageListTransactionModel[index].balance.asDecimal()
                            moneyCart.value = amount.round(MathContext(0, RoundingMode.CEILING))
                                .toDouble()// roommate String to Int
                        }
                        Log.i("ss", "${moneyCart.value}")
                    },
                    isClickCard = indexCard.value == index
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            Row(modifier = Modifier.padding(top = 7.dp)) {
                Text(
                    text = "Choose currency",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.h4.copy(
                        color = IconColorTopBar,
                        fontWeight = FontWeight.W500,
                    ),
                )
            }
            Row(
                modifier = Modifier.padding(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(27.dp)
            ) {
                repeat(imageListShip.size) { index ->
                    CustomShip(
                        nameShipExchange = imageListShip[index].nameShipExchange,
                        nameShip = "",
                        colorBackGround = imageListShip[index].colorBackGround,
                        icons = imageListShip[index].icons,
                        onClick = {
                            if (inClickShip.value == index) {
                                inClickShip.value = -1
                            } else {
                                inClickShip.value = index
                            }
                        },
                        isClickShip = inClickShip.value == index,
                        isExChang = true
                    )
                }
            }
            Row(modifier = Modifier.padding(start = 100.dp, top = 20.dp, end = 100.dp)) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color(0xffDCDAE5))
                ) {
                    IconButton(onClick = {
                        if (sliderPosition > 0) {
                            sliderPosition -= 1
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Remove,
                            contentDescription = "Click to share",
                            tint = DiscretionColor,
                            modifier = Modifier.size(17.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$${sliderPosition.toInt()}", style = MaterialTheme.typography.h3.copy(
                        fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.W500
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color(0xffDCDAE5))
                ) {
                    IconButton(onClick = { sliderPosition += 1 }) {
                        Icon(
                            imageVector = Icons.Outlined.Add,
                            contentDescription = "Click to share",
                            tint = DiscretionColor,
                            modifier = Modifier.size(17.dp)
                        )
                    }
                }
            }
            Slider(
                value = sliderPosition,
                onValueChange = {
                    sliderPosition = it
                    if (it.toInt() != 0) {
                        priceKhmer.value =
                            it.toInt() * ConstantsTransactionModel.imageListTransactionModel[indexCard.value].moneyRal.toInt()
                    } else {
                        priceKhmer.value = 0
                    }
                },
                colors = SliderDefaults.colors(
                    thumbColor = ButtonColor,
                    activeTrackColor = ButtonColor,
                    inactiveTrackColor = if (moneyCart.value != 0.0) {
                        Color(0xffE3E3E7).copy(alpha = 0.6f)
                    } else {
                        ButtonColor.copy(alpha = 0.6f)
                    }
                ),
                steps = 0,
                valueRange = if (moneyCart.value != null) {
                    0f..moneyCart.value.toFloat()
                } else {
                    0f..0f
                }
            )
            Row(modifier = Modifier.padding(top = 2.dp)) {
                Text(
                    text = "Available :$${moneyCart.value.toFloat()}",
                    style = MaterialTheme.typography.h4.copy(
                        color = IconColorTopBar,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                if (indexCard.value != -1) {
                    Text(
                        text = "1$ = រ ${ConstantsTransactionModel.imageListTransactionModel[indexCard.value].moneyRal}",
                        style = MaterialTheme.typography.h4.copy(
                            color = IconColorTopBar,
                            fontWeight = FontWeight.W500,
                        ),
                    )
                } else {
                    Text(
                        text = "1$ =0$",
                        style = MaterialTheme.typography.h4.copy(
                            color = IconColorTopBar,
                            fontWeight = FontWeight.W500,
                        ),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Your will get",
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 16.sp,
                        color = IconColorTopBar,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Text(
                    text = "រ ${priceKhmer.value}",
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))

            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Commission is not charged",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 15.sp,
                    color = IconColorTopBar,
                    fontWeight = FontWeight.W500,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(top = 15.dp, bottom = 10.dp)
            )
            CustomButton(
                onClickButtom = {
                    if (priceKhmer.value > 0 && inClickShip.value != -1) {
                        navHostController.navigate("/success/${indexCard.value}")
                    } else {
                        DiscretionColor
                    }


                },
                nameButtom = "Exchange",
                backgroundColor = if (priceKhmer.value > 0 && inClickShip.value != -1) {
                    ButtonColor
                } else {
                    DiscretionColor
                }


            )
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}


fun String?.asDecimal(locale: Locale? = null): BigDecimal {
    if (this.isNullOrEmpty()) return BigDecimal.ZERO
    val format = NumberFormat.getNumberInstance(locale ?: Locale.getDefault())
    if (format is DecimalFormat) {
        format.isParseBigDecimal = true
        format.roundingMode = RoundingMode.HALF_UP
    }
    return format.parse(this.replace("[^-(?\\d.)]".toRegex(), "")) as? BigDecimal ?: BigDecimal.ZERO
}

fun BigDecimal.asString(decimal: Int = 2): String {
    return "%${decimal}f".format(this)
}




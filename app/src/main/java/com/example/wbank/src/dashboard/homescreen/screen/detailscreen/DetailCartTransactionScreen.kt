import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.wbank.src.dashboard.homescreen.model.ConstantsTransactionModel
import com.example.wbank.wiget.CustomCartTransactions
import com.example.wbank.wiget.CustomShip


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailCartTransactionScreen(
    navHostController: NavHostController,
    id: Int? = 0

) {
    val listShipDetail = ConstantsShipDetail.imageListShip
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp)) {
            Row {
                CustomButtomBack(navHostController, onClick = {
                    navHostController.navigateUp()
                })
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 23.dp, end = 20.dp)
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)


                    ) {
                        Text(
                            text = "Details:",
                            style = MaterialTheme.typography.h4.copy(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            ),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Text(
                            text = ConstantsTransactionModel.imageListTransactionModel[id!!].date, //"10 Apr 01:02",
                            style = MaterialTheme.typography.h4.copy(
                                color = Color.Black.copy(alpha = 0.4f),
                                fontSize = 14.sp,

                                fontWeight = FontWeight.W500,
                            ),
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Image(
                            painter = rememberAsyncImagePainter(
                                ConstantsTransactionModel.imageListTransactionModel[id].image

                            ),
                            contentDescription = "Circle Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(83.dp)

                                .clip(shape = RoundedCornerShape(10.dp))// clip to the circle shape
                            //optional
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Text(
                            text = ConstantsTransactionModel.imageListTransactionModel[id].price,
                            style = MaterialTheme.typography.h4.copy(
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.W600,
                            ),
                            modifier = Modifier.padding(start = 12.dp)

                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Transfer to a bank card  via mobile app Recipient:  ",
                        style = MaterialTheme.typography.h4.copy(
                            color = Color.Black.copy(alpha = 0.4f),
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500,
                        ),
                    )
                    Row(

                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "${ConstantsTransactionModel.imageListTransactionModel[id!!].title} ",
                            style = MaterialTheme.typography.h4.copy(
                                color = Color.Black.copy(alpha = 0.9f),
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.W500,
                            ),
                        )
                        Spacer(modifier = Modifier.weight(1f))

                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(15.dp))
            CustomCartTransactions(
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwL1CoGAdxzkHzXerFGNIf8lASXVRycr07gQ&usqp=CAU",
                title = "Main cart",
                description = " 269",
                price = ConstantsTransactionModel.imageListTransactionModel[id!!].balance,
                date = ConstantsTransactionModel.imageListTransactionModel[id].code,
                isPrice = true,
                isMainCart = true,
                onClick = {
                },
                nameCard = "Main cart",
                isClickCard = false

            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "Initial amount ",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,


                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = ConstantsTransactionModel.imageListTransactionModel[id].amount,
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "Balance ",
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = ConstantsTransactionModel.imageListTransactionModel[id].balance,
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(top = 15.dp),

                horizontalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                repeat(listShipDetail.size) { index ->
                    CustomShip(
                        nameShip = listShipDetail[index].nameShip,
                        colorBackGround = listShipDetail[index].colorBackGround,
                        icons = listShipDetail[index].icons,
                        onClick = {},
                        isExChang = false,
                        nameShipExchange = ""


                    )

                }

            }


        }

    }

}



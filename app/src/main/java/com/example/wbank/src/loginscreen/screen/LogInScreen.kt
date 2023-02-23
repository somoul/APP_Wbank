//
//import android.annotation.SuppressLint
//import android.util.Log
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.relocation.BringIntoViewRequester
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.TopAppBar
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.onFocusEvent
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.platform.LocalView
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.wbank.ui.theme.WbankTheme
//import kotlinx.coroutines.launch
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun LogInScreen(navController: NavController) {
//    val fm = LocalFocusManager.current
//    val fields = remember {
//        mutableStateListOf(*(0..20).map { n ->
//            "Please enter text here!" to ""
//        }.toTypedArray())
//    }
//
//    Log.i("Field", "Data: ${fields.toSet()}")
//    val states = remember {
//        mutableStateListOf("1", "2", "3",
//            "4", "5", "6", "7", "8", "9", "10")
//    }
//
//    // test new
//    val state = rememberLazyListState()
//    val coroutineScope= rememberCoroutineScope()
//    val focusManager= LocalFocusManager.current
//
//    val bringIntoViewRequester = remember { BringIntoViewRequester() }
//    val scope = rememberCoroutineScope()
//    val view = LocalView.current
//
//
//    Scaffold(
//        topBar = {
//            TopAppBar() {
//
//            }
//        }
//
//    ) {
////        Box(
////            modifier = Modifier
////                .fillMaxSize()
//////                .safeContentPadding()
////        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState()),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                repeat(20) { item ->
//                    OutlinedTextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(60.dp),
////                        .onFocusEvent { event ->
////                            if (event.isFocused) {
////                                scope.launch { bringIntoViewRequester.bringIntoView() }
////                            }
////
////                        },
//                        //.imePadding(), // true
////                       .statusBarsPadding().navigationBarsPadding(),//false
//                        value = "",
//                        label = { Text(text = "") },
//                        onValueChange = {
////                        fields[index] = field.copy(second = it)
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Password,
//                            imeAction = ImeAction.Next,
//                        ),
//                        keyboardActions = KeyboardActions(onDone = {
//                            fm.clearFocus(true)
//                        })
//                    )
//                    Spacer(modifier = Modifier.height(10.dp))
//                }
//            }
//
//
//        }
//
////    }
//
//
//
//
//}
//
//
//@Preview(showSystemUi = true)
//@Composable
//fun ViewLogInScreen() {
//    val navController = rememberNavController()
//    WbankTheme {
//        LogInScreen(navController)
//    }
//}
//

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booking_app.ui.theme.navigation.Router
import com.example.booking_app.ui.theme.navigation.navigate
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.ui.theme.DiscretionColor
import com.example.wbank.ui.theme.WbankTheme
import com.example.wbank.wiget.CustomTextField

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogInScreen(navController: NavController) {
    var numberTextField by remember { mutableStateOf("") }
    var passwordTextField by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.background(Color(0xffF4F5F8))
        //.verticalScroll(rememberScrollState(),)
    ) {
        Box {

            Column(
                modifier =
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .align(Alignment.Center)
                    .customPending(start = 28.dp, end = 28.dp, top = 0.dp, bottom = 0.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Wbank",
                    style = MaterialTheme.typography.subtitle2,

                    modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.CenterHorizontally)
                )
                Text(
                    text = "Enter your phone number and password",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(10.dp))
                repeat(2) { item ->
                    if (item == 0) {
                        if (numberTextField.isNotEmpty())
                        {
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                        CustomTextField(
                            label = "Phone number",
                            onValueChange = {
                                numberTextField = it
                            },
                            keyboardType = KeyboardType.Number
                        )
                    } else {
                        if (passwordTextField.isNotEmpty())
                        {
                            Spacer(modifier = Modifier.height(5.dp))
                        }
                        CustomTextField(
                            label = "Password",
                            onValueChange = {
                                passwordTextField = it
                            },
                            keyboardType = KeyboardType.Password,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }
                Text(
                    text = "Forget password?",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.End).padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.weight(1f))
                Box() {
                    CustomButton(
                        onClickButtom = {
                            if (numberTextField.count() >= 8 && passwordTextField.count() >= 6) {
                                navController.navigate(Router.Login.Otp)
                            }
                        },
                        nameButtom = "Log In",
                        backgroundColor = if (numberTextField.count() >= 8 && passwordTextField.count() >= 6) ButtonColor else DiscretionColor
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ViewLogInScreen() {
    val navController = rememberNavController()
    WbankTheme {
        LogInScreen(navController)
    }
}


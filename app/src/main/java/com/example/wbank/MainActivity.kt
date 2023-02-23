package com.example.wbank
import DetailCartTransactionScreen
import LogInScreen
import OtpScreen
import SplashScreen
import TransferScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.booking_app.ui.theme.navigation.Router
import com.example.booking_app.ui.theme.navigation.composableRoute
import com.example.wbank.src.dashboard.homescreen.screen.ContactsScreen
import com.example.wbank.src.dashboard.homescreen.screen.exchangscreen.SuccessScreen
import com.example.wbank.src.dashboard.screen.DashboardScreen
import com.example.wbank.ui.theme.WbankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows()
        setContent {
            WbankTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Router.Splash.route) {
                    composableRoute(Router.Splash) {
                        SplashScreen(navController)
                    }
                    navigation(
                        route = Router.Login.Me.route, startDestination = Router.Login.Email.route
                    ) {
                        composableRoute(Router.Login.Email) {
                            LogInScreen(navController)
                        }
                        composableRoute(Router.Login.Otp) {
                            OtpScreen(navController)
                        }

                        composableRoute(Router.Login.Dashboard) {
                            DashboardScreen(
                                navController
                            )
                        }
                        composableRoute(Router.Contacts) {
                            ContactsScreen(
//                                navController
                            )
                        }


                        composable(
                            "/trans-detail/{id}",
//                            "/trans-detail/{title}/{date}/{transfer}/{code}/{balance}/{amount}",
                            arguments = listOf(
                                navArgument(name = "id") {
                                    type = NavType.IntType
                                },
                            )
                        ) { navBackStackEntry ->
                            DetailCartTransactionScreen(
                                navController,
                                id = navBackStackEntry.arguments?.getInt("id"),
                            )
                        }
                        composableRoute(Router.Transfer) {
                            TransferScreen(
                                navController
                            )
                        }///success
                        composable(
                            "/success/{id}",
                            arguments = listOf(
                                navArgument(name = "id") {
                                    type = NavType.IntType
                                },
                            )
                        ) { navBackStackEntry ->
                            navBackStackEntry.arguments?.getInt("id")?.let {
                                SuccessScreen(
                                    navController,
                                    id = it,
                                )
                            }
                        }

                    }//SuccessScreen
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WbankTheme {
        Greeting("Android")
    }
}
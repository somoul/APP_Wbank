package com.example.wbank.src.dashboard.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wbank.src.dashboard.homescreen.screen.ContactsScreen
import com.example.wbank.src.dashboard.homescreen.screen.FavoritesScreen
import com.example.wbank.src.dashboard.homescreen.screen.GridViewScreen
import com.example.wbank.src.dashboard.homescreen.screen.homescreen.HomeScreen
import com.example.wbank.ui.theme.ButtonColor
import com.example.wbank.ui.theme.IconColorTopBar
import com.example.wbank.ui.theme.WbankTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navControllerRouter: NavHostController) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.background(Color.Red),
        content = { NavigationHost(navController, navControllerRouter) },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
    )
}

@Composable
fun NavigationHost(navController: NavHostController, navControllerRoute: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
            HomeScreen(navControllerRoute)
        }
        composable(NavRoutes.Contacts.route) {
            ContactsScreen()
        }
        composable(NavRoutes.Favorites.route) {
            FavoritesScreen()
        }
        composable(NavRoutes.GridView.route) {
            GridViewScreen()
        }
    }
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contacts")
    object Favorites : NavRoutes("favorites")
    object GridView : NavRoutes("gridView")
}

data class BarItem(
    val image: ImageVector,
    val route: String
)

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            image = Icons.Filled.Bento,
            route = "contacts"
        ),
        BarItem(
            image = Icons.Filled.StopCircle,
            route = "favorites"
        ),
        BarItem(
            image = Icons.Filled.GridView,
            route = "gridView"
        ),
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.primary
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        NavBarItems.BarItems.forEach { navItem ->
            BottomNavigationItem(
                modifier = Modifier.padding(top = 8.dp, bottom = 13.dp),// delete from phone
//                    .padding(top = 8.dp, bottom = 0.dp),
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = "",//navItem.title,
                        tint = if (currentRoute == navItem.route) {
                            ButtonColor
                        } else {
                            IconColorTopBar
                        }
                    )
                },
                label = {
//                    Text(text = "${currentRoute == navItem.route}")
                },
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ViewHomeScreen() {
    val navController = rememberNavController()
    WbankTheme {
//        DashboardScreen()
    }
}

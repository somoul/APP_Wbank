package com.example.booking_app.ui.theme.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable

sealed class Router(open val route: String) {
    var arg: Any? = null
    operator fun invoke() = this.route//invoke() ==String
    operator fun invoke(arg: Any?): String {
        this.arg = arg
        return this.route
    }

    object Splash : Router("/splash")
    sealed class Login(path: String?) : Router("/login/$path") {
        object Me : Login(null)
        object Email : Login("/email")
        object Otp : Login("/otp")
        object Dashboard : Login("/dashboard")
    }

    object DetailTransaction : Router("/trans-detail")
    object Transfer : Router("/ex-chang")//ContactsScreen
    object Success : Router("/success")
    object Contacts : Router("/contacts")

}

fun NavController.navigate(
    route: Router,
    arg: Any? = null,
    optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null
) = navigate(route.invoke(arg)) {
    optionsBuilder?.invoke(this)
}

fun NavGraphBuilder.composableRoute(
    route: Router,
    content: @Composable (NavBackStackEntry) -> Unit
) = composable(route = route.invoke()) {
    content.invoke(it)
}
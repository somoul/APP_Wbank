//import androidx.navigation.NavController
//import com.example.booking_app.R
//import com.example.booking_app.ui.theme.navigation.Router
//import com.example.booking_app.ui.theme.navigation.navigate
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booking_app.ui.theme.navigation.Router
import com.example.booking_app.ui.theme.navigation.navigate
import com.example.wbank.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2300)
//        navController.navigate(Router.Login.Me) {
//            this.popUpTo(Router.Splash.route) {
//                this.inclusive = true
//            }
//        }
//            navController.navigate(Router.Login.Otp) {
//                this.popUpTo(Router.Splash.route) {
//                    this.inclusive = true
//                }
//        }
        navController.navigate(Router.Login.Dashboard) {
            this.popUpTo(Router.Splash.route) {
                this.inclusive = true
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Image(
            painter = painterResource(id = R.drawable.image_splash_screen),
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier
                .height(90.dp)
                .width(180.dp)
        )
        Text(
            text = "wbank",
            color = Color(0xff1A1B25),
            fontWeight = FontWeight.W600,
            style = TextStyle(fontSize = 26.5.sp)
        )
        Spacer(modifier = Modifier.height(180.dp))
        LoadingAnimation3()
    }
}

@Composable
fun LoadingAnimation3(
    circleColor: Color = Color(0xffD06672),
    circleSize: Dp = 18.dp,
    animationDelay: Int = 400,
    initialAlpha: Float = 0.3f
) {
    // 3 circles
    val circles = listOf(
        remember {
            Animatable(initialValue = initialAlpha)

        },
        remember {
            Animatable(initialValue = initialAlpha)
        },
        remember {
            Animatable(initialValue = initialAlpha)
        }
    )
    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            delay(timeMillis = (animationDelay / circles.size).toLong() * index)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = animationDelay
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
    }
    // container for circles
    Row(
        modifier = Modifier
    ) {
        circles.forEachIndexed { index, animatable ->
            if (index != 0) {
                Spacer(modifier = Modifier.width(width = 6.dp))
            }
            Box(
                modifier = Modifier
                    .size(size = circleSize)
                    .clip(shape = CircleShape)
                    .background(
                        color = circleColor
                            .copy(alpha = animatable.value)
                    )
            ) {
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ViewSplassScreen() {
    val navController = rememberNavController()
    SplashScreen(navController)

}

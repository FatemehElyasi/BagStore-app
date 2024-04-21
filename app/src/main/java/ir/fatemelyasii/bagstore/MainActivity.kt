package ir.fatemelyasii.bagstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.fatemelyasii.bagstore.ui.theme.BagStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BagStoreTheme {
                BagStoreUi()

            }
        }
    }


}

@Composable
private fun BagStoreUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "") {
        //screens
        composable(
            route = "ProductScreen/{ProductScreen}",
            arguments = listOf(navArgument("ProductId") {
                type = NavType.IntType
            })
        ) {

            ProductScreen(it.arguments!!.getInt("ProductId", -1))

        }
        //-------
        composable(
            route = "CategoryScreen",
            arguments = listOf(navArgument("CategoryName") {
                type = NavType.StringType
            })
        ) {
            CategoryScreen(it.arguments!!.getString("CategoryName", "null"))
        }
        //------
        composable("MainScreen") {
            MainScreen()
        }
        composable("ProfileScreen") {
            ProfileScreen()
        }
        composable("CartScreen") {
            CartScreen()
        }
        composable("SignUpScreen") {
            SignUpScreen()
        }
        composable("SignInScreen") {
            SignInScreen()
        }
        composable("IntroScreen") {
            IntroScreen()
        }
        composable("NoInternetScreen") {
            NoInternetScreen()
        }
    }
}
//-------------------------

@Composable
fun ProductScreen(productId: Int) {
}

@Composable
fun CategoryScreen(categoryName:String) {
}

@Composable
fun ProfileScreen() {
}

@Composable
fun CartScreen() {
}

@Composable
fun SignUpScreen() {
}

@Composable
fun SignInScreen() {
}

@Composable
fun MainScreen() {
}

@Composable
fun NoInternetScreen() {
}

@Composable
fun IntroScreen() {
}




@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    BagStoreTheme {
    }
}
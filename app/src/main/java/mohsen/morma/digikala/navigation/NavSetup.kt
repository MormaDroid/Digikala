package mohsen.morma.digikala.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import mohsen.morma.digikala.ui.screen.basket.BasketScreen
import mohsen.morma.digikala.ui.screen.category.CategoryScreen
import mohsen.morma.digikala.ui.screen.checkout.CheckoutScreen
import mohsen.morma.digikala.ui.screen.home.HomeScreen
import mohsen.morma.digikala.ui.screen.product.ProductDetailScreen
import mohsen.morma.digikala.ui.screen.product.ProductIntroductionSection
import mohsen.morma.digikala.ui.screen.product.SetCommentSection
import mohsen.morma.digikala.ui.screen.product.TechnicalInfoSection
import mohsen.morma.digikala.ui.screen.profile.ProfileScreen
import mohsen.morma.digikala.ui.screen.splash.SplashScreen

@Composable
fun NavSetup(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) { SplashScreen(navController) }

        composable(Screen.Home.route) { HomeScreen(navController) }

        composable(Screen.Category.route) { CategoryScreen() }

        composable(Screen.Basket.route) { BasketScreen(navController) }

        composable(Screen.Profile.route) { ProfileScreen() }

        composable(Screen.Checkout.route) { CheckoutScreen(navController) }

        composable(
            Screen.ProductDetail.route + "/{productId}",
            arguments = listOf(navArgument("productId") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) { data ->
            data.arguments?.getString("productId")?.let { ProductDetailScreen(navController, it) }
        }

        composable(
            Screen.Description.route + "/{description}",
            arguments = listOf(navArgument("description") {
                defaultValue = ""
                type = NavType.StringType
                nullable = true
            })
        ) { argument ->

            argument.arguments?.getString("description")?.let {
                ProductIntroductionSection(description = it)
            }


        }

        composable(
            Screen.Technical.route + "/{jsonString}", arguments = listOf(navArgument("jsonString") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) { argument ->

            argument.arguments?.getString("jsonString")?.let {
                TechnicalInfoSection(jsonString = it)
            }


        }

        composable(
            Screen.AddComment.route + "?{productId}?{productName}?{imageUrl}",
            arguments = listOf(navArgument("productId") {
                type = NavType.StringType
                defaultValue = ""
            }, navArgument("productName") {
                type = NavType.StringType
                defaultValue = ""
            }, navArgument("imageUrl") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) { argument ->

            argument.arguments?.getString("productId")?.let { id ->
                argument.arguments?.getString("productName")?.let { name ->
                    argument.arguments?.getString("imageUrl")?.let { image ->
                        SetCommentSection(navController, id, name, image)
                    }
                }
            }
        }

    }
}
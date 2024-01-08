package mohsen.morma.digikala.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.Typography

@Composable
fun BottomNav(navController: NavHostController) {

    val itemsList = listOf(

        NavItem(
            R.string.nav_home,
            Screen.Home.route,
            R.drawable.home_fill,
            R.drawable.home_outline
        ),
        NavItem(
            R.string.nav_category,
            Screen.Category.route,
            R.drawable.category_fill,
            R.drawable.category_outline
        ),
        NavItem(
            R.string.nav_basket,
            Screen.Basket.route,
            R.drawable.cart_fill,
            R.drawable.cart_outline
        ),
        NavItem(
            R.string.nav_profile,
            Screen.Profile.route,
            R.drawable.user_fill,
            R.drawable.user_outline
        )

    )

    val backStackEntry by navController.currentBackStackEntryAsState()

    val showBottomNav = backStackEntry?.destination?.route in itemsList.map { it.route }

    if (showBottomNav) {

        BottomNavigation(
            backgroundColor = White,
            elevation = 8.dp
        ) {

            itemsList.forEach{item ->

                val selected = item.route == backStackEntry?.destination?.route

                BottomNavigationItem(
                    selected = selected,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                            Icon(
                                painter = painterResource(id = if (selected) item.selectedItem else item.unSelectedItem),
                                contentDescription = item.route,
                                modifier = Modifier.height(24.dp)
                            )
                    },
                    label = {
                        if (selected)
                            Text(
                                text = stringResource(id = item.name),
                                style = Typography.h6
                            )
                    },
                    alwaysShowLabel = false,
                )

            }

        }

    }

}
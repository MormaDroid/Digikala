package mohsen.morma.digikala.ui.screen.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mohsen.morma.digikala.R
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.viewmodel.BasketVM

@Composable
fun BasketScreen(navController: NavHostController) {

    BasketUI(navController = navController)

}

@Composable
fun BasketUI(basketVM: BasketVM = hiltViewModel(),navController: NavHostController) {

    val  totalCurrentCartCount by basketVM.totalCurrentCartCount.collectAsState(initial = 0)

    val totalNextCartCount by basketVM.totalNextCartCount.collectAsState(initial = 0)

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val tabList = listOf(
        R.string.cart,
        R.string.next_cart_list
    )

    Column {

        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.padding(horizontal = 16.dp),
            indicator = {
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(it[selectedTabIndex])
                        .height(2.dp)
                        .background(if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed)
                )
            }
        ) {

            tabList.forEachIndexed { index, item ->

                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {

                        Row {
                            Text(
                                text = stringResource(item),
                                style = Typography.h5,
                                color = if (selectedTabIndex == index) {
                                    if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                                } else {
                                    if (isSystemInDarkTheme()) Color.DarkGray else Color.Gray
                                }
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            val cartCounter = if (index == 0 ) totalCurrentCartCount else totalNextCartCount

                            if (cartCounter>0) SetBadgeToTab(selectedTabIndex , index , cartCounter)


                        }


                    }
                )

            }

        }

        when (selectedTabIndex) {
            0 -> ShoppingCart(navController = navController)
            1 -> NextShoppingCart()
        }

    }

}



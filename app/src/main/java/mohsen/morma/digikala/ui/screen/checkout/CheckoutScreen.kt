package mohsen.morma.digikala.ui.screen.checkout

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.checkout.OrderModel
import mohsen.morma.digikala.ui.component.ScreenLoading
import mohsen.morma.digikala.ui.screen.basket.BuyProcessContinue
import mohsen.morma.digikala.ui.screen.basket.CartPriceDetailSection
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.viewmodel.AddressVM
import mohsen.morma.digikala.viewmodel.BasketVM
import mohsen.morma.digikala.viewmodel.CheckoutVM

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckoutScreen(
    navController: NavHostController,
    basketVM: BasketVM = hiltViewModel(),
    addressVM: AddressVM = hiltViewModel(),
    checkoutVM: CheckoutVM = hiltViewModel()
) {

    val context = LocalContext.current

    val cartDetail by basketVM.cartDetail.collectAsState()
    val cartList by basketVM.ourCartList.collectAsState()

    var address by remember {
        mutableStateOf("")
    }
    var addressName by remember {
        mutableStateOf("")
    }
    var addressPhone by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    val addressResult by addressVM.addressList.collectAsState()


    when (addressResult) {
        is NetworkResult.Success -> {

            Log.e(Constants.TAG, "success")

            addressResult.data?.let {
                Log.e(Constants.TAG, "CartAddressSection:${it[0].address}")
                if (it.isEmpty()) {
                    address = context.getText(R.string.no_address).toString()
                    addressName = ""
                } else {
                    address = it[it.lastIndex].address
                    addressName = it[it.lastIndex].name
                    addressPhone = it[it.lastIndex].name

                    checkoutVM.getShippingCost(it[it.lastIndex].address)

                }

            }
            isLoading = false
        }

        is NetworkResult.Error -> {
            Log.e(Constants.TAG, "ERR")
            isLoading = true
            Log.e(Constants.TAG, "CenterBanners: ${addressResult.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }
    }


    var shippingCost by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(true) {
        checkoutVM.shippingCost.collectLatest { data ->
            data.data?.let { shippingCost = it }
        }
    }

    if (isLoading) {
        val height = LocalConfiguration.current.screenHeightDp
        ScreenLoading(height = height)
    }

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = { DeliveryTimeBottomSheet() }
        ) {
            Box(Modifier.fillMaxSize()) {

                LazyColumn {

                    item { CheckoutTopBarSection(navController) }

                    item { CheckoutDivider() }

                    item { Spacer(modifier = Modifier.size(12.dp)) }

                    item { CartAddressSection(address, addressName) }

                    item { Spacer(modifier = Modifier.size(16.dp)) }

                    item {
                        Text(
                            text = stringResource(id = R.string.delivery_method),
                            style = Typography.h3,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    item { Spacer(modifier = Modifier.size(10.dp)) }

                    item {
                        CartItemReviewSection(cartList, cartDetail) {
                            scope.launch {
                                sheetState.show()
                            }
                        }
                    }

                    item { Spacer(modifier = Modifier.size(12.dp)) }

                    item { InvoiceSection() }

                    item { Spacer(modifier = Modifier.size(16.dp)) }

                    item {
                        CartPriceDetailSection(
                            cartDetail = cartDetail,
                            isCheckout = true,
                            shippingCost
                        )
                    }


                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = Color.LightGray.copy(0.2f), RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .align(Alignment.BottomCenter)
                        .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
                    Arrangement.SpaceBetween,
                    Alignment.CenterVertically
                ) {

                    BuyProcessContinue(cartDetail.totalPayable + shippingCost) {
                        checkoutVM.addNewOrder(
                            OrderModel(
                                orderAddress = address,
                                orderTotalPrice = (cartDetail.totalPayable + shippingCost),
                                orderTotalDiscount = cartDetail.totalDiscount,
                                orderUserPhone = addressPhone,
                                token = Constants.USER_TOKEN,
                                orderProducts = cartList,
                                orderUserName = addressName,
                                orderDate = "20402"
                            )
                        )
                    }

                }

            }
        }
    }

}







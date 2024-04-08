package mohsen.morma.digikala.ui.screen.product

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.home.AmazingProductModel
import mohsen.morma.digikala.data.remote.model.product.Comment
import mohsen.morma.digikala.data.remote.model.product.ProductResponse
import mohsen.morma.digikala.navigation.Screen
import mohsen.morma.digikala.ui.component.ScreenLoading
import mohsen.morma.digikala.ui.screen.checkout.CheckoutDivider
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.util.Constants.USER_TOKEN
import mohsen.morma.digikala.viewmodel.ProductVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    productId: String,
    productVM: ProductVM = hiltViewModel()
) {

    productVM.getProduct(productId)


    var isLoading by remember {
        mutableStateOf(false)
    }

    var productDetail by remember {
        mutableStateOf(ProductResponse())
    }

    var description by rememberSaveable {
        mutableStateOf("")
    }

    var technical by rememberSaveable {
        mutableStateOf("")
    }

    var comments by rememberSaveable {
        mutableStateOf<List<Comment>>(emptyList())
    }

    var commentCount by rememberSaveable {
        mutableIntStateOf(0)
    }

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var image by rememberSaveable {
        mutableStateOf("")
    }



    LaunchedEffect(true) {
        productVM.productDetail.collectLatest { result ->
            when (result) {
                is NetworkResult.Success -> {
                    result.data?.let { product ->
                        productDetail = product
                        description = product.description.toString()
                        technical = product.technicalFeatures.toString()
                        product.categoryId?.let { categoryId ->
                            productVM.getSimilarProducts(
                                categoryId
                            )
                        }
                        product.comments?.let { comments = it }
                        product.commentCount?.let { commentCount = it }
                        product.name?.let { name = it }
                        product.imageSlider?.let { image = it[0].image }
                    }

                    delay(700)
                    isLoading = false
                }

                is NetworkResult.Error -> {
                    Log.e(TAG, "ProductDetailScreen: ${result.message}")
                    isLoading = true
                }

                is NetworkResult.Loading -> {
                    isLoading = true
                }
            }
        }
    }

    var similarProductList by rememberSaveable {
        mutableStateOf<List<AmazingProductModel>>(emptyList())
    }

    LaunchedEffect(true) {
        productVM.similarProducts.collectLatest { similarList ->

            when (similarList) {
                is NetworkResult.Success -> {
                    similarList.data?.let {
                        similarProductList = it
                    }
                    delay(700)
                    isLoading = false
                }

                is NetworkResult.Error -> {
                    Log.e(TAG, "ProductDetailScreen: ${similarList.message}")
                    isLoading = true
                }

                is NetworkResult.Loading -> {
                    isLoading = true
                }
            }

        }
    }


    val height = LocalConfiguration.current.screenHeightDp
    if (isLoading) ScreenLoading(height = height)

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {

        if (productDetail.name != null) {
            Scaffold(
                bottomBar = {
                    ProductDetailBottomBar(
                        productItem = productDetail,
                        id = productId
                    )
                }
            ) {
                ProductUI(
                    navController,
                    productDetail,
                    similarProductList,
                    description,
                    technical,
                    comments,
                    commentCount,
                    productId,
                    name,
                    image
                )
            }
        }

    }


}

@Composable
fun ProductUI(
    navController: NavHostController,
    product: ProductResponse,
    similarProductList: List<AmazingProductModel>,
    description: String,
    technical: String,
    comments: List<Comment>,
    commentCount: Int,
    id: String,
    name: String,
    image: String
) {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 80.dp, top = 16.dp)
    ) {

        item { TopSliderProduct(product) }

        item { Spacer(modifier = Modifier.size(16.dp)) }

        item { ProductHeaderSection(product) }

        item { Spacer(modifier = Modifier.size(16.dp)) }

        item { CheckoutDivider(thickness = 6.dp, spacerSize = 24.dp) }

        item { Spacer(modifier = Modifier.size(24.dp)) }

        item { SellerInfoSection(product.price?.toLong()!!) }

        item { CheckoutDivider(thickness = 6.dp, spacerSize = 24.dp) }

        item { Spacer(modifier = Modifier.size(24.dp)) }

        item {
            product.categoryId?.let {
                SimilarProductsSection(
                    navController,
                    similarProductList
                )
            }
        }

        item { CheckoutDivider(thickness = 6.dp, spacerSize = 24.dp) }

        item { Spacer(modifier = Modifier.size(24.dp)) }

        item {
            ProductDescriptionSection(
                navController,
                description = description,
                technical = technical
            )
        }

        item { CheckoutDivider(thickness = 6.dp, spacerSize = 24.dp) }

        item { Spacer(modifier = Modifier.size(24.dp)) }

        item {
            ProductCommentSection(comments, commentCount)
        }

        item { Spacer(modifier = Modifier.size(24.dp)) }

        item {
            ProductAddCommentSection {

                if (USER_TOKEN == "null")
                    navController.navigate(Screen.Profile.route)
                else
                    navController.navigate(
                        Screen.AddComment.route + "?productId=${id}?productName=${name}?imageUrl=${image}"
                    )
            }
        }

        item { CheckoutDivider(thickness = 1.dp, spacerSize = 24.dp) }

        item { Spacer(modifier = Modifier.size(24.dp)) }


    }

}






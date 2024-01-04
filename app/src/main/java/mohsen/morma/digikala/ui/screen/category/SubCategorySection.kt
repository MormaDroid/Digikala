package mohsen.morma.digikala.ui.screen.category

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.NetworkResult
import mohsen.morma.digikala.data.remote.model.category.SubCategoryModel
import mohsen.morma.digikala.ui.component.ScreenLoading
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.CategoryVM

@Composable
fun SubCategorySection(categoryVM: CategoryVM = hiltViewModel()) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    var toolList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var digitalList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var mobileList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var supermarketList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var fashionList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var nativeList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var toyList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var beautyList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var homeList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var bookList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }
    var sportList by remember {
        mutableStateOf<List<SubCategoryModel>>(emptyList())
    }

    val result by categoryVM.categoryList.collectAsState()

    when (result) {

        is NetworkResult.Success -> {
            result.data?.let {
                toolList = it.tool
                digitalList = it.digital
                mobileList = it.mobile
                supermarketList = it.supermarket
                fashionList = it.fashion
                nativeList = it.naive
                toyList = it.toy
                beautyList = it.beauty
                homeList = it.home
                bookList = it.book
                sportList = it.sport
            }

            isLoading = false

        }

        is NetworkResult.Error -> {
            isLoading = true
            Log.e(TAG, "CategoryScreen: ${result.message}")
        }

        is NetworkResult.Loading -> {
            isLoading = true
        }

    }

    val height = LocalConfiguration.current.screenHeightDp

    if (isLoading) {
        ScreenLoading(height)
    }

    AnimatedVisibility(visible = !isLoading, enter = fadeIn(tween(2000))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CategoryItem(
                R.string.industrial_tools_and_equipment,
                toolList
            )
            CategoryItem(
                title = R.string.digital_goods,
                subList = digitalList
            )
            CategoryItem(
                title = R.string.mobile,
                subList = mobileList
            )
//            CategoryItem(
//                title = R.string.fashion_and_clothing,
//                subList = fashionList
//            )
            CategoryItem(
                title = R.string.supermarket_product,
                subList = supermarketList
            )
            CategoryItem(
                title = R.string.toys_children_and_babies,
                subList = toyList
            )
            CategoryItem(
                title = R.string.beauty_and_health,
                subList = beautyList
            )
            CategoryItem(
                title = R.string.home_and_kitchen,
                subList = homeList
            )
            CategoryItem(
                title = R.string.books_and_stationery,
                subList = bookList
            )
            CategoryItem(
                title = R.string.sports_and_travel,
                subList = sportList
            )
        }
    }





}



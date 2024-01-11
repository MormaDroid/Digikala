package mohsen.morma.digikala.ui.screen.product

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.product.SetNewCommentModel
import mohsen.morma.digikala.ui.screen.checkout.CheckoutDivider
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.DigikalaDarkRed
import mohsen.morma.digikala.ui.theme.DigikalaRed
import mohsen.morma.digikala.ui.theme.GoldColor
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.Constants
import mohsen.morma.digikala.util.Constants.TAG
import mohsen.morma.digikala.viewmodel.ProductVM

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetCommentSection(
    navController: NavHostController,
    productId: String,
    productName: String,
    imageUrl: String,
    productVM: ProductVM = hiltViewModel()
) {

    var sliderValue by remember {
        mutableFloatStateOf(0f)
    }

    var commentTitle by remember {
        mutableStateOf("")
    }

    var commentDescription by remember {
        mutableStateOf("")
    }

    var isUnknown by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current


    Scaffold(topBar = { ProductInfoTopBar(productName, imageUrl) }) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 84.dp, start = 16.dp, end = 16.dp)
        ) {

            Slider(
                value = sliderValue,
                onValueChange = {
                    sliderValue = it
                },
                modifier = Modifier.fillMaxWidth(),
                valueRange = 1f..5f,
                steps = 4,
                thumb = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(36.dp),
                        tint = GoldColor
                    )
                },
                colors = SliderDefaults.colors(
                    activeTrackColor = GoldColor,
                    inactiveTrackColor = Color.DarkGray.copy(0.1f)
                )
            )

            CheckoutDivider(spacerSize = 24.dp)

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = stringResource(id = R.string.write_opinion),
                style = Typography.h4,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.size(24.dp))

            CommentEditText(
                title = stringResource(id = R.string.comment_title),
                isNecessary = false,
                editTextValue = commentTitle,
                1,
                58.dp
            ) {
                commentTitle = it
            }

            Spacer(modifier = Modifier.size(16.dp))


            CommentEditText(
                title = stringResource(id = R.string.vote),
                isNecessary = true,
                editTextValue = commentDescription,
                3,
                100.dp
            ) {
                commentDescription = it
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp), Arrangement.Center, Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = isUnknown,
                    onCheckedChange = { isUnknown = it },
                    colors = CheckboxDefaults.colors(checkedColor = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed)
                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    text = stringResource(id = R.string.unknown_comment),
                    style = Typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedButton(
                onClick = {

                    if (commentDescription.isNotBlank()) {
                        productVM.setNewCommentModel(
                            SetNewCommentModel(
                                Constants.USER_TOKEN,
                                productId.substringAfter('='),
                                sliderValue.toInt(),
                                commentTitle,
                                commentDescription,
                                if (isUnknown) "کاربر مهمان" else Constants.USER_PHONE
                            )
                        )

                        navController.popBackStack()
                    }else{
                        Toast.makeText(
                            context,
                            "لطفا فیلدهای لازم را پر کنید.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    1.dp,
                    if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                )
            ) {


                Text(
                    text = stringResource(id = R.string.send_commit),
                    style = Typography.h4,
                    fontWeight = FontWeight.Bold,
                    color = if (isSystemInDarkTheme()) DigikalaDarkRed else DigikalaRed
                )


            }

        }

    }


}

@Composable
fun ProductInfoTopBar(
    productName: String,
    imageUrl: String,
) {

    Log.e(TAG, "$productName : ${imageUrl.substringAfter('=')}")

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            Arrangement.Start,
            Alignment.CenterVertically
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = imageUrl.substringAfter('=')),
                contentDescription = null,
                Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = productName.substringAfter('='),
                style = Typography.h4,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray.copy(0.8f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

    }

}


@Composable
fun CommentEditText(
    title: String,
    isNecessary: Boolean,
    editTextValue: String,
    maxLine: Int,
    height: Dp,
    onValueChange: (String) -> Unit
) {

    Column(Modifier.fillMaxWidth(), Arrangement.Center) {
        Text(
            text = title + if (isNecessary) "*" else "",
            style = Typography.h6,
            color = Color.DarkGray.copy(0.8f)
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = editTextValue,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.LightGray.copy(0.2f),
                cursorColor = DigikalaBlue,
                unfocusedLabelColor = Color.LightGray.copy(0.2f),
                focusedLabelColor = Color.LightGray.copy(0.2f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                disabledLabelColor = Color.Transparent,
                disabledTextColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            maxLines = maxLine
        )

    }

}

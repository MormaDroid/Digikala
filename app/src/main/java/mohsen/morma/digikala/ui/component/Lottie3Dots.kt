package mohsen.morma.digikala.ui.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import mohsen.morma.digikala.R

@Composable
fun Lottie3dots(size: Dp) {

    if (isSystemInDarkTheme()) {

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading3dotsdark))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(size)
        )


    } else {

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading3dots))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(size)
        )

    }

}
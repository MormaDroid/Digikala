package mohsen.morma.digikala.ui.screen.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mohsen.morma.digikala.R
import mohsen.morma.digikala.data.remote.model.product.Comment
import mohsen.morma.digikala.ui.theme.DigikalaBlue
import mohsen.morma.digikala.ui.theme.DigikalaGreen
import mohsen.morma.digikala.ui.theme.Orange
import mohsen.morma.digikala.ui.theme.Typography
import mohsen.morma.digikala.util.DigitHelper

@Composable
fun ProductCommentSection(
    comments: List<Comment>,
    commentCount: Int
) {


    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {

            Text(
                text = stringResource(id = R.string.User_opinion),
                style = Typography.h4,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = DigitHelper.digitBySeparatorAndLocate(commentCount.toString()) + " " + stringResource(
                    id = R.string.vote
                ),
                style = Typography.h6,
                fontWeight = FontWeight.Bold,
                color = DigikalaBlue
            )

        }

        Spacer(modifier = Modifier.size(20.dp))

        LazyRow {
            items(comments) { comment ->

                CommentCard(comment)

            }
        }

    }

}

@Composable
fun CommentCard(comment: Comment) {

    val parseTime = comment.updatedAt.substringBefore('T').split('-')
    val year = parseTime[0].toInt()
    val month = parseTime[1].toInt()
    val day = parseTime[2].toInt()

    var suggestIcon by remember {
        mutableIntStateOf(R.drawable.like)
    }

    var suggestColor by remember {
        mutableStateOf(DigikalaGreen)
    }

    var suggestText by remember {
        mutableIntStateOf(R.string.like)
    }

    when (comment.star) {
        in Int.MIN_VALUE..2 -> {
            suggestIcon = R.drawable.like
            suggestText = R.string.dislike
            suggestColor = Orange
        }

        in 2..3 -> {
            suggestIcon = R.drawable.question_mark
            suggestText = R.string.not_sure
            suggestColor = Color.DarkGray.copy(0.7f)
        }

        in 3..Int.MAX_VALUE -> {

            suggestIcon = R.drawable.like
            suggestText = R.string.like
            suggestColor = DigikalaGreen

        }
    }

    Spacer(modifier = Modifier.size(8.dp))

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(256.dp),
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(text = comment.title, style = Typography.h4, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.size(8.dp))

            Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(id = suggestIcon),
                    contentDescription = null,
                    Modifier
                        .size(20.dp)
                        .rotate(if (suggestColor == Orange) 180f else 0f),
                    tint = suggestColor
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = stringResource(id = suggestText),
                    style = Typography.h6,
                    color = suggestColor
                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(text = comment.description, style = Typography.h5)

            Spacer(modifier = Modifier.size(24.dp))

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Row(Modifier.fillMaxWidth(), Arrangement.Start, Alignment.CenterVertically) {

                    Text(
                        text = DigitHelper.gregorianToJalali(year, month, day),
                        style = Typography.h6,
                        color = Color.DarkGray.copy(0.7f)
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = null,
                        modifier = Modifier.size(6.dp),
                        tint = DigikalaBlue.copy(0.8f)
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Text(
                        text = comment.userName,
                        style = Typography.h5,
                        color = DigikalaBlue.copy(0.7f)
                    )

                }
            }

        }

    }

    Spacer(modifier = Modifier.size(8.dp))

}

package com.dinesh.android.testing.v1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import com.dinesh.android.R


@Composable
fun PlaidAssetItem(
    plaidAsset: GetPlaidAssetsResponse.Data,
    onItemClick: (GetPlaidAssetsResponse.Data) -> Unit
) {
    val rows = listOf(
        Pair("Account Name", " :     ${plaidAsset.assetAccount.first().name}"),
        Pair("Type", " :     ${plaidAsset.assetAccount.first().type}"),
        Pair("Sub-type", " :     ${plaidAsset.assetAccount.first().subtype}"),
        Pair("Available balance", " :     ${plaidAsset.assetAccount.first().balanceAvailable}"),
        Pair("Current balance", " :     ${plaidAsset.assetAccount.first().balanceCurrent}"),
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(plaidAsset) }
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = plaidAsset.plaidItem.insName, fontWeight = FontWeight.Bold)
            VerticalEndBarrierExample(
                texts = rows
            )
        }
    }
}

/*

@Composable
fun VerticalEndBarrierExample(
    modifier: Modifier = Modifier,
    texts: List<Pair<String, String>>
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val refs = mutableListOf<ConstrainedLayoutReference>()

        texts.forEachIndexed { index, (text1, text2) ->
            val ref1 = createRef()
            CustomTextView(
                text = text1,
                modifier = Modifier.constrainAs(ref1) {
                    top.linkTo(parent.top, margin = 32.dp * (index + 1))
                    start.linkTo(parent.start, margin = 0.dp)
                })

            refs.add(ref1)
        }

        val barrier = createEndBarrier(*refs.toTypedArray(), margin = 8.dp)
        refs.forEachIndexed { index, ref ->
            CustomTextView(
                text = texts[index].second,
                modifier = Modifier.constrainAs(createRef()) {
                    top.linkTo(ref.top)
                    start.linkTo(barrier)
                }
            )

        }
    }
}
*/

@Composable
fun VerticalEndBarrierExample(
    modifier: Modifier = Modifier,
    texts: List<Pair<String, String>>
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val refs = mutableListOf<ConstrainedLayoutReference>()

        texts.forEachIndexed { index, (text1, text2) ->
            val ref1 = createRef()
            CustomTextView(
                text = text1,
                modifier = Modifier.constrainAs(ref1) {
                    if (index == 0) {
                        top.linkTo(parent.top, margin = 32.dp)
                    } else {
                        top.linkTo(refs[index - 1].bottom, margin = 32.dp)
                    }
                    start.linkTo(parent.start, margin = 0.dp)
                })

            refs.add(ref1)
        }

        val barrier = createEndBarrier(*refs.toTypedArray(), margin = 8.dp)
        refs.forEachIndexed { index, ref ->
            CustomTextView(
                text = texts[index].second,
                modifier = Modifier.constrainAs(createRef()) {
                    top.linkTo(ref.bottom)
                    start.linkTo(barrier)
                }
            )
        }
    }
}

@Composable
fun PlaidAssetsList(
    plaidAssets: List<GetPlaidAssetsResponse.Data>,
    onItemClick: (GetPlaidAssetsResponse.Data) -> Unit
) {
    LazyColumn {
        items(plaidAssets) { plaidAsset ->
            PlaidAssetItem(plaidAsset = plaidAsset, onItemClick = onItemClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaidAssetsScreen() {
    val plaidAssets = hardcodedPlaidAssetsResponse

    plaidAssets?.data?.let {
        PlaidAssetsList(plaidAssets = it) { plaidAsset ->
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextView(text: String = "CustomTextView", modifier: Modifier = Modifier) {
    val poppinsRegular = androidx.compose.ui.text.font.FontFamily(
        androidx.compose.ui.text.font.Font(R.font.poppins_regular)
    )

    Text(
        text = text,
        modifier = Modifier
            .padding(top = 0.dp)
            .then(modifier),
        fontFamily = poppinsRegular,
        color = Color(0xFF646464),
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )
}
package com.fjr619.cryptocurrencyappyt.presentation.coin.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.fjr619.cryptocurrencyappyt.domain.model.Coin

// @Preview
// @Composable
// fun CoinListItemPreview() {
//     CoinListItem(
//         Coin("id", true, "Coin Name".repeat(5), 1, "Symbol"),
//         onItemClick = {}
//     )
// }

class CoinListItemProvider: PreviewParameterProvider<Coin> {
    override val values = sequenceOf(Coin("id", true, "Coin Name".repeat(5), 1, "Symbol"))
}

@Preview
@Composable
fun CoinListItem(
    @PreviewParameter(CoinListItemProvider::class) coin: Coin,
    onItemClick: (Coin) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            // .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.weight(1f, fill = false),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .align(CenterVertically)
                .wrapContentWidth()
        )
    }
}
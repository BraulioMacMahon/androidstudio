package com.example.initialscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.initialscreen.data.PubItem


@Composable
fun PubCard(
    pub: PubItem,
) {
    val cantos = Shapes(small = RoundedCornerShape(5.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(Color(0xFFDFE9F5)),
        shape = cantos.small

    ) {

        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = pub.imagem,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp)
            )
            Text(
                text = pub.conteudo,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


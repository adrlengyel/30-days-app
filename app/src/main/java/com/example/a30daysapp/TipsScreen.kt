package com.example.a30daysapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.model.Tip
import com.example.a30daysapp.model.TipsRepository
import com.example.a30daysapp.ui.theme._30DaysAppTheme

@Composable
fun TipCard(
    tip: Tip,
    tipIndex: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.day) + tipIndex,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(id = tip.heading),
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier.size(10.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = tip.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                )
            }
            Spacer(modifier.size(10.dp))
            Text(
                text = stringResource(id = tip.description)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun TipCardPreview(){
    _30DaysAppTheme {
        TipCard(TipsRepository.tips[1], 1)
    }
}
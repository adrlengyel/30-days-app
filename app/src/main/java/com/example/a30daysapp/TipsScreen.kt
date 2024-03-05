package com.example.a30daysapp

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCard(
    tip: Tip,
    tipIndex: Int,
    modifier: Modifier = Modifier
) {
    var enabled by remember {
        mutableStateOf(false);
    };
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        onClick = { enabled = !enabled },
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        Column(
            modifier = modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                )
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
            if(enabled) {
                Box(
                    modifier = modifier
                        .height(200.dp)
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCardList(
    tips: List<Tip>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string._30_days_of_self_improvement),
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            )
        }
    ) {
        LazyColumn(
            contentPadding = it
        ){
            repeat(tips.size){
                item{
                    TipCard(
                        tip = tips[it],
                        tipIndex = it + 1,
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TipCardListPreview(){
    _30DaysAppTheme {
        TipCardList(TipsRepository.tips)
    }
}
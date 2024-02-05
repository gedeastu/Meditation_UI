package com.example.meditation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditation.R
import com.example.meditation.ui.theme.ButtonBlue
import com.example.meditation.ui.theme.DarkerButtonBlue
import com.example.meditation.ui.theme.DeepBlue
import com.example.meditation.ui.theme.LightRed
import com.example.meditation.ui.theme.TextWhite

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ) {
        Column(modifier = Modifier) {
            GreetingSection(modifier = Modifier)
            ChipSection(chips = listOf(
                "Sweet Sleep",
                "Insomnia",
                "Depression"
            ))
            CurrentMeditation()
        }
    }
}

@Composable
fun GreetingSection(
    name:String="Astu",
    modifier: Modifier = Modifier
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center){
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow(
        modifier = Modifier,
        content = {
            items(chips.size){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedChipIndex = it
                        }
                        .clip(
                            RoundedCornerShape(
                                10.dp
                            )
                        )
                        .background(
                            if (selectedChipIndex == it) {
                                ButtonBlue
                            } else {
                                DarkerButtonBlue
                            }
                        )
                        .padding(15.dp)
                ) {
                    Text(
                        text = chips[it], color = TextWhite, style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}

@Composable
fun CurrentMeditation(color: Color = LightRed){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 25.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                modifier = Modifier.size(16.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun
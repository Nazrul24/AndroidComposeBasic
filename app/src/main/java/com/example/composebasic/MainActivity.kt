package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleCard(
                        title = stringResource(id = R.string.title),
                        shortDescripton = stringResource(id = R.string.short_description ) ,
                        longDescription = stringResource(id = R.string.long_description),
                        imagePainter = painterResource(id = R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}



@Composable
fun ArticleCard(
    title: String,
    shortDescripton: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier){
        Image(painter = imagePainter, contentDescription = null )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = shortDescripton,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JetPackComposePreview() {
    ComposeBasicTheme {
        ArticleCard(
            title = stringResource(id = R.string.title) ,
            shortDescripton = stringResource(id = R.string.short_description) ,
            longDescription = stringResource(id = R.string.long_description),
            imagePainter = painterResource(id = R.drawable.bg_compose_background)
        )
    }
}
package io.korostenskyi.launchitandroid

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.korostenskyi.launchitandroid.ui.theme.LaunchItTheme
import io.korostenskyi.shared.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchItTheme {
                MainScreenContent()
            }
        }
        io.korostenskyi.shared.networking.fetchData()
    }
}

@Composable
fun MainScreenContent() {
    val greetText = greet()
    Text(text = greetText)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LaunchItTheme {
        MainScreenContent()
    }
}

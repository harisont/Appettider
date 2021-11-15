package bho.harisont.appettider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bho.harisont.appettider.ui.theme.AppettiderTheme

class PlaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val place = intent.getStringExtra("place")
        setContent {
            AppettiderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PlaceData(place ?: "Default place name")
                }
            }
        }
    }
}

@Composable
fun PlaceData(name: String) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun PlacesDataPreview() {
    AppettiderTheme {
        PlaceData("Kvibergs marknad")
    }
}
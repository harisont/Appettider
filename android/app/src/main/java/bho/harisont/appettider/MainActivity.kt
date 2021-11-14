package bho.harisont.appettider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bho.harisont.appettider.ui.theme.AppettiderTheme

val places = listOf(
    "Kvibergs Marknad",
    "Stadsbiblioteket",
    "Lidl Nordstan",
    "Litteraturhuset",
    "Postnord",
    "Stora Teater",
    "Hagabion",
    "Bio Roy",
    "Kuggen",
    "Gamlestadens Barnmorskemottagning",
    "Radar",
    "Willy's",
    "Biltema"
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppettiderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PlacesColumn(places)
                }
            }
        }
    }
}

@Composable
fun PlacesColumn(places: List<String>) {
    LazyColumn(){
        items(places.size){
            Text(
                text = places[it],
                fontSize = 36.sp,
                modifier = Modifier.padding(8.dp)
            )
            Divider(color = androidx.compose.ui.graphics.Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppettiderTheme {
        PlacesColumn(places)
    }
}
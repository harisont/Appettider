package bho.harisont.appettider

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                    PlacesColumn (places) {
                        val intent = Intent(this,PlaceActivity::class.java)
                        intent.putExtra("place",places[it])
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun PlacesColumn(places: List<String>, clickedPlace: (Int) -> Unit) {
    LazyColumn(){
        items(places.size){
            Surface(
                modifier = Modifier
                    .clickable {clickedPlace(it)})
            {
                Text(
                    text = places[it],
                    fontSize = 20.sp,
                    modifier = Modifier.padding(15.dp)
                )
                Divider(color = androidx.compose.ui.graphics.Color.Gray, thickness = 1.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlacesColumnPreview() {
    AppettiderTheme {
        PlacesColumn(places) {
            // no lambda here, doesn't matter
        }
    }
}
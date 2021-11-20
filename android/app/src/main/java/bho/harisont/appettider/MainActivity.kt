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
import androidx.room.Room
import bho.harisont.appettider.db.AppDatabase
import bho.harisont.appettider.db.Place
import bho.harisont.appettider.db.Weekday
import bho.harisont.appettider.ui.theme.AppettiderTheme
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create db
        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "places-db"
        ).build()

        // TODO: rm
        thread {
        val place1 = Place(
                "Kåhög",
                "Partille",
                mapOf(
                        Weekday.MON to "09:00-20:00",
                        Weekday.TUE to "09:00-20:00",
                        Weekday.WED to "09:00-20:00",
                        Weekday.THU to "09:00-20:00",
                        Weekday.FRI to "09:00-18:00",
                        Weekday.SAT to "09:00-16:00",
                        Weekday.SUN to "09:00-16:00"
                ),
                "") // TODO: make optional parameter
        val place2 = Place(
                "Kvibergs Marknad",
                "Kibergs kasermer",
                mapOf(Weekday.SAT to "09:00-15:00", Weekday.SUN to "09:00-15:00"),
                ""
        )
        db.placeDao().insert(place1)
        db.placeDao().insert(place2) }

        var placeNames = emptyList<String>()
        thread {
            placeNames = db.placeDao().selectAll().map { it.name }
        }

        setContent {
            AppettiderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PlacesColumn (placeNames) {
                        val intent = Intent(this,PlaceActivity::class.java)
                        intent.putExtra("place",placeNames[it])
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

    AppettiderTheme {
        PlacesColumn(places) {
            // no lambda here, doesn't matter
        }
    }
}
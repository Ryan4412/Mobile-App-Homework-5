package edu.towson.cosc435.kraft.assignment_5.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.kraft.assignment_5.PhotoAppNavGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    // adds a nav controller to be able to navigate to different screens
    val nav = rememberNavController()
    // scaffold is used to add a top app bar to the screen along with core ui elements
    Scaffold(
        topBar = {
            // adds a top app bar with the title photo app
            TopAppBar(title = {
                Text("Photo App")
                },
                // sets the colors of the top app bar based on the color scheme specified in the Themes.kt file
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,)
            )
        }
    ) {
        // navigates to photoAppNavGraph to display the screens of the application
        PhotoAppNavGraph(nav)
    }
}
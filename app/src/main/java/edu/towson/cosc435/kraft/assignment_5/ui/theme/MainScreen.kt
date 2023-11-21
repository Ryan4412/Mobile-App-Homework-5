package edu.towson.cosc435.kraft.assignment_5.ui.theme

import edu.towson.cosc435.kraft.assignment_5.PhotoAppNavGraph
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Photo App")
            })
        }
    ) {
        PhotoAppNavGraph(nav)
    }
}
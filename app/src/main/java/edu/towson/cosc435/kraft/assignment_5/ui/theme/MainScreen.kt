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
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Photo App")
                },
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,)
            )
        }
    ) {
        PhotoAppNavGraph(nav)
    }
}
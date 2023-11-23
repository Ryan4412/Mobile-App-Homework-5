package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PhotoListView(
    photos: List<Photo>,
    updatePhoto: (Photo) -> Unit,
    getBitmap: suspend (String) -> Bitmap?,
    navController: NavHostController,
    onClick: (Bitmap?) -> Unit
){
    // places the grid in the center of the screen with enough padding to be below the top app bar
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.padding(top = 50.dp)
        ){
        // creates a lazy vertical grid that has 2 photos per row and fills the max with and height
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) {

            items(photos) { photo -> // for each cell in the grid
                PhotoItem(photo, getBitmap, navController, onClick, updatePhoto) // populate it with a PhotoItem composable
            }
        }

    }
}
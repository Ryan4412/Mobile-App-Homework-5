package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun PhotoListView(
    photos: List<Photo>,
    updatePhoto: (Photo) -> Unit,
    getBitmap: suspend (String) -> Bitmap?,
    navController: NavHostController,
    onClick: (Bitmap?) -> Unit
){
    Box(contentAlignment = Alignment.Center){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) {

            items(photos) { photo ->
                PhotoItem(photo, getBitmap, navController, onClick, updatePhoto)
            }
        }

    }
}
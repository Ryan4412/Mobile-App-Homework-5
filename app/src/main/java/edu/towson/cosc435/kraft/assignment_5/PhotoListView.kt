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

@Composable
fun PhotoListView(
    photos: List<Photo>,
    updatePhotos: () -> Unit,
    getBitmap: suspend (String) -> Bitmap?
){
    Box(contentAlignment = Alignment.Center){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) {

            items(photos) { photo ->
                updatePhotos()
                PhotoItem(photo, getBitmap)
            }
        }

    }
}
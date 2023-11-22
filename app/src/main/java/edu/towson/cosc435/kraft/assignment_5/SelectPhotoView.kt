package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun SelectPhotoView(bitmap: Bitmap?){
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(bitmap == null){
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        } else {
            // save bitmap to the list of photos
            Image(
                modifier = Modifier.size(400.dp),
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null
            )
        }
    }
}
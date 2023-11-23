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
        if(bitmap == null){ // checks if the bitmap passed is null (should never be null)
            CircularProgressIndicator( // if bitmap is null display a spinning progress indicator
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        } else { // if bitmap is not null
            // display the image using the specified bitmap
            Image(
                modifier = Modifier.size(400.dp),
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null
            )
        }
    }
}
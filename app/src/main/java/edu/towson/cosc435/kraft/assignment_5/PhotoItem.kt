package edu.towson.cosc435.kraft.assignment_5

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import kotlinx.coroutines.delay

@Composable
fun PhotoItem(
    photo: Photo,
    getBitmap: suspend (String) -> Bitmap?
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var bitmap by remember {
            mutableStateOf<Bitmap?>(null)
        }
//        photo.bitmap = getBitmap(photo)
        LaunchedEffect(key1 = photo.id){
            bitmap = getBitmap(photo.download_url)
        }

        if(bitmap == null){
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )

        }else {
            Image(
                modifier = Modifier.size(128.dp),
                bitmap = bitmap!!.asImageBitmap(), contentDescription = null)
        }
    }
}
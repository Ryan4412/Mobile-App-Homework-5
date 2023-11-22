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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PhotoItem(
    photo: Photo,
    getBitmap: suspend (String) -> Bitmap?,
    navController: NavHostController,
    onClick: (Bitmap?) -> Unit,
    updatePhoto: (Photo) -> Unit,
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

//        if(bitmap != null && photo.bitmap == null){
//            val photoWithNewBitmap = Photo(photo.id, photo.url, photo.download_url, bitmap)
//            updatePhoto(photoWithNewBitmap)
//        }

        if(bitmap == null){
            LaunchedEffect(key1 = photo.id){
                bitmap = getBitmap(photo.download_url)
            }
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )

        }else {
            Image(
                modifier = Modifier.size(128.dp).clickable {
                        onClick(bitmap)
                        navController.navigate(Routes.SelectPhoto.route){
                            launchSingleTop = true
                            popUpTo(Routes.PhotoList.route)
                        }
                },
                bitmap = bitmap!!.asImageBitmap(),
                contentDescription = null
            )
        }
    }
}
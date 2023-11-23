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
    // sets all elements in a column that is filled to max width and height, adds 5 data pixels of padding, and centers everything horizontally
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // variable to reference the bitmap
        var bitmap by remember {
            mutableStateOf<Bitmap?>(null)
        }

        if(bitmap != null && photo.bitmap == null){ // if the bitmap for this photo has been retrieved but its corresponding photo object does not have the bitmap stored
            val photoWithNewBitmap = Photo(photo.id, photo.url, photo.download_url, bitmap) // create a new photo object with an updated bitmap
            updatePhoto(photoWithNewBitmap) // update this photo with the newly updated photo
        }

        if(bitmap == null && photo.bitmap == null){ // if both the bitmap is null and the photo has never been retrieved
            LaunchedEffect(key1 = photo.id){ // calls a coroutine to get the photo
                bitmap = getBitmap(photo.download_url) // save the bitmap returned
            }
            CircularProgressIndicator( // while coroutine is running, display a circular progress indication to show that it is currently being retrieved
                modifier = Modifier
                    .size(128.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )

        }else { // if the bitmap is not null or if the photo has been retrieved before
            if(bitmap == null){ // check which is null
                // if bitmap is null display the image using the bitmap stored in the photo object
                Image(
                    modifier = Modifier.size(128.dp).clickable { // makes image clickable
                        onClick(photo.bitmap) // if photo is clicked send the bitmap to the SelectPhotoViewModel so it can be displayed on the next screen
                        navController.navigate(Routes.SelectPhoto.route){ // navigate to the SelectPhoto screen
                            launchSingleTop = true // makes sure there is only one copy of a SelectPhoto screen on the back stack
                            popUpTo(Routes.PhotoList.route) // pops all routes that do not match the specified route off of the back stack
                        }
                    },
                    bitmap = photo.bitmap!!.asImageBitmap(), // creates the image using the specified bitmap (uses !! to assert that it is not null)
                    contentDescription = null // sets the content description to null
                )
            } else { // else (if the bitmap is not null)
                // display the image using the bitmap stored in the bitmap mutable state variable
                Image(
                    modifier = Modifier.size(128.dp).clickable { // makes image clickable
                        onClick(bitmap) // if photo is clicked send the bitmap to the SelectPhotoViewModel so it can be displayed on the next screen
                        navController.navigate(Routes.SelectPhoto.route){// navigate to the SelectPhoto screen
                            launchSingleTop = true // makes sure there is only one copy of a SelectPhoto screen on the back stack
                            popUpTo(Routes.PhotoList.route) // pops all routes that do not match the specified route off of the back stack
                        }
                    },
                    bitmap = bitmap!!.asImageBitmap(), // creates the image using the specified bitmap (uses !! to assert that it is not null)
                    contentDescription = null // sets the content description to null
                )
            }
        }
    }
}
package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PhotoItem(photo: Photo){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(photo.bitmap == null){
            CircularProgressIndicator(
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(10.dp),
                color = MaterialTheme.colorScheme.secondary
            )
//        Text("1")
        }else {
            Image(bitmap = photo.bitmap!!, contentDescription = photo.url)
        }
    }
}
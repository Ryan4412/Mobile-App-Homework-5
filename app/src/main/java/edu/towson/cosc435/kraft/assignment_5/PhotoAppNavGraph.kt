package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
 fun PhotoAppNavGraph(navController: NavHostController){
    val plvm: PhotoListViewModel = viewModel()
    val spvm:SelectPhotoViewModel = viewModel()
    NavHost(navController = navController,
      startDestination = Routes.PhotoList.route
     ){
          composable(Routes.PhotoList.route){
              val photos by plvm._photos
              PhotoListView(
                  photos,
                  getBitmap = plvm::getBitmap,
                  navController = navController,
                  onClick = spvm::setSelectPhotoBitmap,
                  updatePhoto = plvm::updatePhoto
              )
         }
         composable(Routes.SelectPhoto.route){
             val bitmap by spvm._bitmap
             SelectPhotoView(bitmap)
         }
    }
}
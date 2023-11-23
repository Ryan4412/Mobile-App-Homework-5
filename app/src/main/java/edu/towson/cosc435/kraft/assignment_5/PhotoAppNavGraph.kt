package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
 fun PhotoAppNavGraph(navController: NavHostController){
    // initializes a PhotoListViewModel to pass values and functions to the different screens when navigating
    val plvm: PhotoListViewModel = viewModel()
    // initializes a SelectPhotoViewModel to pass values and functions to the different screens when navigating
    val spvm: SelectPhotoViewModel = viewModel()
    // creates a nav host that sets the starting destination (screen that displays on app start up) to the PhotoList screen along passing it the nav controller
    NavHost(navController = navController,
      startDestination = Routes.PhotoList.route
     ){
        // sets a route to navigate to the PhotoList screen in the NavHost
          composable(Routes.PhotoList.route){
              // references the _photos list in the PhotoListViewModel
              val photos by plvm._photos
              PhotoListView( // displays the PhotoList screen
                  photos, // list of photos in PhotoListViewModel
                  getBitmap = plvm::getBitmap, // hoists the getBitmap function in the PhotoListViewModel
                  navController = navController, // passes navController to be able to navigate to a different screen from the PhotoList screen
                  onClick = spvm::setSelectPhotoBitmap, // hoists the setSelectPhotoBitmap function from the SelectPhotoViewModel
                  updatePhoto = plvm::updatePhoto // hoists the updatePhoto function from the PhotoListViewModel
              )
         }
        // sets a route to navigate to the SelectPhoto screen in the NavHost
         composable(Routes.SelectPhoto.route){
             // references the bitmap stored in the SelectPhotoViewModel
             val bitmap by spvm._bitmap
             SelectPhotoView(bitmap) // displays the SelectPhoto screen
         }
    }
}
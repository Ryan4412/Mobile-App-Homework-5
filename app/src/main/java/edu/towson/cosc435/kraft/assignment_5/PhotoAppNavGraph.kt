package edu.towson.cosc435.kraft.assignment_5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
 fun PhotoAppNavGraph(navController: NavHostController){
    val vm: PhotoListViewModel = viewModel()
    NavHost(navController = navController,
      startDestination = Routes.PhotoList.route
     ){
          composable(Routes.PhotoList.route){
              val photos by vm._photos
              PhotoListView(
                  photos,
                  updatePhotos = vm::awaitPhotos,
                  getBitmap = vm::getBitmap
              )
       }
    }
}
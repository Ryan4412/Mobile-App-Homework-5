package edu.towson.cosc435.kraft.assignment_5

// creates a Rputes class that is used to pass a new route through the navController to the NavHost
sealed class Routes(val route: String){

    // route for the PhotoList screen
    object PhotoList: Routes("photolist")
    // route for the SelectPhoto screen
    object SelectPhoto: Routes("selectphoto")

}

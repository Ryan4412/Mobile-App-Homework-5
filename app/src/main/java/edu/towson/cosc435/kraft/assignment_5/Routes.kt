package edu.towson.cosc435.kraft.assignment_5

sealed class Routes(val route: String){

    object PhotoList: Routes("photolist")
    object SelectPhoto: Routes("selectphoto")

}

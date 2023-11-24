package com.example.appdev2assignment3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.appdev2assignment3.Screens.ContactScreen
import com.example.appdev2assignment3.Screens.FullScreen
import com.example.appdev2assignment3.Screens.ListViewScreen
import com.example.appdev2assignment3.Screens.SingleViewScreen
import com.example.appdev2assignment3.Screens.SingleViewScreenNoTask
import com.example.appdev2assignment3.ViewModels.ToDoViewModel

// Enumeration of different routes
sealed class Routes(val route:String)  {
 object Main : Routes("FullScreenRoute")
 object ListView : Routes("ListViewScreenRoute")
 object Contact: Routes("ContactScreenRoute")
 object SingleView: Routes("SingleViewScreenRoute")
}
val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }
val viewModel = ToDoViewModel();

/**
 * Composable function for defining the app's router.
 */
@Composable
fun Router() {
 val navController = rememberNavController()

 CompositionLocalProvider(LocalNavController provides navController) {
  NavHost(navController = navController, startDestination = "Routes.Main.route") {
   composable("Routes.Main.route") { FullScreen(viewModel) }
   composable("Routes.ListView.route") { ListViewScreen(viewModel) }
   composable("Routes.Contact.route") { ContactScreen() }
   navigation(route = "SingleView", startDestination = "SingleView/NoTask") {
    composable("SingleView/NoTask") { SingleViewScreenNoTask(viewModel) }
    composable("SingleView/{taskIndex}") { backStackEntry ->
     val taskIndex = backStackEntry.arguments?.getString("taskIndex")?.toIntOrNull()
     if (taskIndex != null) {
      SingleViewScreen(viewModel,taskIndex)
     } else {
     }
    }
   }
  }
 }
}

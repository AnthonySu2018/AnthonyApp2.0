package com.sioux.anthony.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sioux.anthony.androidapp.pages.Homepage
import com.sioux.anthony.androidapp.pages.PowerUp
import com.sioux.anthony.androidapp.pages.Settings
import com.sioux.anthony.androidapp.pages.ShutDown
import com.sioux.anthony.androidapp.livetv.LiveTV
import com.sioux.anthony.androidapp.route.Screen
import com.sioux.anthony.androidapp.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAppTheme {
                val navController = rememberNavController()
                val items = listOf(
                    Screen.Homepage,
                    Screen.PowerUp,
                    Screen.LiveTV,
                    Screen.ShutDown,
                    Screen.Settings,
                )

                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination


                            items.forEach { it  ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(when(it){
                                            Screen.Homepage -> Icons.Filled.Home
                                            Screen.PowerUp -> Icons.Filled.Power
                                            Screen.LiveTV   -> Icons.Filled.PlayArrow
                                            Screen.ShutDown -> Icons.Filled.PowerOff
                                            Screen.Settings -> Icons.Filled.Settings
                                        },

                                            contentDescription = null) },

                                    label = { Text(stringResource(it.resourceId)) },
                                    selected = currentDestination?.hierarchy?.any { it.route == it.route } == true,
                                    onClick = {
                                        navController.navigate(it.route) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true
                                            // Restore state when reselecting a previously selected item
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController, startDestination = Screen.Homepage.route, Modifier.padding(innerPadding)) {
                        composable(Screen.Homepage.route) {  Homepage(navController) }
                        composable(Screen.PowerUp.route) {  PowerUp(navController) }
                        composable(Screen.LiveTV.route) { LiveTV(navController) }
                        composable(Screen.ShutDown.route) {  ShutDown(navController) }
                        composable(Screen.Settings.route) {  Settings(navController) }
                    }
                }

            }
        }
    }
}










package com.sioux.anthony.androidapp.route

import androidx.annotation.StringRes
import com.sioux.anthony.androidapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Homepage : Screen("Homepage", R.string.Homepage)
    object Calendar : Screen("Calendar", R.string.Calendar)

    object LiveTV : Screen("LiveTV", R.string.LiveTV)
    object Map : Screen("Map", R.string.Map)
    //object Ticket : Screen("Ticket", R.string.Ticket)
    object Profile : Screen("Profile", R.string.Profile)


}
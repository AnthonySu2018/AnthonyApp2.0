package com.sioux.anthony.androidapp

import androidx.annotation.StringRes

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Homepage : Screen("Homepage", R.string.Homepage)
    object LiveTV : Screen("LiveTV", R.string.LiveTV)
    object Devices : Screen("Devices", R.string.Devices)
    object Settings : Screen("Settings", R.string.Settings)


}
package com.sioux.anthony.androidapp.route

import androidx.annotation.StringRes
import com.sioux.anthony.androidapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Homepage : Screen("Homepage", R.string.Homepage)
    object PowerUp : Screen("PowerUp", R.string.PowerUp)
    object LiveTV : Screen("LiveTV", R.string.LiveTV)
    object ShutDown : Screen("PowerDown", R.string.ShutDown)

    object Settings : Screen("Setting", R.string.Settings)

}
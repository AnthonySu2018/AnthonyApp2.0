package com.sioux.anthony.androidapp.route

import androidx.annotation.StringRes
import com.sioux.anthony.androidapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Homepage : Screen("Homepage", R.string.Homepage)
    object LiveTV : Screen("LiveTV", R.string.LiveTV)


}
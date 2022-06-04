package com.debduttapanda.powernavigation

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.ic_baseline_home_24, "Home")
    object Profile : NavDrawerItem("profile", R.drawable.ic_baseline_person_24, "Profile")
    object FriendList : NavDrawerItem("friendlist", R.drawable.ic_baseline_group_24, "FriendList")
    object Settings : NavDrawerItem("settings", R.drawable.ic_baseline_settings_24, "Settings")
}
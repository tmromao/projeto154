package template

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                getBottomItems.forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },
                        label = {
                            Text(bottomNavigationItem.title)
                        },
                        alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bottomNavigationItem.badgeCount != null) {
                                        Badge(
                                            content = {
                                                Text(bottomNavigationItem.badgeCount.toString())
                                            },
                                        )
                                    } else if (bottomNavigationItem.hasNews) {
                                        Badge()
                                    }
                                },
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        bottomNavigationItem.selectedIcon
                                    } else {
                                        bottomNavigationItem.unselectedIcon
                                    },
                                    contentDescription = bottomNavigationItem.title,
                                )
                            }
                        },

                        )
                }
            }
        },
    ) {

    }

}



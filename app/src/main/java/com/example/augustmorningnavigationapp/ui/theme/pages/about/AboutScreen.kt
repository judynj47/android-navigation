package com.example.augustmorningnavigationapp.ui.theme.pages.about

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmorningnavigationapp.ui.theme.AugustMorningNavigationAppTheme
import com.example.augustmorningnavigationapp.ui.theme.pages.login.LoginScreen

@Composable
fun AboutScreen(navController: NavHostController) {
    Text(text = "Welcome to about screen")
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreview() {
    AugustMorningNavigationAppTheme {
        AboutScreen(rememberNavController())
    }

}
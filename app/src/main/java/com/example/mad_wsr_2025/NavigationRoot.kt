package com.example.mad_wsr_2025

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mad_wsr_2025.presentation.custom_pager.OnboardingScreen2
import com.example.mad_wsr_2025.presentation.login.LoginScreen
import com.example.mad_wsr_2025.presentation.otp.OtpScreen
import com.example.mad_wsr_2025.presentation.otp.OtpScreen2
import com.example.mad_wsr_2025.presentation.swipeable_item.ContactsScreen
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) MainScreenGraph else OnboardingGraph
    ) {
        onboardingGraph(navController)
        mainScreenGraph(navController)
    }
}

private fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {
    navigation<OnboardingGraph>(
        startDestination = OnboardingSplashScreen
    ) {
        composable<OnboardingSplashScreen> {
            OnboardingSplashScreen(
                onNextScreen = {
                    navController.navigate(OnboardingIntro) {
                        popUpTo(OnboardingSplashScreen) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<OnboardingIntro> {
//            SupabaseTestScreenRoot()
//            OnboardingScreen(
//                content = { page ->
//                    OnboardingStep(page)
//                }
//            )
//            OnboardingScreen2()
//            ContactsScreen()
//            OtpScreen()
//            OtpScreen2()
            LoginScreen()
        }
    }
}

private fun NavGraphBuilder.mainScreenGraph(navController: NavHostController) {
    navigation<MainScreenGraph>(
        startDestination = MainScreen
    ) {
        composable<MainScreen> {

        }
    }
}

@Serializable
object OnboardingGraph

@Serializable
object OnboardingSplashScreen

@Serializable
object OnboardingIntro

@Serializable
object MainScreenGraph

@Serializable
object MainScreen


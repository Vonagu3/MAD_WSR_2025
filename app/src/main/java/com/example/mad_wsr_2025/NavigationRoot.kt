package com.example.mad_wsr_2025

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
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
            OnboardingScreen(
                content = { page ->
                    OnboardingStep(page)
                }
            )
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


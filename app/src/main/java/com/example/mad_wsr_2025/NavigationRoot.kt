package com.example.mad_wsr_2025

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.mad_wsr_2025.presentation.TestCoil
import com.example.mad_wsr_2025.presentation.forgot_password.ForgotPassword
import com.example.mad_wsr_2025.presentation.otp.Otp
import com.example.mad_wsr_2025.presentation.otp.OtpRoot
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
            ForgotPassword(
                onNextScreen = { email ->
                    navController.navigate(OTP(
                        email = email
                    ))
                }
            )
//            TestCoil()
        }

        composable<OTP> {
            OtpRoot()
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
data class OTP(
    val email: String
)

@Serializable
object MainScreenGraph

@Serializable
object MainScreen


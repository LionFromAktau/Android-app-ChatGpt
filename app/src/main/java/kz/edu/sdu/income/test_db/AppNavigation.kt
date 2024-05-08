package kz.edu.sdu.income.test_db
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.edu.sdu.income.income_ui.CalculatorScreen
import kz.edu.sdu.income.income_ui.ChatApp
import kz.edu.sdu.income.income_ui.MainScreen
import kz.edu.sdu.income.income_ui.PayCheckScreen
import kz.edu.sdu.income.income_ui.SettingsScreen
import kz.edu.sdu.income.viewModel.ChatAIViewModel
import kz.edu.sdu.income.viewModel.IncomeViewModel

@Composable
fun AppNavigation(viewModel: IncomeViewModel, viewModel2: ChatAIViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable("calculatorScreen") { CalculatorScreen(navController, viewModel) }
        composable("settingsScreen") { SettingsScreen(navController, viewModel) }
        composable("payCheckScreen") { PayCheckScreen(navController, viewModel) }
        composable("chatAI") { ChatApp(navController, viewModel2) }
    }
}
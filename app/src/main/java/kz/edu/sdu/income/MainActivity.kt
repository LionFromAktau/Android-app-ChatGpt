package kz.edu.sdu.income

import IncomeViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import kz.edu.sdu.income.data.DataBase
import kz.edu.sdu.income.test_db.AppNavigation
import kz.edu.sdu.income.ui.theme.IncomeTheme
import kz.edu.sdu.income.viewModel.ChatAIViewModel
import kz.edu.sdu.income.viewModel.IncomeViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: IncomeViewModel
    private lateinit var viewModel2 : ChatAIViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBase = DataBase()
        val viewModelFactory = IncomeViewModelFactory(dataBase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(IncomeViewModel::class.java)
        viewModel2 = ViewModelProvider(this).get(ChatAIViewModel::class.java)
        setContent {
            IncomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  AppNavigation(viewModel, viewModel2)
                }
            }
        }
    }
}
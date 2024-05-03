package kz.edu.sdu.income.income_ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kz.edu.sdu.income.MainActivity
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                SplashScreen()
            }
        }
    }

    @Preview(
        showSystemUi = true
    )
    @Composable
    private fun SplashScreen() {
        LaunchedEffect(key1 = true, block = {
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainScreen::class.java))
        })
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E3E3E)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Income",
                    fontSize = 64.sp,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                )

                Text(
                    text = "Work&travel",
                    fontSize = 34.sp,
                    color = Color(0xFFBFBFBF),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
                }
            }
        }
    }

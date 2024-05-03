package kz.edu.sdu.income.income_ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

class MainScreen: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Surface {
                    MainScreenApp()
                }
            }
        }
    }
    @Preview(

        showBackground = true ,
        showSystemUi = true
    )
    @Composable
    private fun MainScreenApp() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            MainTop()
        }


    }

    @Preview
    @Composable
    private fun MainTop(
    ) {
        val shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom=0.dp)
        ) {

            Box(
                modifier = Modifier
                    .background(Color(0xFF0E3E3E), shape = shape)
                    .fillMaxWidth()
                    .height(450.dp),

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom=20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.main_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(300.dp)
                    )
                    Text(
                        text = "Income",
                        fontSize = 36.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 35.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Card (
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(185.dp)
                        .height(295.dp)
                        .clickable {
                            startActivity(Intent(this@MainScreen, CalculatorScreen::class.java))
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0E3E3E),
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Calculator",
                            fontSize = 20.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Card (
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(185.dp)
                        .height(295.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0E3E3E),
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Chat AI",
                            fontSize = 20.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}




package kz.edu.sdu.income.income_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

@Composable
fun MainScreen(navController: NavController ){
    IncomeTheme {
        Surface {
            MainScreenApp(navController = navController)
        }
    }
    }

    @Composable
    private fun MainScreenApp(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundCompose(navController)
        }


    }

    @Composable
    fun BackgroundCompose(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Canvas(modifier = Modifier.fillMaxWidth()) {
                    drawCircle(
                        color = Color(0xFF0E3E3E),
                        radius = 480.dp.toPx(),
                    )
                }
                Spacer(modifier = Modifier.padding(top = 50.dp))
                Image(
                    painter = painterResource(id = R.drawable.main_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(330.dp)
                )
                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 15.dp))
                Text(
                    text = "Income",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(bottom=20.dp))
            }
            Spacer(modifier = Modifier.padding(top=50.dp))
            MainScreenButton(navController)
        }
    }
    @Composable
    fun MainScreenButton(navController: NavController){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ){
                Buttons(text = "Calculator", navController) {
                    navController.navigate("settingsScreen"){
                        popUpTo("mainScreen"){inclusive=true}
                    }
                }
                Spacer(modifier = Modifier.padding(end=22.dp))
                Buttons(text = "Chat AI", navController) {
                    navController.navigate("ChatAI"){
                        popUpTo("mainScreen"){inclusive=true}
                    }
                }
            }
        }
    }

    @Composable
    fun Buttons(
        text: String,
        navController: NavController,
        click: () -> Unit
    ){
        Card(
            modifier = Modifier
                .width(165.dp)
                .height(265.dp)
                .clickable (onClick =click),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0E3E3E)
            ),
            shape = RoundedCornerShape(25.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }




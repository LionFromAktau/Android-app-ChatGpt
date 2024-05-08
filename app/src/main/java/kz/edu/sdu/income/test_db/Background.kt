package kz.edu.sdu.income.test_db

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kz.edu.sdu.income.R
//@Composable
//fun BackgroundCompose(navController : NavHostController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Canvas(modifier = Modifier.fillMaxWidth()) {
//                drawCircle(
//                    color = Color(0xFF0E3E3E),
//                    radius = 480.dp.toPx(),
//                )
//            }
//            Spacer(modifier = Modifier.padding(top = 50.dp))
//            Image(
//                painter = painterResource(id = R.drawable.main_icon),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(330.dp)
//            )
//            Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 15.dp))
//            Text(
//                text = "Income",
//                fontSize = 36.sp,
//                fontWeight = FontWeight.SemiBold,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.White
//            )
//            Spacer(modifier = Modifier.padding(bottom=20.dp))
//        }
//        Spacer(modifier = Modifier.padding(top=50.dp))
//        CustomButton(navController)
//    }
//}
//@Composable
//fun CustomButton(navController: NavHostController){
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp, end = 20.dp)
//        ){
//            Buttons(text = "Calculator", navController) {
//                navController.navigate("CalculatorScreen")
//            }
//            Spacer(modifier = Modifier.padding(end=22.dp))
//            Buttons(text = "Chat AI", navController) {
//                navController.navigate("ChatAI")
//            }
//        }
//    }
//}
//
//@Composable
//fun Buttons(
//    text: String,
//    navController: NavHostController,
//    click : () -> Unit
//){
//    Card(
//            modifier = Modifier
//                .width(165.dp)
//                .height(265.dp)
//                .clickable (onClick =click),
//            colors = CardDefaults.cardColors(
//                containerColor = Color(0xFF0E3E3E)
//            ),
//            shape = RoundedCornerShape(25.dp),
//        ) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = text,
//                    fontSize = 20.sp,
//                    color = Color.White,
//                    fontWeight = FontWeight.SemiBold,
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//        }
//}

@Preview(showSystemUi = true)
@Composable
fun Telegram(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(70.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0E3E3E)
        ),
        shape = RoundedCornerShape(20)
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = "Send button",
            modifier = Modifier.size(25.dp)
        )
    }
}

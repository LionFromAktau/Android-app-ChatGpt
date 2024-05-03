package kz.edu.sdu.income.income_ui

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

class PayCheckScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Surface {
                    PayCheckApp()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun PayCheckApp() {
        val grossPayCheck by remember{ mutableStateOf("1000.00")}
        val federalTax by remember { mutableStateOf("50.00") }
        val stateTax by remember { mutableStateOf("100.00") }
        val tipsTax by remember { mutableStateOf("50.00") }
        val rent by remember { mutableStateOf("250.00") }
        val foodExpense by remember { mutableStateOf("150.00") }
        val netPaycheck by remember { mutableStateOf("999.00") }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF0E3E3E),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    ),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BackButton()
                    Spacer(modifier = Modifier.padding(top = 30.dp))
                    Text(
                        text = "Paycheck",
                        fontSize = 40.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(top = 35.dp))
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.padding(top=40.dp))
                PayCheckRow( "Gross Paycheck", grossPayCheck)
                Spacer(modifier = Modifier.padding(top = 30.dp))
                PayCheckRow( "Federal Tax", federalTax)
                Spacer(modifier = Modifier.padding(top=15.dp))
                PayCheckRow(  "State Tax", stateTax)
                Spacer(modifier = Modifier.padding(top=15.dp))
                PayCheckRow(  "Tips Tax", tipsTax)
                Spacer(modifier = Modifier.padding(top=15.dp))
                PayCheckRow( "Food Expense", foodExpense)
                Spacer(modifier = Modifier.padding(top=15.dp))
                PayCheckRow( "Rent", rent)
                Spacer(modifier = Modifier.padding(top = 50.dp))
                PayCheckRow( "Net Paycheck", netPaycheck)
            }
            Spacer(modifier = Modifier.padding(top = 80.dp))
            bottomButtons()
        }
    }

    @Composable
    fun PayCheckRow(
         text : String,
         value : String
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp)
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp),
                horizontalArrangement = Arrangement.End) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.padding(top=10.dp))
        Image(
            painter = painterResource(id = R.drawable.bottom_rectanglee),
            contentDescription = "",
            modifier = Modifier
                .width(382.dp)
                .height(1.dp)
                .padding(start = 30.dp)
        )
    }

        @Composable
        fun bottomButtons(){
            Row {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(90.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0E3E3E)
                    ),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),

                    ) {
                    Text(
                        text = "Print",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.padding(end=90.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(90.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0E3E3E)
                    ),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),

                    ) {
                    Text(
                        text = "Draft",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
}
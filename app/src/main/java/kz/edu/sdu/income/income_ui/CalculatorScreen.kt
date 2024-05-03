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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

class CalculatorScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Calculator()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun Calculator(){
        var hourlyRate by remember { mutableStateOf("") }
        var hoursWorked by remember { mutableStateOf("") }
        var foodExpense by remember { mutableStateOf("") }
        var grossPayAmount by remember { mutableStateOf("") }
        val shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0E3E3E), shape = shape),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.padding(top = 60.dp),
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowLeft,
                            tint = Color.White,
                            contentDescription = "",
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clickable {
                                    startActivity(Intent(this@CalculatorScreen, MainScreen::class.java))
                                }
                        )
                        Spacer(modifier = Modifier.padding(start = 150.dp, end = 140.dp))
                        Image(
                            painter = painterResource(id = R.drawable.settings),
                            contentDescription = "settings",
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .clickable {
                                    startActivity(Intent(this@CalculatorScreen, SettingsScreen::class.java))
                                }
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 50.dp))
                    Text(
                        text = "Calculator",
                        fontSize = 36.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(top = 150.dp))
                }
            }
            Spacer(modifier = Modifier.padding(top = 40.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CalculateColumn(text = "Hourly Rate", value = hourlyRate) {newValue->
                    if (newValue.isDigitsOnly())
                    hourlyRate = newValue
                }
                Spacer(modifier = Modifier.padding(top=20.dp))
                CalculateColumn(text = "Hours Worked", value = hoursWorked) {newValue->
                    if (newValue.isDigitsOnly())
                    hoursWorked = newValue
                }
                Spacer(modifier = Modifier.padding(top=20.dp))

                CalculateColumn(text = "Food Expense", value = foodExpense) {newValue->
                    if (newValue.isDigitsOnly())
                    foodExpense = newValue
                }
                Spacer(modifier = Modifier.padding(top=20.dp))
                CalculateColumn(text = "Gross Pay Amount", value = grossPayAmount) {newValue->
                    if (newValue.isDigitsOnly())
                    grossPayAmount = newValue

                }

                    Spacer(modifier = Modifier.padding(top = 80.dp))
                    cutomButton()
                }
        }
    }
    
    @Composable
    fun CalculateColumn(
        text : String,
        value : String,
        onValueChange: (String) -> Unit
    ){
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 20.dp)
            )
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
                horizontalArrangement = Arrangement.End){
                OutlinedTextField(
                    value = value,
                    onValueChange = { newValue->
                                    onValueChange(newValue)
                    },
                    textStyle = TextStyle(
                        fontSize = 19.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0E3E3E)
                    ),
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0x4D0E3E3E),
                        focusedBorderColor = Color(0x990E3E3E)
                    ),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }

    @Composable
    fun cutomButton(){
        Button(
            onClick = {
                startActivity(
                    Intent(
                        this@CalculatorScreen,
                        PayCheckScreen::class.java
                    )
                )
            },
            modifier = Modifier
                .width(200.dp)
                .height(45.dp),
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
                text = "Calculate",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


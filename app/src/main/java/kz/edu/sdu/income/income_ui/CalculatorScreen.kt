package kz.edu.sdu.income.income_ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
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
import androidx.compose.ui.unit.dp
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import kz.edu.sdu.income.viewModel.IncomeViewModel

@Composable
fun CalculatorScreen(navController: NavController, viewModel: IncomeViewModel) {
    IncomeTheme {
        Calculator(navController = navController, viewModel = viewModel)
        }
    }

    @Composable
    fun Calculator(navController: NavController, viewModel: IncomeViewModel){
        val hourlyRate by viewModel.hourlyRate
        val hoursWorked by viewModel.hoursWorked
        val foodExpense by viewModel.foodExpense
        val overTime by viewModel.overTime
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
                            contentDescription = "Back button",
                            modifier = Modifier
                                .width(28.dp)
                                .height(28.dp)
                                .clickable {
                                    viewModel.resetAllValues()
                                    navController.navigate("mainScreen") {
                                        popUpTo("mainScreen") { inclusive = true }
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.padding(start = 150.dp, end = 140.dp))
                        Image(
                            painter = painterResource(id = R.drawable.setting_4),
                            contentDescription = "settings",
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .clickable {
                                    navController.navigate("settingsScreen") {
                                        popUpTo("mainScreen") { inclusive = true }
                                    }
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
                    viewModel.updateHourlyRate(newValue)
                }
                Spacer(modifier = Modifier.padding(top=20.dp))
                CalculateColumn(text = "Hours Worked", value = hoursWorked) {newValue->
                    if (newValue.isDigitsOnly())
                    viewModel.updateHoursWorked(newValue)
                }
                Spacer(modifier = Modifier.padding(top=20.dp))

                CalculateColumn(text = "Food Expense", value = foodExpense) {newValue->
                    if (newValue.isDigitsOnly())
                    viewModel.updateFoodExpense(newValue)
                }
                Spacer(modifier = Modifier.padding(top=20.dp))
                CalculateColumn(text = "Overtime", value = overTime) {newValue->
                    if (newValue.isDigitsOnly())
                    viewModel.updateGrossPayAmount(newValue)

                }

                    Spacer(modifier = Modifier.padding(top = 80.dp))
                    CustomButton(navController, viewModel)
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
                    placeholder = {
                                  Text(text = "Type your data here")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }


    @Composable
    fun CustomButton(navController: NavController, viewModel: IncomeViewModel){
        Button(
            onClick = {
                      viewModel.calculateTaxesAndPaycheck()
                      navController.navigate("paycheckScreen"){
                          popUpTo("mainScreen"){inclusive=true}
                      }
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


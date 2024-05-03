package kz.edu.sdu.income.income_ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

val stateList = listOf(
    "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
    "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
    "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
    "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
    "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
    "New Hampshire", "New Jersey", "New Mexico", "New York",
    "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
    "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
    "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
    "West Virginia", "Wisconsin", "Wyoming"
)
class SettingsScreen() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Surface {
                    SettingsApp()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun SettingsApp() {
        var state by remember { mutableStateOf("") }
        var federalTax by remember { mutableStateOf("") }
        var stateTax by remember { mutableStateOf("") }
        var tips by remember { mutableStateOf("") }
        var rent by remember { mutableStateOf("") }
        var periodOfStay by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E3E3E)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BackButton()
                    Spacer(modifier = Modifier.padding(top = 30.dp))
                    Text(
                        text = "Payroll",
                        fontSize = 40.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(top = 40.dp))
                    Column {
                        StateSelector(text = "State", stateList = stateList)

                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "Federal Tax", value = federalTax) { newValue ->
                            federalTax = newValue
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "State Tax", value = stateTax) { newValue ->
                            stateTax = newValue
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "Tips", value = tips) { newValue ->
                            tips = newValue
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "Period of Stay", value = stateTax) { newValue ->
                            stateTax = newValue
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "Rent", value = stateTax) { newValue ->
                            stateTax = newValue
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        PayrollRow(text = "Tips", value = stateTax) { newValue ->
                            stateTax = newValue
                        }
                        Spacer(modifier = Modifier.padding(top=40.dp))
                        SaveButton()
                    }
                }
            }
        }
    }

    @Composable
    fun PayrollRow(
        text: String,
        value: String,
        onValueChange: (String) -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = { newValue ->
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
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
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

//    @Preview(showSystemUi = true)/
//    @Composable
//    fun DropApp() {
//        val text = "State"
//        var state by remember {
//            mutableStateOf("South Caroline")
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFF0E3E3E))
//        ) {
//            StateSelector(text = text, stateList = stateList)
//        }
//    }

    @Composable
    fun StateSelector(
        text : String,
        stateList: List<String>,
    ) {
        var showDialog by remember { mutableStateOf(false) }
        var selectedState by remember { mutableStateOf("Select state") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { showDialog = true},
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White 
                    ),
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 12.dp),
                ) {
                        Text(
                            text = selectedState,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF0E3E3E)
                        )
                }

                if (showDialog) {
                    CustomAlertDialog(
                        title = "Select a State",
                        stateList = stateList,
                        onStateSelected = { selected ->
                            selectedState = selected
                        },
                        onDismissRequest = {
                            showDialog = false
                        }
                    )

                }
            }
        }
    }

    @Composable
    fun CustomAlertDialog(
        title: String,
        stateList: List<String>,
        onStateSelected: (String) -> Unit,
        onDismissRequest: () -> Unit
    ) {
        Dialog(onDismissRequest = onDismissRequest) {
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        items(stateList) { state ->
                                Text(
                                    text = state,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 12.dp)
                                        .clickable {
                                            onStateSelected(state)
                                            onDismissRequest()
                                        }
                                )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun SaveButton() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    startActivity(Intent(this@SettingsScreen, CalculatorScreen::class.java))
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA9EEEE),
                ),
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                ),
            ) {
                Text(
                    text = "Save",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }




//    @Composable
//    fun DropStateMenu(
//        text: String,
//        value: String,
//        stateList: List<String>,
//        onValueChange: (String) -> Unit
//    ){
//        var expanded by remember{ mutableStateOf(false)}
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 25.dp),
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = text,
//                fontSize = 20.sp,
//                color = Color.White,
//                fontWeight = FontWeight.Normal,
//                style = MaterialTheme.typography.bodyLarge,
//                modifier = Modifier
//            )
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(end = 25.dp),
//                horizontalArrangement = Arrangement.End
//            ) {
//                OutlinedTextField(
//                    value = value,
//                    onValueChange = { newValue ->
//                        onValueChange(newValue)
//                    },
//                    textStyle = TextStyle(
//                        fontSize = 14.sp,
//                        textAlign = TextAlign.Start,
//                        fontWeight = FontWeight.SemiBold,
//                        color = Color(0xFF0E3E3E)
//                    ),
//                    modifier = Modifier
//                        .width(150.dp)
//                        .height(50.dp)
//                        .clickable {},
//                    singleLine = true,
//                    colors = OutlinedTextFieldDefaults.colors(
//                        unfocusedBorderColor = Color(0x4D0E3E3E),
//                        unfocusedContainerColor = Color.White,
//                        focusedBorderColor = Color(0x990E3E3E)
//                    ),
//                    shape = RoundedCornerShape(
//                        topStart = 12.dp,
//                        topEnd = 12.dp,
//                        bottomStart = 12.dp,
//                        bottomEnd = 12.dp
//                    ),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    trailingIcon = {
//                        Icon(
//                            imageVector = Icons.Rounded.KeyboardArrowDown,
//                            contentDescription = "Drop Down",
//                            Modifier.clickable { expanded = !expanded }
//                        )
//                    },
//
//                    readOnly = true
//                )
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest={expanded = false},
//                    offset = DpOffset(30.dp, 30.dp),
//                    modifier = Modifier
//                        .background(
//                            Color.Black, shape = RoundedCornerShape(
//                                topStart = 30.dp,
//                                topEnd = 30.dp,
//                                bottomEnd = 30.dp,
//                                bottomStart = 30.dp
//                            )
//                        )
//                        .width(250.dp)
//                        .height(300.dp)
//
//                ) {
//                    stateList.forEach{stateName->
//                        DropdownMenuItem(
//                            text = {
//                                    Row() {
//                                        Text(
//                                            text = stateName,
//                                            fontSize = 16.sp,
//                                            style = MaterialTheme.typography.bodyLarge,
//                                            fontWeight = FontWeight.SemiBold,
//                                            color = Color.White
//                                        )
//                                        Row(
//                                            modifier = Modifier
//                                                .fillMaxWidth()
//                                                .padding(end = 15.dp),
//                                            horizontalArrangement = Arrangement.End
//                                        ) {
//                                            Image(
//                                                painter = painterResource(id = R.drawable.settings),
//                                                contentDescription = "State flag",
//                                                modifier = Modifier
//                                                    .width(16.dp)
//                                                    .height(16.dp)
//                                            )
//                                        }
//                                    }
//                            },
//                            onClick = {
//                                value = stateName
//                                expanded = false
//                                onValueChange(stateName)
//                            },
//                        )
//                    }
//                }
//            }
//        }
//    }
}
@Composable
fun BackButton(){
    Row(
        modifier = Modifier.padding(top = 60.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_button),
            contentDescription = "back button",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clickable {

                }
        )
        Spacer(modifier = Modifier.padding(start = 150.dp, end = 164.dp))
    }
}


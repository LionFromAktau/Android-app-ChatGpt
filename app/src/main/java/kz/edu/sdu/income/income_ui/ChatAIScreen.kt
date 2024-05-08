package kz.edu.sdu.income.income_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kz.edu.sdu.income.R
import kz.edu.sdu.income.viewModel.ChatAIViewModel
import kz.edu.sdu.income.model.Message
import kz.edu.sdu.income.model.MessageType
import kz.edu.sdu.income.ui.theme.IncomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatApp(
    navController: NavController,
    viewModel: ChatAIViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
                Scaffold(
                    modifier = Modifier.padding(bottom = 16.dp),
                ) {
                    ChatAppText(
                        modifier = Modifier
                            .fillMaxHeight(0.92f)
                            .padding(it),
                        messages = uiState.value,
                        navController = navController
                    )
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        UserInputMessage(
                            onClick = {
                                viewModel.addMessage(
                                    type = MessageType.UserMessage,
                                    message = it
                                )
//                                println(">>> Checking input message ${viewModel.messages}")
                            }
                        )
                    }
                }
            }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputMessage(modifier: Modifier = Modifier, onClick: (String) -> Unit){
    var message by remember{
        mutableStateOf("")
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(id = R.dimen.medium),
//                start = dimensionResource(id = R.dimen.medium),
//                end = dimensionResource(id = R.dimen.medium)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = message,
            onValueChange = {message = it},
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.placeholder_message),
                    color = colorResource(id = R.color.placeholder_color),
                    fontSize = 20.sp
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.placeholder_color)
            )
        )
        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.black_green),
                    shape = RoundedCornerShape(16.dp)
                )
                .height(52.dp)
                .width(60.dp)
                .clickable {
                    onClick(message)
                    message = ""
                },
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                tint = Color.White,
                contentDescription = "AI chat icon"
            )
        }

    }
}

@Composable
fun ChatAppTopBar(modifier: Modifier = Modifier, ){

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
            Row(
                modifier = Modifier.padding(top = 60.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    tint = Color.White,
                    contentDescription = "back button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clickable {
                            println("some actions")
                        }
                )
                Spacer(modifier = Modifier.padding(start = 150.dp, end = 164.dp))
            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                text = stringResource(id = R.string.chat_ai),
                fontSize = 40.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(top = 35.dp))
        }
    }

}



@Composable
fun ChatAppText(modifier: Modifier = Modifier, messages: List<Message>, navController: NavController){
    LazyColumn(
        modifier = modifier,
    ){
        item { 
            TopBar(navController = navController)
        }
        items(messages){
            if(it.type == MessageType.AiMessage){
                AiMessage(message = it.message)
            }else{
                UserMessage(message = it.message)
            }
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun AiMessage(modifier: Modifier = Modifier, message: String){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(modifier = Modifier
            .background(
                color = colorResource(id = R.color.light_green),
                shape = CircleShape
            )
            .size(45.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_ai_chat),
                tint = Color.White,
                contentDescription = "AI chat icon"
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(bottomEnd = dimensionResource(id = R.dimen.medium) , topEnd = dimensionResource(id = R.dimen.medium), topStart = dimensionResource(id = R.dimen.medium)),
                    color = colorResource(id = R.color.ai_message)
                )
        ){
            Text(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium)),
                text = message,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }

    }
}


@Composable
fun UserMessage(modifier: Modifier = Modifier, message: String){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(bottomStart = dimensionResource(id = R.dimen.medium) , topEnd = dimensionResource(id = R.dimen.medium), topStart = dimensionResource(id = R.dimen.medium)),
                    color = colorResource(id = R.color.user_message)
                )
        ){
            Text(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium)),
                text = message,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Box(modifier = Modifier
            .background(
                color = colorResource(id = R.color.black_green),
                shape = CircleShape
            )
            .size(45.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_user),
                tint = Color.White,
                contentDescription = "AI chat icon"
            )
        }

    }
}



@Preview(
    showBackground = true,
)
@Composable
fun ChatEditTextPreview() {
    IncomeTheme {
        UserInputMessage(){
            println(">>> Sending message to API ")
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun ChatAppPreview() {
    IncomeTheme{
        val navController = rememberNavController()
        ChatApp(navController)
    }
}
@Preview(showSystemUi = true)
@Composable
fun preView(){
    val nav = rememberNavController()
    TopBar(nav)
}
@Composable
fun TopBar(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF0E3E3E),
                shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp)
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(top = 40.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    tint = Color.White,
                    contentDescription = "Back button",
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .clickable {
                            navController.navigate("mainScreen")
                        }
                )
                Spacer(modifier = Modifier.padding(start = 150.dp, end = 140.dp))
            }
            Spacer(modifier = Modifier.padding(top = 0.dp))
            Text(
                text = "ChatAi",
                fontSize = 36.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }
    }
}
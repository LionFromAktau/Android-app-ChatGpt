package kz.edu.sdu.income.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.edu.sdu.income.model.Message
import kz.edu.sdu.income.model.MessageType
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import org.json.JSONObject
import java.util.Arrays

class ChatAIViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<List<Message>>(mutableListOf())
    val uiState = _uiState.asStateFlow()

    var waitMessage: Boolean = false

    private val client = OkHttpClient()

    fun addMessage(type: MessageType, message: String) {
        val updatedList = _uiState.value + Message(message, type)
        _uiState.value = updatedList




        if (type == MessageType.UserMessage) {
            viewModelScope.launch {
                waitMessage = true
                getAiMessage(userMessage = message)
                waitMessage = false
            }
        }

    }
//
//    private suspend fun getAiMessage(userMessage: String) {
////        val api_key = "Here Must Be your APi"
//        val url = "https://api.openai.com/v1/chat/completions"
//
//        val requestBody = """
//       {
//    "model": "gpt-3.5-turbo",
//    "messages": [
//      {
//        "role": "system",
//        "content": "You are a helpful assistant."
//      },
//      {
//        "role": "user",
//        "content": "$userMessage"
//      }
//    ]
//  }
//        """.trimIndent()
//
//        withContext(Dispatchers.IO) {
//            val request = Request.Builder()
//                .url(url)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", "Bearer $api_key")
//                .post(requestBody.toRequestBody("application/json".toMediaTypeOrNull()))
//                .build()
//
//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.e(">>> Error", "${e.message}")
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    val body = if (response.body == null) {
//                        "No response"
//                    } else {
//                        response.body!!.string()
//                    }
//                    val data = JSONObject(body)
//                        .getJSONArray("choices")
//                        .getJSONObject(0)
//                        .getJSONObject("message")
//                        .getString("content")
//
//                    addMessage(message = data, type = MessageType.AiMessage)
//                    Log.e(">>> Response", body)
//                }
//            })
//        }
//
//    }
//}
package com.example.ff_sdci

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class LoginAsyncTask(private val context: Context, private val serverUrl: String) : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String): String {
        var result = ""

        try {
            val url = URL("$serverUrl/login")
            val connection = url.openConnection() as HttpURLConnection

            // POST 방식으로 요청 설정
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            // 사용자 아이디와 비밀번호를 JSON 형식으로 전송
            val loginData = mapOf(
                "id" to params[0],      // 사용자 아이디
                "password" to params[1]  // 사용자 비밀번호
            )

            val os: OutputStream = connection.outputStream
            os.write(loginData.toString().toByteArray(charset("UTF-8")))
            os.flush()
            os.close()

            // 응답 코드 확인
            val responseCode = connection.responseCode

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 응답 데이터를 문자열로 변환
                val inputStream: InputStream = connection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                val stringBuilder = StringBuilder()
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                }
                result = stringBuilder.toString()

                // 연결 종료
                inputStream.close()
                bufferedReader.close()
            } else {
                result = "Error: $responseCode"
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return result
    }

    // doInBackground가 실행된 후에 호출되는 메서드
    override fun onPostExecute(result: String) {
        // 서버로부터 받은 결과(result)를 처리하면 됩니다.
        // 예를 들어, JSON 데이터를 파싱하여 로그인 성공 여부를 확인하거나
        // 필요에 따라 화면 전환 등을 처리합니다.

        try {
            val jsonObject = JSONObject(result)
            val success = jsonObject.getBoolean("success")

            if (success) {
                // 로그인 성공 시 수행할 동작
                // 예: 다음 화면으로 전환
                val intent = Intent(context, Dep1_Home::class.java)
                context.startActivity(intent)
            } else {
                // 로그인 실패 시 수행할 동작
                // 예: 에러 메시지 표시
                (context as Activity).runOnUiThread{
                    Toast.makeText(context, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}

package com.twomusketeers.presin_compose.ui.screens.forgot_password

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twomusketeers.presin_compose.R
import com.twomusketeers.presin_compose.ui.theme.PresINComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun ForgotPassword() {

    var email by remember { mutableStateOf("") }
    val isDetailsValid by derivedStateOf {
        email.isNotBlank()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = stringResource(R.string.forgot_password_title),
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.we_will_send_an_otp_to_your_email),
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = 16.sp
            )
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = stringResource(R.string.email),
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = 14.sp
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = stringResource(R.string.demo_email),
                            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                            color = Color.LightGray
                        )
                    },
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(500.dp))
                Button(
                    onClick = {},
                    enabled = isDetailsValid,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(320.dp)
                        .height(61.dp),
                    shape = RoundedCornerShape(52.dp)
                ) {
                    Text(
                        text = stringResource(R.string.send_otp),
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    PresINComposeTheme {
        ForgotPassword()
    }
}
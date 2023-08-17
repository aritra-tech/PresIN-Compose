package com.twomusketeers.presin_compose.ui.screens.forgot_password

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twomusketeers.presin_compose.R
import com.twomusketeers.presin_compose.components.OtpTextField
import com.twomusketeers.presin_compose.ui.theme.PresINComposeTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun VerifyOTP() {
    var otpValue by remember {
        mutableStateOf("")
    }
    val isDetailsValid by derivedStateOf {
        otpValue.isNotBlank()
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
                text = stringResource(R.string.verify_otp),
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
                Spacer(modifier = Modifier.height(70.dp))
                OtpTextField(
                    otpText = otpValue,
                    onOtpTextChange = { value, otpInputFilled ->
                        otpValue = value
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.don_t_receive_any_mail),
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        fontSize = 16.sp
                    )
                    TextButton(onClick = {}) {
                        Text(
                            text = stringResource(R.string.resend),
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            color = Color.Blue,
                            fontSize = 16.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(400.dp))
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
                        text = stringResource(R.string.verify_otp),
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
fun VerifyOTPPreview() {
    PresINComposeTheme {
        VerifyOTP()
    }
}
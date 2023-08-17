package com.twomusketeers.presin_compose.ui.screens.forgot_password

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.twomusketeers.presin_compose.R
import com.twomusketeers.presin_compose.ui.theme.PresINComposeTheme

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPassword() {

    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val visibilityOff = painterResource(id = R.drawable.eye_closed)
    val visibilityOn = painterResource(id = R.drawable.eye_opened)
    val isDetailsValid by derivedStateOf {
        password.isNotBlank()
    }

    val tint = LocalContentColor.current

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
                text = "Set new password",
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "You must enter a different password",
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = 16.sp
            )
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {

                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = stringResource(R.string.password),
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = 14.sp
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = stringResource(R.string.demo_password),
                            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                            color = Color.LightGray
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            val visiblity = if (isPasswordVisible) visibilityOn else visibilityOff
                            Image(
                                painter = visiblity,
                                contentDescription = stringResource(R.string.visibility_icon),
                                colorFilter = ColorFilter.tint(tint)
                            )
                        }
                    }
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
                        text = "Reset password",
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
fun ResetPasswordPreview() {
    PresINComposeTheme {
        ResetPassword()
    }
}
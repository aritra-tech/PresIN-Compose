package com.twomusketeers.presin_compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(heading: String, onValueChangeListener: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {

        val input = remember {
            mutableStateOf("")
        }

        Text(text = heading, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = input.value,
            onValueChange = {
                onValueChangeListener(it)
                input.value = it
            })
    }
}
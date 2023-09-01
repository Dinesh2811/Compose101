package com.dinesh.android.basic.text_field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun MyLayoutView(){
    var inputValue by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        MyTextField(value = inputValue, onValueChanged = { inputValue = it })
    }
}

@Composable
private fun MyTextField(value: String, onValueChanged: (String) -> Unit, label: String) {
    TextField(value = value, onValueChange = onValueChanged, label = { Text(label) }, modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth())
}


@Composable
private fun MyTextField(modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, label: String = "Name", hintPlaceHolder: String = "Enter the name") {
    OutlinedTextField(value = value, onValueChange = onValueChanged, label = { Text(label) },
        placeholder = { Text(hintPlaceHolder) }, modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .then(modifier), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))
}

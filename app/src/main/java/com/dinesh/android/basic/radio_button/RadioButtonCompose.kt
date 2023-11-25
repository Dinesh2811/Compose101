package com.dinesh.android.basic.radio_button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinesh.android.R

@Preview(showBackground = true)
@Composable
fun CustomRadioButtonIndicator_WithIconToggleButton() {
    MaterialTheme {
        val selectedValue = remember { mutableStateOf("") }
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        Column(Modifier.padding(8.dp)) {
            Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.selectable(
                        selected = (selectedValue.value == item),
                        onClick = { selectedValue.value = item },
                        role = Role.RadioButton
                    ).padding(8.dp)
                ) {
                    IconToggleButton(
                        checked = selectedValue.value == item,
                        onCheckedChange = { selectedValue.value = item },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = if (selectedValue.value == item) {
                                Icons.Outlined.CheckCircleOutline
                            } else {
                                Icons.Outlined.Circle
                            },
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = item,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
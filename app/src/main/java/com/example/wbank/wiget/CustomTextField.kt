package com.example.wbank.wiget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
) {
    var value by remember {
        mutableStateOf("")

    }
    OutlinedTextField(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,  //KeyboardType.Email,
            imeAction = ImeAction.Next,
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false
        ),
        maxLines = 1,
        singleLine = true,
        value = value,
        label = {
            Text(
                text = label,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffaaaaaa),
            )
        },
        textStyle = TextStyle(
            fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color.Black
        ),
        onValueChange = { it ->
            value = it
            onValueChange(it)
        },
        shape = RoundedCornerShape(14.dp),
        colors = TextFieldDefaults. outlinedTextFieldColors(
            focusedBorderColor = Color(0xffC0C0C0).copy(
                alpha = 0.5f
            ),
            unfocusedBorderColor = Color(0xffC0C0C0),
        ),
    )
}
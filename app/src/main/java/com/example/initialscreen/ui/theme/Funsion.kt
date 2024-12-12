package com.example.initialscreen.ui.theme

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.initialscreen.R

@Composable
fun TextFieldEmail(
    value: String,
    onValueChange: (String) -> Unit
){
    val myColor = Color.DarkGray

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = "Enter Your Email",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = stringResource(R.string.email_icon),
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}

@Composable
fun TextFieldPassword(
    value: String,
    onValueChange: (String) -> Unit
){
    val myColor = Color.DarkGray

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = "Enter Your Password",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = stringResource(R.string.icon_password),
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun TextFieldUrl(
    value: String,
    onValueChange: (String) -> Unit
){
    val myColor = Color.DarkGray
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = "Enter URL of Your Image",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "",
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun TextFieldTextPub(
    value: String,
    onValueChange: (String) -> Unit
){
    val myColor = Color.DarkGray

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = "Enter text",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Create,
                contentDescription = "",
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}



@Composable
fun TextFieldConfirmPassword(){
    val myColor = Color.DarkGray
    var confirmPassword by remember { mutableStateOf("") }

    TextField(
        value = confirmPassword,
        onValueChange = {confirmPassword = it},
        label = {
            Text(text = "Confirm Your Password",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = stringResource(R.string.icon_password),
                tint = Color.DarkGray,
                modifier = Modifier.size(18.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun TextFieldName(
    value: String,
    onValueChange: (String) -> Unit
){
    val myColor = Color.DarkGray
    var name by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = "Enter your Name",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.AccountBox,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun TextFieldSurName(){
    val myColor = Color.DarkGray
    var surName by remember { mutableStateOf("") }

    TextField(
        value = surName,
        onValueChange = {surName = it},
        label = {
            Text(text = "Enter your surname",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.AccountBox,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(18.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun TextFieldPhone(){
    val myColor = Color.DarkGray
    var telefone by remember { mutableStateOf("") }

    TextField(
        value = telefone,
        onValueChange = {telefone = it},
        label = {
            Text(text = "Enter number phone",
                color = Color.LightGray)

        },
        maxLines = 1,
        textStyle = TextStyle(color = Color.DarkGray),
        modifier = Modifier.size(300.dp, 55.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        },

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedLabelColor = myColor,
            unfocusedLabelColor = myColor,
            unfocusedTextColor = myColor,
            cursorColor = myColor,
            unfocusedIndicatorColor = myColor,
            focusedIndicatorColor = myColor


        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun GreetingTextEntrar(title: String, modifier: Modifier = Modifier){
    Text(
        title,
        fontWeight = FontWeight.Light,
        fontSize = 30.sp,
        color = Color(0xFF214CCE)
    )
}

@Composable
fun GreetingTextAcount(title: String, modifier: Modifier = Modifier){
    Text(
        title,
        fontWeight = FontWeight.Light,
        fontSize = 30.sp,
        color = Color(0xFF214CCE)
    )
}
package com.example.putatoe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpScreen (navController: NavController){
    var firstname by remember {
        mutableStateOf("")
    }
    var lastname by remember {
        mutableStateOf("")
    }
    var mobilenumber by remember {
        mutableStateOf("")
    }
    var refral by remember {
        mutableStateOf("")
    }


    Surface (
        color = colorResource(R.color.teal_700)
    ){
        Card (modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )

            {
                Spacer(modifier = Modifier.padding(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Login Image",
                    modifier = Modifier
                        .size(110.dp),
                )
                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = "Welcome", color = Color.Black,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = "Create your new Account", fontSize = 16.sp, color = colorResource(
                        id
                        = R.color.purple_200
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(value = firstname,
                    onValueChange = {
                    firstname = it
                }, label = {
                    Text(text = "First Name",color = Color.Black)
                },leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.baseline_person_24) , contentDescription = "")
                    },)
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = lastname, onValueChange = {
                    lastname = it
                }, label = {
                    Text(text = "Last Name",color = Color.Black)
                },leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_person_2_24) , contentDescription = "")
                },)

                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = mobilenumber, onValueChange = {
                    mobilenumber = it
                }, label = {
                    Text(text = "Mobile Number",color = Color.Black)
                },leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_mobile_friendly_24) , contentDescription = "")
                },)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Enter refral code if any (Optional)", color = Color.Black,
                    modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(1.dp))
                OutlinedTextField(value = refral, onValueChange = {
                    refral = it
                }, label = {
                    Text(text = "Referral code (optional)",color = Color.Black)
                },leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_attach_money_24) , contentDescription = "")
                },)
                Spacer(modifier = Modifier.height(15.dp))
                CheckboxComponent("")
                Spacer(modifier = Modifier.height(15.dp))
                RegisterButton(value = stringResource(id = R.string.register))
              AlreadyAccount(navController)
                }}}}

@Composable
fun RegisterButton(value: String) {
    Button(onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(), colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
    Box (modifier = Modifier
        .width(250.dp)
        .heightIn(48.dp)
        .background(
            color = colorResource(id = R.color.teal_700),
            shape = RoundedCornerShape(25.dp)
        ), contentAlignment = Alignment.Center){
        Text(text = value, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
    }

}
/*
@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean = true, onTextSelected: (String)-> Unit) {
    val initialText = if (tryingToLogin)"Already Register" else "Dont't have an account?"
    val loginText = if (tryingToLogin)"Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Gray)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(minOf(40.dp)
        ),
        text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{${span.item}}")
            if (span.item == loginText) {
                onTextSelected(span.item)
            }
        }
    })
}
*/
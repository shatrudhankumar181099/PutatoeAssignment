package com.example.putatoe

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.putatoe.nvigation.Screen


@Composable
fun LoginScreen (navController: NavController) {
    var email by remember {
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
                    text = "Welcome back!", color = Color.Black,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = "Sign in to your account!", fontSize = 16.sp, color = colorResource(
                        id
                        = R.color.purple_200
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(value = email, onValueChange = {
                        email = it
                    },
                        label = {
                            Text(text = "Email Address",color = Color.Black)
                        }, leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = "")
                        })

                Spacer(modifier = Modifier.height(10.dp))
                var password by rememberSaveable { mutableStateOf("") }
                var passwordVisible by rememberSaveable { mutableStateOf(false) }

                OutlinedTextField(value = password, onValueChange = {
                    password = it
                }, label = {
                    Text(text = "Password", color = Color.Black)
                }, leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_lock_24) , contentDescription = "")
                },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else
                    PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(imageVector  = image, description)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextButton(onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Forget password?",color = Color(0xFF179488))

                }
                     /*   Text(text = "Forget password?",
                            color = Color(0xFF179488),
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(2.dp)
                        )
*/
                Spacer(modifier = Modifier.height(19.dp))

                    CheckboxComponent(value = "")

                Spacer(modifier = Modifier.padding(6.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        Log.i("Credential", "Email: $email Password : $password")
                    }, colors = ButtonDefaults.buttonColors(Color(0xFF179488))) {
                        Text(text = "Login", color = Color.White)
                    }
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF179488))) {
                        Text(text = "Login with O.T.P", color = Color.White)

                    }
                }
                DividerTextComponent()
                Spacer(modifier = Modifier.height(19.dp))
                Image(
                    painter = painterResource(id = R.drawable.google), contentDescription = "",
                    modifier = Modifier.size(60.dp)
                )
                DontHaveAccount(navController)
            }
        }


        }
    }

@Composable
fun DontHaveAccount(navController: NavController) {
    Box (
        modifier = Modifier
            .fillMaxHeight(fraction = 0.8f)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = "Not having an account?", color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 14.sp)

            TextButton(onClick = {
                navController.navigate(Screen.SignUpScreen.route)

            }
            ) {
                Text(text = "Create Account", color = Color(0xFF179488), fontWeight = FontWeight.Bold)
                
            }
        }
   /*     Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color =Color(0xFF94A3B8),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            ){
                append("Dont't have an account?")
            }
            withStyle(
                style = SpanStyle(fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            ){
                append("")
                append("Create Account" )

            }
        })*/
    }
}

@Composable
fun DividerTextComponent() {
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),color = Color.Gray, thickness = 1.dp)
        Text(modifier = Modifier.padding(8.dp), text = stringResource(id = R.string.or),
            fontSize = 20.sp, color = Color.Black)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),color = Color.Gray, thickness = 1.dp)
    }

}

@Composable
fun CheckboxComponent(value: String) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){

        val checkedState = remember {
            mutableStateOf(false)

        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = it
        },
            modifier = Modifier.padding(2.dp), colors = CheckboxDefaults.colors(Color(0xFF179488)))
       Text(text = "I agree to all the", color = Color.Black)
        Text(text = "Terms & Condition", color = Color(0xFF179488),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {

            })

    }

}
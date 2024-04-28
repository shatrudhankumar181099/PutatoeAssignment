package com.example.putatoe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.putatoe.nvigation.Screen

@Composable
fun AlreadyAccount(navController:NavController) {
    Box(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.8f)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = "Already Account?", color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 14.sp)

            TextButton(onClick = {
                navController.navigate(Screen.LoginScreen.route)

            }
            ) {
                Text(text = "Login", color = Color(0xFF179488), fontWeight = FontWeight.Bold)

            }
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
                append("Already Register")

            }
            withStyle(
                style = SpanStyle(fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            ){
                append("")
                append(" Login" )
            }
        })*/


    }

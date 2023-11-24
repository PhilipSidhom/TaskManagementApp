package com.example.appdev2assignment3.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.appdev2assignment3.Layouts.MainLayout

@Composable
fun ContactScreen() {
    MainLayout {
        Column{
            Text(text = "Contact us")
            Text(text = "Phone Number: (514)-345-3456")
            Text(text = "Email: ToDoSInc@Outlook.com")
        }
    }

}
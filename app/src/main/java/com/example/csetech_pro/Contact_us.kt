package com.example.csetech_pro

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun ContactUs(navController: NavController){
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Scaffold(
            topBar ={
                TopAppBar(
                    title =  {
                        Text(text = "Contact Us", color = Color.White)
                    },
                    backgroundColor = Color.Blue
                )
            },
//        Bottom navigation

        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Blue
            ) {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                    label = { Text(
                        text="Home" , color = Color.Black
                    )},
                    selected = false, // Set to true for the active tab
                    onClick = {navController.navigate("Home")}
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                    label = { Text(text="Materials" , color = Color.Black)},
                    selected = true,
                    onClick = {navController.navigate("Resources")}
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text(
                        text="About us" , color = Color.Black
                    )},
                    selected = false,
                    onClick = {navController.navigate("About_us")}
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Filled.Call, contentDescription = "Contact") },
                    label = { Text(
                        text="Contact us" , color = Color.White
                    )},
                    selected = false,
                    onClick = {navController.navigate("Contact_us")}
                )
            }
        }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(colors = listOf(Color.Green,
                    Color.Yellow, Color.Blue), start = Offset(100f, 100f),
                    end = Offset(1500f, 1500f))),

            ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                val senderEmail = remember {
//                    mutableStateOf(TextFieldValue())
//                }
                val emailSubject = remember {
                    mutableStateOf(TextFieldValue())
                }
                val emailBody = remember {
                    mutableStateOf(TextFieldValue())
                }
                val attachmentUri = remember {
                    mutableStateOf<Uri?>(null)
                 }
                // Creating a file picker launcher
                val filePickerLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetContent()
                ) { uri: Uri? ->
                    attachmentUri.value = uri
                }
                Text(text="Contact Form", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Green)
                Spacer(modifier = Modifier.height(25.dp))
                TextField(
                    value = emailSubject.value,
                    onValueChange = { emailSubject.value = it },
                    label = {
                        Text("Email Subject", color = Color.White)}
                    ,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(color = Color.Black, shape = MaterialTheme.shapes.medium),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = emailBody.value,
                    onValueChange = { emailBody.value = it },
                    label = {
                        Text("Email Body" , color = Color.White)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(color = Color.Black, shape = MaterialTheme.shapes.medium),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text=  "Feel free , f you want to add the Resources upload the files" , color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.SemiBold , modifier = Modifier.padding(15.dp))
                Spacer(Modifier.height(20.dp))
                Button(onClick = {
                    filePickerLauncher.launch("*/*")
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                    ) {
                    Text(text = "Upload File", color = Color.White , modifier = Modifier.padding(10.dp))
                }
                Spacer(modifier = Modifier
                    .height(30.dp))
                Button(onClick = {
                    val i = Intent(Intent.ACTION_SEND)
                    val emailAddress = arrayOf("codersnexusjntua@gmail.com")
                    i.putExtra(Intent.EXTRA_EMAIL,emailAddress)
                    i.putExtra(Intent.EXTRA_SUBJECT,emailSubject.value.text)
                    i.putExtra(Intent.EXTRA_TEXT,emailBody.value.text)

                    attachmentUri.value?.let {
                        i.putExtra(Intent.EXTRA_STREAM, it)
                        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    }

                    i.setType("message/rfc822")
                    context.startActivity(Intent.createChooser(i,"Choose an Email client : "))

                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                    ) {
                    Text(
                        text = "Send Email",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text="OR",fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Green)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    coroutineScope.launch {
                        uriHandler.openUri("https://forms.gle/gdpdaQ6CVSvrnxyA9")
                    }
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text="Fill Form" , color = Color.White, fontSize = 15.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen3(){
//    ContactUs()
}
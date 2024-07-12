package com.example.csetech_pro

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import kotlin.random.Random


@Composable
fun Home(navController: NavController){
val context = LocalContext.current
        Scaffold(
            topBar = {
                TopAppBar(
                    title ={
                        Text(text = "JNTUACEA", color = Color.White)
                    },
                    backgroundColor = Color.Blue
                )
            },
//            Bottom navigation
            bottomBar = {
                BottomAppBar(
                    backgroundColor = Color.Blue
                ) {
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text(
                            text="Home" , color = Color.White
                        )},
                        selected = true, // Set to true for the active tab
                        onClick = {navController.navigate("Home")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Resources") },
                        label = { Text(text="Materials" , color = Color.Black)},
                        selected = false,
                        onClick = {navController.navigate("Resources")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "About us") },
                        label = { Text(
                            text="About us" , color = Color.Black
                        )},
                        selected = false,
                        onClick = {navController.navigate("About_us")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Call, contentDescription = "Contact") },
                        label = { Text(
                            text="Contact us" , color = Color.Black
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
                        .padding(10.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                    , verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = rememberImagePainter(data = "https://www.jntuacea.ac.in/images/college.jpg"),
                        contentDescription = null,
                        modifier = Modifier
                            .size(250.dp, 250.dp)
                            .padding(20.dp, 10.dp, 0.dp, 0.dp)
                            .clip(RoundedCornerShape(35.dp))
                            .clickable {
                                Toast
                                    .makeText(context, "JNTUACEA SYMBOL", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val shadowOffset = Offset(x=4f,y=6f)
                    val color = Color(red = Random.nextInt(256),
                        green = Random.nextInt(256),
                        blue = Random.nextInt(256))
                    Text(
                        text = "Computer Science And Engineering",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier,
                        style =
                        TextStyle(
                            fontStyle = FontStyle.Normal,
                            shadow = Shadow(color,shadowOffset,13f)
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "About App",
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontStyle = FontStyle.Normal,
                            shadow = Shadow(color,shadowOffset,10f)
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    val b =
                        "Our app is a comprehensive resource for computer science students, providing a vast collection of PDFs for various subjects related to the field. With easy access to the app, students can conveniently browse and study materials covering a wide range of topics, including programming languages, algorithms, data structures, software engineering, and more. In addition to the subject PDFs, our app  also features a dedicated section that offers previous year question papers specifically tailored to the JNTUACEA curriculum. This allows students to familiarize themselves with the exam format, gain insights into the types of questions asked, and practice effectively for their upcoming examinations. By offering a centralized platform for accessing study materials and question papers, our app aims to enhance the learning experience and support students in their academic journey, ultimately helping them achieve success in their computer science studies."
                    Text(
                        modifier = Modifier
                            .animateContentSize(),
                        text = b,
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.height(110.dp))
                }
            }
        }
}

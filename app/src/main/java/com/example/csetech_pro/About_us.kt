package com.example.csetech_pro

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import kotlin.random.Random


@Composable
fun About_us(navController: NavController){

    val context = LocalContext.current
    val urlHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val shadowOffset = Offset(x=4f,y=6f)
    val color = Color(red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256))
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "About US")
                },
                backgroundColor = Color.Blue
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Blue
            ) {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                    label = { Text(
                        text="Home" , color = Color.Black
                    )},
                    selected = true, // Set to true for the active tab
                    onClick = {navController.navigate("Home")}
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                    label = { Text(text="Materials" , color = Color.Black)},
                    selected = false,
                    onClick = {navController.navigate("Resources")}
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text(
                        text="About us" , color = Color.White
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
                    .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = rememberImagePainter(data = ""), contentDescription = null,
                    modifier = Modifier
                        .size(300.dp, 300.dp)
                        .padding(20.dp, 10.dp, 0.dp, 0.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .clickable {
                            Toast
                                .makeText(context, "Codding Club", Toast.LENGTH_SHORT)
                                .show()
                        },
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Computer Science And Engineering",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,15f)
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "About Us", color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,65f)
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))

                val a = "Click to see details"
                val b =
                    "At the coding club of JNTUACEA, a dynamic group of students passionate about computer science come together to explore the realms of coding and technology. The club is led by five dedicated coordinators, namely Jaya Chandra, Dinesh, Avineshwar, Cherishma, and Reddyvasanthi, all of whom are pursuing their studies in the field of Computer Science and Engineering at JNTUACEA. The club has garnered immense enthusiasm from the student body, with over a hundred students registering to be part of this exciting journey. With the invaluable support of the university, the club has taken its initial steps and is geared up for remarkable growth in the near future. The club's vision extends beyond its current boundaries, as it aspires to expand its influence across the region, fostering a community of tech enthusiasts. In line with these ambitions, the club has strategic plans to organize a diverse range of events including quizzes, hackathons, and more, providing a platform for members to hone their coding skills and thrive in the world of technology."
                var text = b
                Text(
                    modifier = Modifier
                        .animateContentSize()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable {
                            text = b
                        },
                    text = text,
                    fontSize = 15.sp,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,30f))
//                    text = "Our app is a comprehensive resource for computer science students, providing a vast collection of PDFs for various subjects related to the field. With easy access to the app, students can conveniently browse and study materials covering a wide range of topics, including programming languages, algorithms, data structures, software engineering, and more. In addition to the subject PDFs, our app
//                    also features a dedicated section that offers previous year question papers specifically tailored to the JNTUACEA curriculum. This allows students to familiarize themselves with the exam format, gain insights into the types of questions asked, and
//                    practice effectively for their upcoming examinations. By offering a centralized platform for accessing study materials and question papers, our app aims to enhance the learning experience and support students in their academic journey,
//                    ultimately helping them achieve success in their computer science studies.",
//                    color = Color.White,
//                    fontWeight = FontWeight.Black,
//                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(50.dp)
                )
                Text(text = "Our Coordinators", fontWeight = FontWeight.Bold, fontSize = 18.sp, color=Color.Yellow,
                    style =
                    TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,75f))
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Column {
                        Image(painter = rememberImagePainter(data = "https://avatars.githubusercontent.com/u/117835803?v=4"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .clickable {
                                    Toast
                                        .makeText(context, "K Dinesh", Toast.LENGTH_SHORT)
                                        .show()
                                    coroutineScope.launch {
                                        urlHandler.openUri("https://www.linkedin.com/in/dinesh-kuddana-198a0a243/")
                                    }

                                },
                            contentScale = ContentScale.Crop)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = " K Dinesh \n" +
                                "Web Developer", fontSize = 15.sp , color=Color.White)
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Column {
                        Image(painter = rememberImagePainter(data = "https://avatars.githubusercontent.com/u/124431955?v=4"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .clickable {
                                    Toast
                                        .makeText(context, "G Avineshwar", Toast.LENGTH_SHORT)
                                        .show()
                                    coroutineScope.launch {
                                        urlHandler.openUri("https://www.linkedin.com/in/avineshwar-gowrabathina-81a5ba217/")
                                    }
                                },
                            contentScale = ContentScale.Crop)
                        Text(text = "  G Avineshwar\n" +
                                "Android Developer", fontSize = 15.sp , color=Color.White)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column {
                        Image(painter = rememberImagePainter(data = "https://media.licdn.com/dms/image/D5603AQF7t91RmwrwYA/profile-displayphoto-shrink_800_800/0/1694690719548?e=1726099200&v=beta&t=8tfnTfd6pYys-bpi_L5TpRVUkFRepA-SZbY8xIBSvsw"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .clickable {
                                    Toast
                                        .makeText(context, "Jaya Chandra", Toast.LENGTH_SHORT)
                                        .show()
                                    coroutineScope.launch {
                                        urlHandler.openUri("https://www.linkedin.com/in/developerjay000/")
                                    }
                                },
                            contentScale = ContentScale.Crop)
                        Text(text = "B Jaya Chandra\n" +
                                "Web Developer", fontSize = 15.sp , color=Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Column {
                        Image(painter = rememberImagePainter(data = "https://avatars.githubusercontent.com/u/161187451?v=4"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .clickable {
                                    Toast
                                        .makeText(context, " Vasanthi ", Toast.LENGTH_SHORT)
                                        .show()
                                    coroutineScope.launch {
                                        urlHandler.openUri("https://www.linkedin.com/in/talapaneni-vasanthi-03b121242/")
                                    }
                                },
                            contentScale = ContentScale.Crop)
                        Text(text = "T Reddy Vasanthi\n" +
                                "Web Developer", fontSize = 15.sp , color=Color.White)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Image(painter = rememberImagePainter(data = "https://avatars.githubusercontent.com/u/161187451?v=4"),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .clickable {
                                    Toast
                                        .makeText(context, " Cherishma ", Toast.LENGTH_SHORT)
                                        .show()
                                    coroutineScope.launch {
                                        urlHandler.openUri("https://www.linkedin.com/in/cherishma-morusu-166937257/")
                                    }
                                },
                            contentScale = ContentScale.Crop)
                        Text(text = "M Cherishma \n" +
                                "Web Developer", fontSize = 15.sp , color=Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text="Click on our icon to know more about us", textAlign = TextAlign.Justify, color = Color.White, fontWeight = FontWeight.Bold,
                    style =
                    TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,80f)))
                Spacer(modifier = Modifier.height(100.dp))
                Text(text = "")
                }
            }
        }
    }

@Preview
@Composable
fun Screen6(){
//    About_us()
}
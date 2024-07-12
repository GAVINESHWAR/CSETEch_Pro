package com.example.csetech_pro

import Internships
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.csetech_pro.ui.theme.CSETech_ProTheme

//Materials for CSE

val year1 = listOf("1","2","3","4")
val sem1 = listOf("1","2")
val subject12 = listOf("Differential Equations and Calculus","Python Programming","Chemistry","Electrical","Electronics","Environmental Science")
val subject11 = listOf("Linear Algebra and Calculus","Engineering drawing","English","Problem solving with c programing","Physics")
val subject21 = listOf("Discrete mathematics and Graph Theory","Digital Systems","OOPS through Java","Human Values","Data Structures","Managerial Economics Financial Analysis")
val subject22 = listOf("Probability and statistical methods","Database Management System","Computer Organization","Operating System","Software Engineering")
val subject31 = listOf("Design and Analysis of Algorithms","Computer Networks","Formal Language and Automation Theory","Open elective","Professional Elective","Intellectual property Rights")
val subject32 = listOf("Compiler Design","Machine Learning","Cryptography and Network Security","Indian Constitution","Full Stack Development","Open Elective","Professional Elective")
val subject41 = listOf("Open Elective-I", "Open Elective-II", "Agile Methodologies", "Professional elective-II")
val options= listOf("Subjects","Previous Year Question Paper")


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSETech_ProTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainPage()
                }
            }
        }
    }
}
@Composable
fun MainPage(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            Home(navController = navController)
        }
        composable("Resources"){
            Resources(navController=navController)
        }
        composable("About_us"){
            About_us(navController=navController)
        }
        composable("Contact_us"){
            ContactUs(navController=navController)
        }
        composable("College"){
            College(navController = navController)
        }
        composable("Internships"){
            Internships(navController=navController)
        }
    }
}
@Composable
fun Resources(navController: NavController){
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Topics", color = Color.White)
                },
                backgroundColor = Color.Blue
            )
        },
//        ottom navigation
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
                    icon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search") },
                    label = { Text(text="Materials" , color = Color.White)},
                    selected = false,
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

            ) {
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
//                #buttons
                Spacer(modifier = Modifier
                    .height(20.dp)
                    .padding(10.dp))
                GradientButton(
                    text = "College Resources",
                    images = "https://www.jntua.ac.in/icon/jntua.jpg",
                    navController= navController,
                    page = "College"
                )
                Spacer(modifier = Modifier
                    .height(20.dp)
                    .padding(10.dp))
                GradientButton(
                    text = "Internships",
                    images = "https://cdn.uconnectlabs.com/wp-content/uploads/sites/25/2021/10/480x320-Develop-an-Internship-Program.png",
                    navController = navController,
                    page = "Internships"
                )
                Spacer(modifier = Modifier
                    .height(20.dp)
                    .padding(10.dp))
                GradientButton(
                    text = "Courses",
                    images = "https://www.cna.nl.ca/programs-courses/images/Courses.jpg",
                    navController = navController,
                    page = "courses"
                )
                Spacer(modifier =Modifier.height(10.dp))
                Text(text = "Click on the above Buttons" , color = Color.White, fontSize = 20.sp , fontWeight = FontWeight.Bold)
            }
        }
    }
}
//button function
@Composable
fun GradientButton(text: String, images:String,navController: NavController,page:String) {
    Button(
        onClick = { navController.navigate(page) },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(160.dp)
            .clip(RoundedCornerShape(18.dp)),
        colors = ButtonDefaults.buttonColors(
            contentColorFor(backgroundColor = Color(0xFF36D1DC))
        ),
        border = BorderStroke(6.dp, Color.Blue),
    ) {
        Column(modifier = Modifier
//            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = text, color = Color.White, fontSize = 25.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = rememberImagePainter(data = images),
                contentDescription = null, modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)).height(100.dp),
                contentScale = ContentScale.Crop)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CSETech_ProTheme {
//            Resources()
    }
}
//package com.example.csetech_pro
//
//import androidx.compose.foundation.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberImagePainter
//
//@Composable
//fun InternType() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Internships", color = Color.White)
//                },
//                backgroundColor = Color(0xFF2F80ED)
//            )
//        }
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(brush = Brush.linearGradient(colors = listOf(Color(0xFFFFF200),
//                    Color(0xFF6A11CB), Color(0xFF36D1DC)), start = Offset(100f, 100f),
//                    end = Offset(1500f, 1500f))),
//
//            ) {
//            Column(modifier = Modifier
//                .padding(16.dp)
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState()),
//                verticalArrangement = Arrangement.spacedBy(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally) {
////                #buttons
//                Spacer(modifier = Modifier
//                    .height(20.dp)
//                    .padding(10.dp))
//                GradientButton(
//                    text = "Internship Platforms ",
//                    images = "https://image.slidesharecdn.com/internshipportalomaad-180513062700/85/Internship-portal-UML-1-320.jpg"
//                )
//                Spacer(modifier = Modifier
//                    .height(20.dp)
//                    .padding(10.dp))
//                GradientButton(
//                    text = "Government Internships",
//                    images = "https://img.jagranjosh.com/images/2021/August/2082021/govt-internship-2021.jpg"
//                )
//                Spacer(modifier = Modifier
//                    .height(20.dp)
//                    .padding(10.dp))
//                GradientButton(
//                    text = "Internship Providing Companies",
//                    images = "https://content.wisestep.com/wp-content/uploads/2018/12/Internship-Opportunities.jpg" )
//                Spacer(modifier =Modifier.height(10.dp))
//                Text(text = "Click on the above Buttons" , color = Color.White, fontSize = 20.sp , fontWeight = FontWeight.Bold)
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Preview2(){
//    InternType()
//}
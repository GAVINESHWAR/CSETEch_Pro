package com.example.csetech_pro

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun College(navController: NavController){
    val context = LocalContext.current

    var expand1 by remember { mutableStateOf(false) }
    var expand2 by remember {
        mutableStateOf(false)
    }
    var expand3 by remember {
        mutableStateOf(false)
    }
    var expand4 by remember {
        mutableStateOf(false)
    }
    var year by remember{ mutableStateOf(year1[0]) }
    var sem by remember {
        mutableStateOf(sem1[0])
    }
    var option by remember{ mutableStateOf(options[0]) }
    var subject by remember {
        mutableStateOf(subject11[0])
    }

//    sem question papers pdfs
    val sem11 = listOf("")
    val sem12 = listOf("")
    val sem21 = listOf("")
    val sem22 = listOf("")
    val sem31 = listOf("")
    val sem32 = listOf("")
    val sem41 = listOf("")

//    base on the year and sem values changing

    val count = listOf("1", "2", "3", "4", "5","6","7","8")

//    First sem First year pdfs Links:
    val LAC = listOf("")

    val AP = listOf("https://drive.google.com/file/d/1b2UaZApn5NXZCldJ6g1hZ1jsXU5_Pv34/view?usp=sharing",
        "https://drive.google.com/file/d/1BtCvTzH5Aq9euwAgoytiihlln_uZRGtS/view?usp=sharing",
        "https://drive.google.com/file/d/1y-mMwdgvAFTqDpVWckLKRkegJ1ImmTSM/view?usp=sharing",
        "https://drive.google.com/file/d/1oU3k8kj4D5EenwB7NjOsp3W3fPOjRnKo/view?usp=sharing",
        "https://drive.google.com/file/d/1icWGJGj2dMzaP8BKj8kElIPjiIfYQijS/view?usp=sharing")

    val CE = listOf("https://drive.google.com/file/d/1mlIt6RhdztaE2PVZXL9VxRuKIABqLREc/view?usp=sharing")

    val PSCP = listOf("https://drive.google.com/file/d/1Mf4t_vdGsupnwM1yvnEy31LVOy2ws-V6/view?usp=sharing")

    val ED = listOf("https://drive.google.com/file/d/1mTUpa3mwq8vXX47Eh6GMwSIDyZPysFVn/view?usp=sharing",
        "https://drive.google.com/file/d/1qNgkgzHFbJH9ZsRlEYPsTMosH09U2QAG/view?usp=sharing",
        "https://drive.google.com/file/d/180VKyWYHXNg5TTSIg4JRNbyYc7W-jhtZ/view?usp=sharing",
        "https://drive.google.com/file/d/1H4TT1oB5vl3LEOIQ2DRyATln0dT6I4rO/view?usp=sharing",
        "https://drive.google.com/file/d/1iG9GwKlK3LadkQcFbnuwU2tAxsE8CPn5/view?usp=sharing")

//  First Year Second Sem

    val DET=listOf("https://drive.google.com/file/d/1WkXq4uA1wy1z0o4U86_PYoxY_By34vpx/view?usp=sharing",
        "https://drive.google.com/file/d/16gdV2uVFpcrTO1WZbKMIfTfJLQI9gWin/view?usp=sharing",
        "https://drive.google.com/file/d/1a1zc8vSHPlJ8UtetaU5VTTN-9CkQuhCu/view?usp=sharing",
        "https://drive.google.com/file/d/1ZA9ymAnQCVsui3K98i5EJt_jDuuO-RRm/view?usp=sharing",
        "https://drive.google.com/file/d/1LHf5fHDl1hYAPWBZJTf3SxEP6E4SWRpR/view?usp=sharing")

    val chemistry =
        listOf("https://drive.google.com/file/d/11FSuhzrVhhEbJFzuwhstHvOy18knPIlM/view?usp=sharing",
            "https://drive.google.com/file/d/1Ne8_UxH1IXNDHSC3DGxAvPUi9ioncqFR/view?usp=sharing",
            "" +
                    "https://drive.google.com/file/d/1RpPuPgJ4ueTsHUhYxEv-Q89V4-aDZjIS/view?usp=sharing",
            "https://drive.google.com/file/d/1Ahl-HrcbfePaajpNXb3jqYZlCZxbO88P/view?usp=sharing",
            "https://drive.google.com/file/d/1Lq5JqOtjDPJV4kORlDgCabgxZrgbSZa3/view?usp=sharing")

    val PP = listOf("https://docs.google.com/presentation/d/1_1i8YpyEEYQTPtS8CIHYtrQiIG2JmuJJ/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1Vpz8GYqhkSe_x_KBQm3oOtGNv-zxk_kL/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true"
        ,"https://docs.google.com/presentation/d/1T7ZWrnQgQFZI9MVP0Yf1RU8HziTPICxY/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1f1ImeTTcZ3V1ddwJJFlGwWIeHW0LKLgT/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1-Jyh7qG0IRhE4CdMFfzdgIa3fi9q_p5T/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true")

    val BEE1 = listOf("https://drive.google.com/file/d/1BdiwIuvFM7q64dftkmtCw0k_uAd3uVPz/view?usp=sharing",
        "https://drive.google.com/file/d/1WG3uKxXHHUrapAoSqUD_wD03cYv5jHpF/view?usp=sharing",
        "https://drive.google.com/file/d/1JLjuQ_-kSGtNiFULyipOxcNr-aBAfZtb/view?usp=sharing")

    val BEE2 = listOf("https://drive.google.com/file/d/1Ua5HU7A9xUUFOvhd9Ei53vmIkG5_9Dey/view?usp=sharing",
        "https://drive.google.com/file/d/1gX-EieMnNfE7weScrLB4SYu1IJ3y6xtk/view?usp=sharing",
        "https://drive.google.com/file/d/1V9Fmpt0ROzLrfSOEGgaWV-Sqn7m9DAkB/view?usp=sharing")

    val ES = listOf("https://drive.google.com/file/d/1VEZjIfDU8eZYToJOi4ZkJWa2IvkLXJr_/view?usp=sharing",
        "https://docs.google.com/presentation/d/10zMByktIFjJrRrhOzqEqjc4xs_UFuqQD/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1qTBu038JoR4eR2dmfpvKpv1IYZhx6FCi/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true")

//    second year First sem

    val DMGT = listOf("https://drive.google.com/file/d/1m2dW2P40NHYBWbPdUQ-3NYhjagnjWNHn/view?usp=sharing",
        "https://drive.google.com/file/d/1jUJXXckroIw8hjSrTVdcT0B7EWSsObOt/view?usp=sharing",
        "https://drive.google.com/file/d/1r8UwivlabW_x-mZ3siRGv3f9XyaCx0SJ/view?usp=sharing",
        "https://drive.google.com/file/d/1MbE4l8hyc2m4zBqDvsQygxX0IMdCnDPe/view?usp=sharing",
        "https://drive.google.com/file/d/1s49SEdFFjdyStq7FDjaIQrr_Hxr7fp1g/view?usp=sharing")

    val linkofDlD =
        listOf("https://drive.google.com/file/d/1s8z1H-czNk1C3FOwL6Cl5RKSdiM-myZR/view?usp=sharing",
            "https://drive.google.com/file/d/1TzrktcntjvZu0Qyhlhka6I_4QrDXAAVy/view?usp=sharing",
            "https://drive.google.com/file/d/1upwtFKOJY9IilGI2jSuj8ukjK5kk2OJZ/view?usp=sharing",
            "https://drive.google.com/file/d/1GWnPlxyqjDlaRMYEdG90_dGGfc05COgQ/view?usp=sharing",
            "https://drive.google.com/file/d/1NW7DKDoQckjbCMgX-q1epit5B5V7TRwL/view?usp=sharing"
        )

    val OOPS = listOf("https://drive.google.com/file/d/1vh4m7-Nds5AhcOHlHyTGgT61d_NHdmp2/view?usp=sharing",
        "https://drive.google.com/file/d/1nnKomtS_Y9SimpItOgSEubG576AWDOIt/view?usp=sharing",
        "https://drive.google.com/file/d/1gVk722cmjqA6-iOHxC8P0T41XudUQJoz/view?usp=sharing",
        "https://drive.google.com/file/d/1-1AovnQYJ6WWIloBd148G3LEEqQJncBx/view?usp=sharing",
        "https://drive.google.com/file/d/1P8u0k9GGZFOvXFErb1iW4q0NwAby3hwW/view?usp=sharing",
        "https://drive.google.com/file/d/1Zjncav9jSx79AwOCvlyeqSTaAHGDp63-/view?usp=sharing")


    val MEFA = listOf("https://drive.google.com/file/d/1IpaOvPcP1D8FDEvpfZN0TdWrYROi2l5U/view?usp=sharing",
        "https://drive.google.com/file/d/1HbHbZ8S4e4t8NC4ZF1iLGR3qbxs41GNv/view?usp=sharing",
        "https://drive.google.com/file/d/1fiEpHeORNk8WaEd3YmZKzfGVaQqsp6tx/view?usp=sharing",
        "https://drive.google.com/file/d/1qVIO99-Z80VJbpeYh54_nJnZYkSg6PIt/view?usp=sharing",
        "https://drive.google.com/file/d/1tyqEJ114fD-4nznK056aA_QWT7SSub0h/view?usp=sharing")

    val UHV = listOf("https://drive.google.com/file/d/1VS8SnFYnYEsa7x4QpbYFyCcjNrVzgL3W/view?usp=sharing")

    val DS = listOf("https://docs.google.com/presentation/d/1CpEu-CG_vb08vTawC0u3n6y1sKGEWFm9/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/17ybc2aBSH5MWXiIUQCgO6QPZA7bDY7dB/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1ItUoIYTukb9Rp5l9Xlrl7PQWH7tM-eHT/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1Qu5_DR-wO-nNYgyrX6YU1ZyKK3ebG9JQ/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1LxIg76TvMacpV5w79VX12-R5aSapfuUp/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1swHFH88mzqAD6J8bHh0RAKC9ZItMLVJO/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true",
        "https://docs.google.com/presentation/d/1Wx2eg80acG3zaiTR53b1IEEeEP9_LQI9/edit?usp=sharing&ouid=104350276370516746185&rtpof=true&sd=true")


//    sencond year Second sem

    val PSM = listOf("https://drive.google.com/file/d/1jHicCjCBHf2Snq3HURXVXNpMIBs0EtYk/view?usp=sharing",
        "https://drive.google.com/file/d/1ujVZGcc3Es6fc5qeEc5w-VZ3u0mMvWo0/view?usp=sharing",
        "https://drive.google.com/file/d/15US3_2K_PVgXQchBaw_3uKCNmXosKwsS/view?usp=sharing",
        "https://drive.google.com/file/d/1h2H_eCdlJcoZeZP1Xx9b7c_sJl8gZxih/view?usp=sharing",
        "https://drive.google.com/file/d/1zVBudyiiGVYWvv-ighuH0PgXTTcmDJz9/view?usp=sharing")

    val OS = listOf("https://drive.google.com/file/d/1juwSYAzDILOQ_-XWfGqPT9qmGLqcMuZa/view?usp=sharing",
        "https://drive.google.com/file/d/1EKNGb-fqNP-DazkznL-zH0Njf4YgTBY7/view?usp=sharing",
        "https://drive.google.com/file/d/1fr08C234vHCRyBSgAT_8Vs9k-JhjwO6J/view?usp=sharing",
        "https://drive.google.com/file/d/13vSaSsDqgPLc237k0mzxl0RSGjJpepLZ/view?usp=sharing",
        "https://drive.google.com/file/d/1NOzK_CzA849T0LC5glFxN1kwH9ULRgiQ/view?usp=sharing")

    val SE = listOf("https://drive.google.com/file/d/1rYBdsPcCrmK8ii8eIdvXIEwA7bmD1gv0/view?usp=sharing",
        "https://drive.google.com/file/d/1PzZRnQqGkC2gMYv3psE-JwPM9MeXBnkA/view?usp=sharing",
        "https://drive.google.com/file/d/1zZZhZiIqMvOiAW5gaYAUy_ljpVioMb9q/view?usp=sharing",
        "https://drive.google.com/file/d/1zO8MdFnt7RH-DglHl5Q1KcPm3I7UIiLa/view?usp=sharing",
        "https://drive.google.com/file/d/1OdF5NaziUyv99DytHueo7kEpkE9r8J6v/view?usp=sharing")

    val DBMS = listOf("https://drive.google.com/file/d/1f2S_ho-cpf1cu5ysQONw9kt0s15O2EHD/view?usp=sharing",
        "https://drive.google.com/file/d/1P9XXGHK3yFqUmkuZM0W8G4BFpKFjNb6q/view?usp=sharing",
        "https://drive.google.com/file/d/1yJ_Pm8lrm8KdkuKjKseC-8MfJJ8kP9uo/view?usp=sharing",
        "https://drive.google.com/file/d/1hxc7VUiDzhNlxJdjRpSm2k4d81nv-NUi/view?usp=sharing")

    val CO= listOf("https://drive.google.com/file/d/1r3UFJrWO3PJk1CDAILoblYYxwoXsvJZL/view?usp=sharing")

//    Third Year First Sem

    val FLAT = listOf("",
        "https://drive.google.com/file/d/1wAjM4xjm2NXHMwB6eveBjHb_hmWKsb5Z/view?usp=sharing",
        "https://drive.google.com/file/d/1wAlbLGpshm1bcylUSvPwsECcIZoGKqRB/view?usp=sharing",
        "https://drive.google.com/file/d/1wC4ru4P4gTrwnXFBNEkz4AuJLZPN1xFo/view?usp=sharing",
        "https://drive.google.com/file/d/1wDLfdRMmuAOgRECYnWsDsF8H0E1kmJES/view?usp=sharing")
    val CN = listOf("https://drive.google.com/file/d/1pQ1ROohtCcOv0NsxuVDOTaPuagOaomrZ/view?usp=sharing",
        "https://drive.google.com/file/d/1aWqki6PlyglxoW-F-61MFfaCawoIChMj/view?usp=sharing",
        "https://drive.google.com/file/d/1hkkx03iozkhTW_w-ur9ZuzL51UNTNqOi/view?usp=sharing",
        "https://drive.google.com/file/d/1fO5qbReI8Dp5FHNai1XSKIN5OvWjJdbv/view?usp=sharing",
        "https://drive.google.com/file/d/1YBlTh7QdaiMve4rS5vTdwVCLzxFjxP9G/view?usp=sharing")
    val DAA = listOf("","","","https://drive.google.com/file/d/1HySs2CC3pQrwRdzj2gEDeoGNYhVP8_-w/view?usp=sharing",
        "https://drive.google.com/file/d/12bhS5imzw0uD0dgBOv42AybjPfGSQPjO/view?usp=sharing")
    val AI = listOf("https://drive.google.com/file/d/1IsVZqnRefvXPV5hnrzQR7LxYVCFbkqt2/view?usp=sharing",
        "https://drive.google.com/file/d/17eoyCateQ5-9yCpuGgQX-f4MbK-YlgKO/view?usp=sharing",
        "https://drive.google.com/file/d/1Hrz4Vjma0FsAs_G8T6UZ069ys6as59J9/view?usp=sharing",
        "https://drive.google.com/file/d/19kCfPHNcQvZZMo4QAHl0DCcPTzwSyhfi/view?usp=sharing",
        "https://drive.google.com/file/d/16N9KM9hjF3GDKOlKI5LPWmq1umclF9QQ/view?usp=sharing")
    val OE1 = listOf("")
    val IPR = listOf("")

// Third Year First Sem

    val CD = listOf("")
    val ML = listOf("")
    val CNS = listOf("")
    val PE2 =listOf("")
    val OE2 = listOf("")
    val IC = listOf("")
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "College Resources", color = Color.White)
                },
                backgroundColor = Color.Blue
            )
        }
    ) {
        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(colors = listOf(Color.Green,
                    Color.Yellow, Color.Blue), start = Offset(100f, 100f),
                    end = Offset(1500f, 1500f))),
        ){
//            Image(painter = rememberImagePainter(data = "https://img.freepik.com/free-vector/geometric-science-education-background-vector-gradient-blue-digital-remix_53876-125993.jpg"),
//                contentDescription = null, modifier = androidx.compose.ui.Modifier
//                    .fillMaxSize())
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()
                , verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Fill the Details",
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)
                Spacer(modifier = androidx.compose.ui.Modifier.height(46.dp))
                ExposedDropdownMenuBox(
                    expanded = expand1,
                    onExpandedChange = {
                        expand1 = !expand1
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = year,
                        onValueChange = { },
                        label = {
                            Text(text = "Year", color  = Color.Black)
                        },
                        modifier = androidx.compose.ui.Modifier.background(color = Color.White,
                            shape = MaterialTheme.shapes.medium)
                        ,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expand1
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expand1,
                        onDismissRequest = {
                            expand1 = false
                        }
                    ) {
                        year1.forEach { selectionOption ->
                            DropdownMenuItem(onClick = {
                                year = selectionOption
                                expand1 = false
                            }) {
                                Text(text = selectionOption , color = Color.Black)
                            }
                        }
                    }
                }
                Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
                ExposedDropdownMenuBox(
                    expanded = expand2,
                    onExpandedChange = {
                        expand2 = !expand2
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = sem,
                        onValueChange = { },
                        label = {
                            Text(text = "Semester", color  = Color.Black)
                        },
                        modifier = androidx.compose.ui.Modifier.background(color = Color.White,
                            shape = MaterialTheme.shapes.medium),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expand2
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expand2,
                        onDismissRequest = {
                            expand2 = false
                        }
                    ) {
                        sem1.forEach { selectionOption ->
                            DropdownMenuItem(onClick = {
                                sem = selectionOption
                                expand2 = false
                            }) {
                                Text(text = selectionOption, color = Color.Black)
                            }
                        }
                    }
                }
                Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
                ExposedDropdownMenuBox(
                    expanded = expand3,
                    onExpandedChange = {
                        expand3 = !expand3
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = option,
                        onValueChange = { },
                        label = {
                            Text(text = "Select ", color = Color.Black)
                        },
                        modifier = androidx.compose.ui.Modifier.background(color = Color.White,
                            shape = MaterialTheme.shapes.medium),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expand3
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expand3,
                        onDismissRequest = {
                            expand3 = false
                        }
                    ) {
                        options.forEach { selectionOption ->
                            DropdownMenuItem(onClick = {
                                option = selectionOption
                                expand3 = false
                            }) {
                                Text(text = selectionOption, color = Color.Black)
                            }
                        }
                    }
                }
                Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
                if (option.equals("Subjects")) {
                    ExposedDropdownMenuBox(
                        expanded = expand4,
                        onExpandedChange = {
                            expand4 = !expand4
                        }
                    ) {
                        TextField(
                            readOnly = true,
                            value = subject,
                            onValueChange = { },
                            label = {
                                Text(text = "Subject", color = Color.Black)
                            },
                            modifier = androidx.compose.ui.Modifier.background(color = Color.White,
                                shape = MaterialTheme.shapes.medium),
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(
                                    expanded = expand4
                                )
                            },
                            colors = ExposedDropdownMenuDefaults.textFieldColors()
                        )
                        ExposedDropdownMenu(
                            expanded = expand4,
                            onDismissRequest = {
                                expand4 = false
                            }
                        ) {
//                            1-1 subjects
                            if((year=="1") and (sem =="1") and (option=="Subjects")) {
                                subject11.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }

//                            1-2 subjects
                            else if ((year=="1") and (sem =="2") and (option=="Subjects")){
                                subject12.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }
//                            2-1 subjects
                            else if ((year=="2") and (sem =="1") and (option=="Subjects")){
                                subject21.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }
//                            2-2 subjects
                            else if ((year=="2") and (sem =="2") and (option=="Subjects")){
                                subject22.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }
//                            3-1 subjects
                            else if ((year=="3") and (sem =="1") and (option=="Subjects")){
                                subject31.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }
                            else if ((year=="3") and (sem =="2") and (option=="Subjects")){
                                subject32.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption , color = Color.Black)
                                    }
                                }
                            }
                            else if ((year=="4") and (sem == "2") and (option=="Subjects")){
                                subject41.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        subject = selectionOption
                                        expand4 = false
                                    }) {
                                        Text(text = selectionOption, color = Color.Black)
                                    }
                                }
                            }
                        }

                    }
                }
//            Button(onClick = {
//                Toast.makeText(context," Submitted",Toast.LENGTH_SHORT).show()
////                if((year == "1") and (sem == "2") and (subject == "Chemistry") and (option == "Subjects")){
//////                    navController.navigate("files")
////
////                }
//            },
//            modifier = Modifier.background(Color.Blue)){
//                Text(text="Submit", color = Color.White, fontSize = 20.sp)
//            }
                Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
//                First Sem and first Year
                if ((year == "1") and (sem == "1") and (option == "Subjects") and (subject == "Linear Algebra and Calculus")) {
//                    navController.navigate("files")
//                    pdfs(subject, count, linkofDlD)
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                } else if((year == "1") and (sem == "1") and (option == "Subjects") and (subject == "Engineering drawing")){

                    pdfs(subject = subject, count = count, a = ED, 5)
                }
                else if((year == "1") and (sem == "1") and (option == "Subjects") and (subject == "English")){
                    pdfs(subject = subject, count = count, a = CE ,1)
                }
                else if((year == "1") and (sem == "1") and (option == "Subjects") and (subject == "Problem solving with c programing")){
                    pdfs(subject = subject, count = count, a = PSCP,1 )
                }
                else if((year == "1") and (sem == "1") and (option == "Subjects") and (subject == "Physics")){
                    pdfs(subject = subject, count = count, a = AP ,5)
                }
//                first year second Sem
                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Differential Equations and Calculus")){
                    pdfs(subject = subject, count = count, a = DET ,5)
                }
                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Python Programming")){
                    pdfs(subject = subject, count = count, a = PP ,5)
                }
                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Chemistry")){
                    pdfs(subject = subject, count = count, a = chemistry, 5)
                }
                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Electrical")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    pdfs(subject = subject, count = count, a = BEE1 ,3)

                }

                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Electronics")){
                    pdfs(subject = subject, count = count, a = BEE2 ,3)
                }
                else if((year == "1") and (sem == "2") and (option == "Subjects") and (subject == "Environmental Science")){
                    pdfs(subject = subject, count = count, a = ES ,3)
                }
//                second year First sem
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject =="Discrete mathematics and Graph Theory")){
                    pdfs(subject = subject, count = count, a = DMGT, 5)
                }
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject == "Digital Systems")){
                    pdfs(subject = subject, count = count, a = linkofDlD,5 )
                }
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject == "OOPS through Java")){
                    pdfs(subject = subject, count = count, a = OOPS ,5)
                }
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject == "Human Values")){
                    pdfs(subject = subject, count = count, a = UHV ,1)
                }
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject == "Managerial Economics Financial Analysis")){
                    pdfs(subject = subject, count = count, a = MEFA ,5)
                }
                else if((year == "2") and (sem == "1") and (option == "Subjects") and (subject == "Data Structures")){
                    pdfs(subject = subject, count = count, a = DS ,4)
                }
//                second year second sem

                else if((year == "2") and (sem == "2") and (option == "Subjects") and (subject == "Probability and statistical methods")){
                    pdfs(subject = subject, count = count, a = PSM ,5)
                }
                else if((year == "2") and (sem == "2") and (option == "Subjects") and (subject == "Database Management System")){
                    pdfs(subject = subject, count = count, a = DBMS ,5)
                }
                else if((year == "2") and (sem == "2") and (option == "Subjects") and (subject == "Computer Organization")){
                    pdfs(subject = subject, count = count, a = CO ,1)
                }
                else if((year == "2") and (sem == "2") and (option == "Subjects") and (subject == "Operating System")){
                    pdfs(subject = subject, count = count, a = OS ,5)
                }
                else if((year == "2") and (sem == "2") and (option == "Subjects") and (subject == "Software Engineering")){
                    pdfs(subject = subject, count = count, a = SE ,5)
                }

//                Third year first sem
//val subject31 = listOf("Design and Analysis of Algorithms","Computer Networks","Formal Language and Automata Theory","Open elective","Professional Elective","Intellectual property Rights")
                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Computer Networks")){
//                    pdfs(subject = subject, count = count, a = chemistry )
//                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
//                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                    pdfs(subject = subject, count = count, a = CN , 5)
                }

                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Design and Analysis of Algorithms")){
//                    pdfs(subject = subject, count = count, a = chemistry )
//                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
//                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                    pdfs(subject = subject, count = count, a = DAA, 5)
                }
                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Formal Language and Automation Theory")){
//                    pdfs(subject = subject, count = count, a = chemistry )
//                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
//                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                    pdfs(subject = subject, count = count, a = FLAT, 5)
                }
                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Open elective")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Professional Elective")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "1") and (option == "Subjects") and (subject == "Intellectual property Rights")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
//                Third Year Second Sem

                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Compiler Design")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Machine Learning")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Cryptography and Network Security")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Indian Constitution")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Full Stack Development")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Open Elective")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "3") and (sem == "2") and (option == "Subjects") and (subject == "Professional Elective")){
//                    pdfs(subject = subject, count = count, a = chemistry )
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }

//               Fourth year I sem

                else if((year == "4") and (sem=="1") and (option=="Subjects") and (subject=="Open Elective-I")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height((30.dp)))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "4") and (sem=="1") and (option == "Subjects") and (subject == "Open Elective-II")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height((30.dp)))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "4") and (sem == "1") and (option == "Subjects") and (subject=="Agile Methodologies")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year == "4") and (sem =="1") and (option == "Subjects") and (subject == "Professional elective-II")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }

//                previous year Question paper

                else if((year=="1") and (sem=="1") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year=="1") and (sem=="2") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year=="2") and (sem=="1") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year=="2") and (sem=="2") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year=="3") and (sem=="1") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else if((year=="3") and (sem=="2") and (option=="Previous Year Question Paper")){
                    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Green)
                }
                else{
                    Text(text="The Pdfs will be available soon", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun pdfs(subject:String,count:List<String>,a:List<String>,num:Int){
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
//    Temporary values
    Text(text = subject,
        fontSize = 25.sp,
        color = Color.Green,
        fontWeight = FontWeight.Bold)
    Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
    LazyVerticalGrid(
        cells = GridCells.Fixed(num), modifier = androidx.compose.ui.Modifier
            .padding(3.dp)
    ) {
        items(a.size) {
            Card(onClick = {

                coroutineScope.launch {
                    uriHandler.openUri(Uri.parse(a[it]).toString())
                }
            },
                modifier = androidx.compose.ui.Modifier
                    .padding(8.dp)
                    .background(Color.Yellow)
                    .size(160.dp)
                    .clickable { /**/ },
                elevation = 20.dp, backgroundColor = Color.Green) {
                Column(
                    modifier = androidx.compose.ui.Modifier.padding(2.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(data = "https://t3.ftcdn.net/jpg/04/17/28/20/360_F_417282083_X0pybvfs7bqvoNjDOjM3iDklGJ3lTU4q.jpg"),
                        contentDescription = "Pdf section",
                        modifier = androidx.compose.ui.Modifier
                            .height(60.dp)
                            .width(100.dp)
                            .padding(5.dp)
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                    if(subject=="Electrical"){

                    }
                    Text("  " + count[it] + "  Unit ",
                        fontSize = 20.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold)
                    Text("Click to See Pdf ",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
    Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
    Text(text ="")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Screen5(){
//    College()
}
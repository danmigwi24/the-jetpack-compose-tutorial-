package com.dk.learningjetpackcompse


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dk.learningjetpackcompse.ui.theme.LearningJetpackCompseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackCompseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#fffff"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.None,
            modifier = Modifier.height(150.dp)
        )

        Text(
            text = "Welcome to DK",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
    }
}
@Composable
fun TextFieldSView() {

    var user by remember {
        mutableStateOf("dkimani")
    }



    //val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
    TextField(
        value = user,
        onValueChange = { text ->
            user = text
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(
                start = 64.dp,
                end = 64.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .border(
                width = 1.dp,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                shape = RoundedCornerShape(50)
            ),
        shape = RoundedCornerShape(50),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            color = Color(android.graphics.Color.parseColor("#7d32a8")),
            fontSize = 14.sp
        ),
        colors = TextFieldDefaults.colors(
            //focusedContainerColor = containerColor,
            //unfocusedContainerColor = containerColor,
            //disabledContainerColor = containerColor,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
        )

    )
}

@Composable
fun PassTextFieldSView() {
    var pass by remember {
        mutableStateOf("dkimani")
    }

    val passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }

    //val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
    TextField(
        value = pass,
        onValueChange = { text ->
            pass = text
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(
                start = 64.dp,
                end = 64.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .border(
                width = 1.dp,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                shape = RoundedCornerShape(50)
            ),
        shape = RoundedCornerShape(50),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            color = Color(android.graphics.Color.parseColor("#7d32a8")),
            fontSize = 14.sp
        ),
        colors = TextFieldDefaults.colors(
            //focusedContainerColor = containerColor,
            //unfocusedContainerColor = containerColor,
            //disabledContainerColor = containerColor,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),


        )
}


@Composable
fun ButtonView() {
    Button(onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(
                start = 64.dp,
                end = 64.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(android.graphics.Color.parseColor("#7d32a8"))
        ),
        shape = RoundedCornerShape(55)
    ) {
        Text(
            text = "Login",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun DoRememberPassword() {
    Text(
        text = "Don't remember password? click here",
        color = Color(android.graphics.Color.parseColor("#7d32a8")),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        //fontWeight = FontWeight.Bold
    )
}


@Composable
fun LoginBySocialMedia() {
    Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = R.drawable.google), contentDescription = "" , modifier = Modifier.padding(top = 8.dp))
        Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "" , modifier = Modifier.padding(top = 8.dp))
        Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "" , modifier = Modifier.padding(top = 8.dp))
    }
}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LearningJetpackCompseTheme {
//        //Greeting("Android")
//      Login()
//        Column {
//            TextFieldSView()
//            PassTextFieldSView()
//            ButtonView()
//            DoRememberPassword()
//            LoginBySocialMedia()
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LearningJetpackCompseTheme {
        Login()

    }
}
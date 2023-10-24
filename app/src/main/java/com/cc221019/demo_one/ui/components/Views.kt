package com.cc221019.demo_one.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cc221019.demo_one.R

@Composable
fun displayValues(name: String? = null, uid:String? = null){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = name ?: "No name was sent")
        Text(text = uid ?: "No UID was sent")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen(onClick: (String, String) -> Unit){
    var name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var uid by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "DEMO I", fontSize = 50.sp)
        Image(
            painter = painterResource(id =
            R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Box"
        )
        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            value = name,
            onValueChange = {
                    newText -> name = newText
            },
            label = { Text(text = "Name") }
        )
        TextField(
            modifier = Modifier.padding(top = 20.dp),
            value = uid,
            onValueChange = {
                    newText -> uid = newText
            },
            label = { Text(text = "UID") }
        )
        Button(
            onClick = { onClick(name.text.toString(), uid.text.toString())
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(text = "Send", fontSize = 20.sp)
        }
    }
}
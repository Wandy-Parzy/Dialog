package com.example.dialogocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dialogocompose.ui.theme.DialogoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by rememberSaveable { mutableStateOf(false) }

                    Box(modifier = Modifier.fillMaxSize()) {
                        Button(onClick = { show = true }) {
                            Text(text = "Dialogo")

                        }
                    }
                    MyDialog(show, { show = false }, {Log.i("wandy", "clik")})

                }
            }
        }
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {

        AlertDialog(onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Dialogo") },
            text = { Text(text = "Bienvenido, esto es un dialogo") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogoComposeTheme {


    }
}
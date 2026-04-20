package com.example.practica4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Tema de Material 3 por defecto
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ModernGreetingApp()
                }
            }
        }
    }
}

@Composable
fun ModernGreetingApp() {
    // Manejo de estado con remember y mutableStateOf
    var nameInput by remember { mutableStateOf("") }
    var displayMessage by remember { mutableStateOf("Ingresa tu información para comenzar") }

    // Column para alineación vertical simple y limpia
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Componente 1: Image (Usando un vector de la librería estándar para mantenerlo ligero)
        Image(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Avatar de usuario",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 24.dp),
            contentScale = ContentScale.Fit,
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )

        // Componente 2: Text (Dinámico, cambia según el estado)
        Text(
            text = displayMessage,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Componente 3: TextField (Interactivo 1)
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Nombre del desarrollador") },
            placeholder = { Text("Ej. Harry Bodan") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Componente 4: Button (Interactivo 2)
        Button(
            onClick = {
                // Lógica de interactividad
                displayMessage = if (nameInput.isNotBlank()) {
                    "¡Sistema inicializado!\nBienvenido, $nameInput."
                } else {
                    "Error: El campo no puede estar vacío."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp), // Botón alto para mejor usabilidad en pantallas táctiles
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Ejecutar Acción",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
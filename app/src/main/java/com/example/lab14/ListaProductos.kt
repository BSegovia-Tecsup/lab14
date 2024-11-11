package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab14.ui.theme.Lab14Theme

class ListaProductos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab14Theme {
                ProductosListScreen()
            }
        }
    }
}

@Composable
fun ProductosListScreen() {
    val productos = listOf("Procesador", "Tarjeta Madre", "Memoria RAM", "SSD", "Fuente de Poder", "Gabinete")
    LazyColumn {
        items(productos) { producto ->
            Text(text = producto)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductosListScreenPreview() {
    ProductosListScreen()
}

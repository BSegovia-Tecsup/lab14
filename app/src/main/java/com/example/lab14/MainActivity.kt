package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab14.ui.theme.Lab14Theme

data class Producto(
    val nombre: String,
    val precio: String,
    val descripcion: String,
    val imagenResId: Int // ID del recurso de la imagen
)

// Actualizamos la lista de productos con los IDs correctos de tus imágenes
val productos = listOf(
    Producto("Celular Modelo 1", "$100", "Descripción del celular modelo 1", R.drawable.celular_modelo_1),
    Producto("Celular Modelo 2", "$200", "Descripción del celular modelo 2", R.drawable.celular_modelo_2),
    Producto("Celular Modelo 3", "$300", "Descripción del celular modelo 3", R.drawable.celular_modelo_3),
    Producto("Celular Modelo 4", "$400", "Descripción del celular modelo 4", R.drawable.celular_modelo_4),
    Producto("Celular Modelo 5", "$500", "Descripción del celular modelo 5", R.drawable.celular_modelo_5),
    Producto("Celular Modelo 6", "$600", "Descripción del celular modelo 6", R.drawable.celular_modelo_6),
    Producto("Celular Modelo 7", "$700", "Descripción del celular modelo 7", R.drawable.celular_modelo_7),
    Producto("Celular Modelo 8", "$800", "Descripción del celular modelo 8", R.drawable.celular_modelo_8),
    Producto("Celular Modelo 9", "$900", "Descripción del celular modelo 9", R.drawable.celular_modelo_9),
    Producto("Celular Modelo 10", "$1000", "Descripción del celular modelo 10", R.drawable.celular_modelo_10),
    Producto("Celular Modelo 11", "$1100", "Descripción del celular modelo 11", R.drawable.celular_modelo_11),
    Producto("Celular Modelo 12", "$1200", "Descripción del celular modelo 12", R.drawable.celular_modelo_12)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProductList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(productos) { producto ->
            ProductCard(producto = producto)
        }
    }
}

@Composable
fun ProductCard(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = producto.imagenResId),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Precio: ${producto.precio}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = producto.descripcion,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    Lab14Theme {
        ProductList()
    }
}

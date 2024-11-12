package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab14.ui.theme.Lab14Theme

data class ProductoEstado(
    val nombre: String,
    val precio: String,
    val descripcion: String,
    val imagenResId: Int // ID del recurso de la imagen
)

class ListaProductosEstado : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab14Theme {
                PedidoScreen(
                    producto = ProductoEstado(
                        nombre = "Celular Modelo 1",
                        precio = "$1000",
                        descripcion = "Descripción del celular modelo 1",
                        imagenResId = R.drawable.celular_modelo_9
                    )
                )
            }
        }
    }
}

@Composable
fun PedidoScreen(producto: ProductoEstado) {
    var estado by remember { mutableStateOf(0f) } // El estado inicial es 0 (Proceso)
    val estados = listOf("Proceso", "En camino", "Duanas", "En casa")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Estado del Pedido", style = MaterialTheme.typography.headlineSmall)

        // Mostrar la imagen del producto
        Image(
            painter = painterResource(id = producto.imagenResId),
            contentDescription = producto.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 8.dp)
        )

        // Mostrar los detalles del producto
        Text(text = "Producto: ${producto.nombre}")
        Text(text = "Precio: ${producto.precio}")
        Text(text = "Descripción: ${producto.descripcion}")

        // Barra de progreso deslizante (Slider)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Slider(
                value = estado,
                onValueChange = { estado = it },
                valueRange = 0f..3f, // La barra tiene 4 estados: 0, 1, 2, 3
                steps = 3, // 3 pasos entre los valores
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            // Mostrar el nombre del estado actual
            Text(text = estados[estado.toInt()])
        }

        // Muestra el estado actual del pedido
        ClickableText(
            text = AnnotatedString("Estado actual: ${estados[estado.toInt()]}"),
            onClick = {
                // Aquí puedes agregar la funcionalidad adicional si es necesario
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PedidoScreenPreview() {
    Lab14Theme {
        PedidoScreen(
            producto = ProductoEstado(
                nombre = "Celular Modelo 1",
                precio = "$1000",
                descripcion = "Descripción del celular modelo 1",
                imagenResId = R.drawable.celular_modelo_1 // Asegúrate de tener la imagen en la carpeta drawable
            )
        )
    }
}

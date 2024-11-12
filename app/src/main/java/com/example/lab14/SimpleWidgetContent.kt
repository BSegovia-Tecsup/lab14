package com.example.lab14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A dónde quieres dirigirte?",
                modifier = GlanceModifier.padding(16.dp)
            )
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(top = 16.dp)
            ) {
                Button(
                    text = "Página Principal",
                    onClick = actionStartActivity<MainActivity>()
                )
            }
            Row(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = GlanceModifier.padding(top = 8.dp)
            ) {
                Button(
                    text = "Estado del Celular",
                    onClick = actionStartActivity<ListaProductosEstado>()
                )
            }
        }
    }
}


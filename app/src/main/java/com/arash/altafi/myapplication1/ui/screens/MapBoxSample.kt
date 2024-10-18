package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.rememberMapState
import com.arash.altafi.myapplication1.R
import com.mapbox.maps.plugin.gestures.OnMapClickListener

@Composable
fun MapBoxSample() {
    val state = rememberMapState()

    MapboxMap(
        Modifier.fillMaxSize(),
        mapViewportState = rememberMapViewportState {
            setCameraOptions {
                zoom(12.0)
                center(Point.fromLngLat(51.39117511536297, 35.70098549131432))
                pitch(0.0)
                bearing(0.0)
            }
        },
        mapState = state,
        logo = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Mapbox Logo"
            )
        },
    )
}
package com.example.meditation

import androidx.compose.ui.geometry.Offset
import kotlin.math.abs

fun androidx.compose.ui.graphics.Path.standarQuadFromTo(from: Offset, to:Offset){
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x)/2f,
        abs(from.y + to.y)/2f
    )
}
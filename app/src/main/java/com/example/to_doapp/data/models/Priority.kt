package com.example.to_doapp.data.models

import androidx.compose.ui.graphics.Color
import com.example.to_doapp.ui.theme.highPriorityColor
import com.example.to_doapp.ui.theme.lowPriorityColor
import com.example.to_doapp.ui.theme.mediumPriorityColor
import com.example.to_doapp.ui.theme.nonePriorityColor

enum class Priority(val color: Color) {
    HIGH(highPriorityColor),
    MEDIUM(mediumPriorityColor),
    LOW(lowPriorityColor),
    NONE(nonePriorityColor)
}
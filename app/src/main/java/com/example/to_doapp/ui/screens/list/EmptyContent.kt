package com.example.to_doapp.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_doapp.R
import com.example.to_doapp.ui.theme.MediumGrey

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Icon(
            modifier = Modifier
                .size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(R.string.sad_face_string),
            tint = MediumGrey
        )
        Text(
            text = stringResource(id = R.string.no_tasks_found),
            color = MediumGrey,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )

    }
}

@Composable
@Preview
fun EmptyContentPreview() {
    EmptyContent()
}
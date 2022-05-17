package com.example.to_doapp.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_doapp.R
import com.example.to_doapp.components.DisplayAlertDialog
import com.example.to_doapp.data.models.Priority
import com.example.to_doapp.data.models.ToDoTask
import com.example.to_doapp.ui.theme.toAppBarBackgroundColor
import com.example.to_doapp.ui.theme.toAppBarContentColor
import com.example.to_doapp.util.Action

@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colors.toAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.toAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colors.toAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.toAppBarBackgroundColor,
        actions = {
            ExistingTaskAppBarActions(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen )
        }
    )
}

@Composable
fun ExistingTaskAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    var openDialog by remember {
        mutableStateOf(false)
    }
    DisplayAlertDialog(
        title = stringResource(
            id = R.string.delete_task,
            selectedTask.title
        ),
        message = stringResource(
            id = R.string.delete_task_confirmation,
            selectedTask.title
        ),
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { navigateToListScreen(Action.DELETE)}
    )
    DeleteAction(onDeleteClicked = { openDialog = true })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow",
            tint = MaterialTheme.colors.toAppBarContentColor
        )
    }
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_icon),
            tint = MaterialTheme.colors.toAppBarContentColor
        )
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: () -> Unit
) {
    IconButton(onClick = { onDeleteClicked() }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = MaterialTheme.colors.toAppBarContentColor
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = stringResource(id = R.string.update_icon),
            tint = MaterialTheme.colors.toAppBarContentColor
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Add Task",
            tint = MaterialTheme.colors.toAppBarContentColor
        )
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview() {
    NewTaskAppBar(navigateToListScreen = {})
}

@Composable
@Preview
fun ExistingTaskAppBarPreview() {
    ExistingTaskAppBar(
        selectedTask =
        ToDoTask(
            id = 0,
            title = "Mostafa Gamal",
            description = "Great and in demand android developer isa",
            priority = Priority.HIGH
        ),
        navigateToListScreen = {}
    )
}
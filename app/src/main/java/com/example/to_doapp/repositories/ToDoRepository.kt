package com.example.to_doapp.repositories

import com.example.to_doapp.data.ToDoDao
import com.example.to_doapp.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import okhttp3.internal.concurrent.Task
import okhttp3.internal.concurrent.TaskQueue
import java.nio.channels.FileLock
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    val allTasks: Flow<List<ToDoTask>> = toDoDao.getALlTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(id: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = id)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchTask(query: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(query = query)
    }
}
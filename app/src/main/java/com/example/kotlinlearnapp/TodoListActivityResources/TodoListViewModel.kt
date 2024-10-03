package com.example.kotlinlearnapp.TodoListActivityResources

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.util.Date

class TodoListViewModel(private val taskDao: TaskDao) : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    fun getTasksSortedByName() {
        viewModelScope.launch {
            _tasks.postValue(taskDao.getTasksSortedByName())
        }
    }

    fun getTasksSortedByDeadline() {
        viewModelScope.launch {
            _tasks.postValue(taskDao.getTasksSortedByDeadline())
        }
    }

    fun getTasksSortedByUpdateDate() {
        viewModelScope.launch {
            _tasks.postValue(taskDao.getTasksSortedByUpdateDate())
        }
    }

    fun addTask(name: String, deadline: Date?) {
        if (name.isBlank() || deadline == null || deadline.before(Date())) {
            return
        }
        viewModelScope.launch {
            taskDao.insertTask(Task(name = name, deadline = deadline))
            _tasks.postValue(taskDao.getTasksSortedByUpdateDate()) // Fetch updated tasks
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            taskDao.deleteTask(taskId)
            _tasks.postValue(taskDao.getTasksSortedByUpdateDate()) // Update tasks after deletion
        }
    }
}

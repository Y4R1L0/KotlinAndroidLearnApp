package com.example.kotlinlearnapp

import TaskAdapter
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kotlinlearnapp.TodoListActivityResources.TaskDatabase
import com.example.kotlinlearnapp.TodoListActivityResources.TodoListViewModel
import com.example.kotlinlearnapp.TodoListActivityResources.TodoListViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class TodoListActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter
    private val viewModel: TodoListViewModel by viewModels {
        val db = Room.databaseBuilder(applicationContext, TaskDatabase::class.java, "task-db").build()
        TodoListViewModelFactory(db.taskDao())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        taskAdapter = TaskAdapter(this)
        val taskListView = findViewById<ListView>(R.id.TaskListView)
        taskListView.adapter = taskAdapter

        taskListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val task = taskAdapter.getItem(position)
            viewModel.deleteTask(task.id)
            Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.sortByNameBtn).setOnClickListener {
            viewModel.getTasksSortedByName()
        }

        findViewById<Button>(R.id.sortByDeadlineBtn).setOnClickListener {
            viewModel.getTasksSortedByDeadline()
        }

        findViewById<Button>(R.id.sortByUpdateDateBtn).setOnClickListener {
            viewModel.getTasksSortedByUpdateDate()
        }

        findViewById<Button>(R.id.AddListBtn).setOnClickListener {
            val taskName = findViewById<EditText>(R.id.TxtTaskInsert).text.toString()
            val deadlineString = findViewById<EditText>(R.id.TxtDeadlineInsert).text.toString()
            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

            val deadline = try {
                sdf.parse(deadlineString)
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid deadline format", Toast.LENGTH_SHORT).show()
                null
            }

            if (deadline == null || deadline.before(Date())) {
                Toast.makeText(this, "Deadline is invalid or in the past", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addTask(taskName, deadline)
            }
        }

        viewModel.tasks.observe(this, androidx.lifecycle.Observer { tasks ->
            taskAdapter.updateTasks(tasks)
        })
    }
}

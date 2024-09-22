package com.example.kotlinlearnapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TodoListActivity : AppCompatActivity() {

    private lateinit var insTask : EditText
    private lateinit var addTaskBtn : Button
    private lateinit var tasklistView : ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_list)

        insTask=findViewById(R.id.TxtTaskInsert)
        addTaskBtn=findViewById(R.id.AddListBtn)
        tasklistView=findViewById(R.id.TaskListView)


        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        tasklistView.adapter = adapter

        tasklistView.setOnItemClickListener { _, _, i, _ ->
            val text = tasklistView.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this, "You deleted a task:$text",Toast.LENGTH_LONG).show()
        }

        addTaskBtn.setOnClickListener {
            var text = insTask.text.toString().trim()
            if (text.isNotEmpty()) {
                adapter.insert(text, 0)
                insTask.text.clear()
            }


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
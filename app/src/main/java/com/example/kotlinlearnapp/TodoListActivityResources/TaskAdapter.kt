import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.kotlinlearnapp.TodoListActivityResources.Task
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(private val context: Context) : BaseAdapter() {

    private var tasks: List<Task> = listOf()
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }

    override fun getCount(): Int = tasks.size

    override fun getItem(position: Int): Task = tasks[position]

    override fun getItemId(position: Int): Long = tasks[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val task = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)

        val taskNameTextView = view.findViewById<TextView>(android.R.id.text1)
        val taskDeadlineTextView = view.findViewById<TextView>(android.R.id.text2)

        taskNameTextView.text = task.name
        taskDeadlineTextView.text = task.deadline?.let { dateFormat.format(it) } ?: "No deadline"

        if (task.deadline?.before(Date()) == true) {
            view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
        } else {
            view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
        }

        return view
    }
}

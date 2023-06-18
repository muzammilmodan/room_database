package com.trootechdemo.roomdb.feature

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trootechdemo.R
import com.trootechdemo.roomdb.model.UserDetailsRoom

class UserListAdapter(private val mCtx: Context, taskList: List<UserDetailsRoom?>) :
    RecyclerView.Adapter<UserListAdapter.TasksViewHolder>() {
    private val taskList: List<UserDetailsRoom?>

    init {
        this.taskList = taskList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view: View =
            LayoutInflater.from(mCtx).inflate(R.layout.row_user_details_room, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val t: UserDetailsRoom = taskList[position]!!
        holder.textViewTask.text = t.user_name
        holder.textViewDesc.text = t.user_phone
        holder.textViewFinishBy.text = t.user_email
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var textViewStatus: TextView
        var textViewTask: TextView
        var textViewDesc: TextView
        var textViewFinishBy: TextView

        init {
            textViewStatus = itemView.findViewById<TextView>(R.id.textViewStatus)
            textViewTask = itemView.findViewById<TextView>(R.id.textViewTask)
            textViewDesc = itemView.findViewById<TextView>(R.id.textViewDesc)
            textViewFinishBy = itemView.findViewById<TextView>(R.id.textViewFinishBy)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val task: UserDetailsRoom = taskList[getAdapterPosition()]!!
            val intent = Intent(mCtx, UpdateTaskActivity::class.java)
            intent.putExtra("userDetails", task)
            mCtx.startActivity(intent)
        }
    }
}
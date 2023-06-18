package com.trootechdemo.roomdb.feature

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.trootechdemo.R
import com.trootechdemo.roomdb.database.DatabaseClient
import com.trootechdemo.roomdb.feature.AddUserRoomActivity
import com.trootechdemo.roomdb.model.UserDetailsRoom

class UserListRoomActivity : AppCompatActivity() {
    private var buttonAddTask: FloatingActionButton? = null
    private var recyclerView: RecyclerView? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list__room)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview_tasks)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        buttonAddTask = findViewById<FloatingActionButton>(R.id.fltAddUser)
        buttonAddTask?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@UserListRoomActivity, AddUserRoomActivity::class.java)
            startActivity(intent)
        })
        tasks
    }

    private val tasks: Unit
        get() {
            class GetTasks : AsyncTask<Void?, Void?, List<UserDetailsRoom?>>() {
                protected override fun doInBackground(vararg voids: Void?): List<UserDetailsRoom?> {
                    return DatabaseClient.getInstance(applicationContext)?.appDatabase?.taskDao()!!.all!!
                }

                protected override fun onPostExecute(tasks: List<UserDetailsRoom?>) {
                    super.onPostExecute(tasks)
                    if (tasks.isNotEmpty()) {
                        val adapter = UserListAdapter(this@UserListRoomActivity, tasks)
                        recyclerView?.setAdapter(adapter)
                    } else {
                        Toast.makeText(
                            this@UserListRoomActivity,
                            "No Data Found.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            val gt = GetTasks()
            gt.execute()
        }
}
package com.trootechdemo.roomdb.feature

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.trootechdemo.R
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trootechdemo.roomdb.database.DatabaseClient
import com.trootechdemo.roomdb.model.UserDetailsRoom


class UpdateTaskActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtPhone: EditText? = null
    private var edtEmail: EditText? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_task)
        edtName = findViewById<EditText>(R.id.editTextTask)
        edtPhone = findViewById<EditText>(R.id.editTextDesc)
        edtEmail = findViewById<EditText>(R.id.editTextFinishBy)
        val task: UserDetailsRoom =
            getIntent().getSerializableExtra("userDetails") as UserDetailsRoom
        loadTask(task)
        findViewById<View>(R.id.button_update).setOnClickListener(View.OnClickListener {
            Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show()
            updateTask(task)
        })
        findViewById<View>(R.id.button_delete).setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this@UpdateTaskActivity)
            builder.setTitle("Are you sure?")
            builder.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialogInterface: DialogInterface, i: Int) {
                    deleteTask(task)
                }
            })
            builder.setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialogInterface: DialogInterface, i: Int) {}
            })
            val ad = builder.create()
            ad.show()
        })
    }

    private fun loadTask(task: UserDetailsRoom) {
        edtName?.setText(task.user_name)
        edtPhone?.setText(task.user_phone)
        edtEmail?.setText(task.user_email)
        //checkBoxFinished.setChecked(task.isFinished());
    }

    private fun updateTask(task: UserDetailsRoom) {
        val sTask: String = edtName?.getText().toString().trim { it <= ' ' }
        val sDesc: String = edtPhone?.getText().toString().trim { it <= ' ' }
        val sFinishBy: String = edtEmail?.getText().toString().trim { it <= ' ' }
        if (sTask.isEmpty()) {
            edtName?.setError("Enter Name")
            edtName?.requestFocus()
            return
        }
        if (sDesc.isEmpty()) {
            edtPhone?.setError("Enter Phone")
            edtPhone?.requestFocus()
            return
        }
        if (sFinishBy.isEmpty()) {
            edtEmail?.setError("Enter Email")
            edtEmail?.requestFocus()
            return
        }
        class UpdateTask : AsyncTask<Void?, Void?, Void?>() {
            protected override fun doInBackground(vararg voids: Void?): Void? {
                task.user_name=sTask
                task.user_phone=sDesc
                task.user_email=sFinishBy
                DatabaseClient.getInstance(getApplicationContext())!!.appDatabase
                    .taskDao()?.update(task)
                return null
            }

            protected override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this@UpdateTaskActivity, UserListRoomActivity::class.java))
            }
        }

        val ut = UpdateTask()
        ut.execute()
    }

    private fun deleteTask(task: UserDetailsRoom) {
        class DeleteTask : AsyncTask<Void?, Void?, Void?>() {
            protected override fun doInBackground(vararg voids: Void?): Void? {
                DatabaseClient.getInstance(applicationContext)!!.appDatabase
                    .taskDao()?.delete(task)
                return null
            }

            protected override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this@UpdateTaskActivity, UserListRoomActivity::class.java))
            }
        }

        val dt = DeleteTask()
        dt.execute()
    }
}
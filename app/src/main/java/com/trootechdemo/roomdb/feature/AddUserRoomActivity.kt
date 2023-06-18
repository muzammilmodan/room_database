package com.trootechdemo.roomdb.feature

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trootechdemo.R
import com.trootechdemo.roomdb.database.DatabaseClient
import com.trootechdemo.roomdb.model.UserDetailsRoom

class AddUserRoomActivity : AppCompatActivity() {

    private var editTextTask: EditText? = null
    private var editTextDesc: EditText? = null
    private var editTextFinishBy: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user__room)
        editTextTask = findViewById<EditText>(R.id.editTextTask)
        editTextDesc = findViewById<EditText>(R.id.editTextDesc)
        editTextFinishBy = findViewById<EditText>(R.id.editTextFinishBy)
        findViewById<View>(R.id.button_save).setOnClickListener(View.OnClickListener { saveTask() })
    }

    private fun saveTask() {
        val sName: String = editTextTask?.text.toString().trim { it <= ' ' }
        val sPhone: String = editTextDesc?.text.toString().trim { it <= ' ' }
        val sEmail: String = editTextFinishBy?.text.toString().trim { it <= ' ' }
        if (sName.isEmpty()) {
            editTextTask?.error = "Name required"
            editTextTask?.requestFocus()
            return
        }
        if (sPhone.isEmpty()) {
            editTextDesc?.error = "Phone required"
            editTextDesc?.requestFocus()
            return
        }
        if (sEmail.isEmpty()) {
            editTextFinishBy?.error = "Email required"
            editTextFinishBy?.requestFocus()
            return
        }
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {
             @Deprecated("Deprecated in Java")
             override fun doInBackground(vararg voids: Void?): Void? {

                //creating a user
                val task = UserDetailsRoom()
                task.user_name=sName
                task.user_email =sEmail
                task.user_phone=sPhone

                //adding to database
                DatabaseClient.getInstance(applicationContext)!!.appDatabase.taskDao()!!.insert(task)
                return null
            }

            @Deprecated("Deprecated in Java")
            protected override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                finish()
                startActivity(Intent(applicationContext, UserListRoomActivity::class.java))
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
            }


        }

        val st = SaveTask()
        st.execute()
    }
}
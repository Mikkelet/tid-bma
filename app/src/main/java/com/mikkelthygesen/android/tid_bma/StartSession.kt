package com.mikkelthygesen.android.blockmyapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

import kotlinx.android.synthetic.main.activity_start_session.*

class StartSession : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_session)
        setSupportActionBar(toolbar)

        val spinnerProvider = findViewById<Spinner>(R.id.spinner_startsession_provider)
        val spinnerExercises = findViewById<Spinner>(R.id.spinner_startsession_exercises)

        ArrayAdapter.createFromResource(this,R.array.exercises_array,R.layout.support_simple_spinner_dropdown_item).also {
            arrayAdapter ->
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerProvider.adapter = arrayAdapter
            spinnerProvider.onItemSelectedListener = SpinnerActivity()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener{
    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        print(position)
        val choice = "$position"
        Snackbar.make(view, choice,Snackbar.LENGTH_SHORT).setAction("Action",null).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        print("You selected nothing!")
    }

}

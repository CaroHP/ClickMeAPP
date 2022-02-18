package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button


private val TAG = "MainActivity"
private val TEXT ="TEXT_CONTENT"

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) { //Bunlde:superclase todo lo que tiene que ver con el estado
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio)

        val userInput: EditText = findViewById<EditText>(R.id.editTextTextPersonName)
        val button: Button = findViewById<Button>(R.id.button4)
        val buttonborrar: Button = findViewById<Button>(R.id.button5)
        textView = findViewById<TextView>(R.id.textView2)

        textView?.text = ""
        textView?. movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.setText("")
            }
        })

        buttonborrar.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                textView?.text = ""
                userInput.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT, "")
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onPause")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())

    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}
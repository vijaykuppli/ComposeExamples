package com.vijaykuppli.android.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * This function to make transparent app bar.
         * Enable and run the app to check the output
         */
//        enableEdgeToEdge()

        /**
         * If you add simple text 1 by 1 it will overlap each other. In order to
         * show next to the previous view you have to use column or row.
         */
        setContent {
            Text(text = "Vijay santosh")
            Text(text = "Pavani")
            Text(text = "Jayansh Krishna")
        }
    }
}
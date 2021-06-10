package com.example.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        if (intent.action==Intent.ACTION_SEND){
            val monster=intent?.getStringExtra(Intent.EXTRA_TEXT)
            Log.i("Intents","You selected monster $monster")
            val monsterId=resources.getIdentifier(monster?.trim(),"drawable",packageName)
            imageView.setImageResource(monsterId)
            return
        }



        Log.i("Intents","Actions =${intent.action}")

        val lastPart=intent.data?.lastPathSegment
        if (lastPart!!.equals("view")) {
            val monsterId=intent.data?.getQueryParameter("id")
            Log.i("Intents","Query parameter =$monsterId")

            val extraId=intent.extras!!.getInt("monsterId")
            Log.i("Intents","Extra value=$extraId")

            imageView.setImageResource(extraId)

        }

    }
}
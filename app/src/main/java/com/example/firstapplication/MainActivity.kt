package com.example.firstapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        monster1.setOnClickListener { vieMonster(R.drawable.monster1) }
        monster3.setOnClickListener { vieMonster(R.drawable.monster3) }
        monster4.setOnClickListener { vieMonster(R.drawable.monster4) }
        monster5.setOnClickListener { vieMonster(R.drawable.monster5) }
    }

    private fun vieMonster(monsterId: Int) {
        val intent=Intent(this,DetailActivity::class.java)
        intent.setAction(Intent.ACTION_VIEW)
        val uri=Uri.parse("http://com.example.firstapplication/view?id=$monsterId")
        intent.data=uri

        intent.putExtra("monsterId",monsterId)
        startActivity(intent)


    }
}
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //my edited from start from here..
        val rollbutton:Button = findViewById(R.id.button)
        rollbutton.setOnClickListener {
            //shows a toast msg when clicked
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            //alternative
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            //instead of temporary toast below shows a textView value 6
            //val resultTextview: TextView = findViewById(R.id.textView)
            //resultTextview.text= "6"

            //here we add some logic to show random dice image
                val role = Dice(6)
                val ro = role.roll()
                val luckynum:Int = (1..6).random()
                val imgview: ImageView = findViewById(R.id.imageView)
                when(ro){
                    1 -> imgview.setImageResource(R.drawable.dice_1)
                    2 -> imgview.setImageResource(R.drawable.dice_2)
                    3 -> imgview.setImageResource(R.drawable.dice_3)
                    4 -> imgview.setImageResource(R.drawable.dice_4)
                    5 -> imgview.setImageResource(R.drawable.dice_5)
                    6 -> imgview.setImageResource(R.drawable.dice_6)
                }
                if(luckynum==ro)
                    Toast.makeText(this, "You won!", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "sorry you got ${ro} try again", Toast.LENGTH_SHORT).show()

        }
    }


}

class Dice(private val numSides :Int) {
    val rolrange: IntRange = 1..numSides
    fun roll(): Int {
        return (rolrange).random()
    }
}

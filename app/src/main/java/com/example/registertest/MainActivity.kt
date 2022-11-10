package com.example.registertest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<EditText>(R.id.editName)
        val surname=findViewById<EditText>(R.id.editSurname)
        val numID=findViewById<EditText>(R.id.editID)
        val mail=findViewById<EditText>(R.id.editMail)
        val btn_click=findViewById<Button>(R.id.myButton)
        val fiz=findViewById<CheckBox>(R.id.faiz)
        val astra=findViewById<CheckBox>(R.id.astraZ)
        val modern=findViewById<CheckBox>(R.id.moderna)
        val noVAc=findViewById<CheckBox>(R.id.noVacine)




        btn_click.setOnClickListener {

            val resultName=name.text.toString()
            val resultSurname=surname.text.toString()
            val resultID=numID.text.toString()
            val resultMail=mail.text.toString()


            if(resultName==""|| resultSurname==""||resultID==""||resultMail==""){
                Toast.makeText(this@MainActivity,"გრაფა ცარიელია",Toast.LENGTH_SHORT).show()
            }else if(numID.length() < 11 ){
                Toast.makeText(this@MainActivity,"არასწორი პირადი ნომერი",Toast.LENGTH_SHORT).show()
            }else if (!resultMail.isValidEmail()){
                Toast.makeText(this@MainActivity,"არასწორი მეილი",Toast.LENGTH_SHORT).show()
            }else if (noVAc.isChecked){
                Toast.makeText(this@MainActivity,"თქვენ არ ხართ აცრილი",Toast.LENGTH_SHORT).show()
            }else if (fiz.isChecked){
                Toast.makeText(this@MainActivity,"თქვენ აცრილი ხართ ფაიზერით",Toast.LENGTH_SHORT).show()
            }else if (astra.isChecked){
                Toast.makeText(this@MainActivity,"თქვენ აცრილი ხართ ასტრათი",Toast.LENGTH_SHORT).show()
            }else if (modern.isChecked){
                Toast.makeText(this@MainActivity,"თქვენ აცრილი ხართ მოდერნათი",Toast.LENGTH_SHORT).show()
            }else if (!noVAc.isChecked && !fiz.isChecked && !astra.isChecked && !modern.isChecked){
                Toast.makeText(this@MainActivity,"ყუთები ცარიელია",Toast.LENGTH_SHORT).show()
            }


        }


    }

    fun CharSequence?.isValidEmail()=!isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
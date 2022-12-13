package com.example.school_project

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class StartingActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting2)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor=getColor(R.color.completed_color)
        }
        val bottomnav:BottomNavigationView=findViewById(R.id.bottomNavView)
        replaceFragment(HomeNavFragment())
        bottomnav.setOnItemSelectedListener {
      when(it.itemId){
//          R.id.nav_home-> replaceFragment(HomeNavFragment())
          R.id.nav_home->startActivity(Intent(applicationContext,HomeMainActivity::class.java))
          else->{
              replaceFragment(BlankFragment())
          }
      }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment){
    val fragmentManager=supportFragmentManager
    val fragmentTransaction=fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.frameLayout,fragment)
    fragmentTransaction.commit()

}
}
package com.example.school_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.GridLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.school_project.examActivities.RetrofitClient
import com.example.school_project.homeMainModel.HomeMainData
import com.example.school_project.homeMainModel.HomeMainModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        supportActionBar?.hide()
        val bottomNav:BottomNavigationView=findViewById(R.id.bottomNavigation)
        val homeRV1:RecyclerView=findViewById(R.id.homeMainRV1)
        homeRV1.layoutManager= GridLayoutManager(applicationContext,3)
val dataList:MutableList<HomeMainData> =ArrayList()
        val homeMainAdapter:HomeMainAdapter= HomeMainAdapter(applicationContext,dataList)
        homeRV1.adapter=homeMainAdapter
        val retrofitClient=RetrofitClient()
        retrofitClient.api().homeMainModel.enqueue(object : retrofit2.Callback<List<HomeMainModel>?> {
            override fun onResponse(call: Call<List<HomeMainModel>?>, response: Response<List<HomeMainModel>?>) {
                val dataMain: List<HomeMainModel>? =response.body()
                val data:List<HomeMainData> = dataMain!!.get(0).data
                var i:Int=0
                while (i<data.size){
                    dataList.add(HomeMainData(data.get(i).title,data.get(i).sub_title,R.drawable.menu))
                    homeMainAdapter.notifyDataSetChanged()
                    i++
                }
                Toast.makeText(applicationContext,"success", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<List<HomeMainModel>?>, t: Throwable) {

            }
        })
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->startActivity(Intent(applicationContext,HomeMainActivity::class.java))
                R.id.nav_calender->startActivity(Intent(applicationContext,AlertActivity::class.java))
                else->{

                }
            }
            true
        }
    }
}





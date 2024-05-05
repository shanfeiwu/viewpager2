package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2:ViewPager2
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sport_activity)

        viewPager2 = findViewById(R.id.sport_main_view_pager2)
        var viewPager2FragmentAdapter = ViewPager2FragmentAdapter(this,initFragmentList())
        viewPager2.adapter = viewPager2FragmentAdapter

        bottomNavigationView = findViewById(R.id.btn_nav_view)
        bottomNavigationView.setOnNavigationItemSelectedListener{
            item ->
            when(item.itemId){
                R.id.home ->
                    viewPager2.currentItem = 0
                R.id.second ->
                    viewPager2.currentItem = 1
            }
            return@setOnNavigationItemSelectedListener true
        }

        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNavigationView.selectedItemId = R.id.home
                    1 -> bottomNavigationView.selectedItemId = R.id.second
                }
            }
        })
    }

    fun initFragmentList():List<Fragment>{
        var viewPager2FragmentFirst = ViewPager2FragmentFirst()
        var viewPager2FragmentTwo = ViewPager2FragmentTwo()
        var fragmentlist = ArrayList<Fragment>()
        fragmentlist.add(viewPager2FragmentFirst)
        fragmentlist.add(viewPager2FragmentTwo)
        return fragmentlist
    }

}
package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.views.CircularProgressBar

class ViewPager2FragmentFirst : Fragment() {
    lateinit var circularProgressBar:CircularProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.view_pager2_framgent_one,container,false)
        circularProgressBar = view.findViewById(R.id.circluar_progress_bar)
        return view
    }

    override fun onResume() {
        super.onResume()
        circularProgressBar.setProgress(50.0F,"800")
    }
}
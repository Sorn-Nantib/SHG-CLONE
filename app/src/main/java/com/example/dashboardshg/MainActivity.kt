package com.example.dashboardshg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.shg_clone.SliderAdapter
import com.example.shg_clone.SliderItem
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        viewPager2 = findViewById(R.id.viewPager_ImageSlider)
        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.ad1))
        sliderItems.add(SliderItem(R.drawable.ad2))
        sliderItems.add(SliderItem(R.drawable.ad3

        ))
        viewPager2.adapter = SliderAdapter(sliderItems,viewPager2)


        viewPager2.clipToPadding =false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val indicator  = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager_ImageSlider)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{
                page, position ->
            val r = 1- kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.25f


        }
        viewPager2.setPageTransformer(compositePageTransformer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when(itemView){
            R.id.nav_ring -> Toast.makeText(applicationContext,"Add check",Toast.LENGTH_SHORT).show()
            R.id.nav_call -> Toast.makeText(applicationContext,"Notification",Toast.LENGTH_SHORT).show()

        }
        return false
    }
}
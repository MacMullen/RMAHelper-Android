package com.macmullen.rmahelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mainToolbar))

        var viewPager = findViewById<ViewPager>(R.id.mainViewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        var tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.home)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.products)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.companies)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.invoice)))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

}

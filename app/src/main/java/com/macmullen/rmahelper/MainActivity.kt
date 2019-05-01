package com.macmullen.rmahelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mainToolbar))

        drawer = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    HomeFragment.newInstance(),
                    "Products"
                ).commit()
                R.id.nav_products -> supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    ProductsFragment.newInstance(),
                    "Products"
                ).commit()
                R.id.nav_companies -> supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    CompaniesFragment.newInstance(),
                    "Products"
                ).commit()
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsFragment.newInstance(), "Products").commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        var toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawer,
            mainToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

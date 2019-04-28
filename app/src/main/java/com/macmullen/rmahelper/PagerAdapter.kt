package com.macmullen.rmahelper


import android.content.ContentProvider
import android.provider.Settings.System.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.content.Context


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return HomeFragment()
            1 -> return ProductsFragment()
            2 -> return CompaniesFragment()
            3 -> return InvoiceFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 4
    }
}
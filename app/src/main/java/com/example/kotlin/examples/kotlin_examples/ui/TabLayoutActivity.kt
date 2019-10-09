package com.example.kotlin.examples.kotlin_examples.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import androidx.viewpager.widget.ViewPager
import com.example.kotlin.examples.kotlin_examples.R
import com.google.android.material.tabs.TabLayout


import java.util.ArrayList

class TabLayoutActivity : AppCompatActivity() {

    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    private var tabIndicators: ArrayList<String> = ArrayList<String>()
    private var tabFragments: ArrayList<Fragment> = ArrayList<Fragment>()
    private var contentAdapter: ContentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.viewpager)
        initContent()
        initTab()
    }

    private fun initTab() {
        //tabLayout?.setTabMode(TabLayout.MODE_SCROLLABLE)
        //Use of setter method instead of property access syntax
        tabLayout?.tabMode=TabLayout.MODE_SCROLLABLE
        tabLayout?.setupWithViewPager(viewPager)
    }

    private fun initContent() {
        for (i in 0..9) {
            tabIndicators.add("Tab $i")
        }

        for (s in tabIndicators) {
            tabFragments.add(
                TabContentFragment.newInstance(
                    s
                )
            )
        }
        contentAdapter = ContentPagerAdapter(supportFragmentManager)
        //viewPager?.setAdapter(contentAdapter)
        viewPager?.adapter = contentAdapter;
    }


    internal inner class ContentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return tabFragments.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tabIndicators.get(position)
        }

        override fun getCount(): Int {
            return tabIndicators.size
        }
    }


}

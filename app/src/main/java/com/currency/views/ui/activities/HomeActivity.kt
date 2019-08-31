package com.currency.views.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.currency.R
import com.currency.views.ui.adapters.TabAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var tabFragmentAdapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tabFragmentAdapter = TabAdapter(this, supportFragmentManager)

        initView()
    }

    private fun initView() {
        viewPager.adapter = tabFragmentAdapter
        tabularLayout.setupWithViewPager(viewPager)
        viewPager.currentItem = 1
    }
}

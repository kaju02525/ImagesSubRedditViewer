package com.greedygame.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.greedygame.R
import com.greedygame.adapter.GameAdapter
import com.greedygame.model.ChildrenData
import com.greedygame.mvvm.GameViewModel
import kotlinx.android.synthetic.main.main_layout.*

class GameActivity : AppCompatActivity(){
    private val mViewModel by lazy { ViewModelProviders.of(this).get(GameViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.main_layout)
         observeLiveData()
         hideShowProgress(true)
    }

    private fun observeLiveData() {
        mViewModel.responseData.observe(this, Observer {
            hideShowProgress(false)
            initData(it.data)
        })
        mViewModel.errorData.observe(this, Observer {
            hideShowProgress(false)
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show();
        })
    }

    private fun initData(data: ChildrenData?) {
        recycler_view.adapter = GameAdapter(data?.children!!)
    }


    private fun hideShowProgress(flag: Boolean) {
        if (flag) {
            progress_circular?.visibility = View.VISIBLE
        } else {
            progress_circular?.visibility = View.GONE
        }
    }
}
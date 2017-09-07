package com.example.snb.repeater

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.*
import com.example.snb.repeater.R.id.*
import com.example.snb.repeater.R.layout.activity_main_page

class MainPage : AppCompatActivity() {

    private val mHideHandler = Handler()
    private var mContentView: View? = null
    private var mControlsView: View? = null
    private var mVisible: Boolean = false

    private val mHideRunnable = Runnable { hide() }

    private val mDelayHideTouchListener = View.OnTouchListener { _, _ ->
        if (AUTO_HIDE) delayedHide(AUTO_HIDE_DELAY_MILLIS)
        false
    }
    private val mShowPart2Runnable = Runnable {
        supportActionBar?.show()
        mControlsView!!.visibility = VISIBLE
    }
    private val mHidePart2Runnable = Runnable {
        mContentView!!.systemUiVisibility = SYSTEM_UI_FLAG_LOW_PROFILE or SYSTEM_UI_FLAG_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_IMMERSIVE_STICKY or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activity_main_page)

        mVisible = true
        mControlsView = findViewById(fullscreen_content_controls)
        mContentView = findViewById(fullscreen_content)
        mContentView!!.setOnClickListener { if (mVisible) hide() else show() }
        findViewById(dummy_button).setOnTouchListener(mDelayHideTouchListener)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        delayedHide(UI_CREATE_ANIMATION_DELAY)
    }

    private fun hide() {
        supportActionBar?.hide()
        mControlsView!!.visibility = GONE
        mVisible = false
        delayedHide(UI_ANIMATION_DELAY, mShowPart2Runnable, mHidePart2Runnable)
    }

    private fun show() {
        mContentView!!.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        mVisible = true
        delayedHide(UI_ANIMATION_DELAY, mHidePart2Runnable, mShowPart2Runnable)
    }

    private fun delayedHide(delayMillis: Int) {
        delayedHide(delayMillis, mHideRunnable, mHideRunnable)
    }

    private fun delayedHide(delayMillis: Int, toRemove: Runnable, toPost: Runnable) {
        mHideHandler.removeCallbacks(toRemove)
        mHideHandler.postDelayed(toPost, delayMillis.toLong())
    }

    companion object {
        private val AUTO_HIDE = true
        private val AUTO_HIDE_DELAY_MILLIS = 3000
        private val UI_ANIMATION_DELAY = 300
        private val UI_CREATE_ANIMATION_DELAY = 100
    }
}

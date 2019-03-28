package com.waifusims.wanicchou.util

import androidx.viewpager.widget.ViewPager
import com.waifusims.wanicchou.ui.adapter.ListPagerAdapter

fun ViewPager.replaceListPagerAdapter(replacementAdapter : ListPagerAdapter){
    val existingAdapter = this.adapter as ListPagerAdapter
    existingAdapter.clearFragments()
    this.removeAllViews()
    this.adapter = replacementAdapter
}

package com.trootechdemo.roomdb.interfaces

import android.view.View

interface RecyclerViewItemClicked {
    fun onItemClickListener(view: View?, position: Int)
}
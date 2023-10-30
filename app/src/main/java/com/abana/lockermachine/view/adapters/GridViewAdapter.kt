package com.abana.lockermachine.view.adapters

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.TextView
import com.abana.lockermachine.R
import com.abana.lockermachine.model.pojo.Items
import com.abana.lockermachine.model.pojo.MachineLocker
import com.abana.lockermachine.model.pojo.Result
import com.google.gson.Gson

class GridViewAdapter(private val context: Context, private val data: List<Items>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val cellData = data[position].machineLocker
        val textView = TextView(context)
        textView.text = cellData!!.lockerNo.toString() // Numbers start from 1
        textView.layoutParams = AbsListView.LayoutParams(
            AbsListView.LayoutParams.MATCH_PARENT, // Match the parent width
            AbsListView.LayoutParams.WRAP_CONTENT  // Wrap content for height
        )

        return textView
    }
}
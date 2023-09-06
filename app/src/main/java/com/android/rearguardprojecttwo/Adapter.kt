package com.android.rearguardprojecttwo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(val mContext: Context, val mItems: MutableList<Items>) : BaseAdapter()  {
    override fun getCount(): Int {
        return mItems.size
    }

    override fun getItem(position: Int): Any {
        return mItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item_listview, parent, false)

        val item : Items = mItems[position]

        val TItle = convertView?.findViewById<View>(R.id.ItemTitle) as TextView
        val Desc = convertView.findViewById<View>(R.id.ItemDesc) as TextView
        val Com = convertView.findViewById<View>(R.id.ItemCompany) as TextView
        val Date = convertView.findViewById<View>(R.id.ItemDate) as TextView

        TItle.text = item.aTitle
        Desc.text = item.aDesc
        Com.text = item.aCompany
        Date.text = item.aDate

        return convertView
    }


}
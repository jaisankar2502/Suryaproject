package com.surya.suryaproject.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.surya.suryaproject.R
import com.surya.suryaproject.model.griditem

class gridadapter(var context:Context,var arrayList: ArrayList<griditem>): BaseAdapter() {
    override fun getCount(): Int {
        return  arrayList.size
    }

    override fun getItem(position: Int): Any {
       return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var view:View= View.inflate(context, R.layout.gridlayout,null)
        var image:ImageView=view.findViewById(R.id.image)
        var name:TextView= view.findViewById(R.id.name)
        var listitem:griditem=arrayList.get(position)
        name.text=listitem.name
        listitem.image?.let { image.setImageResource(it) }
        return view
    }
}
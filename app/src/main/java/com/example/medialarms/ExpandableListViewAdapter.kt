package com.example.medialarms

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import java.util.Locale


class ExpandableListViewAdapter internal constructor(private val context : Context, private val groupList : List<String>, private val itemList : HashMap<String, List<String>>):
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return groupList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.itemList[this.groupList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return groupList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return this.itemList[this.groupList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView= p2
        val grupoTitulo=getGroup(p0) as String

        if (convertView==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.group_alarmas, null)
        }
        val alarmasGrupo=convertView!!.findViewById<TextView>(R.id.grupo_alarmas)
        alarmasGrupo.setText(grupoTitulo)

        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView= p3
        val itemTitulo=getChild(p0, p1) as String

        if (convertView==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.item_alarmas, null)
        }
        val alarmasItem=convertView!!.findViewById<TextView>(R.id.item)
        alarmasItem.setText(itemTitulo)

        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }


}
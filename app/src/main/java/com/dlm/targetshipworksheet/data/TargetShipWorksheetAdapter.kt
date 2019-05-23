package com.dlm.targetshipworksheet.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.model.Marker

class TargetShipWorksheetAdapter (private val list: ArrayList<Marker>,
                                  private val context: Context): RecyclerView.Adapter<TargetShipWorksheetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TargetShipWorksheetAdapter.ViewHolder {
        //Create our view from our xml file
        val view = LayoutInflater.from(context).inflate(R.layout.target_ship_worksheet_item, parent, false)

        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TargetShipWorksheetAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem (item: Marker) {
            var id: TextView = itemView.findViewById(R.id.textview_list_item_id) as TextView
            var time: TextView = itemView.findViewById(R.id.textview_list_item_time) as TextView
            var ownCourse: TextView = itemView.findViewById(R.id.textview_list_item_own_course) as TextView
            var ownSpeed: TextView = itemView.findViewById(R.id.textview_list_item_own_speed) as TextView
            var targetBearing: TextView = itemView.findViewById(R.id.textview_list_item_target_bearing) as TextView
            var targetAob: TextView = itemView.findViewById(R.id.textview_list_item_target_aob) as TextView
            var targetRange: TextView = itemView.findViewById(R.id.textview_list_item_target_range) as TextView
            var targetSpeed: TextView = itemView.findViewById(R.id.textview_list_item_target_speed) as TextView
            var targetCourse: TextView = itemView.findViewById(R.id.textview_list_item_target_course) as TextView
            var targetName: TextView = itemView.findViewById(R.id.textview_list_item_target_name) as TextView

            id.text = item.id.toString()
            time.text = item.time
            ownCourse.text = item.ownCourse.toString()
            ownSpeed.text = item.ownSpeed.toString()
            targetBearing.text = item.targetBearing.toString()
            targetAob.text = item.targetAob
            targetRange.text = item.targetRange.toString()
            targetSpeed.text = item.targetSpeed.toString()
            targetCourse.text = item.targetCourse.toString()

            itemView.setOnClickListener {
                Toast.makeText(context, id.text + " " + time.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
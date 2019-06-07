package com.dlm.targetshipworksheet.ui

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.dlm.targetshipworksheet.MainActivity
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.data.TargetShipWorksheetAdapter
import com.dlm.targetshipworksheet.model.Marker
import com.dlm.targetshipworksheet.model.MarkerModel
import kotlinx.android.synthetic.main.target_ship_worksheet_view.*

class TargetShipWorksheetView: AppCompatActivity() {
    private val PREFS_NAME = MainActivity.prefsName()

    private var adapter: TargetShipWorksheetAdapter? = null
    private var markerList: ArrayList<Marker>? = null
    private var markerModel: MarkerModel? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.target_ship_worksheet_view)

        // init model and adapter
        markerModel = MarkerModel(getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))
        markerList = ArrayList<Marker>()
        var lm  = StaggeredGridLayoutManager(9,StaggeredGridLayoutManager.VERTICAL)
        lm.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        layoutManager = lm

        adapter = TargetShipWorksheetAdapter(markerList!!, this)

        // set-up RecyclerView
        recyclerview_worksheet.setHasFixedSize(true)
        recyclerview_worksheet.layoutManager = layoutManager
        recyclerview_worksheet.adapter = adapter

        // load data
        for (item in markerModel!!.findAllDataDemo()) {
            markerList!!.add(item)
        }
        adapter!!.notifyDataSetChanged()

    }

}

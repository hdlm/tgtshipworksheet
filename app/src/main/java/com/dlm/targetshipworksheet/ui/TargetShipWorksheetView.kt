package com.dlm.targetshipworksheet.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.data.TargetShipWorksheetAdapter
import com.dlm.targetshipworksheet.model.Marker
import kotlinx.android.synthetic.main.target_ship_worksheet_view.*

class TargetShipWorksheetView: AppCompatActivity() {
    private var adapter: TargetShipWorksheetAdapter? = null
    private var markerList: ArrayList<Marker>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.target_ship_worksheet_view)

        markerList = ArrayList<Marker>()
        layoutManager = LinearLayoutManager(this)
        adapter = TargetShipWorksheetAdapter(markerList, this)

        // set-up RecyclerView
        recyclerview_worksheet.layoutManager = layoutManager
        recyclerview_worksheet.adapter = adapter

	//TODO cargar los datos de prueba



    }




}

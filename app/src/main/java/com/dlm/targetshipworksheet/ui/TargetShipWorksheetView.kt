package com.dlm.targetshipworksheet.ui
/*
MIT License

Copyright (c) 2019 Henry De la Mano

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
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
        var lm  = LinearLayoutManager(this)
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

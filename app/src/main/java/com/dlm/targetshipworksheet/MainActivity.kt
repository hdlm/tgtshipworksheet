package com.dlm.targetshipworksheet

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.widget.TableLayout
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.dlm.targetshipworksheet.entities.Marker
import kotlinx.android.synthetic.main.activity_main.*
import com.dlm.targetshipworksheet.boundaries.MarkerDetail
import android.content.Intent
import com.dlm.targetshipworksheet.models.MarkerModel

/*
@see http://learningprogramming.net/mobile/android/create-datatable-in-android/
 */
class MainActivity : AppCompatActivity() {

    private var tableLayout : TableLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        loadData()
    }

    private fun initView() : Unit {
        tableLayout = tableLayoutMark
    }

    private fun loadData() : Unit {
        createColumns()
        fillData()

    }

    private fun createColumns() : Unit {
        var tableRow = TableRow(this)
        tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        // Id Column
        var textViewId = TextView(this)
        textViewId.text = "Id"
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewId.setPadding(5,5,5,0)
        tableRow.addView(textViewId)

        // Time column
        var textViewTime = TextView(this)
        textViewTime.text = "Time"
        textViewTime.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTime.setPadding(5,5,5,0)
        textViewTime.setOnClickListener {Toast.makeText(applicationContext, "Time", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTime)

        // Own Course Column
        var textViewOwnCourse = TextView(this)
        textViewOwnCourse.text = "Own Crs"
        textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnCourse.setPadding(5,5,5,0)
        textViewOwnCourse.setOnClickListener {Toast.makeText(applicationContext, "Own Course", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewOwnCourse)

        // Own Speed Column
        var textViewOwnSpeed = TextView(this)
        textViewOwnSpeed.text = "Own Spd"
        textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnSpeed.setPadding(5,5,5,0)
        textViewOwnSpeed.setOnClickListener {Toast.makeText(applicationContext, "Own Speed", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewOwnSpeed)

        // Target Bearing Column
        var textViewTargetBearing = TextView(this)
        textViewTargetBearing.text = "Tgt Brg"
        textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetBearing.setPadding(5,5,5,0)
        textViewTargetBearing.setOnClickListener {Toast.makeText(applicationContext, "Target Bearing", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTargetBearing)

        // Target AOB Column
        var textViewTargetAob = TextView(this)
        textViewTargetAob.text = "Tgt AOB"
        textViewTargetAob.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetAob.setPadding(5,5,5,0)
        textViewTargetAob.setOnClickListener {Toast.makeText(applicationContext, "Target AOB", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTargetAob)

        // Target Range Column
        var textViewTargetRange = TextView(this)
        textViewTargetRange.text = "Tgt Rng"
        textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetRange.setPadding(5,5,5,0)
        textViewTargetRange.setOnClickListener {Toast.makeText(applicationContext, "Target Range", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTargetRange)

        // Target Speed Column
        var textViewTargetSpeed = TextView(this)
        textViewTargetSpeed.text = "Tgt Spd"
        textViewTargetSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetSpeed.setPadding(5,5,5,0)
        textViewTargetSpeed.setOnClickListener {Toast.makeText(applicationContext, "Target Speed", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTargetSpeed)

        // Target Course Column
        var textViewTargetCourse = TextView(this)
        textViewTargetCourse.text = "Tgt Crs"
        textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetCourse.setPadding(5,5,5,0)
        textViewTargetCourse.setOnClickListener {Toast.makeText(applicationContext, "Target Course", Toast.LENGTH_LONG).show() }
        tableRow.addView(textViewTargetCourse)

        tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        // Add Divider
        tableRow = TableRow(this)
        tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        // Id Column
        textViewId = TextView(this)
        textViewId.text = "--"
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewId.setPadding(5,5,5,0)
        tableRow.addView(textViewId)

        // Time column
        textViewTime = TextView(this)
        textViewTime.text = "------"
        textViewTime.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTime.setPadding(5,5,5,0)
        tableRow.addView(textViewTime)

        // Own Course Column
        textViewOwnCourse = TextView(this)
        textViewOwnCourse.text = "----------"
        textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnCourse.setPadding(5,5,5,0)
        tableRow.addView(textViewOwnCourse)

        // Own Speed Column
        textViewOwnSpeed = TextView(this)
        textViewOwnSpeed.text = "-----------"
        textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewOwnSpeed)

        // Target Bearing Column
        textViewTargetBearing = TextView(this)
        textViewTargetBearing.text = "---------"
        textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetBearing.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetBearing)

        // Target AOB Column
        textViewTargetAob = TextView(this)
        textViewTargetAob.text = "----------"
        textViewTargetAob.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetAob.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetAob)

        // Target Range Column
        textViewTargetRange = TextView(this)
        textViewTargetRange.text = "---------"
        textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetRange.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetRange)

        // Target Speed Column
        textViewTargetSpeed = TextView(this)
        textViewTargetSpeed.text = "---------"
        textViewTargetSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetSpeed)

        // Target Course Column
        textViewTargetCourse = TextView(this)
        textViewTargetCourse.text = "---------"
        textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetCourse.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetCourse)

        tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

    }

    private fun fillData() : Unit {

        var markerModel = MarkerModel()

        for(marker in markerModel.findAll()) {
            var tableRow = TableRow(this)
            tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

            tableRow.setOnClickListener { view ->
                var currentRow : TableRow = view as TableRow
                var textViewId : TextView = currentRow.getChildAt(0) as TextView
                var sId = textViewId.text.toString()
                //Toast.makeText(applicationContext, sId, Toast.LENGTH_LONG).show()
                var intent = Intent(this, MarkerDetail::class.java)
                intent.putExtra("id", sId)
                startActivity(intent)
            }

            // Id Column
            var textViewId = TextView(this)
            textViewId.text = marker.id.toString()
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewId.setPadding(5,5,5,0)
            tableRow.addView(textViewId)
            
            
            // Time Column
            var textViewTime = TextView(this)
            textViewTime.text = marker.time
            textViewTime.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTime.setPadding(5,5,5,0)
            tableRow.addView(textViewTime)
            
            // Own Course Column
            var textViewOwnCourse = TextView(this)
            textViewOwnCourse.text = marker.ownCourse.toString()
            textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnCourse.setPadding(5,5,5,0)
            tableRow.addView(textViewOwnCourse)
            
            // Own Speed Column
            var textViewOwnSpeed = TextView(this)
            textViewOwnSpeed.text = marker.ownSpeed.toString()
            textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnSpeed.setPadding(5,5,5,0)
            tableRow.addView(textViewOwnSpeed)
            
            // Target Bearing Column
            var textViewTargetBearing = TextView(this)
            textViewTargetBearing.text = marker.targetBearing.toString()
            textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetBearing.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetBearing)
            
            // Target AOB Column
            var textViewTargetAOB = TextView(this)
            textViewTargetAOB.text = marker.targetAob
            textViewTargetAOB.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetAOB.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetAOB)
            
            // Target Range Column
            var textViewTargetRange = TextView(this)
            textViewTargetRange.text = marker.targetRange.toString()
            textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetRange.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetRange)
            
            // Target Speed Column
            textViewId = TextView(this)
            textViewId.text = marker.targetSpeed.toString()
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewId.setPadding(5,5,5,0)
            tableRow.addView(textViewId)
            
            // Target Course Column
            var textViewTargetCourse = TextView(this)
            textViewTargetCourse.text = if(marker.targetCourse == -1) "unknown" else marker.targetCourse.toString()
            textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetCourse.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetCourse)

            tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        }
    }

}

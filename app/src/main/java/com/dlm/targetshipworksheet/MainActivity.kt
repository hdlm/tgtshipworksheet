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
        var markers : ArrayList<Marker> = arrayListOf(
                Marker("01:00", 90, 0, 15, "port", 8000, 5, -1),
                Marker("01:10", 90, 0, 25, "port", 7500, 5, -1),
                Marker("01:20", 90, 0, 30, "port", 7400, 5, -1),
                Marker("01:30", 90, 0, 35, "port", 7300, 5, -1),
                Marker("01:40", 90, 0, 40, "port", 7200, 5, -1),
                Marker("01:50", 90, 0, 45, "port", 7100, 5, -1),
                Marker("02:00", 90, 0, 50, "port", 7000, 5, -1) )
        var marks : List<Marker> = markers

        createColumns()

        fillData(marks)

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
        tableRow.addView(textViewTime)

        // Own Course Column
        var textViewOwnCourse = TextView(this)
        textViewOwnCourse.text = "Own Course"
        textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnCourse.setPadding(5,5,5,0)
        tableRow.addView(textViewOwnCourse)

        // Own Speed Column
        var textViewOwnSpeed = TextView(this)
        textViewOwnSpeed.text = "Own Speed"
        textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewOwnSpeed)

        // Target Bearing Column
        var textViewTargetBearing = TextView(this)
        textViewTargetBearing.text = "Target Bearing"
        textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetBearing.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetBearing)

        // Target AOB Column
        var textViewTargetAob = TextView(this)
        textViewTargetAob.text = "Target AOB"
        textViewTargetAob.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetAob.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetAob)

        // Target Range Column
        var textViewTargetRange = TextView(this)
        textViewTargetRange.text = "Target Range"
        textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetRange.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetRange)

        // Target Speed Column
        var textViewTargetSpeed = TextView(this)
        textViewTargetSpeed.text = "Target Speed"
        textViewTargetSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetSpeed)

        // Target Course Column
        var textViewTargetCourse = TextView(this)
        textViewTargetCourse.text = "Target Course"
        textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetCourse.setPadding(5,5,5,0)
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
        textViewTime.text = "----"
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
        textViewOwnSpeed.text = "---------"
        textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewOwnSpeed)

        // Target Bearing Column
        textViewTargetBearing = TextView(this)
        textViewTargetBearing.text = "--------------"
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
        textViewTargetRange.text = "------------"
        textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetRange.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetRange)

        // Target Speed Column
        textViewTargetSpeed = TextView(this)
        textViewTargetSpeed.text = "------------"
        textViewTargetSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetSpeed.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetSpeed)

        // Target Course Column
        textViewTargetCourse = TextView(this)
        textViewTargetCourse.text = "-------------"
        textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetCourse.setPadding(5,5,5,0)
        tableRow.addView(textViewTargetCourse)

        tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

    }

    private fun fillData(markers : List<Marker>)  {

        var id = 1

        for(marker in markers) {
            var tableRow = TableRow(this)
            tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

            tableRow.setOnClickListener { view ->
                var currentRow : TableRow = view as TableRow
                var textViewId : TextView = currentRow.getChildAt(0) as TextView
                var id = textViewId.toString()
                Toast.makeText(applicationContext, id, Toast.LENGTH_LONG).show()
            }

            // Id Column
            var textViewId = TextView(this)
            id++; textViewId.text = id.toString()
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
            textViewTargetAOB.text = textViewTargetAOB.toString()
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
            var textViewId = TextView(this)
            textViewId.text = marker.targetSpeed.toString()
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewId.setPadding(5,5,5,0)
            tableRow.addView(textViewId)
            
            // Target Course Column
            var textViewTargetCourse = TextView(this)
            textViewTargetCourse.text = marker.targetCourse.toString()
            textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetCourse.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetCourse)

            tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        }
    }

}

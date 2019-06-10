package com.dlm.targetshipworksheet

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.widget.TableLayout
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.dlm.targetshipworksheet.ui.MarkerDetail
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import com.dlm.targetshipworksheet.model.Marker
import com.dlm.targetshipworksheet.model.MarkerModel

/**
 *
 * The class represents the <italic> MainActivity</italic> of the app
 * <p>The app is responsible for keeping track of the contacts detected in the <italic>Target Ship Worksheet</italic>.</p>
 * <p>The UI emulates a DataGrid component to display the data.</p>
 * @see http://learningprogramming.net/mobile/android/create-datatable-in-android/
 *
 * @version 1.2, 2019-06-10
 * @author hdelamano
 * <p>Use the file <code>string.xml</code> to display the messages.</p>
 *
 * @version 1.1, 2019-06-07
 * @author hdelamano
 * <p>The necessary adjustments were made for the changes of properties in the [marker][com.dlm.targetshipworksheet.model.Marker]
 * class, as well as modification in the [fillData] methods.</p>
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    val PREFS_NAME = MainActivity.prefsName()
    val REQUEST_CODE = 1

    private var tableLayout : TableLayout? = null
    private var prefs : SharedPreferences? = null



    companion object {
        fun prefsName(): String = "TargetShipWorksheetPrefs";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        //testSaveLoadMarker(Marker(1, "12:00",90, 1, 45, "stdb", 10000, 8, 270 ))
        //
        // INIT VIEW
        //
        tableLayout = tableLayoutMark

        loadData()
    }

    /**
     * Return from the Activity called
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                tableLayout!!.removeAllViews()
                loadData()
            } else if(resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show()
        }
    }


    private fun loadData() : Unit {
        createColumns()

        var markerModel = MarkerModel(prefs!!)
        fillData (markerModel.findAll())
    }


    /**
     * The method shows the heading of the spreadsheet
     */
    private fun createColumns() : Unit {
        var tableRow = TableRow(this)
        tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        // Id Column
        var textViewId = TextView(this)
        textViewId.text = this.getString(R.string.worksheet_label_column_id)
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewId.setPadding(5,5,5,0)
        tableRow.addView(textViewId)

        // Time column
        var textViewTime = TextView(this)
        textViewTime.text = this.getString(R.string.worksheet_label_column_time)
        textViewTime.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTime.setPadding(5,5,5,0)
        textViewTime.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_time), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTime)

        // Own Course Column
        var textViewOwnCourse = TextView(this)
        textViewOwnCourse.text = this.getString(R.string.worksheet_label_column_own_course)
        textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnCourse.setPadding(5,5,5,0)
        textViewOwnCourse.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_own_course), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewOwnCourse)

        // Own Speed Column
        var textViewOwnSpeed = TextView(this)
        textViewOwnSpeed.text = this.getString(R.string.worksheet_label_column_own_speed)
        textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewOwnSpeed.setPadding(5,5,5,0)
        textViewOwnSpeed.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_own_speed), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewOwnSpeed)

        // Target Bearing Column
        var textViewTargetBearing = TextView(this)
        textViewTargetBearing.text = this.getString(R.string.worksheet_label_column_target_bearing)
        textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetBearing.setPadding(5,5,5,0)
        textViewTargetBearing.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_target_bearing), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTargetBearing)

        // Target AOB Column
        var textViewTargetAob = TextView(this)
        textViewTargetAob.text = this.getString(R.string.worksheet_label_column_target_aob)
        textViewTargetAob.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetAob.setPadding(5,5,5,0)
        textViewTargetAob.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_target_aob), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTargetAob)

        // Target Range Column
        var textViewTargetRange = TextView(this)
        textViewTargetRange.text = this.getString(R.string.worksheet_label_column_target_range)
        textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetRange.setPadding(5,5,5,0)
        textViewTargetRange.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_target_range), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTargetRange)

        // Target Speed Column
        var textViewTargetSpeed = TextView(this)
        textViewTargetSpeed.text = this.getString(R.string.worksheet_label_column_target_speed)
        textViewTargetSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetSpeed.setPadding(5,5,5,0)
        textViewTargetSpeed.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_target_speed), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTargetSpeed)

        // Target Course Column
        var textViewTargetCourse = TextView(this)
        textViewTargetCourse.text = this.getString(R.string.worksheet_label_column_target_course)
        textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
        textViewTargetCourse.setPadding(5,5,5,0)
        textViewTargetCourse.setOnClickListener {Toast.makeText(applicationContext, this.getString(R.string.worksheet_hint_column_target_course), Toast.LENGTH_SHORT).show() }
        tableRow.addView(textViewTargetCourse)

        tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        // Add Divider
        tableRow = TableRow(this)
        tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

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

        tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

    }

    /**
     * The method is responsible for filling the spreadsheet with the stored records
     * @param list collection of markers
     */
    private fun fillData(list : List<Marker>) : Unit {

        for(marker in list) {
            var tableRow = TableRow(this)
            tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

            // Id Column
            var textViewId = TextView(this)
            textViewId.text = marker.id.toString()
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewId.setPadding(5,5,5,0)
            textViewId.setOnClickListener(this)
            tableRow.addView(textViewId)

            // Time Column
            var textViewTime = TextView(this)
            textViewTime.text = marker.time
            textViewTime.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTime.setPadding(5,5,5,0)
            textViewTime.setOnClickListener(this)
            tableRow.addView(textViewTime)

            // Own Course Column
            var textViewOwnCourse = TextView(this)
            textViewOwnCourse.text = marker.ownCourse
            textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnCourse.setPadding(5,5,5,0)
            textViewOwnCourse.setOnClickListener(this)
            tableRow.addView(textViewOwnCourse)

            // Own Speed Column
            var textViewOwnSpeed = TextView(this)
            textViewOwnSpeed.text = marker.ownSpeed
            textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnSpeed.setPadding(5,5,5,0)
            textViewOwnSpeed.setOnClickListener(this)
            tableRow.addView(textViewOwnSpeed)

            // Target Bearing Column
            var textViewTargetBearing = TextView(this)
            textViewTargetBearing.text = marker.targetBearing
            textViewTargetBearing.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetBearing.setPadding(5,5,5,0)
            textViewTargetBearing.setOnClickListener(this)
            tableRow.addView(textViewTargetBearing)

            // Target AOB Column
            var textViewTargetAOB = TextView(this)
            textViewTargetAOB.text = marker.targetAob
            textViewTargetAOB.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetAOB.setPadding(5,5,5,0)
            textViewTargetAOB.setOnClickListener(this)
            tableRow.addView(textViewTargetAOB)

            // Target Range Column
            var textViewTargetRange = TextView(this)
            textViewTargetRange.text = marker.targetRange
            textViewTargetRange.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetRange.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetRange)

            // Target Speed Column
            textViewId = TextView(this)
            textViewId.text = marker.targetSpeed
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewId.setPadding(5,5,5,0)
            tableRow.addView(textViewId)

            // Target Course Column
            var textViewTargetCourse = TextView(this)
            textViewTargetCourse.text = marker.targetCourse
            textViewTargetCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewTargetCourse.setPadding(5,5,5,0)
            tableRow.addView(textViewTargetCourse)

            // Ship Name
            var textViewShipName = TextView(this)
            textViewShipName.text = marker.targetName
            textViewShipName.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewShipName.setPadding(5,5,5,0)
            tableRow.addView(textViewShipName)

            tableLayout!!.addView(tableRow, TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

        }
    }

    // El metodo es utilizado para verificar el guardado y carga del objeto marked
    private fun testSaveLoadMarker(marker: Marker): Unit {
        var txtMarker = marker.toString()
        var newMarker = Marker.load(txtMarker)

        Log.d("-> Marker loaded: ", newMarker.toString())
    }

    override fun onClick(view: View?) {
        var currentRow: TableRow? = null

        // get the TableRow
        if (view is TextView) {
            var v = view
            currentRow = v.parent as TableRow
        } else if (view is TableRow) {
            currentRow = view
        }

        // get the 'id' field
        var textViewId: TextView = currentRow!!.getChildAt(0) as TextView
        var sId = textViewId.text

        // passing data between activities
        var intent = Intent(this, MarkerDetail::class.java)
        intent.putExtra("id", sId)
        startActivityForResult(intent, REQUEST_CODE)
    }

}

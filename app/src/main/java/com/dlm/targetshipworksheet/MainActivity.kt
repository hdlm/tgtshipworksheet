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
import com.dlm.targetshipworksheet.boundaries.MarkerDetail
import android.content.Intent
import android.util.Log
import android.view.View
import com.dlm.targetshipworksheet.entities.Marker
import com.dlm.targetshipworksheet.models.MarkerModel

/**
La clase representa el <italic>MainActivity</italic> de la app
<p>La app se encarga de llevar los registros de los contactos detectados en
 el Target Ship Worksheet.</p>
<p>La UI emula un componente DataGrid para desplegar los datos</p>
@see http://learningprogramming.net/mobile/android/create-datatable-in-android/
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var tableLayout : TableLayout? = null
    val REQUEST_CODE = 1
    val PREFS_NAME = MainActivity.prefsName()

    companion object {
        fun prefsName(): String = "TargetShipWorksheetPrefs";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //testSaveLoadMarker(Marker(1, "12:00",90, 1, 45, "stdb", 10000, 8, 270 ))
        initView()
        loadData()
    }

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

    private fun initView() : Unit {
        tableLayout = tableLayoutMark
    }

    private fun loadData() : Unit {
        createColumns()
        fillData()

    }

    /**
     * El metodo muestra el encabezado de la la hoja
     */
    private fun createColumns() : Unit {
        var tableRow = TableRow(this)
        tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

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
     * El metodo se encarga de llenar la hoja con los registros almacenados
     */
    private fun fillData() : Unit {

        var markerModel = MarkerModel(getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE))

        for(marker in markerModel.findAll()) {
            var tableRow = TableRow(this)
            tableRow.layoutParams = (TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT))

            //tableRow.setOnClickListener(this)
            /*tableRow.setOnClickListener { view ->
                var currentRow : TableRow = view as TableRow
                var textViewId : TextView = currentRow.getChildAt(0) as TextView
                var sId = textViewId.text.toString()
                //Toast.makeText(applicationContext, sId, Toast.LENGTH_LONG).show()
                var intent = Intent(this, MarkerDetail::class.java)
                intent.putExtra("id", sId)
                startActivityForResult(intent, REQUEST_CODE)
            }*/

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
            textViewOwnCourse.text = marker.ownCourse.toString()
            textViewOwnCourse.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnCourse.setPadding(5,5,5,0)
            textViewOwnCourse.setOnClickListener(this)
            tableRow.addView(textViewOwnCourse)

            // Own Speed Column
            var textViewOwnSpeed = TextView(this)
            textViewOwnSpeed.text = marker.ownSpeed.toString()
            textViewOwnSpeed.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
            textViewOwnSpeed.setPadding(5,5,5,0)
            textViewOwnSpeed.setOnClickListener(this)
            tableRow.addView(textViewOwnSpeed)

            // Target Bearing Column
            var textViewTargetBearing = TextView(this)
            textViewTargetBearing.text = marker.targetBearing.toString()
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
        var sId = textViewId.text.toString()

        // passing data between activities
        var intent = Intent(this, MarkerDetail::class.java)
        intent.putExtra("id", sId)
        startActivityForResult(intent, REQUEST_CODE)
    }

}

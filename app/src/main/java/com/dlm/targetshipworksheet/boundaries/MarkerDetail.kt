package com.dlm.targetshipworksheet.boundaries

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.models.MarkerModel
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.widget.Spinner
import com.dlm.targetshipworksheet.MainActivity
import com.dlm.targetshipworksheet.utils.MaskWatcher
import kotlinx.android.synthetic.main.activity_marker_details.*

/**
 * La clase se encarga de crear / editar un marker o anotacion de una embarcacion detectada
 */
class MarkerDetail : AppCompatActivity() {

    //Patched to accept String in a clean code when used InputType=Number on EditText
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    val TITLE = "Marker Detail"
    val PREFS_NAME = MainActivity.prefsName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_details)

        var myPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        setTitle(TITLE)
        var intent = intent
        var id = intent.getStringExtra("id")
        var markerModel = MarkerModel(myPref)
        var marker = markerModel.find(id.toInt())

        textViewId.text = marker?.id.toString()
        if(!TextUtils.isEmpty(marker?.time)) {  // cargar los valores de los campos correspondientes

            editTextTime.text = marker?.time?.toEditable()
            //editTextTime.addTextChangedListener(MaskWatcher("##:##"))

            editTextOwnCourse.text = marker?.ownCourse.toString().toEditable()
            editTextOwnSpeed.text = marker?.ownSpeed.toString().toEditable()
            editTextTargetBearing.setText(marker?.targetBearing.toString())
            selectSpinnerItemByValue(spinnerTargetAob, marker?.targetAob)
            editTextTargetRange.setText(marker?.targetRange.toString())
            editTextTargetSpeed.setText(marker?.targetSpeed.toString())
            editTextTargetCourse.setText(if (marker!!.targetCourse == -1) "unknown" else marker.targetCourse.toString())
        }
        buttonGuardar.setOnClickListener {
            if (marker != null) {
                marker.time = editTextTime.text.toString()
                marker.ownCourse = editTextOwnCourse.text.toString().toInt()
                marker.ownSpeed = editTextOwnSpeed.text.toString().toInt()
                marker.targetBearing = editTextTargetBearing.text.toString().toInt()
                marker.targetAob = spinnerTargetAob.selectedItem.toString()
                marker.targetRange = editTextTargetRange.text.toString().toInt()
                marker.targetSpeed = editTextTargetSpeed.text.toString().toInt()
                marker.targetCourse = editTextTargetCourse.text.toString().toInt()

                markerModel.save(marker)
            }

            setResult(Activity.RESULT_OK)
            finish()  // it a function to allowed an activity to stacking out
        }

        buttonCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()  // it a function to allowed an activity to stacking out
        }

        editTextTime.addTextChangedListener( MaskWatcher("##:##") )
    }

    /** El metodo se encarga de seleccionar el item correpondiente al valor especificado */
    private fun selectSpinnerItemByValue(spinner: Spinner, value: String?): Unit
    {
        if (value != null) {
            var adapter = spinner.adapter
            for (pos in 0..adapter.count - 1) {
                if (adapter.getItem(pos).toString() == value)
                    spinner.setSelection(pos)
            }
        }
    }

}

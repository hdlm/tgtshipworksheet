package com.dlm.targetshipworksheet.ui

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.model.MarkerModel
import android.text.Editable
import android.text.Html
import android.text.TextUtils
import android.widget.Spinner
import com.dlm.targetshipworksheet.MainActivity
import com.dlm.targetshipworksheet.utils.MaskWatcher
import kotlinx.android.synthetic.main.activity_marker_details.*

/**
 * La clase se encarga de crear / editar un marker o anotacion de una embarcacion detectada
 *
 * @see https://medium.com/google-developer-experts/android-strings-xml-things-to-remember-c155025bb8bb
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
            editTextOwnCourse.text = marker?.ownCourse.toString().toEditable()
            editTextOwnSpeed.text = marker?.ownSpeed.toString().toEditable()
            editTextTargetBearing.setText(marker?.targetBearing.toString())
            selectSpinnerItemByValue(spinnerTargetAob, marker?.targetAob)
            editTextTargetRange.setText(marker?.targetRange.toString())
            editTextTargetSpeed.setText(marker?.targetSpeed.toString())
            editTextTargetCourse.setText(if (marker!!.targetCourse == -1) "unknown" else marker.targetCourse.toString())
        }
        buttonGuardar.setOnClickListener {
            if (validateFields()) {  // campos requeridos llenados satisfactoriamente
                if (marker != null) {
                    marker.time = editTextTime.text.toString()
                    if (!TextUtils.isEmpty(editTextOwnCourse.text)) marker.ownCourse = editTextOwnCourse.text.toString().toInt()
                    else marker.ownCourse = null
                    if (!TextUtils.isEmpty(editTextOwnSpeed.text)) marker.ownSpeed = editTextOwnSpeed.text.toString().toInt()
                    else marker.ownSpeed = null
                    if (!TextUtils.isEmpty(editTextTargetBearing.text)) marker.targetBearing = editTextTargetBearing.text.toString().toInt()
                    else marker.targetBearing = null
                    marker.targetAob = spinnerTargetAob.selectedItem.toString()
                    if (!TextUtils.isEmpty(editTextTargetRange.text)) marker.targetRange = editTextTargetRange.text.toString().toInt()
                    marker.targetRange = null
                    if (!TextUtils.isEmpty(editTextTargetSpeed.text)) marker.targetSpeed = editTextTargetSpeed.text.toString().toInt()
                    marker.targetSpeed = null
                    if (!TextUtils.isEmpty(editTextTargetCourse.text)) marker.targetCourse = editTextTargetCourse.text.toString().toInt()
                    else marker.targetCourse = null

                    markerModel.save(marker)
                }
                setResult(Activity.RESULT_OK)
                finish()  // it a function to allowed an activity to stacking out
            }
            else
                return@setOnClickListener
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
            for (pos in 0 until adapter.count-1) {
                if (adapter.getItem(pos).toString() == value)
                    spinner.setSelection(pos)
            }
        }
    }

    /** El metodo se encarga de validar los campos obligatorios */
    private fun validateFields(): Boolean
    {
        var resp = true

        if (TextUtils.isEmpty(editTextTime.text)) {
            editTextTime.error = Html.fromHtml(getString(R.string.error_message_time))
            resp = false
        }

        return resp

    }

}

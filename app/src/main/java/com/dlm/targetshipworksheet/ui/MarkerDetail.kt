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
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.model.MarkerModel
import android.text.Editable
import android.text.TextUtils
import android.widget.Spinner
import com.dlm.targetshipworksheet.MainActivity
import com.dlm.targetshipworksheet.utils.MaskWatcher
import kotlinx.android.synthetic.main.activity_marker_details.*

/**
 * The class is responsible for creating / editing a marker or annotation of a vessel detected
 *
 * @version 1.2, 2019-06-08
 * @author hdelamano
 * <p>A warning that is occurring due to the overshadowing of a variable was suppressed.</p>
 *
 * @version 1.1, 2019-06-07
 * @author hdelamano
 * <p>Adjustments were made for the change of properties of the [com.dlm.targetshipworksheet.model.Marker] class </p>
 *
 * @see [source](https://medium.com/google-developer-experts/android-strings-xml-things-to-remember-c155025bb8bb)
 */
class MarkerDetail : AppCompatActivity() {

    //Patched to accept String in a clean code when used InputType=Number on EditText
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    val PREFS_NAME = MainActivity.prefsName()

    var prefs : SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_details)

        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        setTitle(this.getString(R.string.marker_detail_title))
        var intent = intent
        var id = intent.getStringExtra("id")
        var markerModel = MarkerModel(prefs!!)
        var marker = markerModel.find(id.toInt())

        textViewId.text = marker?.id.toString()
        if(!TextUtils.isEmpty(marker?.time)) {  // cargar los valores de los campos correspondientes
            editTextTime.text = marker?.time?.toEditable()
            editTextOwnCourse.text = marker?.ownCourse!!.toEditable()
            editTextOwnSpeed.text = marker.ownSpeed!!.toEditable()
            editTextTargetBearing.setText(marker.targetBearing)
            selectSpinnerItemByValue(spinnerTargetAob, marker.targetAob)
            editTextTargetRange.setText(marker.targetRange)
            editTextTargetSpeed.setText(marker.targetSpeed)
            editTextTargetCourse.setText(marker.targetCourse)

        } else {   // ajustar al siguiente ID disponible
            textViewId.text = markerModel.nextAvailableId(markerModel.findAll()).toString()

        }
        buttonGuardar.setOnClickListener {
            if (validateFields()) {  // campos requeridos llenados satisfactoriamente
                @Suppress("NAME_SHADOWING") var marker = markerModel.emptyMarker()
                marker.id = textViewId.text.toString().toInt()
                marker.time = editTextTime.text.toString()
                if (!TextUtils.isEmpty(editTextOwnCourse.text)) marker.ownCourse = editTextOwnCourse.text.toString()
                else marker.ownCourse = ""
                if (!TextUtils.isEmpty(editTextOwnSpeed.text)) marker.ownSpeed = editTextOwnSpeed.text.toString()
                else marker.ownSpeed = ""
                if (!TextUtils.isEmpty(editTextTargetBearing.text)) marker.targetBearing = editTextTargetBearing.text.toString()
                else marker.targetBearing = ""
                marker.targetAob = spinnerTargetAob.selectedItem.toString()
                if (!TextUtils.isEmpty(editTextTargetRange.text)) marker.targetRange = editTextTargetRange.text.toString()
                marker.targetRange = ""
                if (!TextUtils.isEmpty(editTextTargetSpeed.text)) marker.targetSpeed = editTextTargetSpeed.text.toString()
                marker.targetSpeed = ""
                if (!TextUtils.isEmpty(editTextTargetCourse.text)) marker.targetCourse = editTextTargetCourse.text.toString()
                else marker.targetCourse = ""

                markerModel.save(marker)
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
            editTextTime.error = HtmlCompat.fromHtml(getString(R.string.error_message_time), HtmlCompat.FROM_HTML_MODE_LEGACY)
            resp = false
        }

        return resp

    }

}

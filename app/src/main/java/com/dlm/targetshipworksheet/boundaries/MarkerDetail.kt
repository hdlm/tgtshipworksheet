package com.dlm.targetshipworksheet.boundaries

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.models.MarkerModel
import android.text.Editable
import kotlinx.android.synthetic.main.activity_marker_details.*

class MarkerDetail : AppCompatActivity() {


    //Patched to accept String in a clean code when used InputType=Number on EditText
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_details)

        setTitle("Marker Detail")
        var intent = intent
        var id = intent.getStringExtra("id")
        var markerModel = MarkerModel()
        var marker = markerModel.find(id)

        textViewId.text = marker?.id.toString()
        editTextTime.text = marker?.time?.toEditable()
        editTextOwnCourse.text = marker?.ownCourse.toString().toEditable()
        editTextOwnSpeed.text =marker?.ownSpeed.toString().toEditable()
        editTextTargetBearing.setText(marker?.targetBearing.toString())
        editTextTargetAob.setText(marker?.targetAob.toString())
        editTextTargetRange.setText(marker?.targetRange.toString())
        editTextTargetSpeed.setText(marker?.targetSpeed.toString())
        editTextTargetCourse.setText( if(marker!!.targetCourse == -1) "unknown" else marker.targetCourse.toString())
    }


}

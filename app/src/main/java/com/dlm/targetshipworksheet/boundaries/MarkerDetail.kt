package com.dlm.targetshipworksheet.boundaries

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dlm.targetshipworksheet.R
import com.dlm.targetshipworksheet.models.MarkerModel
import kotlinx.android.synthetic.main.activity_marker_details.*

class MarkerDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_details)

        setTitle("Marker Detail")
        var intent = intent
        var id = intent.getStringExtra("id")
        var markerModel = MarkerModel()
        var marker = markerModel.find(id)

        textViewId.text = marker?.id.toString()
        textViewTime.text = marker?.time
        textViewOwnCourse.text = marker?.ownCourse.toString()
        textViewOwnSpeed.text = marker?.ownSpeed.toString()
        textViewTargetBearing.text = marker?.targetBearing.toString()
        textViewTargetAob.text = marker?.targetAob.toString()
        textViewTargetRange.text = marker?.targetRange.toString()
        textViewTargetSpeed.text = marker?.targetSpeed.toString()
        textViewTargetCourse.text = if(marker!!.targetCourse == -1) "unknown" else marker.targetCourse.toString()

    }
}

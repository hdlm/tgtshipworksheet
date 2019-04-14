package com.dlm.targetshipworksheet.entities

/**
 * The entity represent a Ship mark
 */
class Marker {
    val PORT : String = "port"
    val STBD : String = "stbd" // starboard
    val UNKNOWN : Int = -1

    var id : Int? = null
    var time : String? = null
    var ownCourse : Int? = null
    var ownSpeed : Int? = null
    var targetBearing : Int? = null
    var targetAob : String? = null
    var targetRange : Int? = null
    var targetSpeed : Int? = null
    var targetCourse : Int? = null

    constructor(
        id: Int?,
        time: String?,
        ownCourse: Int?,
        ownSpeed: Int?,
        targetBearing: Int?,
        targetAob: String?,
        targetRange: Int?,
        targetSpeed: Int?,
        targetCourse: Int?
    ) {
        this.id = id
        this.time = time
        this.ownCourse = ownCourse
        this.ownSpeed = ownSpeed
        this.targetBearing = targetBearing
        this.targetAob = targetAob
        this.targetRange = targetRange
        this.targetSpeed = targetSpeed
        this.targetCourse = targetCourse
    }
}
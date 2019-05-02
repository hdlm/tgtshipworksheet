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

    override fun toString(): String
    {
        var sb = StringBuilder()
        sb.append(id).append(',').append(time).append(',').append(ownCourse).append(',').append(ownSpeed).append(',')
        sb.append(targetBearing).append(',').append(targetAob).append(',').append(targetRange).append(',')
        sb.append(targetSpeed).append(',').append(targetCourse)

        return sb.toString()
    }

    companion object {
        fun load(obj: String): Marker {
            val propList : List<String> = obj.split(",")
            var id : Int? = null
            var time : String? = null
            var ownCourse : Int? = null
            var ownSpeed : Int? = null
            var targetBearing : Int? = null
            var targetAob : String? = null
            var targetRange : Int? = null
            var targetSpeed : Int? = null
            var targetCourse : Int? = null

            for(idx in 0..propList.size-1) {
                when (idx) {
                    0 -> id = propList[idx].toInt()
                    1 -> time = propList[idx]
                    2 -> ownCourse = propList[idx].toInt()
                    3 -> ownSpeed = propList[idx].toInt()
                    4 -> targetBearing = propList[idx].toInt()
                    5 -> targetAob = propList[idx]
                    6 -> targetRange = propList[idx].toInt()
                    7 -> targetSpeed = propList[idx].toInt()
                    8 -> targetCourse = propList[idx].toInt()
                }
            }
            var marker = Marker(id, time, ownCourse, ownSpeed, targetBearing, targetAob, targetRange, targetSpeed, targetCourse)
            return marker
        }
    }

}
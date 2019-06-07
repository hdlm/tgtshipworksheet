package com.dlm.targetshipworksheet.model


/**
 * The class represent a <italic>Ship mark</italic> entity
 * <p>The class is responsible for recovering and saving the records of markers.</p>
 *
 * @version 1.1, 2018-06-07
 * @author hdelamano
 * <p>The <code>Int</code> properties were changed to <code>String</code></p>
 *
 * @version 1.0
 * @author hdelamano
 * <p>Creation of the class</p>
 */
class Marker {
    val PORT : String = "port"
    val STBD : String = "stbd" // starboard

    var id : Int? = null
    var time : String? = null
    var ownCourse : String? = null
    var ownSpeed : String? = null
    var targetBearing : String? = null
    /** port / starboard */
    var targetAob : String? = null
    var targetRange : String? = null
    var targetSpeed : String? = null
    var targetCourse : String? = null
    var targetName: String? = null

    constructor(
        id: Int?,
        time: String?,
        ownCourse: String?,
        ownSpeed: String?,
        targetBearing: String?,
        targetAob: String?,
        targetRange: String?,
        targetSpeed: String?,
        targetCourse: String?,
        targetName: String?
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
        this.targetName = targetName
    }

    override fun toString(): String
    {
        var sb = StringBuilder()
        sb.append(id).append(',').append(time).append(',').append(ownCourse).append(',').append(ownSpeed).append(',')
        sb.append(targetBearing).append(',').append(targetAob).append(',').append(targetRange).append(',')
        sb.append(targetSpeed).append(',').append(targetCourse).append(',').append(targetName)

        return sb.toString()
    }

    companion object {
        fun load(obj: String): Marker {
            val propList : List<String> = obj.split(",")
            var id : Int? = null
            var time : String? = null
            var ownCourse : String? = null
            var ownSpeed : String? = null
            var targetBearing : String? = null
            var targetAob : String? = null
            var targetRange : String? = null
            var targetSpeed : String? = null
            var targetCourse : String? = null
            var targetName : String? = null

            for(idx in 0..propList.size-1) {
                when (idx) {
                    0 -> id = propList[idx].toInt()
                    1 -> time = propList[idx]
                    2 -> ownCourse = propList[idx]
                    3 -> ownSpeed = propList[idx]
                    4 -> targetBearing = propList[idx]
                    5 -> targetAob = propList[idx]
                    6 -> targetRange = propList[idx]
                    7 -> targetSpeed =  propList[idx]
                    8 -> targetCourse = propList[idx]
                    9 -> targetName = propList[idx]
                }
            }
            var marker = Marker(
                id,
                time,
                ownCourse,
                ownSpeed,
                targetBearing,
                targetAob,
                targetRange,
                targetSpeed,
                targetCourse,
                targetName
            )
            return marker
        }
    }

}
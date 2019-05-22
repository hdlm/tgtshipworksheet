package com.dlm.targetshipworksheet.model


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
                var a = propList[idx]
                when (idx) {
                    0 -> id = propList[idx].toInt()
                    1 -> time = propList[idx]
                    2 -> try { ownCourse = propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
                    3 -> try { ownSpeed = propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
                    4 -> try { targetBearing = propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
                    5 -> targetAob = propList[idx]
                    6 -> try { targetRange = propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
                    7 -> try { targetSpeed =  propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
                    8 -> try {targetCourse = propList[idx].toInt() } catch(ignore: java.lang.NumberFormatException) { }
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
                targetCourse
            )
            return marker
        }
    }

}
package com.dlm.targetshipworksheet.model


/**
 * The class represent a <italic>Ship mark</italic> entity
 * <p>The class is responsible for recovering and saving the records of markers.</p>
 * @author hdelamano
 * @version 1.0
 * <p>Creation of the class</p>
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
    var targetName: String? = null

    constructor(
        id: Int?,
        time: String?,
        ownCourse: Int?,
        ownSpeed: Int?,
        targetBearing: Int?,
        targetAob: String?,
        targetRange: Int?,
        targetSpeed: Int?,
        targetCourse: Int?,
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
            var ownCourse : Int? = null
            var ownSpeed : Int? = null
            var targetBearing : Int? = null
            var targetAob : String? = null
            var targetRange : Int? = null
            var targetSpeed : Int? = null
            var targetCourse : Int? = null
            var targetName : String? = null

            for(idx in 0..propList.size-1) {
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
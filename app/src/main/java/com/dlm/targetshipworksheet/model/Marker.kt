package com.dlm.targetshipworksheet.model
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
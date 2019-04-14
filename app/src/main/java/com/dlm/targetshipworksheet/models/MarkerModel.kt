package com.dlm.targetshipworksheet.models

import com.dlm.targetshipworksheet.entities.Marker

class MarkerModel {

    var markers : ArrayList<Marker>? = null

    fun findAll() : List<Marker> {

        markers = arrayListOf(
            Marker(1, "01:00", 90, 0, 15, "port", 8000, 5, -1),
            Marker(2,"01:10", 90, 0, 25, "port", 7500, 5, -1),
            Marker(3,"01:20", 90, 0, 30, "port", 7400, 5, -1),
            Marker(4,"01:30", 90, 0, 35, "port", 7300, 5, -1),
            Marker(5,"01:40", 90, 0, 40, "port", 7200, 5, -1),
            Marker(6,"01:50", 90, 0, 45, "port", 7100, 5, -1),
            Marker(7,"02:00", 90, 0, 50, "port", 7000, 5, -1) )

        var marks : List<Marker> = markers as List<Marker>
        return marks
    }

    fun find(id : String) : Marker? {
        for(marker in findAll()) {
            if(id.toInt() == marker.id)  return marker
        }
        return null
    }
}
package com.dlm.targetshipworksheet.model

import android.content.SharedPreferences

/**
 * The class represents the model corresponding to the <code>Marker</code> registered 
 * <p>The persistence of the data is done through a <code>SharedPreferences</code>. </p>
 * <p>The class is responsible for recovering and saving the records of markers. </p>
 * @author hdelamano
 * @version 1.0
 * <p>Creation of the class</p>
 * @see Marker
 */
class MarkerModel (var myPref: SharedPreferences){

    init {
        this.myPref = myPref
    }

    /** The method returns all registered marker */
    fun findAll() : List<Marker> {
        var lst: List<Marker>    // the List it is immutable by default

        // data back
        if(myPref.contains("1")) { // Existen registros persistentes, por lo tanto, proceder a cargarlos
            var mapMarkers: Map<String, *> =  myPref.all
            var lstMarkers =  ArrayList<Marker>()
            for(txtMarker in mapMarkers) {
                var marker = Marker.load(txtMarker.value as String)
                lstMarkers.add(marker)
            }
            var sortedList = lstMarkers.sortedWith(compareBy({ it.id }))  // ordenar la lista por 'id'
            lst = sortedList
        } else {  // Retornar una lista de registros en blanco
            lst = findAllDataBlank()
            for(marker in lst) {  // guardar los registros por defecto de forma persistente
                save(marker)
            }
        }
        return lst
    }

    // The method is used exclusively for test purposes
    fun findAllDataDemo() : List<Marker> {
        var markers: List<Marker> =  listOf(
            Marker(1, "01:00", 90, 0, 15, "port", 8000, 5, -1, "unknown"),
            Marker(2, "01:10", 90, 0, 25, "port", 7500, 5, -1, "unknown"),
            Marker(3, "01:20", 90, 0, 30, "port", 7400, 5, -1, "unknown"),
            Marker(4, "01:30", 90, 0, 35, "port", 7300, 5, -1, "unknown"),
            Marker(5, "01:40", 90, 0, 40, "port", 7200, 5, -1, "unknown"),
            Marker(6, "01:50", 90, 0, 45, "port", 7100, 5, -1, "unknown"),
            Marker(7, "02:10", 90, 0, 50, "port", 7000, 5, -1, "unknown"),
            Marker(8, "02:20", 90, 0, 15, "port", 8000, 5, -1, "unknown"),
            Marker(9, "02:30", 90, 0, 25, "port", 7500, 5, -1, "unknown"),
            Marker(10, "02:40", 90, 0, 30, "port", 7400, 5, -1, "unknown"),
            Marker(11, "02:50", 90, 0, 35, "port", 7300, 5, -1, "unknown"),
            Marker(12, "03:00", 90, 0, 40, "port", 7200, 5, -1, "unknown"),
            Marker(13, "03:10", 90, 0, 45, "port", 7100, 5, -1, "unknown"),
            Marker(14, "03:20", 90, 0, 50, "port", 7000, 5, -1, "unknown")
        )
/*        var list: ArrayList<Marker> = ArrayList<Marker>()
        for (item in markers) {
            list.add(item)
        }
        */
        return markers
    }

    // The method is used to fill blank cells
    fun findAllDataBlank() : List<Marker> {
        var markers: List<Marker> = listOf(
            Marker(1, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(2, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(3, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(4, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(5, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(6, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(7, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(8, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(9, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(10, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(11, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(12, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(13, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(14, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(15, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(16, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(17, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(18, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(19, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(20, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(21, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(22, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(23, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(24, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(25, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(26, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(27, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(28, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(29, "", 0, 0, 0, "port", 0, 0, -1, "unknown"),
            Marker(30, "", 0, 0, 0, "port", 0, 0, -1, "unknown")
        )
        return markers
    }

    /** The method is responsible for finding the marker corresponding to the specified 'id' */
    fun find(id : Int) : Marker? {
        for(marker in findAll()) {
            if(id == marker.id)  return marker
        }
        return null
    }

    /** The method keeps the records in a persistent way */
    fun save(marker: Marker) {

        var editor: SharedPreferences.Editor = myPref.edit()
        editor.putString(marker.id.toString(), marker.toString())
        editor.commit()  // very important!
    }
}
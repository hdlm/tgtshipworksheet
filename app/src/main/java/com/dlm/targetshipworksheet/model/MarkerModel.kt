package com.dlm.targetshipworksheet.model

import android.content.SharedPreferences
import android.text.TextUtils

/**
 * The class represents the model corresponding to the <code>Marker</code> registered 
 * <p>The persistence of the data is done through a <code>SharedPreferences</code>. </p>
 * <p>The class is responsible for recovering and saving the records of markers. </p>
 *
 * @version 1.2, 2019-06-08
 * @author hdelamano
 * <p>The search was corrected by [id][com.dlm.targetshipworksheet.model.MarkerModel.find].</p>
 *
 * @version 1.1, 2019-06-07
 * @author hdelamano
 * <p>Adjustments were made for the change of properties of the [marker][com.dlm.targetshipworksheet.model.Marker] class and refinement in several methods</p>
 *
 * @version 1.0
 * @author hdelamano
 * <p>Creation of the class</p>
 * @see Marker
 */
class MarkerModel (var myPref: SharedPreferences) {

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

            for(txtMarker in mapMarkers) {  // recorrer los registros guardados y agregarlos en la lista
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
            Marker(1, "01:05", "90", "0", "15", "port", "9000", "", "", "-------"),
            Marker(2, "01:10", "90", "0", "20", "port", "8500", "", "", "-------"),
            Marker(3, "01:15", "90", "0", "25", "port", "8000", "", "", "-------"),
            Marker(4, "01:20", "90", "0", "35", "port", "7500", "", "", "-------"),
            Marker(5, "01:25", "90", "0", "45", "port", "7400", "", "270", "-------"),
            Marker(6, "01:30", "90", "0", "55", "port", "7300", "5", "270", "-------"),
            Marker(7, "01:35", "90", "0", "65", "port", "7200", "5", "270", "-------"),
            Marker(8, "01:40", "90", "0", "75", "port", "7100", "5", "270", "-------"),
            Marker(9, "01:45", "90", "0", "85", "port", "7000", "5", "270", "-------"),
            Marker(10, "01:50", "90", "0", "95", "port", "6900", "5", "270", "-------"),
            Marker(11, "01:55", "90", "0", "100", "port", "6800", "5", "270", "-------"),
            Marker(12, "02:00", "90", "0", "105", "port", "6600", "5", "270", "-------"),
            Marker(13, "02:05", "90", "0", "115", "port", "6400", "5", "270", "-------"),
            Marker(14, "02:10", "90", "0", "125", "port", "6200", "5", "270", "-------"),
            Marker(15, "02:15", "90", "0", "135", "port", "6000", "5", "270", "-------"),
            Marker(16, "02:20", "90", "0", "145", "port", "5700", "5", "270", "-------"),
            Marker(17, "02:25", "90", "0", "155", "port", "5500", "5", "270", "-------"),
            Marker(18, "02:30", "90", "0", "165", "port", "5300", "5", "270", "-------"),
            Marker(19, "02:35", "90", "0", "175", "port", "5100", "5", "270", "Queen Elizabeth"),
            Marker(20, "02:40", "90", "0", "185", "port", "4800", "5", "270", "Queen Elizabeth")
        )
        return markers
    }

    // The method is used to fill blank cells
    fun findAllDataBlank() : List<Marker> {
        var markers: List<Marker> = listOf(
            Marker(1, "", "", "", "", "", "", "", "", "-------"),
            Marker(2, "", "", "", "", "", "", "", "", "-------"),
            Marker(3, "", "", "", "", "", "", "", "", "-------"),
            Marker(4, "", "", "", "", "", "", "", "", "-------"),
            Marker(5, "", "", "", "", "", "", "", "", "-------"),
            Marker(6, "", "", "", "", "", "", "", "", "-------"),
            Marker(7, "", "", "", "", "", "", "", "", "-------"),
            Marker(8, "", "", "", "", "", "", "", "", "-------"),
            Marker(9, "", "", "", "", "", "", "", "", "-------"),
            Marker(10, "", "", "", "", "", "", "", "", "-------"),
            Marker(11, "", "", "", "", "", "", "", "", "-------"),
            Marker(12, "", "", "", "", "", "", "", "", "-------"),
            Marker(13, "", "", "", "", "", "", "", "", "-------")
        )
        return markers
    }

    /** The method return an empty marker with the next <code>ID</code> */
    fun emptyMarker() : Marker {
        return Marker((findAll().size + 1), "", "", "", "", "", "", "", "", "-------")

    }


    /** The method return the next ID available to be assigned to a record */
    fun nextAvailableId(list : List<Marker>) : Int
    {
        for (marker in list) {
            if (TextUtils.isEmpty(marker.time) ) return marker.id!!
        }

        var lst : ArrayList<Marker> = list as ArrayList
        // create and return a new record
        lst.add(emptyMarker())
        return lst.last().id!!

    }


    /** The method is responsible for finding the marker corresponding to the specified 'id' */
    fun find(id : Int) : Marker? {
        for(marker in findAll()) {
            if(id  == marker.id)  return marker
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
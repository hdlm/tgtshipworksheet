package com.dlm.targetshipworksheet.model

import android.content.SharedPreferences

/**
 * La clase representa el modelo correspondiente a los <code>Marker</code> registrados
 * <p>La persistencia de los datos se realiza a traves de un <code>SharedPreferences</code>.</p>
 */
class MarkerModel (var myPref: SharedPreferences){

    init {
        this.myPref = myPref
    }

    /** El metodo retorna todos los marker registrados */
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

    // El metodo es utilizado solo para propositos de prueba
    fun findAllDataDemo() : List<Marker> {
        var markers: List<Marker> =  listOf(
            Marker(1, "01:00", 90, 0, 15, "port", 8000, 5, -1),
            Marker(2, "01:10", 90, 0, 25, "port", 7500, 5, -1),
            Marker(3, "01:20", 90, 0, 30, "port", 7400, 5, -1),
            Marker(4, "01:30", 90, 0, 35, "port", 7300, 5, -1),
            Marker(5, "01:40", 90, 0, 40, "port", 7200, 5, -1),
            Marker(6, "01:50", 90, 0, 45, "port", 7100, 5, -1),
            Marker(7, "02:00", 90, 0, 50, "port", 7000, 5, -1)
        )
        return markers
    }

    // El metodo es utilizado llenar celdas en blanco
    fun findAllDataBlank() : List<Marker> {
        var markers: List<Marker> = listOf(
            Marker(1, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(2, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(3, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(4, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(5, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(6, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(7, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(8, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(9, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(10, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(11, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(12, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(13, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(14, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(15, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(16, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(17, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(18, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(19, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(20, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(21, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(22, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(23, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(24, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(25, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(26, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(27, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(28, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(29, "", 0, 0, 0, "port", 0, 0, -1),
            Marker(30, "", 0, 0, 0, "port", 0, 0, -1)
        )
        return markers
    }

    /** El metodo se encarga de buscar el marker correspondiente al 'id' especificado */
    fun find(id : Int) : Marker? {
        for(marker in findAll()) {
            if(id == marker.id)  return marker
        }
        return null
    }

    /** El metodo se encarga de la persistencia del registro */
    fun save(marker: Marker) {

        var editor: SharedPreferences.Editor = myPref.edit()
        editor.putString(marker.id.toString(), marker.toString())
        editor.commit()  // very important!
    }
}
package com.dlm.targetshipworksheet.utils

/*
    MIT License
    Copyright (c) 2016 Diego Yasuhiko Kurisaki
 */

/* Example
    EmailView.addTextChangedListener(new MaskWatcher("###-##'));
 */

import android.text.TextWatcher
import android.text.Editable
import android.util.Log

class MaskWatcher(mask: String) : TextWatcher {

    private var isRunning = false
    private var isDeleting = false
    private val mask: String = mask


    override fun afterTextChanged(editable: Editable?) {
        Log.d(this.javaClass.name, "afterTextChanged()")
        if (isRunning || isDeleting) {
            return
        }
        isRunning = true

        var editableLength = editable!!.length
        if (editableLength < mask.length) {
            try {
                if (mask.elementAt(editableLength) != '#') {
                    editable.append(mask.elementAt(editableLength - 1))
                } else if (mask.elementAt(editableLength - 1) != '#') {
                    editable.insert(editableLength - 1, mask, editableLength - 1, editableLength)
                }
            } catch (ex: java.lang.StringIndexOutOfBoundsException) {
                // ignore
            }
        } else if (editableLength > mask.length){  // se ha excedido la longitud de la 'mask'
            editable.delete(editableLength-1, editableLength)
        }

        isRunning = false
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        Log.d(this.javaClass.name, "beforeTextChanged()")
        Log.d("> count: ", count.toString())
        isDeleting = count > after
    }


    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Log.d(this.javaClass.name, "onTextChanged()")
        // do nothing
    }
}
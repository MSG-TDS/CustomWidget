package com.example.customwidget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TdsText : AppCompatTextView
{
    var delimiter1 : String = ""

    constructor(context : Context?) : super(context!!){

    }
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs){
        val typed = context.obtainStyledAttributes(attrs, R.styleable.TdsText)
        val size = typed.indexCount

        for ( i in 0 until size){
            when(typed.getIndex(i)){
                R.styleable.TdsText_delimiter -> {
                    delimiter1 = typed.getString(typed.getIndex(i)) ?: "-"
                    process(delimiter1)
                }
            }

        }
    }

    constructor(context : Context, attrs: AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr){

    }

    open fun process(delimiter: String = delimiter1) {
        try {
            val one = text.substring(0, 4)
            val two = text.substring(4, 6)
            val three = text.substring(6)

            setText("$one $delimiter $two $delimiter $three")
        }catch(e : Exception)
        {
            setText("")
        }
    }
}
package com.udacity.shoestore.util

import android.text.TextUtils
import android.widget.EditText
import androidx.databinding.InverseMethod

class Converter {
    companion object {
//        @InverseMethod("stringToDouble")
//        @JvmStatic
//        fun stringToDouble(value: String): Double? {
//            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
//                return null
//            }
//            return value.toDoubleOrNull()
//        }
//
//        @JvmStatic
//        fun doubleToString(value: Double?): String {
//            return value?.toString() ?: ""
//        }

        @InverseMethod("stringToDouble")
        @JvmStatic
        fun doubleToString(
            value: Double,
        ): String {
            return value.toString()
        }

        @JvmStatic
        fun stringToDouble(
            value: String,
        ): Double {
            return value.toDoubleOrNull() ?: 0.0
        }


    }
}
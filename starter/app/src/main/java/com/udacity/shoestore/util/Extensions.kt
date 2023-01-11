package com.udacity.shoestore.util

import android.widget.EditText

fun EditText.isValidText() = this.text.toString().isNotEmpty()

package com.ddona.adpater.model

import com.ddona.adpater.R

data class Contact(
    val id: Int,
    var name: String,
    var phone: String,
    var image: Int = R.mipmap.ic_launcher,
)

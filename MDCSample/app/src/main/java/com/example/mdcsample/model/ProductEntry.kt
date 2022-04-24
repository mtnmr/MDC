package com.example.mdcsample.model

import android.content.res.Resources
import android.net.Uri
import com.example.mdcsample.R

class ProductEntry(
    val title: String, dynamicUrl: String, val url: String, val price: String, val description: String) {
    val dynamicUrl: Uri = Uri.parse(dynamicUrl)
}
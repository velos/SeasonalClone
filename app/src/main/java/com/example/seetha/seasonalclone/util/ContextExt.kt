package com.example.seetha.seasonalclone.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// See also the KTX extensions such as .systemService()

fun Context.inflate(@LayoutRes resource: Int, root: ViewGroup?, attachToRoot: Boolean): View =
        LayoutInflater.from(this).inflate(resource, root, attachToRoot)

package com.aermakova.corgstore.util

import java.io.File
import java.io.FileInputStream
import java.util.Properties

object LocalProperties {

    val localProperties: Properties = Properties().apply {
        try {
            load(FileInputStream(File("local.properties")))
        } catch (ignored: Throwable) {  }
    }
}
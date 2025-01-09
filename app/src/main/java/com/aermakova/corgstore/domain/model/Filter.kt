package com.aermakova.corgstore.domain.model

enum class Filter(val keyword: String) {
    POPULAR("bestseller"),
    CHAIR("chair"),
    TABLE("table"),
    ARMCHAIR("armchair"),
    BED("bed"),
    LAMP("lamp"),
    STORAGE("storage")
}

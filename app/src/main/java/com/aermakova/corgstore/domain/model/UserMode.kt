package com.aermakova.corgstore.domain.model

enum class UserMode(val code: Int) {
    UNAUTHORISED(code = 0),
    GUEST(code = 1),
    AUTHORIZED(code = 2)
}
package com.geolib.entities


import java.security.InvalidParameterException

class Vector private constructor(val northbound: Double, val eastbound: Double, val elevation: Double) {
    companion object {
        @Throws(InvalidParameterException::class)
        fun create(northbound: Double, eastbound: Double, elevation: Double): Vector {
            return Vector(northbound, eastbound, elevation)
        }
    }
}

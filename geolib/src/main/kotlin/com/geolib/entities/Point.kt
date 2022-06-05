package com.geolib.entities


import java.security.InvalidParameterException

data class Point private constructor(val longitude: Double, val latitude: Double, val elevation: Double = 0.0) {

    companion object {
        @Throws(InvalidParameterException::class)
        fun create(longitude: Double, latitude: Double, elevation: Double = 0.0): Point {
            validateLatitude(latitude)
            return Point(wrapLongitude(longitude),latitude, elevation)
        }

        private fun wrapLongitude(longitude: Double): Double {
            return when  {
                longitude > LONGITUDE_MAX -> ( LONGITUDE_MAX - 1E-15 )
                longitude < LONGITUDE_MIN -> LONGITUDE_MIN
                else                      -> longitude
            }
        }

        private fun validateLatitude(latitude: Double) {
            if (latitude < -90 || latitude > 90) {
                throw InvalidParameterException("Latitude must be within -90.0 and 90.0. But it was %s".format(latitude))
            }
        }
    }
}

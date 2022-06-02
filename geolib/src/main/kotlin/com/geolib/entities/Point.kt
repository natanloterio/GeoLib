package com.geolib.entities


import java.security.InvalidParameterException

data class Point private constructor(val longitude: Double, val latitude: Double) {

    companion object {

        @Throws(InvalidParameterException::class)
        fun create(longitude: Double, latitude: Double): Point {
            validateLatitude(latitude)
            return Point(wrapLongitude(longitude),latitude)
        }

        private fun wrapLongitude(longitude: Double): Double {
            return when  {
                longitude > LONGITUDE_MAX -> LONGITUDE_MAX
                longitude < LONGITUDE_MIN -> LONGITUDE_MAX
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

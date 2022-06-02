package com.geolib.entities


import java.security.InvalidParameterException

data class Point private constructor(val longitude: Double, val latitude: Double) {

    companion object {

        @Throws(InvalidParameterException::class)
        fun create(longitude: Double, latitude: Double): Point {
            validateLongitude(longitude)
            validateLatitude(latitude)
            return Point(longitude,latitude)
        }

        private fun validateLongitude(longitude: Double) {
            if (longitude < -90 || longitude > 90) {
                throw InvalidParameterException("Longitude must be within -90.0 and 90.0. But it was %s".format(longitude))
            }
        }

        private fun validateLatitude(latitude: Double) {
            if (latitude < -90 || latitude > 90) {
                throw InvalidParameterException("Latitude must be within -90.0 and 90.0. But it was %s".format(latitude))
            }
        }
    }
}

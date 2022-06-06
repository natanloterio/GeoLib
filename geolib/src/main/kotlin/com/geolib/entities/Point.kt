package com.geolib.entities


import java.security.InvalidParameterException

class Point private constructor(var longitude: Double, var latitude: Double, var elevation: Double = 0.0): Shape{

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

    override fun translate(vector: Vector) {
        longitude+= vector.northbound;
        latitude+= vector.eastbound;
        elevation+= vector.elevation;
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return this.latitude == other.latitude &&
                    this.longitude == other.longitude &&
                    this.elevation == other.elevation
        }
        return super.equals(other)
    }
}

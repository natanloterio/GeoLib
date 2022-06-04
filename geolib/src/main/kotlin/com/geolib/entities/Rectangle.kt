package com.geolib.entities


import java.security.InvalidParameterException

data class Rectangle private constructor(val southWestPoint: Point, val northEastPoint: Point) {
    companion object {

        @Throws(InvalidParameterException::class)
        fun create(southWestPoint: Point, northEastPoint: Point): Rectangle {
            //TODOvalidateCoordinates(southWestPoint, northEastPoint)
            return Rectangle(southWestPoint, northEastPoint)
        }

//        private fun wrapLongitude(longitude: Double): Double {
//            return when  {
//                longitude > LONGITUDE_MAX -> LONGITUDE_MAX
//                longitude < LONGITUDE_MIN -> -LONGITUDE_MAX
//                else                      -> longitude
//            }
//        }
//
//        private fun validateCoordinates(latitude: Point, northEastPoint: Point) {
//            if (latitude < -90 || latitude > 90) {
//                throw InvalidParameterException("Latitude must be within -90.0 and 90.0. But it was %s".format(latitude))
//            }
//        }
    }


    fun containsPoint(testPoint: Point): Boolean {
        val isWithinSouthWestBoundaries = (southWestPoint.latitude <= testPoint.latitude && southWestPoint.longitude <= testPoint.longitude)
        val isWithinNorthEastBoundaries = (northEastPoint.latitude >= testPoint.latitude && northEastPoint.longitude >= testPoint.longitude)
        return isWithinSouthWestBoundaries && isWithinNorthEastBoundaries
    }

}

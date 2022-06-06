package com.geolib.entities


class Rectangle private constructor(private var southWestPoint: Point, private var northEastPoint: Point): Shape {
    companion object {

        fun create(southWestPoint: Point, northEastPoint: Point): Rectangle {
            return Rectangle(southWestPoint, northEastPoint)
        }

    }


    fun containsPoint(testPoint: Point): Boolean {
        val isWithinSouthWestBoundaries = (southWestPoint.latitude <= testPoint.latitude && southWestPoint.longitude <= testPoint.longitude)
        val isWithinNorthEastBoundaries = (northEastPoint.latitude >= testPoint.latitude && northEastPoint.longitude >= testPoint.longitude)
        return isWithinSouthWestBoundaries && isWithinNorthEastBoundaries
    }

    override fun translate(vector: Vector) {
        southWestPoint.translate(vector)
        northEastPoint.translate(vector)
    }

    fun southWestPointLatitude(): Double = southWestPoint.latitude

    fun southWestPointLongitude(): Double = southWestPoint.longitude

    fun southWestPointElevation(): Double = southWestPoint.elevation

    fun northEastPointLatitude(): Double = northEastPoint.latitude

    fun northEastPointLongitude(): Double = northEastPoint.longitude

    fun northEastPointElevation(): Double = northEastPoint.elevation

}

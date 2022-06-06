package com.geolib.entities


class Rectangle private constructor(var southWestPoint: Point, var northEastPoint: Point): Shape {
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

}

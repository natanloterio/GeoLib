package com.geolib.entities

import java.security.InvalidParameterException

class PolyLine private constructor(val points: List<Point>): Shape {

    companion object {

        @Throws(InvalidParameterException::class)
        fun create(points: List<Point>): PolyLine {
            validate(points)
            return PolyLine(points)
        }

        private fun validate(points: List<Point>) {
            if (points.size < 2) throw InvalidParameterException("No sufficient points, A Polyline require at least an array with 2 Points")
        }
    }

    fun getPointAtGivenDistanceInMeters(distanceInMeters: Double): Point? {
        val linesList = asLines()
        var lengthOfPreviousLines = 0.0
        for (line in linesList) {

            val currentLineLength = line.distanceInMeters()
            val distanceIsWithinMeasuredLines = lengthOfPreviousLines+currentLineLength > distanceInMeters

            if (distanceIsWithinMeasuredLines) {
                val startPointLatitude = line.startPointLatitude()
                val startPointLongitude = line.startPointLongitude()
                val endPointLatitude = line.endPointLatitude()
                val endPointLongitude = line.endPointLongitude()

                val distanceInMetersOffset = distanceInMeters - lengthOfPreviousLines
                val factor = distanceInMetersOffset / currentLineLength

                val targetLatitude = (endPointLatitude + startPointLatitude) * factor
                val targetLongitude = (endPointLongitude + startPointLongitude) * factor

                return Point.create(longitude = targetLongitude, latitude = targetLatitude)
            }

            lengthOfPreviousLines += currentLineLength

        }
        return null
    }

    fun asLines(): ArrayList<Line> {
        val linesList = arrayListOf<Line>()
        var priorPoint: Point? = null
        for (currentPoint in points)  {
            if (priorPoint == null) {
                priorPoint = currentPoint
                continue
            }
            linesList.add(Line.create(priorPoint, currentPoint))
        }
        return linesList
    }

    override fun translate(vector: Vector) {
        points.forEach { it.translate(vector) }
    }
}
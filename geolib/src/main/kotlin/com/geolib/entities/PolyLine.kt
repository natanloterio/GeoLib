package com.geolib.entities

import java.security.InvalidParameterException

class PolyLine private constructor(val points: List<Point>): Shape {

    companion object {

        @Throws(InvalidParameterException::class)
        fun create(points: List<Point>): PolyLine {
            if (points.size < 2) throw InvalidParameterException("No sufficient points, A Polyline require at least an array with 2 Points")
            return PolyLine(points)
        }
    }

    fun getPointAtGivenDistanceInMeters(distanceInMeters: Double): Point? {
        val linesList = asLines()
        var lengthOfPreviousLines = 0.0
        for (line in linesList) {

            val currentLineLength = line.distanceInMeters()
            val distanceIsWithinMeasuredLines = lengthOfPreviousLines+currentLineLength > distanceInMeters

            if (distanceIsWithinMeasuredLines) {
                val distanceInMetersOffset = distanceInMeters - lengthOfPreviousLines
                val factor = distanceInMetersOffset / currentLineLength
                val startPoint = line.startPoint
                val endPoint = line.endPoint
                val targetLatitude = (endPoint.latitude + startPoint.latitude) * factor
                val targetLongitude = (endPoint.longitude + startPoint.longitude) * factor
                return Point.create(longitude = targetLongitude, latitude = targetLatitude)
            }

            lengthOfPreviousLines += currentLineLength

            if (lengthOfPreviousLines == distanceInMeters) {
                return line.endPoint
            }
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
package com.geolib.entities

import java.security.InvalidParameterException

class PolyLine private constructor(val points: List<Point>) {

    companion object {

        @Throws(InvalidParameterException::class)
        fun create(points: List<Point>): PolyLine {
            if (points.size < 2) throw InvalidParameterException("No sufficient points, A Polyline require at least an array with 2 Points")
            return PolyLine(points)
        }
    }

    fun asLines(): ArrayList<Line> {
        val linesList = arrayListOf<Line>()
        var priorPoint: Point? = null
        for (idx in  points.indices)  {
            if (priorPoint == null) {
                priorPoint = points[idx]
                continue
            }
            val currentPoint = points[idx]
            linesList.add(Line.create(priorPoint, currentPoint))
        }
        return linesList
    }
}
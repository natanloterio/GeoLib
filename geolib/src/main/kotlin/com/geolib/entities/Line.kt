package com.geolib.entities

import java.security.InvalidParameterException
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sqrt

class Line private constructor(val startPoint: Point, val endPoint: Point) {

    companion object {
        /** Earth mean radius defined by WGS 84 in meters  */
        const val EARTH_MEAN_RADIUS = 6371008.7714

        fun create(startPoint: Point, endPoint: Point): Line {
            return Line(startPoint = startPoint, endPoint = endPoint)
        }

    }

    private fun distanceInMeters(): Double {
        val x = Math.toRadians(startPoint.longitude - endPoint.longitude) * cos(Math.toRadians((startPoint.latitude + endPoint.latitude) / 2.0))
        val y = Math.toRadians(endPoint.latitude - startPoint.latitude)
        return sqrt(x * x + y * y) * EARTH_MEAN_RADIUS
    }

    fun distanceInMetersRounded(): Double = round(distanceInMeters())
}
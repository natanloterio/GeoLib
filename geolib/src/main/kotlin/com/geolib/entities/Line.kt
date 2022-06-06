package com.geolib.entities

import com.geolib.extensions.toRadians
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Line private constructor(val startPoint: Point, val endPoint: Point): Shape {

    companion object {
        fun create(startPoint: Point, endPoint: Point): Line {
            return Line(startPoint = startPoint, endPoint = endPoint)
        }
    }

    fun distanceInMeters(): Double {
        val originLatitude = startPoint.latitude.toRadians()
        val targetLatitude = endPoint.latitude.toRadians()
        val originLongitude = startPoint.longitude.toRadians()
        val targetLongitude = endPoint.longitude.toRadians()

        //Haversine
        val dFigma = targetLatitude - originLatitude
        val dLambda = targetLongitude - originLongitude
        val a = sin(dFigma/2) * sin(dFigma/2) + cos(originLatitude) * cos(targetLatitude) * sin(dLambda/2) * sin(dLambda/2);
        val c = 2 * atan2(sqrt(a), sqrt(1 - a));
        val d = EARTH_RADIUS * c;
        return d

    }

    override fun translate(vector: Vector) {
        startPoint.translate(vector)
        endPoint.translate(vector)
    }

}
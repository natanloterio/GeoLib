package com.geolib.tests

import com.geolib.entities.Line
import com.geolib.entities.Point
import org.junit.Assert.*
import org.junit.Assert
import org.junit.Test
import java.security.InvalidParameterException



internal class LineTest {

    @Test
    fun `Measure correctly a distance between two points`() {
        val startPoint = Point.create(40.0,10.0)
        val endPoint = Point.create(40.0,10.5)
        val line = Line.create(startPoint,endPoint)
        val distance = line.distanceInMetersRounded().toInt()
        assertEquals(55598, distance)
    }

    fun distance() {
    }
}
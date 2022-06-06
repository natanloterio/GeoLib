package com.geolib.tests

import com.geolib.entities.Point
import com.geolib.entities.Rectangle
import com.geolib.entities.Vector
import org.junit.Assert
import org.junit.Test


internal class VectorTest {

    @Test
    fun `A vector must translate a Point position`() {
        val longitude = 0.0
        val latitude = 0.0
        val elevation = 0.0
        val point = Point.create(longitude, latitude, elevation)
        val vector = Vector.create(3.0,10.0,90.0)
        point.translate(vector)
        Assert.assertEquals(point.longitude, vector.northbound,0.0)
        Assert.assertEquals(point.latitude, vector.eastbound,0.0)
        Assert.assertEquals(point.elevation, vector.elevation,0.0)
    }
}
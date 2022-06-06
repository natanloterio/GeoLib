package com.geolib.tests

import com.geolib.entities.Line
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
        Assert.assertEquals(point.longitude, 3.0,0.0)
        Assert.assertEquals(point.latitude, 10.0,0.0)
        Assert.assertEquals(point.elevation, 90.0,0.0)
    }

    @Test
    fun `A vector must translate a Line position`() {
        val startPoint = Point.create(0.0, 0.0, 0.0)
        val endPoint = Point.create(1.0, 1.0, 1.0)
        val line = Line.create(startPoint, endPoint)
        val vector = Vector.create(3.0,10.0,90.0)
        line.translate(vector)

        Assert.assertEquals(line.startPoint.longitude, 3.0,0.0)
        Assert.assertEquals(line.startPoint.latitude, 10.0,0.0)
        Assert.assertEquals(line.startPoint.elevation, 90.0,0.0)
        Assert.assertEquals(line.endPoint.longitude, 4.0,0.0)
        Assert.assertEquals(line.endPoint.latitude, 11.0,0.0)
        Assert.assertEquals(line.endPoint.elevation, 91.0,0.0)
    }

    @Test
    fun `A vector must translate a Rectangle position`() {
        val southWestPoint = Point.create(0.0,0.0,0.0)
        val northEastPoint = Point.create(4.0,4.0, 0.0)
        val rectangle = Rectangle.create(southWestPoint, northEastPoint)
        val vector = Vector.create(3.0,10.0,90.0)
        rectangle.translate(vector)

        Assert.assertEquals(rectangle.southWestPoint.longitude, 3.0,0.0)
        Assert.assertEquals(rectangle.southWestPoint.latitude, 10.0,0.0)
        Assert.assertEquals(rectangle.southWestPoint.elevation, 90.0,0.0)
        Assert.assertEquals(rectangle.northEastPoint.longitude, 7.0,0.0)
        Assert.assertEquals(rectangle.northEastPoint.latitude, 14.0,0.0)
        Assert.assertEquals(rectangle.northEastPoint.elevation, 90.0,0.0)
    }
}
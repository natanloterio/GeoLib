package com.geolib.tests

import com.geolib.entities.*
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

        Assert.assertEquals(line.startPointLongitude(), 3.0,0.0)
        Assert.assertEquals(line.startPointLatitude(), 10.0,0.0)
        Assert.assertEquals(line.startPointElevation(), 90.0,0.0)
        Assert.assertEquals(line.endPointLongitude(), 4.0,0.0)
        Assert.assertEquals(line.endPointLatitude(), 11.0,0.0)
        Assert.assertEquals(line.endPointElevation(), 91.0,0.0)
    }

    @Test
    fun `A vector must translate a Rectangle position`() {
        val southWestPoint = Point.create(0.0,0.0,0.0)
        val northEastPoint = Point.create(4.0,4.0, 0.0)
        val rectangle = Rectangle.create(southWestPoint, northEastPoint)
        val vector = Vector.create(3.0,10.0,90.0)
        rectangle.translate(vector)

        Assert.assertEquals(rectangle.southWestPointLongitude(), 3.0,0.0)
        Assert.assertEquals(rectangle.southWestPointLatitude(), 10.0,0.0)
        Assert.assertEquals(rectangle.southWestPointElevation(), 90.0,0.0)
        Assert.assertEquals(rectangle.northEastPointLongitude(), 7.0,0.0)
        Assert.assertEquals(rectangle.northEastPointLatitude(), 14.0,0.0)
        Assert.assertEquals(rectangle.northEastPointElevation(), 90.0,0.0)
    }

    @Test
    fun `A vector must translate a Polyline position`() {
        val startPoint = Point.create(0.0, 0.0, 0.0)
        val endPoint = Point.create(7.0, 1.0, 0.0)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        val polyLine = PolyLine.create(listOfPoints)
        val vector = Vector.create(3.0,10.0,90.0)
        polyLine.translate(vector)
        val testPoint = polyLine.points.first()

        Assert.assertEquals(testPoint.longitude, 3.0,0.0)
        Assert.assertEquals(testPoint.latitude, 10.0,0.0)
        Assert.assertEquals(testPoint.elevation, 90.0,0.0)
    }
}
package com.geolib.tests
import com.geolib.entities.Line
import com.geolib.entities.Point
import com.geolib.entities.PolyLine
import org.junit.Assert.*
import org.junit.Test
import java.security.InvalidParameterException


internal class PolyLineTests {

    @Test
    fun `Must have at least 2 points in a list to create a Polyline`() {
        val startPoint = Point.create(40.0,10.0)
        val endPoint = Point.create(40.0,10.0)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        val polyLine = PolyLine.create(listOfPoints)
        assert(polyLine is PolyLine)
    }

    @Test
    fun `Must return a list of points of Points`() {
        val startPoint = Point.create(40.0,10.0)
        val endPoint = Point.create(40.0,10.0)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        val polyLine = PolyLine.create(listOfPoints)
        assertEquals(2, polyLine.points.size)
    }

    @Test
    fun `Must throw InvalidParameterException if less than 2 points are set in the constructor`() {
        val startPoint = Point.create(40.0,10.0)
        try {
            val listOfPoints = arrayListOf(startPoint)
            PolyLine.create(listOfPoints)
        }catch (e: InvalidParameterException){
            assertEquals(e.message, "No sufficient points, A Polyline require at least an array with 2 Points")
            return
        }
        fail("Should've throw an exception if less than 2 points are passed as the PolyLine constructor")
    }

    @Test
    fun `Must return the Points as a list of Lines`() {
        val polyline = mockPolyLine()
        val listOfLines = polyline.asLines()
        assert(listOfLines is List<Line>)
    }

    @Test
    fun `Exposes a function to get a 3D location anywhere along the PolyLine at a given a distance`() {
        val startPoint = Point.create(3.0, 7.0)
        val endPoint = Point.create(7.0, 1.0)
        val line = Line.create(startPoint,endPoint)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        val polyLine = PolyLine.create(listOfPoints)
        val targetPoint = polyLine.getPointAtGivenDistanceInMeters((801123/2).toDouble())
        if (targetPoint != null) {
            val distanceCheck = Line.create(startPoint,targetPoint).distanceInMeters()
            assertEquals((801123/2).toDouble()/1000,distanceCheck/1000,0.8)
        }
        val distanceBetween = Line.create(startPoint,endPoint)
//        val distance = (801123/2).toDouble()
//        val factor = distance / distanceBetween
//
//        val targetLatitude = (endPoint.latitude + startPoint.latitude) * factor
//        val targetLongitude = (endPoint.longitude + startPoint.longitude) * factor
    }

    private fun mockPolyLine(): PolyLine {
        val startPoint = Point.create(40.0, 10.0)
        val endPoint = Point.create(40.0, 10.5)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        return PolyLine.create(listOfPoints)
    }

}

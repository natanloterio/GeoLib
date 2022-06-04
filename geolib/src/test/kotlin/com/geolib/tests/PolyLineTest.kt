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
        val startPoint = Point.create(40.0,10.0)
        val endPoint = Point.create(40.0,10.5)
        val listOfPoints = arrayListOf(startPoint, endPoint)
        val listOfLines = PolyLine.create(listOfPoints).asLines()
        assert(listOfLines is List<Line>)
    }

    @Test
    fun `Exposes a function to get a 3D location anywhere along the PolyLine at a given a distance`() {
        TODO()
    }
}

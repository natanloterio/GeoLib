package com.geolib.tests

import com.geolib.entities.Point
import com.geolib.entities.Rectangle
import org.junit.Assert
import org.junit.Test


internal class RectangleTest {

    @Test // Shouldn't test if the points are correct?
    fun `Must to create a Rectangle from 2 corners Points`() {
        val southWestPoint = Point.create(40.0,10.0)
        val northEastPoint = Point.create(50.0,20.0)
        val rectangle = Rectangle.create(southWestPoint, northEastPoint)
        assert(rectangle is Rectangle)
    }

    @Test //Exposes a way to determine if a Point is contained within the rectangle  (elevation is disregarded in this case).
    fun `Must return true if rectangle contains a target point`() {
        val southWestPoint = Point.create(-10.0,-10.0)
        val northEastPoint = Point.create(10.0,10.0)
        val targetPoint = Point.create(0.0,0.0)
        val rectangle = Rectangle.create(southWestPoint, northEastPoint)
        val pointIsWithin = rectangle.containsPoint(targetPoint)
        Assert.assertTrue(pointIsWithin)
    }

    @Test //Exposes a way to determine if a Point is contained within the rectangle  (elevation is disregarded in this case).
    fun `Must return false if rectangle doesn't contains a target point`() {
        //TODO imporove other false cenarios, as tests for every corner
        val southWestPoint = Point.create(-10.0,-10.0)
        val northEastPoint = Point.create(10.0,10.0)
        val targetPoint = Point.create(-11.0,10.0)
        val rectangle = Rectangle.create(southWestPoint, northEastPoint)
        val pointIsWithin = rectangle.containsPoint(targetPoint)
        Assert.assertFalse(pointIsWithin)
    }
}
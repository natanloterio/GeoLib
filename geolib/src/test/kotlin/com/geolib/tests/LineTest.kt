package com.geolib.tests

import org.junit.Assert.assertEquals
import org.junit.Test


internal class LineTest {

    @Test
    fun `Measure correctly the Line's length`() {
        val line = mockLine()
        val distance = line.distanceInMeters()
        assertEquals(857420.20, distance, 0.01)
    }

}
package com.geolib.tests

import com.geolib.entities.Rectangle
import com.geolib.entities.Vector
import org.junit.Test


internal class VectorTest {

    @Test // Constructed from 3 distances, northbound and eastbound (specified in degrees), and a distance that specifies the change in elevation.
    fun `Must to create a Vector from 3 distances `() {
        val vector = Vector.create(40.0,10.0)

        assert(rectangle is Rectangle)
    }
}
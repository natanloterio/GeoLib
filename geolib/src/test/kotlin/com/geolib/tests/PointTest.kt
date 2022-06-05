package com.geolib.tests
import com.geolib.entities.LONGITUDE_MAX
import com.geolib.entities.LONGITUDE_MIN
import com.geolib.entities.Point
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import java.security.InvalidParameterException

class PointTest {

    @Test
    fun `New Point instance returns the right properties`() {
        val longitude = 53.46276675957706
        val latitude = 10.049567988755534
        val point = Point.create(longitude = longitude, latitude = latitude)
        assert(longitude == point.longitude)
        assert(latitude == point.latitude)
    }

    @Test
    fun `Wraps longitude to LONGITUDE_MAX if its greater or equal to 180`() {
        val longitude = 191.0000000
        val latitude = 10.049567988755534

        val point = Point.create(longitude = longitude, latitude = latitude)
        assertEquals(LONGITUDE_MAX,point.longitude,0.0)
    }

    @Test
    fun `Wraps longitude to -180 if its lower than -180`() {
        val longitude = -191.0000000
        val latitude = 10.049567988755534

        val point = Point.create(longitude = longitude, latitude = latitude)
        assertEquals(LONGITUDE_MIN,point.longitude,0.0)
    }

    @Test
    fun `Throws exception if latitude greater than 90`() {
        val longitude = 80.0000001 // should be between -90.0 and 90.0
        val latitude = 90.04956798875554

        try {
            Point.create(longitude = longitude, latitude = latitude)
            junit.framework.Assert.fail("Should've thrown an exception when latitude greater than 90")
        } catch (e: InvalidParameterException) {
            assertEquals(e.message,"Latitude must be within -90.0 and 90.0. But it was %s".format(latitude))
            return
        }
        fail("Should've throw an exception with invalid Point  if latitude greater tha 90")
    }

    @Test
    fun `Throws exception if latitude lower than -90`() {
        val longitude = 80.0000001 // should be between -90.0 and 90.0
        val latitude = -90.04956798875554

        try {
            Point.create(longitude = longitude, latitude = latitude)
            junit.framework.Assert.fail("Should've thrown an exception when latitude lower than -90")
        } catch (e: InvalidParameterException) {
            assertEquals(e.message,"Latitude must be within -90.0 and 90.0. But it was %s".format(latitude))
            return

        }
        fail("Should've throw an exception with invalid Point  if latitude lower tha -90")
    }

}
package com.geolib.tests

import com.geolib.entities.Line
import com.geolib.entities.Point


fun mockLine(): Line {
    val startPoint = Point.create(-5.714722222222222, 51.08305555555556)
    val endPoint = Point.create(-3.0700000000000003, 58.64388888888889)
    val line = Line.create(startPoint, endPoint)
    return line
}

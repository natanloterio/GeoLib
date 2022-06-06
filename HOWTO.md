# Geo Library - How To

This is a quick take on How to Use this library

### Shapes
Every shape must to be properly initialized through its static `create` method. 
We are using it instead of the class direct constructor because if an wrong parameter
is passed into the constructur, an `InvalidParameterException` will happen. And it would leave the created instance of that class without reference causing unnecessary use of memory.

Allcoordinates are expressed as [WGS84 latitude and longitude, in degrees](https://pt.wikipedia.org/wiki/WGS84#:~:text=WGS%2084%20(World%20Geodetic%20System,revis%C3%A3o%20se%20deu%20em%202004).


## Point

Constructed with a latitude, longitude and elevation (default = 0.0) (distance from WGS84 ellipsoid).

`````
    val point = Point.create(4.0,3.0,0.0)`
`````

Throws `InvalidParameterException` if latitudes aren't in the range  [-90, 90]. But longitudes passed to this library (input) may be outside this range  [-180, 180> (left
inclusive, right exclusive) and are automatically wrapped to the range by the library.





## Line

Constructed from any 2 Points

`````
    val startPoint = Point.create(-5.714722222222222, 51.08305555555556)
    val endPoint = Point.create(-3.0700000000000003, 58.64388888888889)
    val line = Line.create(startPoint, endPoint)
`````


Lines have length in meters, and you can get it by calling:

`````
    val distance = line.distanceInMeters() 
`````



## PolyLine

Constructed from an ordered collection of 2 or more Points.

`````
    val startPoint = Point.create(40.0,10.0)
    val endPoint = Point.create(40.0,10.0)
    val listOfPoints = arrayListOf(startPoint, endPoint)
    val polyLine = PolyLine.create(listOfPoints)
`````


Has a function to get a 3D location anywhere along the PolyLine at a given a distance
measured from the origin of the PolyLine .

`````
    val distanceInMeters = 4000.0
    val pointAt = polyLine.getPointAtGivenDistanceInMeters(distanceInMeters)
`````

Also, you can get it as a list of lines

`````
    val listOfLines = polyLine.asList()
`````




## Rectangle

Constructed from 2 corner Points (South/West, North/East)

`````
    val startPoint = Point.create(-5.714722222222222, 51.08305555555556)
    val endPoint = Point.create(-3.0700000000000003, 58.64388888888889)
    val line = Line.create(startPoint, endPoint)
`````


You can test if a Point is contained within the rectangle (elevation is
disregarded in this case).

`````
    val southWestPoint = Point.create(-10.0,-10.0)
    val northEastPoint = Point.create(10.0,10.0)
    val targetPoint = Point.create(0.0,0.0)
    val rectangle = Rectangle.create(southWestPoint, northEastPoint)

    // returns true if the target point is within
    val pointIsWithin = rectangle.containsPoint(targetPoint)
`````




## Vector

Constructed from 3 distances, northbound and eastbound (specified in degrees), and a distance that specifies the change in elevation.

`````
    val vector = Vector.create(3.0,10.0,90.0)
`````


You can use the vector to translate any Shape:

`````
    point.translate(vector)
    line.translate(vector)
    polyline.translate(vector)
    rectangle.translate(vector)         

`````



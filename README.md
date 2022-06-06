# Geo Library - Interview Exercise

Geo Library is an geospatial library to define locations and trajectories on Earth as well as geospatial areas of different sizes and shapes for no-flying zones.

### Shapes
This library has the following shapes that will allow you tho create Points, Lines, Polylines, Rectangles. And also you will be able to translate those Shapes with any given Vector.


- Point: Represents any location on (or above) Earth.
- Line: Represents a straight line between 2 Points.
- PolyLine: Represents a segmented line between 2 or more Points. 
- Rectangle: Represents a rectangular area, defined by 2 corner 
- Vector: Points. Represents a 3D shift for translation of other 3D objects.

## Project Structure
This project a `application` folder, and the `geolib` folder which is the library itself.

```
Geolib/
├─ application/
├─ geolib/
├─ .gitignore
├─ README.md
```

## How to build

Clone it:

`git clone git@github.com:natanloterio/GeoLib.git `



Then get into the `geolib` folder and run build:

`cd  geolib && ./gradlew build`



### Publish it into Maven Local

Go into the `geolib` folder

Run the `publishToMavenLocal` task

`./gradlew publishToMavenLocal`

If everything goes well, you should have it now as a local library and you can use it 
as a dependency for your local projects. 

## Gradle configuration

Add the follow dependency into your `build.gradle` file

// build.gradle file
````
dependencies {
    implementation 'com.geolib:geolib:1.0.1-SNAPSHOT'
    ...
}
````










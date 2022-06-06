# Geo Library - Interview Exercise
@Author Natan Lotério

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

````sh
cd  geolib && ./gradlew build
````


### Publish it into Maven Local

Go into the `geolib` folder

Run the `publishToMavenLocal` task
````sh
./gradlew publishToMavenLocal
````

If everything goes well, you should have it now as a local library and you can use it 
as a dependency of your local projects. 

## Gradle configuration

Add the follow dependency into your `build.gradle` file

// build.gradle file
````
dependencies {
    implementation 'com.geolib:geolib:1.0.1-SNAPSHOT'
    ...
}
````

# How To

[See docs](HOWTO.md)

## License 

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

[READ FULL LICENSE](LICENSE.md)









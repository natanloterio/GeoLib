import com.geolib.entities.Line
import com.geolib.entities.Point

class Teste {
    init {
        val startPoint = Point.create(40.0,10.0)
        val endPoint = Point.create(40.0,10.5)

        print(Line.planeDistance(startPoint,endPoint))
    }

}
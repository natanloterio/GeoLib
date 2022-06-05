import com.geolib.entities.Point
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val startPoint = Point.create(-5.714722222222222, 51.08305555555556)
    val endPoint = Point.create(-3.0700000000000003, 58.64388888888889)
    //println(distFrom(startPoint.latitude.toFloat(),endPoint.latitude.toFloat(),startPoint.longitude.toFloat(),endPoint.longitude.toFloat())/1000)
    println(distFrom2(startPoint.latitude.toFloat(),endPoint.latitude.toFloat(),startPoint.longitude.toFloat(),endPoint.longitude.toFloat())/1000)

    val vectorLatitude = endPoint.latitude.to - startPoint.latitude
    val vectorLongitude = endPoint.longitude - startPoint.longitude

    val distanceBetween = distFrom2(startPoint.latitude.toFloat(),endPoint.latitude.toFloat(),startPoint.longitude.toFloat(),endPoint.longitude.toFloat())/1000
    val factor = endPoint.longitude / vectorLatitude

    val targetLatitude = startPoint.latitude * factor
    val targetLongitude = startPoint.longitude * factor
    val targetPoint = Point.create(latitude = targetLatitude, longitude = targetLongitude)
    val distanceCheck = distFrom2(startPoint.latitude.toFloat(),targetPoint.latitude.toFloat(),startPoint.longitude.toFloat(),targetPoint.longitude.toFloat())/1000
    println(distanceCheck)

}

fun distFrom(lat1: Float, lng1: Float, lat2: Float, lng2: Float): Float {
    val earthRadius = 6371000.0 //meters
    val dLat = Math.toRadians((lat2 - lat1).toDouble())
    val dLng = Math.toRadians((lng2 - lng1).toDouble())
    val a = sin(dLat / 2) * sin(dLat / 2) + cos(Math.toRadians(lat1.toDouble())) * cos(Math.toRadians(lat2.toDouble())) * sin(dLng / 2) * sin(dLng / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return (earthRadius * c).toFloat()
}


fun distFrom2(lat1: Float, lng1: Float, lat2: Float, lng2: Float): Double {
    val earthRadius = 6371000.0 //meters
    val figma1 = lat1.toRadians()
    val figma2 = lat2.toRadians()
    val lambda1 = lng1.toRadians()
    val lambda2 = lng2.toRadians()
    val dFigma = figma2 - figma1
    val dLambda = lambda2 - lambda1
    val a = sin(dFigma/2) * sin(dFigma/2) + cos(lat1) * cos(lat2) * sin(dLambda/2) * sin(dLambda/2);
    val c = 2 * atan2(sqrt(a), sqrt(1 - a));
    val d = earthRadius * c;
    return d
}

fun Float.toRadians(): Double = this * (Math.PI / 180)


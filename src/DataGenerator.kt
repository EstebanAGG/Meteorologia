import kotlin.random.Random

/**
 * Genera 10000 datos meteorológicos simulados
 */

val datosMeteorologicos: List<DataMeteo> = List(10000) {
    DataMeteo(
        Random.nextDouble(-50.0,50.0),
        Random.nextDouble(0.0,100.0),
        Random.nextInt(0,200)
    )
}
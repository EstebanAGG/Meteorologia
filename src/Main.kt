import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

suspend fun main() = withContext(Dispatchers.Default){
    val meteoData = datosMeteorologicos
    val tempMaxima = async { maximaTemperatura(meteoData) }
    val tempMinima = async { minimaTemperatura(meteoData) }
    val promedioTemp = async { promedioTemperatura(meteoData) }
    val humedadMaxima = async { humedadMaxima(meteoData) }
    val humedadMinima = async { humedadMinima(meteoData) }
    val vientoMaximo = async {maximoViento(meteoData) }
    val vientoMinimo = async { minimoViento(meteoData) }

    println("""TEMPERATURA:
        |Mínima: ${"%.2f".format(tempMinima.await())}
        |Máxima: ${"%.2f".format(tempMaxima.await())}
        |Promedio: ${"%.2f".format(promedioTemp.await())}
        |---------------------------------
        |HUMEDAD:
        |Mínima:${"%.2f".format(humedadMinima.await())}
        |Máxima: ${"%.2f".format(humedadMaxima.await())}
        |---------------------------------
        |VIENTO:
        |Mínimo: ${vientoMinimo.await()}
        |Máximo: ${vientoMaximo.await()}
    """.trimMargin())
}
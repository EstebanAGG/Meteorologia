import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val meteoData = datosMeteorologicos
    launch(Dispatchers.Default) {
        val tempMinima = async { minimaTemperatura(meteoData) }
        val humedadMin = async { humedadMinima(meteoData) }
        val tempMaxima = async { maximaTemperatura(meteoData) }
        val promedioTemp = async { promedioTemperatura(meteoData) }
        val humedadMaxima = async { humedadMaxima(meteoData) }
        val vientoMaximo = async { maximoViento(meteoData) }
        val vientoMinimo = async { minimoViento(meteoData) }
        println(
            """TEMPERATURA:
        |Mínima: ${"%.2f".format(tempMinima.await())}
        |Máxima: ${"%.2f".format(tempMaxima.await())}
        |Promedio: ${"%.2f".format(promedioTemp.await())}
        |---------------------------------
        |HUMEDAD:
        |Mínima:${"%.2f".format(humedadMin.await())}
        |Máxima: ${"%.2f".format(humedadMaxima.await())}
        |---------------------------------
        |VIENTO:
        |Mínimo: ${vientoMinimo.await()}
        |Máximo: ${vientoMaximo.await()}
    """.trimMargin()
        )
    }
}
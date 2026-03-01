import kotlinx.coroutines.*

fun main() {
    val meteoData = datosMeteorologicos

    var tempMinima = 0.0
    var humedadMin = 0.0

    runBlocking {
        launch { tempMinima = minimaTemperatura(meteoData) }
        launch { humedadMin = humedadMinima(meteoData) }
    }
    runBlocking {
        val tempMaxima = async { maximaTemperatura(meteoData) }
        val promedioTemp = async { promedioTemperatura(meteoData) }
        val humedadMaxima = async { humedadMaxima(meteoData) }
        val vientoMaximo = async { maximoViento(meteoData) }
        val vientoMinimo = async { minimoViento(meteoData) }

        println(
            """TEMPERATURA:
        |Mínima: ${"%.2f".format(tempMinima)}
        |Máxima: ${"%.2f".format(tempMaxima.await())}
        |Promedio: ${"%.2f".format(promedioTemp.await())}
        |---------------------------------
        |HUMEDAD:
        |Mínima:${"%.2f".format(humedadMin)}
        |Máxima: ${"%.2f".format(humedadMaxima.await())}
        |---------------------------------
        |VIENTO:
        |Mínimo: ${vientoMinimo.await()}
        |Máximo: ${vientoMaximo.await()}
    """.trimMargin()
        )
    }
}
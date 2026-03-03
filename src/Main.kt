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
        println("TEMPERATURA:")
        imprimirValor("Mínima:",tempMinima.await())
        imprimirValor("Máxima:",tempMaxima.await())
        imprimirValor("Promedio:",promedioTemp.await())
        println("---------------------------------")
        println("HUMEDAD:")
        imprimirValor("Minima:",humedadMin.await())
        imprimirValor("Maxima:",humedadMaxima.await())
        println("---------------------------------")
        println("VIENTO:")
        println("Mínimo: ${vientoMinimo.await()} ")
        println("Máximo: ${vientoMaximo.await()} ")
    }
}
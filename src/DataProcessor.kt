/**
 * Función asíncrona que calcula la suma de todos los datos de temperatura
 */
suspend fun sumaTemperatura(meteoData: List<DataMeteo>):Double{
    return meteoData.sumOf { it.temperatura }
}

/**
 * Devuelve la humedad máxima de la lista de datos meteorológicos
 */
suspend fun humedadMaxima(meteoData: List<DataMeteo>):Double{
    return meteoData.maxOf { it.humedad }
}

/**
 * Devuelve la humedad mínima de la lista
 */
suspend fun humedadMinima(meteoData: List<DataMeteo>):Double{
    return meteoData.minOf { it.humedad }
}

/**
 * Calcula el promedio de la temperatura
 */
suspend fun promedioTemperatura(meteoData: List<DataMeteo>):Double {
    return sumaTemperatura(meteoData)/meteoData.size
}

/**
 * Devuelve la máxima tempeeratura
 */
fun maximaTemperatura(meteoData: List<DataMeteo>):Double{
    return meteoData.maxOf { it.temperatura }
}

/**
 * Devuelve la mínima temepreatura
 */
suspend fun minimaTemperatura(meteoData: List<DataMeteo>):Double{
    return meteoData.minOf { it.temperatura }
}

/**
 * Devuelve el máximo viento
 */
suspend fun maximoViento(meteoData: List<DataMeteo>): Int{
    return meteoData.maxOf { it.velocidadViento }
}

/**
 * Devuelve el mínimo viento
 */
suspend fun minimoViento(meteoData: List<DataMeteo>):Int{
    return meteoData.minOf { it.velocidadViento }
}

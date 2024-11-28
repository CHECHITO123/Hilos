class Sensor(private val nombre: String) : Thread() {
    override fun run() {
        repeat(5) {
            println("$nombre está en ejecución.")
            try {
                Thread.sleep(500) // Simula un tiempo de espera
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        println("$nombre ha terminado.\n")
    }
}

fun main() {
    // Crear e iniciar los sensores como hilos
    val sensorTemperatura = Sensor("Sensor Temperatura")
    val sensorHumedad = Sensor("Sensor Humedad")
    val sensorPresion = Sensor("Sensor Presión")

    sensorTemperatura.start()
    sensorHumedad.start()
    sensorPresion.start()

    // Esperar a que terminen todos los sensores
    sensorTemperatura.join()
    sensorHumedad.join()
    sensorPresion.join()

    println("Todos los sensores han terminado.")
}

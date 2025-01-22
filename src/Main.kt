fun main(){
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(2000)

    var lista= listOf(
        "Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Gris",
        "Morado", "Negro", "Blanco", "Cian", "Rosa", "Turquesa",
        "Violeta", "Magenta", "Marrón", "Celeste", "Oliva", "Lila",
        "Dorado", "Plateado", "Beige", "Esmeralda", "Coral", "Marfil",
        "Lima", "Lavanda", "Terracota", "Fucsia", "Chocolate", "Ocre",
        "Granate", "Mostaza"
    )

    val palabra=lista.shuffled()[0]

    println("Bienvenido al juego del ahorcado, tienes 7 intentos para adivinar la palabra")

    var mascara=mutableListOf<Char>()

    for (i in palabra){
        mascara.add('*')
    }
    var intento=1

    while (intento != 7){
        var acierto=false
        print("La palabra que tienes que adivinar es: ")
        for (i in 0 until palabra.length){
            print(mascara[i].toString())
        }
        println()
        println("Intento numero $intento, te quedan ${7-intento} intentos.")
        println("Escribe la letra que deseas:")

        var letra= readln().lowercase()

        for (i in 0 until palabra.length) {
            if (letra[0] == palabra.lowercase()[i]) {
                mascara[i] = palabra[i]
                acierto=true
            }
        }
        var palabraComparable=""
        for (i in 0 until palabra.length){
            palabraComparable=palabraComparable+mascara[i]
        }
        if(palabraComparable==palabra){
            println("¡Enhorabuena has adivinado la palabra!")
            break
        }
        if (!acierto){
            intento++
            DibujoAhorcado.dibujar(intento)
        }
        if (intento == 7) {
            println("¡Lo siento! Has agotado tus intentos. La palabra era: $palabra")
        }
    }
    rm.cerrar()
}
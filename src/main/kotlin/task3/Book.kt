package task3

class Book(val name: String,
           private val info: List<InformationType>
) {
    private var isOpen = false

    fun open(human: Human): List<InformationType> {
        isOpen = true
        println("$name открыта ${human.name}")
        return info
    }

    fun close(human: Human) : String {
        if (isOpen) {
            isOpen = false
            return ("${human.name} закрыл $name.")
        } else {
            throw Exception("$name уже закрыта.")
        }
    }
}
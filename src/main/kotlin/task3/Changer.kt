package task3

class Changer(name: String) : Human(name) {
    override fun read(book: Book) : Boolean{
        if (book.name == "Путеводитель по галактике для автостопщиков") {
            println("Редактор $name заинтересован в книге ${book.name}")
            return true
        } else {
            println("Редактор $name не заинтересован в книге ${book.name}")
            return false
        }
    }
}
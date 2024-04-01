package task3


open class Human(val name: String) {

    fun chooseBook(books: List<Book>) : Book {
        val book = books.random()
        println("$name выбрал книгу ${book.name}")
        return book
    }

    open fun read(book: Book) : Boolean{
        val info = book.open(this)

        val interestingCount = info.count { it == InformationType.INTERESTING }

        if (interestingCount > 0) {
            println("Читатель $name заинтересовался в книге ${book.name}")
        } else {
            println("Читатель $name не нашел ничего интересного в книге {$book.name}")
        }

        book.close(this)
        return interestingCount > 0
    }
}
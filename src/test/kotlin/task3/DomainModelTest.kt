package task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DomainModelTest {

    private val books = arrayOf(
        Book("Гарри Поттер", listOf(InformationType.INTERESTING, InformationType.BORING)),
        Book("Путеводитель по галактике для автостопщиков", listOf(InformationType.INTERESTING, InformationType.INTERESTING)),
        Book("Крестный отец", listOf(InformationType.BORING, InformationType.BORING))
    )

    @Test
    fun `test book open and close`() {
        val book = books[0]
        val human = Human("Алексей")

        val info = book.open(human)
        assertEquals(2, info.size)
        assertEquals("Гарри Поттер", book.name)

        val closeMessage = book.close(human)
        assertEquals("Алексей закрыл Гарри Поттер.", closeMessage)
    }

    @Test
    fun `test changer reads book`() {
        val changer = Changer("Алексей")
        val book = books[1]

        val isInterested = changer.read(book)
        assertTrue(isInterested)
    }

    @Test
    fun `test human chooses and reads book`() {
        val human = Human("Алексей")
        val chosenBook = human.chooseBook(books.toList())
        val info = chosenBook.open(human)
        val count = info.count { it == InformationType.INTERESTING } > 0
        val isInterested = human.read(chosenBook)
        assertEquals(isInterested, count)
    }

    @Test
    fun `test book close exception`() {
        val book = books[0]
        val human = Human("Алексей")

        assertThrows<Exception> { book.close(human) }
    }
}

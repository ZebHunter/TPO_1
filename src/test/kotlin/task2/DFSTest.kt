package task2
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GraphTests {
    companion object {
        private lateinit var allVertexes : ArrayList<Node>

        init {
            val node0 = Node(ArrayList())
            val node1 = Node(ArrayList())
            val node2 = Node(ArrayList())
            val node3 = Node(ArrayList())
            val node4 = Node(ArrayList())
            val node5 = Node(ArrayList())
            val node6 = Node(ArrayList())
            val node7 = Node(ArrayList())
            val node8 = Node(ArrayList())
            val node9 = Node(ArrayList())
            val node10 = Node(ArrayList())

            node0.child.addAll(listOf(node1, node2, node3))
            node1.child.addAll(listOf(node2, node3))
            node2.child.addAll(listOf(node7))
            node4.child.addAll(listOf(node8, node9))
            node5.child.addAll(listOf(node6))
            node7.child.addAll(listOf(node1, node5))
            node9.child.addAll(listOf(node4, node8))

            allVertexes =
                ArrayList(listOf(node0, node1, node2, node3, node4, node5, node6, node7, node8, node9, node10))
        }
    }


    @Test
    fun `traverse graph starting from node 2`() {
        val array : Array<Int> = arrayOf(2, 7, 5, 6, 1, 3)
        val result : ArrayList<Int> = ArrayList()

        DFS.traverseStartingWith(allVertexes[2], action = {result.add(it.number)})
        print(result)
        assertTrue(array contentEquals result.toArray())
    }

    @Test
    fun `traverse graph starting from node 3 (one element)`() {
        val array : Array<Int> = arrayOf(3)
        val result : ArrayList<Int> = ArrayList()

        DFS.traverseStartingWith(allVertexes[3], action = {result.add(it.number)})
        print(result)
        assertTrue(array contentEquals result.toArray())
    }

    @Test
    fun `traverse graph starting from node 7`() {
        val array : Array<Int> = arrayOf(7, 5, 6, 1, 3, 2)
        val result : ArrayList<Int> = ArrayList()

        DFS.traverseStartingWith(allVertexes[7], action = {result.add(it.number)})
        print(result)
        assertTrue(array contentEquals result.toArray())
    }

    @Test
    fun `traverse graph starting from node 1`() {
        val array : Array<Int> = arrayOf(1, 3, 2, 7, 5, 6)
        val result : ArrayList<Int> = ArrayList()

        DFS.traverseStartingWith(allVertexes[1], action = {result.add(it.number)})
        print(result)
        assertTrue(array contentEquals result.toArray())
    }
}
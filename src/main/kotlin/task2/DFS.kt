package task2

import kotlin.collections.ArrayList
import java.util.*

class Node(val child: ArrayList<Node> = ArrayList()){
    companion object {
        private var num : Int = -1
    }

    val number = ++num
}

object DFS {
    fun traverseStartingWith(
        start: Node,
        action: (Node) -> Unit = {}
    ) {
        val visited : ArrayList<Node> = ArrayList()
        val following : ArrayDeque<Node> = ArrayDeque()

        following.push(start)

        while (!following.isEmpty()) {
            val cur = following.pop()
            visited.add(cur)
            action(cur)

            for (child in cur.child) {
                if (!visited.contains(child)) {
                    following.push(child)
                }
            }
        }
    }
}
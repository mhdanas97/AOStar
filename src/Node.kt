import java.util.*

class Node(val name: String, val heuristic: Int, val final: Boolean, val operators: PriorityQueue<Operator>) {
    fun solve(originalFlag: Boolean): Boolean {
        if (final) {
            if (originalFlag) println("Solved for node $name")
            return true
        }
        if (operators.isEmpty()) return false
        while (operators.isNotEmpty()) {
            val operator = operators.poll()
            var andChildren = true
            for (child: Node in operator.andNodes) {
                if (!child.solve(false)) {
                    andChildren = false
                    break
                }
            }
            if (andChildren) {
                if (originalFlag) println("Solved for node $name")
                return true
            }
        }
        return false
    }
}
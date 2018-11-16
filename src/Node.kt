import java.util.*

class Node(val name: String, val heuristic: Int, val final: Boolean, val operators: PriorityQueue<Operator>, var cost: Int?) {

    fun solve(parentOperator: Operator?): Boolean {
        if (this.cost == null) this.cost = parentOperator?.cost

        if (final) {
            if (parentOperator == null) println("Solved for node $name")
            return true
        }

        if (operators.isEmpty()) return false

        while (operators.isNotEmpty()) {
            val operator: Operator = operators.poll()
            val originalCost: Int = if (operator.visited) operator.cost else
                operator.cost + operator.andNodes.sumBy { it.heuristic }

            operator.visited = true
            operator.cost += this.cost as Int
            var andChildren = true

            for (child: Node in operator.andNodes) {
                if (!child.solve(operator)) {
                    andChildren = false
                    break
                }

            }


            if (operator.cost < originalCost) operators.add(operator)

            if (andChildren) {
                if (parentOperator == null) println("Solved for node $name")

                return true
            }

        }
        return false
    }
}
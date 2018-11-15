import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {
    val operatorComparator: Comparator<Operator> = kotlin.Comparator { o1: Operator, o2: Operator ->
        when (o1.visited) {
            true -> o1.cost
            else -> o1.cost + o1.andNodes.sumBy { it.heuristic }
        } - when (o2.visited) {
            true -> o2.cost
            else -> o2.cost + o2.andNodes.sumBy { it.heuristic }
        }
    }
    val p0 = Node("P0", 0, false, PriorityQueue(operatorComparator), 0)
    val p1 = Node("P1", 0, true, PriorityQueue(operatorComparator), null)
    val p2 = Node("P2", 50, false, PriorityQueue(operatorComparator), null)
    val p3 = Node("P3", 28, false, PriorityQueue(operatorComparator), null)
    val p4 = Node("P4", 40, false, PriorityQueue(operatorComparator), null)
    val p5 = Node("P5", 0, true, PriorityQueue(operatorComparator), null)
    val p6 = Node("P6", 0, true, PriorityQueue(operatorComparator), null)
    val p7 = Node("P7", 30, false, PriorityQueue(operatorComparator), null)
    val p8 = Node("P8", 22, false, PriorityQueue(operatorComparator), null)
    val p9 = Node("P9", 20, false, PriorityQueue(operatorComparator), null)
    val p10 = Node("P10", 30, false, PriorityQueue(operatorComparator), null)
    val p11 = Node("P11", 15, false, PriorityQueue(operatorComparator), null)
    val p12 = Node("P12", 15, false, PriorityQueue(operatorComparator), null)
    val p13 = Node("P13", 0, true, PriorityQueue(operatorComparator), null)
    val p14 = Node("P14", 0, true, PriorityQueue(operatorComparator), null)
    val p15 = Node("P15", 0, true, PriorityQueue(operatorComparator), null)

    p0.operators.add(
            Operator("P1P2", 5 + p1.heuristic + p2.heuristic, p0, arrayListOf(p1, p2), false)
    )
    p0.operators.add(
            Operator("P3", 19 + p3.heuristic, p0, arrayListOf(p3), false)
    )
    p0.operators.add(
            Operator("P4P5", 8 + p4.heuristic + p5.heuristic, p0, arrayListOf(p4, p5), false)
    )
    p2.operators.add(
            Operator("P15P10", 5 + p15.heuristic + p10.heuristic, p2, arrayListOf(p15, p10), false)
    )
    p3.operators.add(
            Operator("P6P7", 20 + p6.heuristic + p7.heuristic, p3, arrayListOf(p6, p7), false)
    )
    p3.operators.add(
            Operator("P8P9", 10 + p8.heuristic + p9.heuristic, p3, arrayListOf(p8, p9), false)
    )
    p4.operators.add(
            Operator("P10", 10 + p10.heuristic, p4, arrayListOf(p10), false)
    )
    p4.operators.add(
            Operator("P11P12", 20 + p11.heuristic + p12.heuristic, p4, arrayListOf(p11, p12), false)
    )
    p10.operators.add(
            Operator("P13P14P6", 45 + p13.heuristic + p14.heuristic + p6.heuristic
                    , p10, arrayListOf(p13, p14, p6), false)
    )
    println(p0.solve(null))
}
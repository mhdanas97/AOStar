import java.util.*

fun main(args: Array<String>) {
    val operatorComparator = Comparator { a: Operator, b: Operator ->
        (a.cost + a.andNodes.sumBy { it.heuristic })
        -(b.cost + b.andNodes.sumBy { it.heuristic })
    }
    val p0 = Node("P0", 0, false, PriorityQueue(operatorComparator))
    val p1 = Node("P1", 0, true, PriorityQueue(operatorComparator))
    val p2 = Node("P2", 50, false, PriorityQueue(operatorComparator))
    val p3 = Node("P3", 28, false, PriorityQueue(operatorComparator))
    val p4 = Node("P4", 40, false, PriorityQueue(operatorComparator))
    val p5 = Node("P5", 0, true, PriorityQueue(operatorComparator))
    val p6 = Node("P6", 0, true, PriorityQueue(operatorComparator))
    val p7 = Node("P7", 30, false, PriorityQueue(operatorComparator))
    val p8 = Node("P8", 22, false, PriorityQueue(operatorComparator))
    val p9 = Node("P9", 20, false, PriorityQueue(operatorComparator))
    val p10 = Node("P10", 30, false, PriorityQueue(operatorComparator))
    val p11 = Node("P11", 15, false, PriorityQueue(operatorComparator))
    val p12 = Node("P12", 15, false, PriorityQueue(operatorComparator))
    val p13 = Node("P13", 0, true, PriorityQueue(operatorComparator))
    val p14 = Node("P14", 0, true, PriorityQueue(operatorComparator))
    val p15 = Node("P15", 0, true, PriorityQueue(operatorComparator))

    p0.operators.add(
            Operator("P1P2", 5, p0, arrayListOf(p1, p2))
    )
    p0.operators.add(
            Operator("P3", 19, p0, arrayListOf(p3))
    )
    p0.operators.add(
            Operator("P4P5", 8, p0, arrayListOf(p4, p5))
    )
    p2.operators.add(
            Operator("P15P10", 5, p2, arrayListOf(p15, p10))
    )
    p3.operators.add(
            Operator("P6P7", 20, p3, arrayListOf(p6, p7))
    )
    p3.operators.add(
            Operator("P8P9", 10, p3, arrayListOf(p8, p9))
    )
    p4.operators.add(
            Operator("P10", 10, p4, arrayListOf(p10))
    )
    p4.operators.add(
            Operator("P11P12", 20, p4, arrayListOf(p11, p12))
    )
    p10.operators.add(
            Operator("P13P14P6", 45, p10, arrayListOf(p13, p14, p6))
    )
    println(p0.solve(true))
}
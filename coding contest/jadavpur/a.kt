fun main() {
    val problemTimes = readLine()?.split(" ")?.map { it.toInt() } ?: return
    println(solveAllProblems(problemTimes))
}

fun solveAllProblems(problemTimes: List<Int>): String {
    if (problemTimes.size != 4) return "NO"
    
    val sortedTimes = problemTimes.sortedDescending()
    
    if (sortedTimes[0] > 90) return "NO"
    
    val option1 = maxOf(sortedTimes[0], sortedTimes[1], sortedTimes[2] + sortedTimes[3])
    
    val option2 = maxOf(sortedTimes[0] + sortedTimes[3], sortedTimes[1], sortedTimes[2])
    
    val option3 = maxOf(sortedTimes[0], sortedTimes[1] + sortedTimes[3], sortedTimes[2])
    
    val option4 = maxOf(sortedTimes[0], sortedTimes[1], sortedTimes[2] + sortedTimes[3])
    
    val minTime = minOf(option1, option2, option3, option4)
    
    return if (minTime <= 90) "YES" else "NO"
}
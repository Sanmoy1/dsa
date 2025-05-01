fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    
    val result = IntArray(n + 1)
    
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val diff = Math.abs(a[i] - a[j])
            
            for (k in 1..n) {
                if (diff % k == 0) {
                    result[k]++
                }
            }
        }
    }
    
    println(result.slice(1..n).joinToString(" "))
}
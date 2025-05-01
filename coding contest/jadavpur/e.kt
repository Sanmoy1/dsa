fun main() {
    val n = readLine()!!.toInt()
    val maze = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    
    val dp = Array(n) { Array(n) { LongArray(2) { 0 } } }
    
    dp[0][0][0] = 1
    dp[0][0][1] = maze[0][0].toLong()
    
    val mod = 1_000_000_007L
    
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == 0 && j == 0) continue
            
            if (j > 0 && (maze[i][j-1] == 1 || maze[i][j-1] == 3)) {
                dp[i][j][0] = (dp[i][j][0] + dp[i][j-1][0]) % mod
                dp[i][j][1] = maxOf(dp[i][j][1], dp[i][j-1][1] + maze[i][j])
            }
            
            if (i > 0 && (maze[i-1][j] == 2 || maze[i-1][j] == 3)) {
                dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][0]) % mod
                dp[i][j][1] = maxOf(dp[i][j][1], dp[i-1][j][1] + maze[i][j])
            }
        }
    }
    
    println("${dp[n-1][n-1][0]} ${dp[n-1][n-1][1]}")
}
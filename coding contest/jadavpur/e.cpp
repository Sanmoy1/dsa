#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    vector<vector<int>> marks(N, vector<int>(N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> marks[i][j];
        }
    }
    
    const long long MOD = 1000000007;
    
    vector<vector<long long>> dp(N, vector<long long>(N, 0));
    vector<vector<int>> max_dp(N, vector<int>(N, 0));
    
    dp[0][0] = 1;
    max_dp[0][0] = marks[0][0];
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (i == 0 && j == 0) continue;
            
            long long ways = 0;
            int max_prev = -1;
            
            if (j > 0 && (marks[i][j-1] == 1 || marks[i][j-1] == 3)) {
                ways += dp[i][j-1];
                max_prev = max(max_prev, max_dp[i][j-1]);
            }
            
            if (i > 0 && (marks[i-1][j] == 2 || marks[i-1][j] == 3)) {
                ways += dp[i-1][j];
                max_prev = max(max_prev, max_dp[i-1][j]);
            }
            
            dp[i][j] = ways % MOD;
            if (ways > 0) {
                max_dp[i][j] = marks[i][j] + max_prev;
            }
        }
    }
    
    cout << dp[N-1][N-1] << " " << max_dp[N-1][N-1] << endl;
    
    return 0;
}
import sys

MOD = 998244353

def solve():
    # Reading input using sys.stdin.read for fast input handling
    input = sys.stdin.read
    data = input().splitlines()

    # Reading n and k
    n, k = map(int, data[0].split())
    
    # Reading the attack powers and health values
    a = list(map(int, data[1].split()))  # attack powers of the monsters
    h = list(map(int, data[2].split()))  # health values of the monsters

    # Calculate the total damage CJ will take
    total_damage = 0
    total_rounds = []

    # Calculate the number of rounds each monster survives
    for i in range(n):
        rounds = (h[i] + k - 1) // k  # ceil(h[i] / k)
        total_rounds.append(rounds)

    # Now we calculate the total damage for each round where monsters are still alive
    for i in range(n):
        total_damage += a[i] * total_rounds[i]  # monster's total contribution to CJ's health

    # Output the total damage modulo 998244353
    print(total_damage % MOD)

# Run the function
solve()
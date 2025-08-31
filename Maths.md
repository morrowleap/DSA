Problem Solving Strategy

- Read problem and constraints.
Read the problem statement.
Identify constraints and requirements.
Clarify assumptions and ambiguities.

- Simplify for intuition.
Break down the problem into simpler parts.
Write pseudocode for better structure.

- Write code.
Implement the solution.
Focus on variable names and modularity.

- Test all cases.
Dry run with sample inputs (e.g., 5342, 3478).
Check for edge cases and refine if necessary.

- Refine if needed.
Analyze time and space complexity.
Refactor for optimization if needed.

- Submit.
Validate correctness.
Submit and review.

---

Notes on Progress

- Speed: Practice with a timer.

- Focus: Eliminate distractions, track improvements.

- Correctness: Improved understanding and debugging.

---

Learning Focus Areas

Today:
Backtracking, Heaps

Tomorrow:
Graphs

Day After Tomorrow:
Dynamic Programming (DP)

Key Topics to Master
Data Structures:

Union-Find / Disjoint Set (important)
Interval Trees (less critical)
Problem Types:

Array, Hashing
2-pointer, Sliding window
Trees, Linked Lists
Algorithmic Techniques:

Backtracking (Sudoku Solver, Valid Sudoku)
Randomness in Playlist Shuffle




## Mathematical Algorithms and Code Snippets

### 1. Highest Common Factor (HCF) - Using Euclidean's Algorithm
The Euclidean algorithm is a method for finding the greatest common divisor (GCD) of two integers. The key idea is to repeatedly replace the larger number with its remainder when divided by the smaller number, until the remainder is zero.

```cpp
int gcd(int a, int b) {
    if (a == 0) {
        return b;
    }
    return gcd(b % a, a);
}
```

- **Explanation**:  
  - `b % a` finds the remainder of `b` divided by `a`.
  - Replace `b` with `a` and `a` with the remainder, and continue the process.
  - The function stops when `a` becomes 0, and `b` holds the GCD.

### 2. Lowest Common Multiple (LCM)
The LCM of two numbers can be derived using the formula:

LCM(a, b) = |a × b| / GCD(a, b)

### 3. Iterating Over Neighboring Cells in a 2D Grid
This code snippet shows how to iterate over adjacent cells (up, down, left, right) in a 2D grid.

```cpp
vector<int> roww = {1, -1, 0, 0}; // Row offsets
vector<int> coll = {0, 0, -1, 1}; // Column offsets

for (int i = 0; i < 4; i++) {
    int newX = x + roww[i];
    int newY = y + coll[i];
    cout << grid[newX][newY];
}
```

- **Explanation**:  
  - `roww` and `coll` are used to adjust the current cell's coordinates (`x, y`) to access its neighbors.
  - This snippet accesses the four neighbors of cell `(x, y)`.

### 4. Roman Numerals
Roman numerals are represented by seven different symbols and their values:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

#### Rules:
1. **Combining Symbols**:  
   Symbols are generally placed in descending order. When a smaller symbol precedes a larger symbol, it is subtracted (e.g., IV = 4). When a smaller symbol follows a larger symbol, it is added (e.g., VI = 6).

2. **Repetition Rules**:  
   The same symbol cannot be repeated more than three times in a row. Symbols like V, L, and D are never repeated.

3. **Subtractive Rules**:  
   Subtractive notation only allows one smaller numeral to precede a larger one, such as "IV" (4) or "IX" (9).

#### Example Code Snippet:
```java
public static final Map<Character, Integer> romanValues = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
```

### 5. ASCII Values of Digits [0 – 9]
The ASCII values for digits range from 48 ('0') to 57 ('9').

#### Example Code Snippet:
```cpp
bool isDigit(char ch) {
    return (int)ch >= 48 && (int)ch <= 57;
}
```

### 6. Sudoku Box Index Calculation
The following expression determines which of the nine 3x3 boxes a cell belongs to on a 9x9 Sudoku board:

```cpp
int k = i / 3 * 3 + j / 3;
```

- **Explanation**:  
  - `i / 3`: Divides the row index `i` by 3. This maps rows 0-2, 3-5, and 6-8 into 0, 1, and 2, respectively.
  - `* 3`: Sets the base index for rows of boxes (0, 3, or 6).
  - `j / 3`: Divides the column index `j` by 3, categorizing columns into 0, 1, and 2.
  
This is useful in the context of Sudoku validation to find the 3x3 sub-box of a cell.

### 7. Check if a Character is Alphanumeric
```cpp
bool isAlphanumeric(char c) {
    return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
}
```

### 8. Convert Character to Lowercase
```cpp
char lowerCase(char ch) {
    if (ch >= 'A' && ch <= 'Z') {
        return ch + ('a' - 'A');
    }
    return ch;
}
```
```java
static char lowerCase(char ch) {
    if (ch >= 'A' && ch <= 'Z') {
        return (char) (ch + ('a' - 'A'));
    }
    return ch;
}
```

- **Explanation**:  
  - If the character is an uppercase letter, convert it to lowercase by adjusting its ASCII value.


### 9. Removing Absolute Value from an Inequality  
The inequality |i - j| ≤ k can be converted to:  

|i - j| ≤ k

-k ≤ (i - j) ≤ k

-i - k ≤ -j ≤ -i + k

i + k ≥ j ≥ i - k


### 10. Fast Exponentiation Using Recursive Method (Java)
```java
private static final long MOD = 1000000007;

long myPow(long x, long n) {
    if (n == 0) {
        return 1;
    }
    x = x % MOD;
    if (n % 2 == 0) {
        return myPow((x * x) % MOD, n / 2);
    } else {
        return (x * myPow(x, n - 1)) % MOD;
    }
}
```

### 11. Odd and Even Indices Calculation
```java
long oddIndices = n / 2;
long evenIndices = n - oddIndices; // Equivalent to n/2 + n%2
```
oddIndices represents half of n.

evenIndices adjusts for the remaining elements, handling odd values of n by adding n % 2.


```java
static int countDigit(int n) {
        return (int)Math.floor(Math.log10(n) + 1);
    }
```

https://leetcode.com/problems/count-good-numbers/

---


Bit Manipulation

Sieve of Erathosness

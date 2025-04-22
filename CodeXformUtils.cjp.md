> **Note**: When describing the methods of a data structure, I would use the following logical order:
> 
> 1. **Declaration and Initialization**: How to declare and initialize the data structure.
>    - Constructor methods
>    - Initialization examples
> 
> 2. **Insertion and Addition**: Methods or operations used to add elements to the data structure.
>    - `add()`, `insert()`, `push()`, etc.
> 
> 3. **Access and Retrieval**: Methods to access or retrieve elements without modifying the data structure.
>    - Indexing, element access (`get()`), size retrieval (`size()`, `length()`), etc.
> 
> 4. **Update and Modification**: Methods to modify elements within the data structure.
>    - Update (`set()`), replace, etc.
> 
> 5. **Deletion and Removal**: Methods to remove elements from the data structure.
>    - `delete()`, `remove()`, `pop()`, `clear()`, etc.
> 
> 6. **Traversal and Iteration**: Methods for iterating over or traversing the data structure.
>    - Looping through elements (e.g., `forEach()` or custom iterator methods).
> 
> 7. **Utility Operations**: Other useful operations that do not fit into the above categories but enhance the functionality.
>    - Sorting (`sort()`), reversing (`reverse()`), finding (`find()`), searching (`contains()`), checking emptiness (`isEmpty()`).
> 
> 8. **Special Methods or Advanced Operations**: Any additional methods that provide specialized functionality.
>    - Copying (`copy()`), merging, transformation, balancing (in case of trees), etc.
> 
> 9. **Destruction or Cleanup**: Methods related to memory management or cleanup, if applicable.
>    - Destructor (in languages with manual memory management, e.g., `delete` in C++).
> 
> This order helps ensure a logical flow from setting up the data structure to managing its lifecycle and accessing its elements, making it easier for someone to understand how to use it effectively.

# Insights
  - [Short-circuit evaluation in Programming](https://www.geeksforgeeks.org/short-circuit-evaluation-in-programming/)
  - [Pointers](https://youtu.be/2ybLD6_2gKM)
  - [Yoda Conditions](https://en.wikipedia.org/wiki/Yoda_conditions)

# ASCII
<table>
<tr>
<th>C++</th>
<th>Java</th>
<th>Python</th>
</tr>
<tr>
<td>

```cpp
// Get ASCII code
int ascii = static_cast<int>(c);
int ascii = (int)c;

// Convert ASCII to character
char c = static_cast<char>(ascii);
char c = (char)ascii;
```

</td>
<td>

```java
// Get ASCII code
int ascii = (int) c;

// Convert ASCII to character
char c = (char) ascii;
```

</td>
<td>

```python
# Get ASCII code
ascii = ord(c)

# Convert ASCII to character
c = chr(ascii)
```

</td>
</tr>
</table>

# Basics
<table>
<tr>
<th>C++</th>
<th>Java</th>
<th>Python</th>
</tr>
<tr>
<td>

```cpp
// Integer Min max
#include <limits>
INT_MIN
INT_MAX

// To Int
int x = (int)ch - 48;
int x = ch - '0';
int x = ch; // narrowing on C

// Int to Float
float myFloat = myInt * 1.0f;

// To String
to_string(num)

// Float Division
float ans = (float)a / (float)b;

// Sqrt
#include <cmath>
sqrt(x);

// Max
max(a, b);
max({a, b, c});// max of 3 numbers 
*max_element(arr, arr + n);

// Sum
accumulate(arr, arr + n, 0);

// Floor, Ceil
#include <cmath>
floor(num), ceil(num)

// Absolute
#include <cmath>
abs(number)
fabs(floatNumber)

// Object Check
// C++ lacks built-in object identity like Java/Python 
// because it doesn't have garbage-collected objects 
// or a universal object superclass. 
// However, you can check if two pointers/references refer to the same memory address, 
// effectively checking if they are the same object.
MyClass obj1;
MyClass obj2;
MyClass* ptr1 = &obj1;
MyClass* ptr2 = &obj1;

ptr1 == ptr2 // true

// Pow
#include <cmath>
pow(base, exponent);

// MOD
const int MOD = 1000000007;

// Reference Variable / Pass by reference
void modify(int& x)
```

</td>
<td>

```java
// Integer Min max
Integer.MIN_VALUE
Integer.MAX_VALUE

// To Int
(int)x
int a = ch - '0';

// Int to Float
float myFloat = myInt * 1.0f;

// To String
Integer.toString(num);

// Sqrt
import java.lang.Math;
Math.sqrt(x);

// Max
Math.max(a, b);
Math.max(Math.max(a, b), c);
Arrays.stream(arr).max()

// Sum
Arrays.stream(arr).sum();

// Floor, Ceil
Math.floor(num), Math.ceil(num)

// Absolute
Math.abs(number)

// Object Check
// Java inherently supports object identity through references. Using the == operator on object references checks if they point to the same object in memory.
MyClass obj1 = new MyClass();
MyClass obj2 = new MyClass();
MyClass obj3 = obj1;

obj1 == obj2 // false

obj1 == obj3 // true

// Pow
Math.pow(base, exponent);

// MOD
private static final int MOD = 1000000007;
```

</td>
<td>

```python
# Integer Min max
int(-(2**31))
int(2**31 - 1)

# To Int
int(x)

# Int to Float
my_float = my_int * 1.0

# To String
str(num)

# Integer Division
result = a // b

# Sqrt
import math
math.sqrt(x)

# Max
max(a, b)
max(a, b, c)
max(arr)

# Sum
sum(arr)

# Decrementing Loop
for i in range(10, 0, -1):
    print(i)

# Floor, Ceil
import math
math.floor(4.2), math.ceil(4.2)

# divmod, quotient = dividend / divisor; remainder = dividend % divisor;
quotient, remainder = divmod(dividend, divisor)
n, digit = divmod(n, 10)

# Absolute
abs(number)

# Object Check
obj1 = MyClass()
obj2 = MyClass()
obj3 = obj1

if obj1 is obj2: # false
if obj1 is obj3: # true

# Pow
pow(base, exponent)

# MOD
MOD = 1000000007
```

</td>
</tr>
</table>


# Constructors
<table>
<tr>
<th>C++</th>
<th>Java</th>
<th>Python</th>
</tr>
<tr>
<td>

```cpp
class Example {
private:
    int value;
    vector<vector<int>> matrix;
    stack<int> s;

public:
    // Default constructor (explicitly using = default)
    Example() = default;

    // Parameterized constructor with an initializer list for matrix initialization
    Example(int val, int size) : value(val), matrix(size, vector<int>(size, 0)) {}

    // Parameterized constructor accepting an existing matrix
    Example(int val, vector<vector<int>> mat) : value(val), matrix(mat) {}

    // Parameterized constructor accepting a stack
    Example(int val, stack<int> stk) : value(val), s(stk) {}
};
```

</td>
<td>

```java
public class Example {
    int value;
    List<Integer> numbers;

    public Example(int val, List<Integer> nums) {
        this.value = val;
        this.numbers = new ArrayList<>(nums);
    }
}
```

</td>
<td>

```python
class Example:
    def __init__(self, val, nums):
        self.value = val
        self.numbers = nums.copy()  # Assuming nums is a list, .copy() ensures a new list is created
```

</td>
</tr>
</table>


# Pairs
<table>
<tr>
<th>C++</th>
<th>Java</th>
<th>Python</th>
</tr>
<tr>
<td>

```cpp
// Declaration
#include <utility>
pair<int, string> myPair;
```

</td>
<td>

```java
// Declaration https://www.geeksforgeeks.org/creating-a-user-defined-printable-pair-class-in-java/
static class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
    static Pair of(int first, int second) {
        return new Pair(first, second);
    }
}
Pair p = Pair.of(i + 1, i + 2);
```

</td>
<td>

```python
# Declaration
my_pair = (1, "Apple")
```

</td>
</tr>
</table>


# String
<table>
<tr>
<th>C++</th>
<th>Java</th>
<th>Python</th>
</tr>
<tr>
<td>

```cpp
// /* Unlike Java's String, which is immutable,
//    C++'s std::string is mutable and allows in-place modifications. */

// // Include necessary headers
// #include <string>
// #include <algorithm> // for sort and transform

// // Declaration
// string str = "Hello, World!";

// // Length
// str.length();

// // Indexing
// str[index];

// // Access last element
// str.back(); str[str.length() - 1];

// // Sorting
// sort(str.begin(), str.end());

// // Iterate
// for (char ch : str);

// // Substring
// str.substr(start_index, length);

// // To lower case (entire string)
// transform(str.begin(), str.end(), str.begin(), ::tolower);

// // To lower case (single character)
// tolower(c);

// // Append
// str += " Additional Text";

// // Insert
// str.insert(position, "Inserted Text");

// // Update
// str[position] = 'X';

// // Delete
// str.erase(start_position, length);

// // Clear
// str.clear();

// // Remove last element
// str.pop_back();
```

</td>
<td>

```java
// // Declaration
// String str = "Hello, World!";
// StringBuilder sb = new StringBuilder("Hello, World!");

// // Compare strings
// boolean result = str.equals(str2);
// boolean sbResult = sb1.toString().equals(sb2.toString());

// // Length
// int strLength = str.length();
// int sbLength = sb.length();

// // Indexing
// char ch = str.charAt(index);
// char sbCh = sb.charAt(index);

// // Sorting
// char[] strCharArray = str.toCharArray();
// Arrays.sort(strCharArray);
// String sortedStr = new String(strCharArray);

// char[] sbCharArray = sb.toString().toCharArray();
// Arrays.sort(sbCharArray);
// sb = new StringBuilder(new String(sbCharArray));

// // Iterate
// for (char c : str.toCharArray()) {
//     // Process c
// }

// for (int i = 0; i < sb.length(); i++) {
//     char c = sb.charAt(i);
//     // Process c
// }

// // Substring
// String substr = str.substring(startIndex, endIndex);
// String sbSubstr = sb.substring(startIndex, endIndex);
// StringBuilder sbSub = new StringBuilder(sb.substring(startIndex, endIndex));

// // String to char array
// char[] arr = str.toCharArray();
// char[] sbArr = sb.toString().toCharArray();

// // Char array to String/StringBuilder
// String strFromArr = String.valueOf(arr);
// StringBuilder sbFromArr = new StringBuilder().append(arr);

// // To lower case
// String lowerStr = str.toLowerCase();
// char lowerChar = Character.toLowerCase(c);

// for (int i = 0; i < sb.length(); i++) {
//     sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
// }

// // Append
// str += " Additional Text";
// sb.append(" Additional Text");

// // Insert
// String strInserted = str.substring(0, index) + "Inserted Text" + str.substring(index);
// sb.insert(index, "Inserted Text");

// // To convert StringBuilder to String
// String strFromSb = sb.toString();

// // Replace
// String strReplaced = str.substring(0, startIndex) + "Replacement Text" + str.substring(endIndex);
// sb.replace(startIndex, endIndex, "Replacement Text");

// // Deletion
// sb.deleteCharAt(sb.length() - 1);
```

</td>
<td>

```python
# # Declaration
# str_var = "Hello, World!"

# # Length
# len(str_var)

# # Indexing
# str_var[index]

# # Sorting
# sorted_str = ''.join(sorted(str_var))

# # Iterate
# for ch in str_var:

# # SubString
# str_var[start_index:end_index]

# # To lower case
# ch_or_str.lower()
```

</td>
</tr>
</table>


# Array
<table>
<tr>
<th>Static array in C++ STL</th>
<th>Static array in Java Collections</th>
</tr>
<tr>
<td>

```cpp
// Initialization
int arr[] = {1, 2, 3, 4, 5}; // Explicit initialization
int arr[5] = {1, 2, 3, 4, 5}; // With size specification
int arr[5]; // Default, uninitialized
vector<int> adjacencyList[N]; // Array of N vectors for adjacency list

// Array Fill
#include <algorithm>
fill_n(arr, 5, 10); // Fill an array `arr` of size 5 with 10s.
#include <numeric>
iota(arr, arr + 5, 10); // 10 11 12 13 14

// Size
int size = sizeof(arr) / sizeof(arr[0]);

// Looping
for(int i = 0; i < size; i++) {
    // Access each element as arr[i]
}

// Indexing
arr[i]

// Sorting
sort(arr, arr + 5);
```

</td>
<td>

```java
// Initialization
int[] arr = new int[]{1, 2, 3, 4, 5}; // Explicit initialization
int[] arr = {1, 2, 3, 4, 5}; // Shorthand syntax
int[] arr = new int[5]; // Default initialization with zeroes

// Array Fill
Arrays.fill(arr, 10); // Fill the array `arr` with 10s.

// Length
int length = arr.length;

// Looping
for(int i = 0; i < arr.length; i++) {
    // Access each element as arr[i]
}
for(int element : arr) {
    // Access each element as element
}

// Indexing
arr[i]

// Sorting
Arrays.sort(arr);
```

</td>
</tr>
</table>

# Dynamic Array
<table>
<tr>
<th>Vector in C++ STL</th>
<th>ArrayList in Java Collections</th>
<th>List in Python</th>
</tr>
<tr>
<td>

```cpp
// Variable Initialization
#include <vector>
vector<int> vec = {1, 2, 3, 4, 5};
vector<int> indeg(n, 0);

vector<vector<int>> vec_2d(3);
for (int i = 0; i < 3; i++)
    vec_2d[i].resize(4);

vector<vector<int>> vec_2d_initialized(rows, vector<int>(cols, 0));

adjMatrix.resize(numVertices, vector<int>(numVertices, 0));


// SubList creation / Vector copy initialization
vector<int> sublist(v.begin(), v.begin() + idx + 1); // 0 to idx
vector<int> sublist(v.begin() + idx + 1, v.end());  // idx + 1 to n

vector<int> sublist;
sublist.assign(v.begin() + 1, v.end() - 1)); // 1 to n - 2

// Vector Fill
#include <algorithm>
fill(visited.begin(), visited.end(), false);
memset(&abc[0], 0, sizeof(int) * abc.size());
#include <numeric>
iota(parent.begin(), parent.end(), 0); // 0 1 2 ..

// Resize
vec.resize(newSize, 0);

// Size
size_t size = vec.size();

// Looping
// Same as static array

// Indexing
vec.at(index) // Bounds checking
vec[index] // No bounds checking

// Append
vec.push_back(5);
vec.push_back(vector<string>()); // Pushing an empty vector of strings

// Sorting
sort(vec.begin(), vec.end());
sort(vec.begin(), vec.end(), greater<int>()); // descending order

// Sum
#include <numeric>
int sum = accumulate(vec.begin(), vec.end(), 0) // `0` is the initial sum value

// Reverse
reverse(vec.begin(), vec.end());

// Delete Element
vec.erase(vec.begin() + index);

// Max Element
*max_element(vec.begin(), vec.end());
```

</td>
<td>

```java
// Variable Initialization
import java.util.ArrayList;
ArrayList<Integer> arrayList = new ArrayList<>();
List<Integer> list = List.of(1, 2, 3);

// SubList creation
List<Integer> sublist = original.subList(1, 4);

// List Fill
Collections.fill(list, 10);

// Size
int size = list.size();

// Looping
// Same as static array

// Indexing
list.get(i)

// Append
list.add(5);
list.add(new ArrayList<String>());  // Adding an empty ArrayList of Strings

// Sorting
Collections.sort(list);
Collections.sort(list, Collections.reverseOrder());

// Sum
Arrays.stream(arr).sum()

// Reverse
Collections.reverse(list);

// Delete Element
list.remove(index);

// Max Element
Collections.max(list);
```

</td>
<td>

```python
# Variable Initialization
arr = [1, 2, 3, 4, 5]

# SubList Creation
sublist = original[1:4]

# List Fill
arr = [10] * 5 # Create a list of five 10s.
arr = [10 for _ in range(len(arr))] # Fill existing list with 10s

# Size
size = len(arr)

# Looping
for i in range(len(arr)):
    # Access each element as arr[i]
for element in arr:
    # Access each element as element

# Indexing
arr[i]

# Append
arr.append(5)
arr.append([])  # Appending an empty list

# Sorting
arr.sort()
sorted_arr = sorted(arr) # to get a sorted list without modifying the original
vec.sort(reverse=True)

# Sum
sum(arr[0: k])

# Reverse
arr.reverse()

# Delete Element
arr.pop(index)

# Max Element
max(arr)
```

```python
# Tuples in Python: Immutable and Hashable
var = ("Geeks", "for", "Geeks")
tuple_constructor = tuple(("dsa", "developement", "deep learning"))
```

</td>
</tr>
</table>


# HashMap
<table>
<tr>
<th>HashMap in C++ STL</th>
<th>HashMap in Java Collections</th>
<th>HashMap in Python</th>
</tr>
<tr>
<td>

```cpp
// Declarartion
#include <unordered_map>
unordered_map<char, int> ump = {{'I', 1}, {'V', 5}};

// Key Check
if (ump.find(key) != ump.end()) {}

// Key-Value Addition
ump["key"] = 1;

// Inc. If Absent
ump["key"] = ump["key"] + 1;

// Access
int value = ump.at(key); // Use at() to handle out-of-bound access

// Iteration
for (auto it = ump.begin(); it != ump.end(); ++it) {
    cout << it->first << ": " << it->second << endl;
}

for (const auto& pair : ump) {
    cout << "Key: " << pair.first << endl;
}

// Remove
ump.erase("key");

// Sort by value in decreasing order 
/* Convert the hashmap to a vector of pairs, Sort the vector by value using the custom comparator function */
bool sortDesc(const pair<string, int>& a, const pair<string, int>& b) {
    return a.second > b.second;
}
vector<pair<string, int>> vec(ump.begin(), ump.end());
sort(vec.begin(), vec.end(), sortDesc);

// TODO: Ordered HashMap

// Size
ump.size();

// Clear
ump.clear();
```

</td>
<td>

```java
// Declarartion
import java.util.HashMap;
HashMap<String, Integer> map = new HashMap<>();

// Key Check
if (mapName.containsKey(key)) {}

// Key-Value Addition
hashMap.put("key", 1);

// Inc. If Absent
map.put("key", map.getOrDefault("key", 0) + 1);

// Access
int value = map.get(key); // Returns null if key does not exist
int safeValue = map.getOrDefault(key, 0); // Default value if key doesn't exist

// Iteration
for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

for (String key : myMap.keySet()) { // Iterating through the keys
    System.out.println("Key: " + key);
}

// Remove
hashMap.remove("key");

// Sort by value in decreasing order
// Its a complex process

// TODO: Ordered HashMap

// Size
hashMap.size();

// Clear
hashMap.clear();
```

</td>

<td>

```python
# Declarartion
hash = {}
from typing import Dict # With specified types using type hints (Python 3.9+ for more specific types):
hash: Dict[str, int] = {}
matches = {"{": "}", "[": "]", "(": ")"}

# Key Check
if key in mapName:

# Key-Value Addition
hashmap["key"] = 1

# Inc. If Absent
dictionary["key"] = dictionary.get("key", 0) + 1
hash[cnt] = hash.get(cnt, []) + [i] # .append(i) modifies the list in place and returns None

# Access
value = hashMap.get("key") # Returns None if key does not exist
safe_value = hashMap.get("key", 0) # Returns default value 0 if key doesn't exist

# Iteration
for key, value in map.items():
    print(f"{key}: {value}")

for num in hash: # Iterating Through Dictionary Keys
    print(num)

# Remove
del hashMap["key"]

# Sort by value in decreasing order
hash = dict(sorted(hash.items(), key=lambda item: item[1], reverse=True))

# TODO: Ordered HashMap

# Size
len(hashMap)

# Clear
hashMap.clear()
```

</td>
</tr>
</table>


# HashSet
<table>
<tr>
<th>Set in C++ STL</th>
<th>HashSet in Java Collections</th>
<th>Set in Python</th>
</tr>
<tr>
<td>

```cpp
// Declaration
#include <unordered_set>
unordered_set<int> unorderedSet; // Red-Black Tree
set<int> orderedSet; // Hash Table
unordered_set<string> wordSet(words.begin(), words.end());

// Insert
unorderedSet.insert(1); // O(log N), N -> number of elements in set
orderedSet.insert(1); // O(1) average, O(n) worst case (due to rehashing).
set.insert(vector.begin(), vector.end());

// Check if contains
unorderedSet.find(1) != unorderedSet.end()

// Remove
unorderedSet.erase(1)

// Iterate
for (const auto& x : st)

// Set to List
vector<int> ans(st.begin(), st.end());
return ans;

// Clear
unorderedSet.clear()

// Size
unorderedSet.size()
```

</td>
<td>

```java
// Declaration
HashSet<Integer> hashSet = new HashSet<>();

// Insert
hashSet.add(1);

// Check if contains
hashSet.contains(1);

// Remove
hashSet.remove(1);

// Iterate
for (String item : my_set)

// TODO: Ordered set

// Set to List
new ArrayList<>(hashSet);

// Clear
hashSet.clear();

// Size
hashSet.size();
```

</td>

<td>

```python
# Declaration
seen = set()

# Insert
seen.add(1)

# Check if contains
contains = 1 in seen

# Remove
seen.remove(1)

# Iterate
for x in seen:

# Ordered Set
sorted_list = sorted(seen)

# Set to List
list(seen)

# Clear
seen.clear()

# Size
len(seen)
```

</td>
</tr>
</table>

# Stack
<table>
<tr>
<th>Stack in C++ STL</th>
<th>Stack in Java Collections</th>
<th>Stack in Python</th>
</tr>
<tr>
<td>

```cpp
// Declaration
#include <stack>
stack<int> stk;

// Push
stk.push(1)

// Pop
stk.pop()

// isEmpty
stk.empty()

// Top
stk.top()

// Iteration (without modifying the original stack)
// Make a copy of the stack or Pass by Value into a function
stack<int> temp = stk;
while (!temp.empty()) {
    cout << temp.top() << " ";
    temp.pop();
};
```

</td>
<td>

```java
// Declaration
import java.util.Stack;
Stack<Integer> stack = new Stack<>();

// Push
stack.push(1)

// Pop
stack.pop()

// isEmpty
stack.empty()

// Top
stack.peek()

// Iteration (without modifying the original stack)
for (int i = stack.size() - 1; i >= 0; i--) {
    System.out.print(stack.get(i) + " ");
}

System.out.print("Stack from top to bottom: ");
Stack<Integer> temp = new Stack<>();
temp.addAll(st);
while (!temp.isEmpty())
{
    System.out.print(temp.pop() + " ");
}
System.out.println();
```

</td>

<td>

```python
# Declaration
stack = []

# Push
stack.append(1)

# Pop
stack.pop()

# isEmpty
if not stack
if len(stack) == 0:

# Top
stack[-1]

# Iteration (without modifying the original stack)
for item in reversed(stack):
    print(item, end=' ')
```

</td>
</tr>
</table>

# Queue
<table>
<tr>
<th>Queue in C++ STL</th>
<th>Queue in Java Collections</th>
<th>Queue in Python</th>
</tr>
<tr>
<td>

```cpp
// Declaration
queue<int> q;

// Push
q.push(1);

// isEmpty
q.empty()

// Peek
q.front()

// Pop
q.pop()

// Size
q.size()
```

</td>
<td>

```java
// Declaration
Queue<Integer> q = new LinkedList<>();

// Push
q.add(1);

// isEmpty
q.isEmpty()

// Peek
q.peek()

// Pop
q.remove()

// Size
q.size()
```

</td>

<td>

```python
# Implementation using list
# Declaration
queue = []

# Push
queue.append('a')

# isEmpty
len(queue) == 0
not queue

# Peek
queue[0]

# Pop
queue.pop(0)

# Size
len(q)

# Implementation using queue.Queue
# Declaration
from queue import Queue
q = Queue()

# Push
q.put(1)

# isEmpty
q.empty()

# Front
q.queue[0]

# Pop
q.get()

# Size
q.qsize()
```

</td>
</tr>
</table>

# Lazy Evaluation Techniques
TODO: See tutorial for below and document chaining iterators, filtering, and mapping, first start with java
<table>
<tr>
<th>Java Streams</th>
<th>Python: Generators, Iterator Tools, Generator Expressions</th>
</tr>
<tr>
<td>

```java
// Streams
Arrays.stream(nums).filter(num -> num <= target).count();
```

</td>

<td>

```python
# Generators // lazy-evaluating manner

# Iterator Tools

# Generator Expressions // Concise way to create generators
count = sum(1 for num in nums if num <= target)

sumation = sum(num for num in nums)

grades = [88, 92, 79, 85, 67]
all_passing = all(grade >= 65 for grade in grades) # Output: True

words = ["apple", "banana", "cherry"]
has_short_word = any(len(word) < 5 for word in words) # Output: False
```

</td>
</tr>
</table>

# Priority Queue(Min Heap, Max Heap)
<table>
<tr>
<th>Priority Queue in C++ STL</th>
<th>Priority Queue in Java Collections</th>
<th>HeapQ in Python</th>
</tr>
<tr>
<td>

```cpp
#include <queue>

// Declaration
priority_queue<int> pq;
priority_queue<int, vector<int>, greater<int>> minHeap;

// Push
pq.push(10);

// isEmpty
pq.empty()

// Peek
pq.top()

// Pop
pq.pop()

// Size
pq.size()

// Iterate by popping all elements
while (!pq.empty()) {
    cout << pq.top() << " ";
    pq.pop();
}
```

</td>
<td>

```java
import java.util.PriorityQueue;

// Declaration
PriorityQueue<Integer> pq = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // Used for Dijkstra algo

// Push
pq.add(10);

// isEmpty
pq.isEmpty();

// Peek
pq.peek();

// Pop
pq.poll();

// Size
pq.size();

// Iterating with iterator
for (Integer value : pq) {
    System.out.println(value);
}

// Iterating by polling
while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

</td>

<td>

```python
import heapq

# Declaration
pq = []

# Push
heapq.heappush(pq, 10)
# Insert a negated value to simulate max heap behavior
heapq.heappush(maxHeap, -val)

# isEmpty (Not a direct function, so using len())
len(pq) == 0

# Peek (Directly access the smallest item)
pq[0] if pq else 'Heap is empty'
# Peek at the max element without removing
-maxHeap[0]

# Pop
heapq.heappop(pq)
# Retrieve the original value by negating again
-heapq.heappop(maxHeap)

# Size (Using len() function for list)
len(pq)

# Iterating by removing elements
while not pq.empty():
    print(pq.get())
```

</td>
</tr>
</table>

# Template
<table>
<tr>
<th>Template in C++ STL</th>
<th>Template in Java Collections</th>
<th>Template in Python</th>
</tr>
<tr>
<td>

```cpp
// Template
// g++ -std=c++17 solution.cpp && ./a.out   
#include <bits/stdc++.h>

#define vi vector<int>
#define vvi vector<vi>
#define pii pair<int, int>
#define vii vector<pii>
#define rep(i, a, b) for (int i = a; i < b; i++)
#define ff first
#define ss second
#define setBits(x) __builtin_popcount(x)

using namespace std;

const int N = 1e5 + 2, MOD = 1e9 + 7;

class Solution {};

void print2DArray(const vector<vector<int>>& result) {
    cout << "[";
    for (size_t i = 0; i < result.size(); ++i) {
        cout << "[";
        for (size_t j = 0; j < result[i].size(); ++j) {
            cout << result[i][j];
            if (j < result[i].size() - 1) cout << ",";
        }
        cout << "]";
        if (i < result.size() - 1) cout << ",";
    }
    cout << "]" << endl; // Produces something like this : [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
}

void printStack(stack<int> s) {
    cout << "Stack elements (from top to bottom): ";
    while (!s.empty()) {
        cout << s.top() << " ";
        s.pop();
    }
    cout << endl;
}

int main() {
    int n;

    cout << "Enter the length of array: ";
    cin >> n;

    vector<int> nums(n, 0);
    cout << "Enter the array: " << endl;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    Solution sol;
    vector<vector<int>> result = sol.solution(nums);

    print2DArray(result);

    return 0;
}
```

</td>
<td>

```java
// Template
import java.util.*;
import java.io.*;

public class Main {
    static final int N = (int)1e5 + 2;
    static final int MOD = (int)1e9 + 7;

    // Shortcuts
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> vi = new ArrayList<>();
        List<List<Integer>> vvi = new ArrayList<>();
        List<Pair> vii = new ArrayList<>();
        
        // Loop example
        rep(0, 5, i -> System.out.println(i));

        // Set bits example
        System.out.println(setBits(7));
    }
}

```

</td>

<td>

```python

```

</td>
</tr>
</table>
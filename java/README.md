# Java Collections Framework

## The Concept of a Framework

The Java Collections Framework is not just a random set of classes; it is an organized hierarchy of interfaces and implementations that provide reusable data structures and algorithms.

At the top sits the **Iterable** interface, which allows objects to be traversed using the enhanced `for-each` loop.

Next comes the **Collection** interface, which represents a group of elements and provides common operations such as:

* Add elements
* Remove elements
* Check collection size
* Clear elements
* Iterate through elements

The hierarchy then splits into three main branches:

### List

Ordered collections that allow duplicate elements.

### Set

Collections that do not allow duplicate elements.

### Queue

Collections designed to hold elements before processing.

Alongside these is the **Map** interface, which is not a subtype of Collection but is still part of the Collections Framework.

A Map stores data as **key-value pairs**, where:

* Keys must be unique
* Values can be duplicated

---

## Collections Hierarchy

```text
Iterable
    |
Collection
 ┌───┼────┐
 |   |    |
List Set Queue

Map (Separate Hierarchy)
```

---

# Lists

A **List** is an ordered collection that:

* Maintains insertion order
* Allows duplicate elements
* Supports index-based access

## ArrayList

Internally uses a dynamic array.

### Advantages

* Fast random access
* Efficient iteration
* Low memory overhead

### Disadvantages

* Slow insertion/deletion in the middle

### Time Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| get()         | O(1)       |
| add() at end  | O(1)       |
| insert middle | O(n)       |
| delete middle | O(n)       |

---

## LinkedList

Internally uses a doubly linked list.

### Advantages

* Fast insertion/deletion at beginning and middle
* Implements List and Deque

### Disadvantages

* Slow random access

### Time Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| get(index) | O(n)       |
| addFirst() | O(1)       |
| addLast()  | O(1)       |
| remove()   | O(1)       |

---

## Vector

Similar to ArrayList but synchronized.

### Characteristics

* Thread-safe
* Legacy class
* Slower than ArrayList

### Modern Alternative

Use:

```java
CopyOnWriteArrayList
```

or

```java
Collections.synchronizedList()
```

---

# Sets

A **Set** stores unique elements.

Useful for:

* User IDs
* Email addresses
* Product IDs
* Removing duplicates

---

## HashSet

Uses hashing internally.

### Characteristics

* No ordering guarantee
* Fast insertion and lookup
* Allows one null value

### Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(1)       |
| contains() | O(1)       |
| remove()   | O(1)       |

---

## LinkedHashSet

Extends HashSet behavior.

### Characteristics

* Maintains insertion order
* Slightly slower than HashSet

### Example

```text
Input:
3,1,5

Output:
3,1,5
```

---

## TreeSet

Uses a Red-Black Tree internally.

### Characteristics

* Sorted order
* No duplicate values
* Slower than HashSet

### Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| add()      | O(log n)   |
| contains() | O(log n)   |
| remove()   | O(log n)   |

### Example

```text
Input:
5,2,8,1

Output:
1,2,5,8
```

---

# Maps

A Map stores information as key-value pairs.

Example:

```java
Map<Integer, String> users = new HashMap<>();

users.put(1, "John");
users.put(2, "David");
```

---

## HashMap

Most commonly used Map implementation.

### Characteristics

* No ordering guarantee
* Fast lookup
* One null key allowed
* Multiple null values allowed

### Complexity

| Operation | Complexity |
| --------- | ---------- |
| put()     | O(1)       |
| get()     | O(1)       |
| remove()  | O(1)       |

---

## LinkedHashMap

Maintains insertion order.

### Example

```java
1 -> John
2 -> David
3 -> Alex
```

Order remains preserved.

### Common Use Case

* LRU Cache

---

## TreeMap

Uses a Red-Black Tree.

### Characteristics

* Sorted by key
* No null keys
* Keys stored in ascending order

### Complexity

| Operation | Complexity |
| --------- | ---------- |
| put()     | O(log n)   |
| get()     | O(log n)   |
| remove()  | O(log n)   |

---

# Queue and Deque

A Queue follows the FIFO principle.

**FIFO = First In First Out**

Example:

```text
A → B → C

Process:
A
B
C
```

---

## PriorityQueue

Stores elements according to priority.

### Example

```text
Input:
10, 3, 7, 1

Poll Order:
1, 3, 7, 10
```

### Complexity

| Operation | Complexity |
| --------- | ---------- |
| add()     | O(log n)   |
| poll()    | O(log n)   |
| peek()    | O(1)       |

---

## ArrayDeque

Double-ended queue.

Supports:

```java
addFirst()
addLast()
pollFirst()
pollLast()
```

### Complexity

Most operations are:

```text
O(1)
```

---

# Generics and Type Safety

Generics allow collections to store a specific data type.

Benefits:

* Compile-time safety
* No explicit casting
* Cleaner code

Example:

```java
List<String> names = new ArrayList<>();

names.add("John");

// names.add(42); // Compilation Error
```

---

# Collections Utility Class

The Collections Framework provides a utility class called:

```java
Collections
```

Useful methods:

## Sort

```java
Collections.sort(nums);
```

## Reverse

```java
Collections.reverse(nums);
```

## Shuffle

```java
Collections.shuffle(nums);
```

## Find Minimum

```java
Collections.min(nums);
```

## Find Maximum

```java
Collections.max(nums);
```

Example:

```java
List<Integer> nums = Arrays.asList(3,1,4,2);

Collections.sort(nums);
Collections.reverse(nums);
```

---

# Internal Working

## HashMap / HashSet

Uses:

```text
Hash Table
```

Benefits:

* Fast lookup
* Fast insertion
* O(1) average complexity

---

## TreeMap / TreeSet

Uses:

```text
Red-Black Tree
```

Benefits:

* Sorted data
* O(log n) operations

---

## ArrayList

Uses:

```text
Resizable Dynamic Array
```

When capacity is full:

```text
New Capacity = Old Capacity × 1.5 (approximately)
```

Elements are copied to a larger array.

---

## LinkedList

Uses:

```text
Node
 ├── Previous
 ├── Data
 └── Next
```

Each node stores references to both previous and next nodes.

---

# Summary Table

| Interface / Family | Common Implementations                  | Order                     | Duplicates  | Null Support        | Typical Use Cases          | Performance        |
| ------------------ | --------------------------------------- | ------------------------- | ----------- | ------------------- | -------------------------- | ------------------ |
| List               | ArrayList, LinkedList, Vector           | Maintains insertion order | Allowed     | Yes                 | Ordered data, index access | ArrayList O(1) get |
| Set                | HashSet, LinkedHashSet, TreeSet         | Depends on implementation | Not Allowed | Limited             | Unique elements            | HashSet O(1)       |
| Queue / Deque      | ArrayDeque, LinkedList, PriorityQueue   | FIFO / Priority           | Allowed     | Usually discouraged | Scheduling, BFS            | O(1) or O(log n)   |
| Map                | HashMap, LinkedHashMap, TreeMap         | Depends on implementation | Keys Unique | Limited             | Fast lookup                | HashMap O(1)       |
| Concurrent         | ConcurrentHashMap, CopyOnWriteArrayList | Varies                    | Varies      | Usually No          | Multi-threading            | High throughput    |
| Utilities          | Collections, Arrays                     | N/A                       | N/A         | N/A                 | Sorting, Searching         | Utility Methods    |

---

# Easy Interview Cheat Sheet

| Requirement            | Best Choice       |
| ---------------------- | ----------------- |
| Fast Lookup            | HashMap           |
| Sorted Keys            | TreeMap           |
| Preserve Order         | LinkedHashMap     |
| Fast Random Access     | ArrayList         |
| Frequent Insert/Delete | LinkedList        |
| Unique Elements        | HashSet           |
| Sorted Unique Elements | TreeSet           |
| Priority Processing    | PriorityQueue     |
| Thread-Safe Map        | ConcurrentHashMap |
| LRU Cache              | LinkedHashMap     |

---

# Golden Rule for Interviews

### Need Fast Lookup?

Use **HashMap**

### Need Sorted Data?

Use **TreeMap / TreeSet**

### Need Insertion Order?

Use **LinkedHashMap / LinkedHashSet**

### Need Fast Index Access?

Use **ArrayList**

### Need Frequent Insert/Delete?

Use **LinkedList**

### Need Thread Safety?

Use **ConcurrentHashMap**

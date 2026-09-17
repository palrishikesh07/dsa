# 📚 Graph Data Structure — Beginner Notes

## 1. What is a Graph?

A **Graph** is a data structure used to represent relationships between objects.

A graph contains:

* **Vertices / Nodes** → Objects
* **Edges** → Connections between objects

Example:

```text
A ---- B
|      |
|      |
C ---- D
```

Here:

```text
Nodes = A, B, C, D

Edges = A-B, A-C, B-D, C-D
```

### Easy way to remember

> **Node = Thing**
> **Edge = Connection**

---

# 2. Basic Graph Terminology

| Term            | Meaning                                   |
| --------------- | ----------------------------------------- |
| Vertex / Node   | A point in the graph                      |
| Edge            | Connection between two nodes              |
| Adjacent Nodes  | Nodes directly connected                  |
| Degree          | Number of edges connected to a node       |
| Path            | Sequence of connected nodes               |
| Cycle           | Path that comes back to the starting node |
| Connected Graph | Every node can reach another node         |
| Component       | Separate connected part of a graph        |
| Weight          | Cost/value associated with an edge        |

Example:

```text
A ----- B
 \     /
  \   /
    C
```

For node `A`:

```text
Degree = 2
```

Because `A` connects to `B` and `C`.

---

# 3. Directed Graph

In a **Directed Graph**, edges have a direction.

```text
A → B → C
```

This means:

```text
A can go to B
B can go to C
```

But:

```text
B cannot necessarily go to A
```

### Example

Social media:

```text
A follows B
```

This does not necessarily mean:

```text
B follows A
```

---

# 4. Undirected Graph

In an **Undirected Graph**, connections work both ways.

```text
A ---- B
```

Means:

```text
A → B
B → A
```

### Example

Facebook friendship:

```text
A ---- B
```

If A is friends with B, B is also friends with A.

---

# 5. Weighted Graph

A **Weighted Graph** has a value/cost on each edge.

```text
A --5-- B
|       |
2       10
|       |
C --3-- D
```

For example, the weight can represent:

* Distance
* Cost
* Time
* Network latency

```text
A → B = 5 km
```

---

# 6. Unweighted Graph

An **Unweighted Graph** has no cost/value on edges.

```text
A ---- B
|      |
|      |
C ---- D
```

We only care whether two nodes are connected.

---

# 7. Path

A **Path** is a sequence of nodes connected by edges.

```text
A → B → C → D
```

This is a path from:

```text
A to D
```

Path:

```text
A → B → C → D
```

---

# 8. Cycle

A **Cycle** occurs when we can start from a node and return to the same node.

```text
A ---- B
|      |
|      |
D ---- C
```

Cycle:

```text
A → B → C → D → A
```

### Remember

> **Cycle = Start → Travel → Come back to Start**

---

# 9. Connected Graph

A graph is **connected** when every node is reachable from every other node.

```text
A ---- B
|      |
C ---- D
```

All nodes are connected.

---

# 10. Disconnected Graph

A graph can contain separate groups.

```text
A ---- B        C ---- D
```

There is no connection between:

```text
A-B
```

and

```text
C-D
```

So the graph is **disconnected**.

---

# 11. Connected Components

Each separate connected group is called a **Connected Component**.

```text
A ---- B       C ---- D       E
```

Components:

```text
Component 1 = A, B

Component 2 = C, D

Component 3 = E
```

So:

```text
Number of components = 3
```

---

# 12. Degree

Degree means:

> Number of edges connected to a node.

Example:

```text
      B
      |
A ---- C ---- D
      |
      E
```

For node `C`:

```text
Degree(C) = 4
```

Because:

```text
C-B
C-A
C-D
C-E
```

---

# 13. In-Degree and Out-Degree

These are mainly used in **Directed Graphs**.

```text
A → B → C
    ↑
    D
```

For node `B`:

### In-Degree

Number of edges coming **into** B.

```text
A → B
D → B
```

Therefore:

```text
In-degree(B) = 2
```

### Out-Degree

Number of edges going **out of** B.

```text
B → C
```

Therefore:

```text
Out-degree(B) = 1
```

### Easy trick

```text
IN  = coming in
OUT = going out
```

---

# 14. Graph Representation

There are mainly 3 ways to represent a graph.

## 14.1 Edge List

Store every edge as a pair.

```text
[
  [0, 1],
  [1, 2],
  [2, 3]
]
```

Meaning:

```text
0 ---- 1
       |
       2
       |
       3
```

Simple but not very efficient for finding all neighbors.

---

# 15. Adjacency Matrix

Use a 2D array.

Example:

```text
0 ---- 1
|      |
|      |
2 ---- 3
```

Matrix:

```text
    0 1 2 3

0   0 1 1 0
1   1 0 0 1
2   1 0 0 1
3   0 1 1 0
```

If:

```text
matrix[i][j] = 1
```

then:

```text
i and j are connected
```

### Space

```text
O(V²)
```

---

# 16. Adjacency List ⭐

Most commonly used representation in coding interviews.

Example:

```text
0 ---- 1
|      |
2 ---- 3
```

Adjacency list:

```text
0 → [1, 2]

1 → [0, 3]

2 → [0, 3]

3 → [1, 2]
```

In Java:

```java
List<List<Integer>> graph = new ArrayList<>();
```

### Easy way to remember

> **Adjacency List = Each node stores its neighbors**

---

# 17. BFS — Breadth First Search ⭐⭐⭐

BFS explores a graph **level by level**.

It uses:

```text
Queue
```

Example:

```text
       1
      / \
     2   3
    / \
   4   5
```

BFS:

```text
1 → 2 → 3 → 4 → 5
```

### Remember

> **BFS = Queue = Level by Level**

Basic algorithm:

```text
1. Put starting node into Queue
2. Mark it visited
3. Remove node from Queue
4. Visit its neighbors
5. Add unvisited neighbors to Queue
6. Repeat
```

---

# 18. DFS — Depth First Search ⭐⭐⭐

DFS goes as deep as possible before coming back.

It uses:

```text
Stack
```

or

```text
Recursion
```

Example:

```text
       1
      / \
     2   3
    / \
   4   5
```

Possible DFS:

```text
1 → 2 → 4 → 5 → 3
```

### Remember

> **DFS = Stack / Recursion = Go Deep**

---

# 19. BFS vs DFS

| BFS                                        | DFS                      |
| ------------------------------------------ | ------------------------ |
| Uses Queue                                 | Uses Stack               |
| Level by level                             | Goes deep                |
| Good for shortest path in unweighted graph | Good for exploring paths |
| `O(V + E)`                                 | `O(V + E)`               |
| Often iterative                            | Often recursive          |

### Memory Trick

```text
BFS → B = Breadth → Queue

DFS → D = Depth → Stack
```

---

# 20. Visited Array ⭐

Graphs can contain cycles.

Example:

```text
A → B → C
↑       ↓
└───────┘
```

Without tracking visited nodes, traversal can continue forever.

So we use:

```java
boolean[] visited = new boolean[V];
```

When visiting:

```java
visited[node] = true;
```

### Remember

> **Graph traversal + Cycle possibility = Visited array**

---

# 21. Tree vs Graph

A **Tree is a special type of Graph**.

### Tree

```text
      A
     / \
    B   C
   / \
  D   E
```

Properties:

* Connected
* No cycle
* `V - 1` edges

### Graph

```text
A ---- B
|      |
D ---- C
```

Can have:

* Cycles
* Multiple paths
* Directed edges
* Weighted edges
* Disconnected components

---

# 22. DAG

DAG = **Directed Acyclic Graph**

It means:

```text
Directed + No Cycle
```

Example:

```text
A → B → D
 \       ↑
  → C ───
```

There is a direction, but no cycle.

DAG is important for:

* Task scheduling
* Dependency management
* Build systems
* Course prerequisites

---

# 23. Topological Sort ⭐⭐⭐

Topological Sort is used on a:

```text
DAG
```

It gives an ordering of nodes based on dependencies.

Example:

```text
Learn HTML
    ↓
Learn CSS
    ↓
Learn JavaScript
    ↓
Learn React
```

Possible topological order:

```text
HTML → CSS → JavaScript → React
```

### Two common approaches

```text
1. BFS → Kahn's Algorithm
2. DFS → Topological Sort
```

---

# 24. Cycle Detection

Very important interview topic.

### Undirected Graph

Common approaches:

```text
DFS + Parent
```

or

```text
DSU / Union Find
```

### Directed Graph

Common approach:

```text
DFS + Recursion Stack
```

or

```text
Kahn's Algorithm
```

---

# 25. Shortest Path

Goal:

> Find the minimum-cost path between nodes.

Example:

```text
A --5-- B
|       |
2       3
|       |
C --1-- D
```

Different algorithms are used depending on the graph.

| Algorithm      | Use                       |
| -------------- | ------------------------- |
| BFS            | Unweighted graph          |
| Dijkstra       | Non-negative weights      |
| Bellman-Ford   | Can handle negative edges |
| Floyd-Warshall | All-pairs shortest path   |

---

# 26. Dijkstra's Algorithm ⭐⭐⭐

Used for:

```text
Shortest Path
```

when edge weights are:

```text
NON-NEGATIVE
```

Example:

```text
A --4-- B
|       |
1       2
|       |
C --3-- D
```

Dijkstra repeatedly chooses the node with the **smallest known distance**.

Usually implemented with:

```text
Priority Queue / Min Heap
```

### Remember

> **Dijkstra = Shortest Path + No Negative Weight**

---

# 27. Bellman-Ford

Used for shortest path when the graph can contain:

```text
Negative Edge Weights
```

Important advantage:

```text
Can detect negative cycles
```

Basic idea:

```text
Relax all edges V - 1 times
```

### Remember

> **Bellman-Ford = Negative weights + Negative cycle detection**

---

# 28. Minimum Spanning Tree (MST)

A Minimum Spanning Tree connects all nodes with:

```text
Minimum total edge weight
```

Important algorithms:

```text
1. Kruskal
2. Prim
```

Example:

```text
      2
 A ------- B
 |         |
4|         |1
 |         |
 C ------- D
      3
```

MST chooses the cheapest edges that connect all nodes without creating a cycle.

---

# 29. Kruskal's Algorithm

Kruskal:

```text
1. Sort edges by weight
2. Pick smallest edge
3. Avoid cycle
4. Continue
```

Usually uses:

```text
DSU / Union Find
```

### Memory trick

> **Kruskal = Sort Edges + DSU**

---

# 30. Prim's Algorithm

Prim grows the MST from a starting node.

```text
Start with one node
        ↓
Choose cheapest connecting edge
        ↓
Add new node
        ↓
Repeat
```

Usually uses:

```text
Priority Queue
```

### Memory trick

> **Prim = Grow the tree**

---

# 31. Union Find / DSU

DSU = **Disjoint Set Union**

Used for:

* Connected components
* Cycle detection
* Kruskal's algorithm

Main operations:

```text
find()
union()
```

Example:

```text
A    B    C    D
```

Initially:

```text
{A} {B} {C} {D}
```

After:

```text
union(A, B)
```

we get:

```text
{A, B} {C} {D}
```

---

# 32. Important Graph Algorithms — Quick Map

```text
GRAPH
 |
 +-- Traversal
 |    |
 |    +-- BFS
 |    +-- DFS
 |
 +-- Shortest Path
 |    |
 |    +-- BFS
 |    +-- Dijkstra
 |    +-- Bellman-Ford
 |    +-- Floyd-Warshall
 |
 +-- MST
 |    |
 |    +-- Prim
 |    +-- Kruskal
 |
 +-- Ordering
 |    |
 |    +-- Topological Sort
 |
 +-- Cycle Detection
 |    |
 |    +-- DFS
 |    +-- BFS
 |    +-- DSU
 |
 +-- Components
      |
      +-- DFS
      +-- BFS
      +-- DSU
```

---

# 33. Graph Learning Order ⭐

Don't try to learn everything at once.

Follow this order:

```text
1. Graph basics
      ↓
2. Directed vs Undirected
      ↓
3. Weighted vs Unweighted
      ↓
4. Adjacency Matrix
      ↓
5. Adjacency List ⭐
      ↓
6. BFS ⭐
      ↓
7. DFS ⭐
      ↓
8. Visited Array
      ↓
9. Connected Components
      ↓
10. Cycle Detection
      ↓
11. Topological Sort
      ↓
12. Shortest Path
      ↓
13. Dijkstra
      ↓
14. Bellman-Ford
      ↓
15. MST
      ↓
16. Prim
      ↓
17. Kruskal
      ↓
18. DSU
```

---

# 34. Must-Know Terms for Interviews

Before solving graph problems, make sure you understand these:

```text
Node / Vertex
Edge
Adjacent
Degree
In-degree
Out-degree
Path
Cycle
Connected
Disconnected
Component
Directed Graph
Undirected Graph
Weighted Graph
Unweighted Graph
DAG
Adjacency List
Adjacency Matrix
BFS
DFS
Visited
Topological Sort
Shortest Path
Dijkstra
Bellman-Ford
MST
Prim
Kruskal
DSU / Union Find
```

---

# 🧠 Super Easy Memory Sheet

```text
BFS
↓
Queue
↓
Level by Level

DFS
↓
Stack / Recursion
↓
Go Deep

Dijkstra
↓
Priority Queue
↓
Shortest Path
↓
No Negative Weight

Bellman-Ford
↓
Shortest Path
↓
Negative Weight Allowed

Kruskal
↓
Sort Edges
↓
DSU
↓
MST

Prim
↓
Priority Queue
↓
Grow MST

Topological Sort
↓
DAG
↓
Dependency Ordering

DSU
↓
Union + Find
↓
Components / Cycle / Kruskal
```

---

# 🎯 First 5 Problems to Practice

Start with these before advanced graph problems:

### 1. BFS Traversal

Learn:

```text
Queue
Visited
Adjacency List
```

### 2. DFS Traversal

Learn:

```text
Recursion
Visited
Adjacency List
```

### 3. Number of Connected Components

Learn:

```text
DFS/BFS
Visited
```

### 4. Detect Cycle in Undirected Graph

Learn:

```text
DFS
Parent
Visited
```

### 5. Shortest Path in Unweighted Graph

Learn:

```text
BFS
Distance
Visited
```

---

# ⭐ Golden Rule

When you see a Graph problem, ask these questions:

```text
1. Is it Directed or Undirected?

2. Is it Weighted or Unweighted?

3. Can there be a Cycle?

4. Do I need to visit/explore?
   → BFS / DFS

5. Do I need shortest path?
   → BFS / Dijkstra / Bellman-Ford

6. Do I need dependency ordering?
   → Topological Sort

7. Do I need minimum cost to connect everything?
   → MST

8. Do I need components/cycle detection?
   → DFS/BFS/DSU
```

> **Master BFS + DFS + Adjacency List first.**
> Once these are clear, most graph concepts become much easier.

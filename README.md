# Question 1 | Exam Hall Check-In System
A university needs a system to record the order in which students arrive to take their exam. The system must:
- Preserve arrival order (first come, first recorded)
- Allow index-based access to generate numbered reports
- Grow dynamically as students arrive at any time
- Support searching whether a student has already checked in
- Expected group size: 30 to 50 students

Which List implementation would you use: ArrayList or LinkedList? Justify your answer by considering which operations happen most frequently.

Hint: Think about what happens more often: random index access or adding to the end?

Chosen structure: ArrayList
Justification: Because we need to have storage, index-based access, and the ability to add new elements dynamically, ArrayList is the one. If we choose a LinkedList, the adding operation is one of the best, but accessing a specific index is costly in terms of time complexity, being O(n) on average, because it needs to check each element from 0 to n - 1. Meanwhile, ArrayList accesses elements in O(1) in worst, best, and average cases.

Code snippet: File InnerSchoolSystem.java

Output:

```
New system
[]
[John]
[John, Martin]
[John, Martin, Pedro]
Consulting student at index 0
John
```

# Question 2 | Unique Student ID Validation
An online learning platform needs to quickly verify whether a student ID is already registered. The system must:
- Guarantee no duplicate IDs exist
- Check membership in O(1) time
- Order of insertion is irrelevant
- Handle up to 100,000 student IDs

Which Set implementation would you choose? Consider HashSet, LinkedHashSet, and TreeSet. Justify why you discard the other two options.

Hint: Order doesn't matter at all — only lookup speed does.

Chosen structure: HashSet
Justification: For the first requirement of the system that needs to guarantee no duplicates, all the Sets guarantee that. The next req, that needs to check membership in O(1), there are only two options, the HashSet and LinkedHashSet but the third requirement decides what type we need to use, it says that Order of insertion is irrelevant, the only option that dont fits in that req is LinkedHashSet because it can remember the order of insertion, so finally we have HashSet to this exercise. TreeSet doesn't fit the req to checks in O(1), it cheks in O(log n) becuase of the implementation of a tree inside.

Code snippet: File SystemIDValidation.java

Output:

```
New System
Adding student A001. It's added? ->true
Adding student A002. It's added? ->true
Adding student A003. It's added? ->true
Adding student A001. It's added? ->false
The student A001 exist? ->true
The student A999 exist? ->false
Total IDs: 3
```

# Question 3 | Shared Office Printer Queue
An office has a single shared printer used by several departments. Documents pile up while the printer is busy. The system must:
- Process documents in arrival order (FIFO)
- Allow urgent documents to be inserted at the front of the queue
- Show how many documents are pending
- Cancel the last document added if it was sent by mistake

Would you use Queue or Deque? Which concrete implementation (ArrayDeque,
PriorityQueue, LinkedList)? Justify considering all required operations.

Hint: Do you need to add/remove from both ends of the queue?

### Chosen structure
**Deque:** To process documents in arrival order, allow urgent documents to be inserted at the front, and to cancel the last document added
- `addFirst()`
- `addLast()`
- `size()`
- `removeLast()`

### Justification
While a **Queue** data structure would be useful to process documents in arrival order, it would be insufficient to satisfy every requirement. **Deque** can provide what Queue can do by adding documents in arrival order with `addLast()`, while also providing some additional methods. `addFirst()` allows to add urgent documents at the start of the printing queue, and last added documents can be delete with `removeLast()`. It also has the `size()` method, which can be used to see how many documents are pending.

The best concrete implementation for this in Java would be an **`ArrayDeque`** because it implements `Deque` and allows for:
- O(1) add/remove at both ends
- No node overhead (array-backed)
- Faster than LinkedList in practice
- No capacity limit (resizes automatically)

This structure follows the **FIFO** principle and also supports front insertion.

# Question 4 | Student Grade Book
A school system needs to store student grades per subject. The system must:
- Map each student's name to a (subject → grade) mapping
- Quickly retrieve all subjects for a given student
- Generate reports sorted alphabetically by student name
- Update grades without removing others

Which Map implementation would you use for the outer map (student → subjects)? What about the inner map (subject → grade)? They can be different. Justify both choices.

Hint: Alphabetical order in the report is a key hint for the outer map.

Chosen structure:  
**Outer Map (Student → Subjects):** `TreeMap<String, Map<String, Double>>`  
**Inner Map (Subject → Grade):** `HashMap<String, Double>`

Justification:  
**Outer Map - TreeMap:**  
- **Orden alfabético automático:** TreeMap organiza los nombres de los estudiantes en orden alfabético, facilitando la generación de reportes sin pasos adicionales de ordenamiento.  
- **Reportes eficientes:** Al recorrer el TreeMap, los estudiantes ya están ordenados alfabéticamente, lo que permite generar reportes de manera directa y eficiente (O(n)).  
- **Buen rendimiento:** Las operaciones de inserción y búsqueda tienen una complejidad de O(log n), lo cual es adecuado para el tamaño típico de una lista de estudiantes.

**Inner Map - HashMap:**  
- **Acceso eficiente:** HashMap permite acceder, insertar y actualizar calificaciones de materias en tiempo promedio O(1).  
- **Sin necesidad de orden:** No es necesario que las materias estén ordenadas, ya que el requisito de orden solo aplica a los estudiantes.  
- **Óptimo para actualizaciones:** HashMap es más rápido que TreeMap para las operaciones frecuentes de actualización de calificaciones.  
- **Versatilidad:** Permite agregar o modificar materias fácilmente sin afectar la estructura.

Esta estructura aprovecha el orden automático del TreeMap para los reportes y la rapidez del HashMap para gestionar las calificaciones de cada materia.

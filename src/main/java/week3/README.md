# Week 3 — OOP, Classes and Objects

Concept module. The six runnable demos live in [`class_problems/`](./class_problems):

| Section | Topic | Demo |
|---|---|---|
| 1 | What is OOP? | `OopIntroDemo` |
| 2 | Benefits: Reusability, Security, Extensibility | `BenefitsDemo` |
| 3 | Class & Object | `BlueprintDemo` |
| 4 | Class Definition and Syntax | `ClassSyntaxDemo` |
| 5 | Creating and Using Objects | `ObjectUsageDemo` |
| 6 | Instance vs Class (static) Members | `StaticDemo` |

```bash
javac -d out $(find src -name '*.java')
java -cp out week3.class_problems.OopIntroDemo
java -cp out week3.class_problems.BenefitsDemo
java -cp out week3.class_problems.BlueprintDemo
java -cp out week3.class_problems.ClassSyntaxDemo
java -cp out week3.class_problems.ObjectUsageDemo
java -cp out week3.class_problems.StaticDemo
```

## Test Yourself — answers

**1. Explain the difference between a class and an object using an SRM example that is not the hostel room.**
A class is the description; an object is one real instance of it. The exam question *paper* is the class — it says
each sheet has fields (roll number, subject) and behaviour (be written on). The 60 *filled answer sheets* are the
objects: each one exists separately, carries its own actual values, and one student writing on their sheet does
nothing to anyone else's.

**2. Why does private protect data better than "being careful"?**
"Being careful" is a promise every caller has to remember to keep, and people forget — especially at 2 AM six months
later, or when four different developers touch the same code. `private` makes the compiler enforce the rule. The
field simply cannot be written from outside the class, so the only path in is through a method you wrote and where
you put the check.

**3. What are Java's defaults for an unset int, boolean, and String field?**
`int` → `0`, `boolean` → `false`, `String` (and every object reference) → `null`. Java never leaves a field as
garbage. Note that `null` is very different from `""` — calling a method on `null` throws a
`NullPointerException`.

**4. Why does a constructor have no return type?**
Because it would return nothing meaningful — it *is* the moment the object comes into being. `new` allocates the
memory and the constructor fills it in; there is no value to hand back. Declaring a return type (even `void`) turns
it into an ordinary method that `new` can no longer call, which is a classic silent bug.

**5. After `IdCard b = a;`, how many objects exist? What happens when you change `b.libraryBooks`?**
One. `b` is just a second name for the same object — the assignment copies the *address*, not the card. Changing
`b.libraryBooks` changes `a.libraryBooks` too, because both variables point at the same thing.

**6. Why can main not use an instance field directly? Answer in one sentence.**
Because `main` is static — it runs before any object exists, so there is no instance whose field it could read.

**7. If campus is static and one object changes it, what do all the other objects see?**
They all see the new value immediately, because there is only one `campus` in the whole class and every object
shares it. That is exactly what happens in `StaticDemo` when `SrmStudent.campus = "SRM Ramapuram"` transfers every
student at once.

**8. When would making a field static be an actively bad idea?**
Whenever the value should differ per object — attendance, CGPA, room number, name. A static field is shared state,
so writing one student's value silently overwrites it for every other student, and the corruption shows up far away
from the line that caused it. Static is for constants, shared counters, and utilities — not per-object data.

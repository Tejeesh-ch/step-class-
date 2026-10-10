# Week 6 — Access Modifiers, Encapsulation & Object Modeling

Practice problems live in [`class_problems/`](./class_problems):

| Problem | Class |
|---|---|
| M1. Student Placement Record Management | `PlacementRecord` |
| M2. Hostel Mess Wallet Management | `MessWallet` |
| M3. Course Credit Management | `Course` |
| M4. Library ID Card Management | `IdCard` |
| M5. Student and College Information Management | `Student` |

```bash
javac -d out $(find src -name '*.java')
java -cp out week6.class_problems.PlacementRecord
java -cp out week6.class_problems.MessWallet
java -cp out week6.class_problems.Course
java -cp out week6.class_problems.IdCard
java -cp out week6.class_problems.Student
```

## Concept sheet — sections

1. Access Modifiers — private, default, protected, public
2. Visibility Across Packages and Inheritance
3. Encapsulation — Data Hiding
4. The JavaBean Standard — Getters and Setters
5. Read-Only and Write-Only Properties
6. Immutable Objects
7. final Fields and Encapsulation

| Modifier | Accessible from |
|---|---|
| `private` | Only code inside the exact same class |
| default (no keyword) | Any class in the same package — nothing else |
| `protected` | Same package, plus any subclass, even in a different package |
| `public` | Anywhere at all |

Everyday rule: fields `private`, methods `public`. Deviate only when you can explain why.

## Test Yourself — answers

**1. What is the one situation where `protected` actually reaches code in a different package — and why does it not
reach every class in that package?**
Only a *subclass* reaches it, and only through inheritance: the subclass may touch a protected member of its own
superclass, and even then only on an object of its own type (or a subtype of it) — not on some unrelated instance
of the declaring class. Every other class in that package is excluded, because same-package access is what
*package-private* grants; `protected` adds the subclass clause on top of that, it does not widen the package.

**2. Give a concrete example of a bug that public fields alone would allow, which encapsulation prevents.**
With `public double amountPaid` on `FeeAccount`, any caller can write `ravi.amountPaid = 200000;` and declare the
fee cleared — no money moved, the "payment must be positive" rule never ran, and the ledger records nothing. The
same shape of bug appears with `public LocalDate dateOfBirth = LocalDate.of(2030, 1, 1)`. Making the field
private forces every write through `pay()`, which is the single place holding the rule.

**3. Why does a boolean JavaBean property use `isX()` instead of `getX()`?**
It is the JavaBeans naming convention, and property introspectors discover properties by those names. `isX()` is
the canonical form for a boolean getter because it reads as a question about state — `isEnabled()` rather than
`getEnabled()`. Frameworks (Hibernate, Jackson, Spring, the IDE property grid) rely on the convention to bind the
field, so deviating makes the property invisible to them.

**4. Describe a real field that should be a read-only property, and a real field that should be write-only.**
Read-only: an account `balance` — the holder must be able to *see* it (`getBalance()`) but no code outside should
ever assign it; changes only happen via `pay()` / `deduct()`. Write-only: a password or a card PIN — you must be
able to set it (`setPassword(...)`) but nothing outside should ever read it back, so there is deliberately no
getter. The same reasoning covers one-time secrets such as an API key or CVV.

**5. What does it mean to "change" an immutable object, if none of its fields can actually be reassigned?**
You never mutate it. You build and return a *new* object carrying the changed value and move your reference to
that: `NameTag longer = tag.withNickname("Maria G.")`. The original object is bit-for-bit unchanged forever,
which is what makes it safe to share between threads and to hand to callers.

**6. A class has a `private final int[]` field with no defensive copying. Describe exactly how an outside caller
could still mutate it.**
`final` locks the *reference*, not the contents. Any method that returns the field directly hands over the actual
backing array, so a caller can simply do `obj.getScores()[0] = 999;` and rewrite the object's internals from
outside — no setter needed. The same hole exists on the way in if the constructor stores the caller's array
without cloning. Defensive copying (clone in, clone out) closes both directions.

**7. Why is a public no-argument constructor part of the JavaBean standard, even for a class whose fields are all
mandatory in spirit?**
Because tooling has to construct the object *before* it knows what the values are: a framework reads the data
source first, instantiates with `new X()`, then fills properties one by one through setters. A no-arg constructor
is the only one it can always call, and it guarantees a properties object exists even when some fields are still
unknown. Validation of the "mandatory" fields then happens in the setters or a later lifecycle step.

**8. In the `SrmStudentProfile` example, why are `regNo` and `name` final while `attendance` is not?**
Because their real-world lifecycles differ. A student's name and registration number are identity — assigned once
and never altered for the life of the profile — so `final` both documents that and makes the compiler enforce it.
Attendance changes every time a lecture happens, so it must stay mutable. The underlying rule: match each field's
mutability to the value's actual lifecycle — freeze identity, allow state.

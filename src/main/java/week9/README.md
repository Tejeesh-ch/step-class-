# Week 9 — Abstraction, Interfaces & Class vs Interface (Category C)

Every problem is modelled with an **abstract base class** declaring the shared
contract, concrete subclasses holding their own rules, and a `main` that
processes the list without type checks.

## Coding problems

| Sheet | Problem | Class |
|---|---|---|
| Practice | 1. Garden Plot Area Report | `class_problems.GardenPlotAreaReport` |
| Practice | 2. Weekly Staff Pay | `class_problems.WeeklyStaffPay` |
| Practice | 3. Library Late Fine Counter | `class_problems.LibraryLateFineCounter` |
| Practice | 4. Electricity Connection Billing | `class_problems.ElectricityConnectionBilling` |
| Practice | 5. Travel Booking with a Common Fee | `class_problems.TravelBookingWithCommonFee` |
| Assignment | 1. Movie Ticket Counter | `assigment_problems.MovieTicketCounter` |
| Assignment | 2. Parcel Shipping Desk | `assigment_problems.ParcelShippingDesk` |
| Assignment | 3. College Fee Counter | `assigment_problems.CollegeFeeCounter` |
| Assignment | 4. City Cab Fare Meter | `assigment_problems.CityCabFareMeter` |
| Assignment | 5. Home Appliance Energy Report | `assigment_problems.HomeApplianceEnergyReport` |

```bash
javac -d out $(find src -name '*.java')
printf '4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT\n' \
  | java -cp out week9.assigment_problems.CityCabFareMeter
```

### Where each shared rule lives

| Problem | Shared in the base class |
|---|---|
| Travel Booking | `BOOKING_FEE = 50` — change it and one line changes |
| Movie Ticket | `CONVENIENCE_FEE = 20`, applied per ticket in `amount()` |
| College Fee | `TRANSPORT_FEE = 12000`, gated by `usesBus()` |
| City Cab | `MINIMUM_FARE = 100` and the night surcharge in `fare()` |
| Energy Report | the units formula and `COST_PER_UNIT`, gated by `supportsSaver()` |
| Parcel Shipping | `insurance()` defaults to `0.00`; insured types override it |

## Part B — Quiz answers

1. **C** — Hiding *how* an object performs its operations and showing only *what* it does.
2. **C** — An abstract class cannot be instantiated directly.
3. **B** — The class must itself be declared `abstract`, or it will not compile.
4. **C** — `private`. An abstract method must be visible to subclasses so they can override it.
5. **C** — Interface fields are implicitly `public static final` (constants).
6. **C** — Any number of interfaces.
7. **D** — `public`. Interface methods are part of the public contract.
8. **C** — Interfaces carry no instance state, so there is no conflicting data inheritance to be ambiguous about.
9. **D** — A compile-time error, until the class overrides the method (or the interface qualifies it with `default`).
10. **B** — Abstract classes can have constructors, and they run when a subclass object is created.

## Part C — Concept questions, answered

**1. Explain abstraction in your own words, with a real-life example.**
Abstraction is exposing only the capabilities a caller needs while hiding the
mechanics behind them. A car's *dashboard* is the abstraction: you get an
accelerator pedal, a brake and a speedometer. Fuel injection timing, valve lift
and combustion order are all hidden — you drive the car perfectly well without
knowing any of it, and the manufacturer can rework the engine without changing
your driving habits. What is shown: "press this to go faster". What is hidden:
how the engine turns that pressure into motion. In code, an abstract `Plot`
shows `area()` to the report while hiding that a circle integrates and a
rectangle multiplies.

**2. Primary difference between abstraction and encapsulation, and how they work together.**
Abstraction is about the **interface** — deciding *what* operations exist and
hiding their implementation. Encapsulation is about the **data** — bundling
state with the methods that may touch it and blocking outside access with
access modifiers. Abstraction is a design-time simplification; encapsulation is
an enforcement mechanism. They cooperate in one class: abstraction publishes a
narrow `pay()` method and hides the calculation, while encapsulation makes the
`salary` field `private` so nobody can bypass `pay()` and write it directly. The
first reduces the caller's *mental* load, the second removes the caller's *ability*
to break the object.

**3. An abstract class cannot be instantiated, yet it can have a constructor. Why, and when does it run?**
The constructor is never used to build an instance of the abstract class itself.
It runs **when a concrete subclass is constructed**, as part of `super(...)`,
initialising the state that every subclass inherits — final fields, shared setup,
invariants that must hold regardless of which subclass is being created. Without
it, inherited fields would have no way of being initialised except subclass-by-
subclass assignment, which is exactly the duplication abstraction is meant to
remove. It also gives the base class a place to enforce a rule once for all
subclasses.

**4. Why can't an abstract method be `private`, `static`, or `final`?**
- **`private`** — a subclass could not see it, so it could never be overridden,
  yet an abstract method has no body of its own. The contract would be unusable.
- **`static`** — static methods are resolved at compile time from the declaring
  class and are never overridden; polymorphism would have nothing to dispatch on.
  A static method also belongs to the class rather than an instance, so there is
  no object to supply the implementation.
- **`final`** — `final` explicitly forbids overriding, which directly
  contradicts the requirement that every concrete subclass provide the body.

**5. The diamond problem, and how Java's design addresses it.**
The diamond arises when a class inherits the *same* method from two different
paths — `A` declares `run()`, `B` and `C` both extend `A` and override it, and
`D extends B, C` now has two conflicting versions with no obvious winner, plus
(if there were fields) two copies of `A`'s state. Java avoids it by allowing a
class to extend **only one** class, so the inheritance chain is always a tree and
data inheritance never forks. To gain multiple contracts it uses interfaces,
which carry **no instance state** — so there is nothing to duplicate — and where
two interfaces supply the same default method, the compiler forces the class to
resolve it explicitly by overriding (a compile-time error, not an ambiguous
runtime choice).

# Week 8 — Inheritance & Polymorphism (Category C)

Every problem here is modelled the same way: one interface declaring the shared
operation, one class per variant holding its own rules, and a central `main`
that processes a list **without any `if/else` on the type**.

## Coding problems

| Sheet | Problem | Class |
|---|---|---|
| Practice | 1. Payment System Fee Calculation | `class_problems.PaymentSystemFeeCalculation` |
| Practice | 2. Library Item Due Date Calculator | `class_problems.LibraryItemDueDateCalculator` |
| Practice | 3. Delivery Fee Calculator | `class_problems.DeliveryFeeCalculator` |
| Practice | 4. Examination Question Grader | `class_problems.ExaminationQuestionGrader` |
| Practice | 5. Public Transport Fare Calculator | `class_problems.PublicTransportFareCalculator` |
| Assignment | 1. The Canteen Billing Counter | `assigment_problems.CanteenBillingCounter` |
| Assignment | 2. The Campus Parking Charge Calculator | `assigment_problems.CampusParkingChargeCalculator` |
| Assignment | 3. The Hostel Electricity Bill | `assigment_problems.HostelElectricityBill` |
| Assignment | 4. The Festival Bonus Calculator | `assigment_problems.FestivalBonusCalculator` |
| Assignment | 5. The Streaming Plan Renewal Reminder | `assigment_problems.StreamingPlanRenewalReminder` |

All ten read from standard input: the first line is `N`, followed by `N` records.

```bash
javac -d out $(find src -name '*.java')

printf '3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000\n' | java -cp out week8.class_problems.PaymentSystemFeeCalculation
printf '4\nBIKE 3\nCAR 4\nTRUCK 1\nCAR 1\n'            | java -cp out week8.assigment_problems.CampusParkingChargeCalculator
```

### ⚠ Correction to the Practice sheet, Problem 3

The sheet's **business rules** and its **sample output** disagree:

| Type | Rules give | Sheet prints |
|---|---|---|
| STANDARD 10 kg / 50 km | 5 + 5 + 5 = **15.00** | 15.00 ✓ |
| EXPRESS 5 kg / 20 km | 15 + 5 + 4 = **24.00** | 29.00 ✗ |
| INTERNATIONAL 20 kg / 100 km / 30 customs | 25 + 40 + 50 + 30 = **145.00** | 155.00 ✗ |
| Total | **184.00** | 199.00 ✗ |

The implementation follows the stated business rules, because STANDARD matches
them exactly and the rules are the specification. The discrepancy is also
documented in `DeliveryFeeCalculator.java`.

## Quiz answers

1. **C** — Polymorphism. Give each document type its own `render()` and the
   `if/else if` chain disappears.
2. **A, B** — `Car` is a `Vehicle`; `Rectangle` is a `Shape`. C is not an
   is-a relation, and D is a *has-a* (composition).
3. **C** — Runtime method dispatch (dynamic binding on the receiver's actual type).
4. **C** — Inheritance-based polymorphism.
5. **A, C, D** — Book extends the inherited behaviour, LibraryItem defines the
   common behaviour, and a DVD can be processed through a `LibraryItem`
   reference. B is wrong: DVD *overrides* `getLoanPeriod()`, it is not merely
   shared behaviour.
6. **A, C** — A `Dog` behind an `Animal` reference runs `Dog`'s override, and
   that override is exactly "overridden behaviour". B is wrong (the base
   implementation is the general one, not the specialised one) and D is wrong
   (a subclass may add entirely new methods).
7. **C** — A new `WalletPayment` slots straight in; `PaymentProcessor`'s
   iteration logic never changes. That is the open/closed principle at work.
8. **A** — It produces tighter coupling and wrong is-a relationships, which
   makes the design rigid.
9. **A, C** — One generic sender handles every channel, and a new channel can
   be added without touching existing sender logic. B is wrong (the logic is
   spread across subclasses, not centralised into one) and D is wrong (each
   channel gets its *own* `send()`).
10. **A, B, C** — Polymorphic collections iterate easily, process uniformly and
    cut down casts. D is the opposite of the truth: they make new types *easier*
    to add.

## Concept questions — answers

**1. How does inheritance let specialised classes reuse and then modify base behaviour? Give a business example.**
The subclass inherits every field and method of the base class unchanged, then
overrides only the ones whose rules differ. A `FeeAccount` already knows how to
`pay()`; `HostelFeeAccount` inherits that tested logic and adds
`payInTwoInstallments()` (reuse) while an `EmiFeeAccount` could override `pay()`
to allow instalments (modification) without ever editing `FeeAccount`.

**2. What is the 'is-a' relationship, and why does getting it right matter?**
A subclass must genuinely *be* a special case of its base — a `Car` is a
`Vehicle`, but a `DatabaseConnection` is not a `NetworkResource`. It matters
because inheritance buys substitutability: anywhere a `Vehicle` is expected a
`Car` must work. Forcing a false is-a breaks that contract, so callers get
objects that don't honour the base class's promises — and because the mistake is
baked into the type hierarchy, it is expensive to untangle later.

**3. Define method overriding, with an Employee salary example.**
Overriding is when a subclass redefines a method that already exists in the base
class with the same name, parameters and return type, so the call resolves to
the subclass version at runtime. `Employee.calculateSalary()` might return
`monthlySalary`; `Manager.calculateSalary()` overrides it to add a bonus, and
`Contractor.calculateSalary()` overrides it to compute an hourly rate. The
payroll loop calls `calculateSalary()` on each `Employee` and gets the right
formula every time.

**4. Explain runtime polymorphism / dynamic dispatch.**
The reference's *compile-time* type decides which methods are callable; the
object's *runtime* type decides which implementation actually runs. When
`v.startEngine()` is called on a `Vehicle` reference, the JVM looks at the
object's real class, finds the matching method in that class's vtable, and
invokes it. The selection happens on each call at runtime, which is why the same
line of code starts a petrol engine for a `Car` and an electric one for a
`Motorcycle`.

**5. How do polymorphic collections work, and why are they useful?**
You store many objects of different concrete types behind one base type —
`List<LibraryItem> items = List.of(new Book(...), new DVD(...))`. Iterating and
calling `items.get(i).getLoanPeriod()` needs no casting and no type checks.
Advantages: uniform processing, no `instanceof` chains, and a new subtype can be
added later without touching the loop — the collection's code stays closed while
the system stays open for extension.

**6. Polymorphism vs. repeated type-based conditionals — compare them.**
The `if/else if (x instanceof ...)` version puts every variant's logic in one
growing method: each new type means editing that method, and forgetting a branch
fails silently. Polymorphism moves each variant's logic into its own class, so
the central code never changes and the compiler *forces* you to implement the
contract. Prefer polymorphism for varying behaviour among related objects; keep
conditional logic for genuinely unrelated cases like validation or configuration.

**7. How do inheritance and polymorphism let you add a new PaymentMethod with almost no change?**
Add `class WalletPayment implements Payment { ... }` and the existing
`PaymentProcessor` — which only knows about `Payment` — handles it unchanged.
Nothing in the processing loop is edited, because the loop never named concrete
types to begin with. Only genuinely new *behaviour* (say, a QR-code channel)
would require touching shared code.

**8. Inherited vs. overridden behaviour — when does each apply?**
Inherit when the base implementation is already correct for the subclass: a
`SavingsAccount` inherits `getBalance()` unchanged. Override when the subclass's
rules genuinely differ: `FixedDepositAccount` must override `withdraw()` to
enforce the lock-in period, and `Book` overrides `getLoanPeriod()` to shorten it
for new releases. Rule of thumb: inherit the default, override the exception.

**9. Why is inheritance used purely for code reuse a bad idea?**
Because there is no real is-a relationship, so substitutability breaks — callers
accepting the base type get an object that violates its contract. A
`HelperUtility` that `extends Calculator` just to reuse `add()` makes every
`Calculator` variable potentially a helper, couples unrelated classes together,
and forces changes in one to ripple into the other. Prefer composition ("has-a")
or a shared static utility when the relationship is not genuinely "is-a".

**10. Analyse a VehicleRental system — common and specialised behaviours.**
Common to all rentals: `calculateCost()`, `returnVehicle()`, `getRenter()`,
`isActive()`. Specialised: `CarRental` needs `driverAgeSurcharge()` and a fuel
policy; `TruckRental` needs `payloadCapacity()` and a loading-time rate.
Model it with a `Rental` base class holding the shared fields and the
`calculateCost()` signature, then `CarRental` and `TruckRental` extend it and
override `calculateCost()` with their own pricing, while adding only their own
extra members. The rental-office report then loops over `List<Rental>` and
costs everything uniformly.

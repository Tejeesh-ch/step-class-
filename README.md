# Step_semester_3

Daily progress log and documentation for **STEP – Semester 3** (CodInClub, powered by BridgeLabz).

> Branching model follows [docs/STEP_GitHub_Structure_Guide.pdf](./docs/STEP_GitHub_Structure_Guide.pdf):
> `main` = documentation only · `develop` = empty project skeleton · `feature/session_n` = one coding session each.

## Date: 10-10-2026

**Today's Work:**
- Set the repository up per the GitHub Repository Structure Guide: `main`, `develop` and `feature/session_1` … `feature/session_9` branches created; feature branches are always branched from `develop` and are not merged back.
- Uploaded every problem sheet issued so far to [`docs/`](./docs/) — Weeks 1 through 9, class problems, assignments, practice sheets and concept modules.
- Solved all 70 coding problems across Weeks 1–9 and pushed them, branch by branch:

  | Branch | Sheet(s) | Problems |
  |---|---|---|
  | `feature/session_1` | Week 1 class + Week 1 assignment | 10 |
  | `feature/session_2` | Week 2 class + Week 2 assignment | 10 |
  | `feature/session_3` | Week 3 OOP concept module | 6 demos + 8 written answers |
  | `feature/session_4` | Week 4 Category C practice + assignment | 10 |
  | `feature/session_5` | Week 5 Category C practice | 5 |
  | `feature/session_6` | Week 6 Category C practice + concept module | 6 + 8 written answers |
  | `feature/session_7` | Week 7 Encapsulation practice + assignment | 10 |
  | `feature/session_8` | Week 8 polymorphism practice + assignment | 10 + quiz + 10 written answers |
  | `feature/session_9` | Week 9 Abstraction & Interfaces practice + assignment | 10 + quiz + 5 written answers |

- Every program was compiled with `javac` and run against the sample input printed in its own sheet; the outputs were checked line by line.

**Next Session Plan:**
- Add `feature/session_10` for the next sheet when it is issued, following the same `src/main/java/<topic>/class_problems` + `assigment_problems` layout.
- Keep appending a dated block here after each session.

**Issues Faced:**
- The **Week 8 Practice, Problem 3 (Delivery Fee Calculator)** sheet contradicts itself: its business rules give EXPRESS = 24.00 and INTERNATIONAL = 145.00 for the sample input, while its sample output prints 29.00 and 155.00 (STANDARD = 15.00 agrees with the rules). The solution follows the stated business rules; the discrepancy is documented in `week8/class_problems/DeliveryFeeCalculator.java` and in the Week 8 README.
- None otherwise.

---

## Branches

| Branch | Content allowed |
|--------|-----------------|
| `main` | This README and the problem sheets in `docs/` (no code) |
| `develop` | Empty Java project skeleton (no solved problems) |
| `feature/session_1` | Week 1 — `src/main/java/week1/` |
| `feature/session_2` | Week 2 — `src/main/java/week2/` |
| `feature/session_3` | Week 3 — `src/main/java/week3/` |
| `feature/session_4` | Week 4 — `src/main/java/week4/` |
| `feature/session_5` | Week 5 — `src/main/java/week5/` |
| `feature/session_6` | Week 6 — `src/main/java/week6/` |
| `feature/session_7` | Week 7 — `src/main/java/week7/` |
| `feature/session_8` | Week 8 — `src/main/java/week8/` |
| `feature/session_9` | Week 9 — `src/main/java/week9/` |

## Problem sheets

| Week | Sheet | File |
|------|-------|------|
| 1 | Day 1 Live-Coding (5 class problems) | [STEP-SEM-3 Week 1 Problems.pdf](./docs/STEP-SEM-3%20Week%201%20Problems.pdf) |
| 1 | Assignment (5 problems) | [STEP=SEM-3 Week 1_Problems_Assignment.pdf](./docs/STEP=SEM-3%20Week%201_Problems_Assignment.pdf) |
| 2 | Day 2 Live-Coding (5 class problems) | [STEP-SEM3-Week2-Practice Problems.pdf](./docs/STEP-SEM3-Week2-Practice%20Problems.pdf) |
| 2 | Assignment (5 problems) | [STEP-SEM3-Week2-Assignment Problems.pdf](./docs/STEP-SEM3-Week2-Assignment%20Problems.pdf) |
| 3 | OOP, Classes and Objects — concept module | [Week 3 OOP](./docs/STEP-SEM-3_Week_3_-OOP-Classes-and-Objects-Concept-Introduction.pdf) |
| 4 | Arrays Category C — practice | [Week 4 Practice](./docs/Array_Week4_Category_C_Practice_Problem.pdf) |
| 4 | Arrays Category C — assignment | [Week 4 Assignment](./docs/Array_Week4_Category_C_Assignment_Problem.pdf) |
| 5 | Java Arrays and Methods Category C | [Week 5 Practice](./docs/STEP-SEM-3_Week_5_Java_Arrays_and_Methods_Category_C_Practice_problems.pdf) |
| 6 | Classes and Objects Revision Category C | [Week 6 Practice](./docs/Classes%20and%20Objects%20Revision_Week6_Category_C_Practice_Problems.pdf) |
| 6 | Access Modifiers, Encapsulation & Object Modeling — concept module | [Week 6 Concept](./docs/STEP-SEM-3_Week_6_Access_Modifiers_Encapsulation_Object_Modeling_Category_C_Concept.pdf) |
| 7 | Encapsulation Category C — practice | [Week 7 Practice](./docs/Week7_Encapsulation_Category_C_Practice.pdf) |
| 7 | Encapsulation Category C — assignment | [Week 7 Assignment](./docs/Week7_Encapsulation_Category_C_Assignment.pdf) |
| 8 | Category C — practice | [Week 8 Practice](./docs/STEP-SEM-3_Week_8_Category_C_Practice.pdf) |
| 8 | Category C — coding assignment | [Week 8 Assignment](./docs/STEP-SEM-3_Week_8_Category_C_Coding_Assignment.pdf) |
| 9 | Abstraction / Interface / Class vs Interface — practice | [Week 9 Practice](./docs/Category%20C%20-%20Abstraction_Interface_Class%20Vs%20Interface.pdf) |
| 9 | Abstraction / Interface — coding assignment | [Week 9 Assignment](./docs/CATEGORY-C-Abstraction_Interface_Class%20Vs%20Interface_CODING-ASSIGNMENT.pdf) |
| — | Workflow guide | [STEP_GitHub_Structure_Guide.pdf](./docs/STEP_GitHub_Structure_Guide.pdf) |

## Package layout

Inside every feature branch the code is organised by topic, and every topic package holds exactly two
sub-packages:

```
src/main/java/<topic>/class_problems/      problems solved during the live session
src/main/java/<topic>/assigment_problems/  problems given as take-home assignments
```

## Building

```bash
# from a feature branch
javac -d out $(find src -name '*.java')

# run one solution (Weeks 1-7 take no input, Weeks 8-9 read stdin)
java -cp out week1.class_problems.PalindromeChecker
printf '3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000\n' | java -cp out week8.class_problems.PaymentSystemFeeCalculation
```

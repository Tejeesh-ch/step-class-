# Step_semester_3

Daily progress log and documentation for **STEP – Semester 3** (CodInClub, powered by BridgeLabz).

> Branching model follows [docs/STEP_GitHub_Structure_Guide.pdf](./docs/STEP_GitHub_Structure_Guide.pdf):
> `main` = documentation only · `develop` = empty project skeleton · `feature/session_n` = one coding session each.

## Date: 10-10-2026

**Today's Work:**
- Repository set up per the GitHub Repository Structure Guide: `main`, `develop`, and `feature/session_*` branches created.
- All problem sheets for the semester uploaded to [`docs/`](./docs/).

**Next Session Plan:**
- Solve the problem sheets session by session and push each one to its own `feature/session_n` branch.

**Issues Faced:**
- None

---

## Branches

| Branch | Content allowed |
|--------|-----------------|
| `main` | This README and the problem sheets in `docs/` (no code) |
| `develop` | Empty Java project skeleton (no solved problems) |
| `feature/session_1` | Week 1 solutions — `src/main/java/week1/` |
| `feature/session_2` | Week 2 solutions — `src/main/java/week2/` |
| `feature/session_3` | Week 3 solutions — `src/main/java/week3/` |
| `feature/session_4` | Week 4 solutions — `src/main/java/week4/` |
| `feature/session_5` | Week 5 solutions — `src/main/java/week5/` |
| `feature/session_6` | Week 6 solutions — `src/main/java/week6/` |

## Problem sheets

| Sheet | File |
|-------|------|
| Week 1 – Day 1 Live-Coding (5 class problems) | [STEP-SEM-3 Week 1 Problems.pdf](./docs/STEP-SEM-3%20Week%201%20Problems.pdf) |
| Week 1 – Assignment (5 problems) | [STEP=SEM-3 Week 1_Problems_Assignment.pdf](./docs/STEP=SEM-3%20Week%201_Problems_Assignment.pdf) |
| Week 2 – Day 2 Live-Coding (5 class problems) | [STEP-SEM3-Week2-Practice Problems.pdf](./docs/STEP-SEM3-Week2-Practice%20Problems.pdf) |
| Week 2 – Assignment (5 problems) | [STEP-SEM3-Week2-Assignment Problems.pdf](./docs/STEP-SEM3-Week2-Assignment%20Problems.pdf) |
| Week 3 – OOP, Classes and Objects (concept module) | [STEP-SEM-3_Week_3_-OOP-Classes-and-Objects-Concept-Introduction.pdf](./docs/STEP-SEM-3_Week_3_-OOP-Classes-and-Objects-Concept-Introduction.pdf) |
| Week 4 – Arrays Category C (5 practice problems) | [Array_Week4_Category_C_Practice_Problem.pdf](./docs/Array_Week4_Category_C_Practice_Problem.pdf) |
| Week 4 – Arrays Category C (5 assignment problems) | [Array_Week4_Category_C_Assignment_Problem.pdf](./docs/Array_Week4_Category_C_Assignment_Problem.pdf) |
| Week 5 – Java Arrays and Methods Category C (5 problems) | [STEP-SEM-3_Week_5_Java_Arrays_and_Methods_Category_C_Practice_problems.pdf](./docs/STEP-SEM-3_Week_5_Java_Arrays_and_Methods_Category_C_Practice_problems.pdf) |
| Week 6 – Classes and Objects Revision Category C (5 problems) | [Classes and Objects Revision_Week6_Category_C_Practice_Problems.pdf](./docs/Classes%20and%20Objects%20Revision_Week6_Category_C_Practice_Problems.pdf) |
| Workflow guide | [STEP_GitHub_Structure_Guide.pdf](./docs/STEP_GitHub_Structure_Guide.pdf) |

## Package layout

Inside every feature branch the code is organised by topic, and every topic package holds exactly two
sub-packages:

```
src/main/java/<topic>/class_problems/      problems solved during the live session
src/main/java/<topic>/assigment_problems/  problems given as take-home assignments
```

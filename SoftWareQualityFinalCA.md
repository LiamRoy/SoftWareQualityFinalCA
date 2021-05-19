# SoftWareQualityFinalCA
## Introduction

The goal of this project is to be a reference guide for best practices during software development following a test driven approach. The project is about storing information about student grades.
---
## Features/Requirements
- Creating Rubrics
- Listing Rubrics
- Adding Rubrics Criteria
- Get rubrics by name
- Create student grade
- Add new student grade
- Get all student grades
 - Grade Calculations 
---
## Sections  
Scrum sprint backlog and task estimation
Unit testing and Test-Driven development
Test coverage metric
Team version-control 
Code-review checklist
---
# Scrum sprint backlog and task estimation

Sprint Backlog is a Scrum Artifact. Scrum is an agile framework used for developing and delivering software in short periods of time. These short periods of time are called sprints, generally a 2-week period that starts with a Sprint plan and ends with the product coded. 
The sprint backlog is a list of tasks by the Scrum team to be completed during the sprint. During the sprint planning meeting, the team selects several product backlog items. These consist of User Stories and tasks identified by the team.
### Task Estimation

Task Estimation in Scrum projects is done by the entire team. It is setup during the Spring Planning meeting. The goal of Estimation is to consider the User Stories for the Sprint by Priority and by the Ability of the team to deliver during the Time Box of the Sprint. 
Types of Estimation includes Story Points with its most popular being Planning Poker. Planning Poker is what I will be using in this project. In this technique each task is assigned a story point value relating to its complexity. 
I will be using the Fibonacci sequence. The Fibonacci sequence is a series of numbers in which each number ( Fibonacci number ) is the sum of the two preceding numbers. The simplest is the series 1, 1, 2, 3, 5, 8, etc. Using the Fibonacci sequence allows for a simple and clear distinction between task estimates.
**1** is the lowest number meaning it is a task which requires minimal effort or problem solving. Example: A name change.
**2** is slightly more complex but still a straight-forward task.
Example: Adding a return statement.
**3** is a task that would require a degree of computational thinking, but still relatively straightforward.
Example: Looping through a collection.
**5** is a task which requires more logical thinking to implement.
Example: Designing and implementing mathematical algorithms.
**8** is the second highest value and should be given to a very complex function.
Example: Carrying out a high degree of computation or data manipulation.
**13** is the highest value that can be given to a task on this scale. This would be a task which requires a very substantial amount of effort and solving to implement. If it is decided that a task is valued at 13 the team should work to try and break the task down in to smaller steps.

### Tasks
-	Create new rubric - 2
-	Add Criterion to rubric - 3
-	Get a list of all rubrics - 3
-	Get rubrics by name - 5
-	Create student grade - 2
-	Add new student grade - 2
-	Get all student grades - 5
### Grade Calculations
-	Average - 5
-	Standard deviation - 8
-	Minimum - 3
-	Maximum – 3

I will be comparing two tasks to show why one has a certain amount of story points compared to the other. They are:
- Create a new Rubric – size 2
- Get the grade average – size 5

When comparing tasks, it is important to look at the computational factors, complexity, and the steps it will take to complete it. Creating a rubric is not that complex and is a very easy object to create. With the average, I must get all the grades from the collection, get the sum, and then divide it by the number of entries. This is more complex and therefore has a higher story point.

### Velocity
The velocity metric is used to determine the size of the entire sprint. To calculate the velocity of a sprint, you must add up all the story points for each individual task. It may not give an accurate reading after the first Sprint, but as time progresses and more Sprints are completed you can work out the teams average velocity.


# BoardR - Task Organizing System

_Part 1_

## 1. Description

**BoardR** is a task-management system which will evolve in the next several weeks. During the course of the project, we will follow the best practices of `Object-Oriented Programming` and `Design`.

## 2. Goals  

Your goal is to design and implement the main building blocks of the application - the **BoardItem** class and the **Board** class.

## 3. Setup

- Create a new project - a console application - and name it **BoardR**  
- **Make sure that you are using JDK 11**  
- Leave the main method empty for now.  
- Create two classes - `Board` and `BoardItem`, each in a separate file.  

## 4. BoardItem class

### Description

This class will model our idea of an **Item** that we can put in a **Board** (check [Trello](https://trello.com/)). A BoardItem can be used to describe anything - a **task**, **bug**, **note**, **assignment**...

A minimum viable BoardItem should have at least a `title` (describes what this item is about), `dueDate` (when it should be done), and `status` (describes the state of this item - being worked on, being completed, etc..)  

For a useful BoardItem, the `title` should not be empty. The `dueDate` should probably be in the future - we can't expect a task to be finished before we created it. There must be some rules on how a BoardItem changes its state - for example, from a state you can only _advance_ to the next one or _rollback_ to the previous one.  

### Fields

- **title**: _String_, should never be empty, and its length should be between [5, 30] ([How to read bracket notation for ranges?](https://stackoverflow.com/questions/4396290/what-does-this-square-bracket-and-parenthesis-bracket-notation-mean-first1-last))
- **dueDate**: _LocalDate_, should never be in the past
- **status**: `Open -> Todo -> InProgress -> Done -> Verified` (maybe `Enum` can help here).

> Note: for the first version of the application don't implement any validation, you will add it later

### Constructor

When creating a BoardItem, we must be forced to provide title and date, and we must start from the initial state (a constructor with the right arguments will come in handy).

- Should accept a `title`, a `date` and assign those to their respective fields
- A new `BoardItem` must have its `status` as `Open`

#### Example

```java
BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
System.out.println(item.title);
System.out.println(item.dueDate);
System.out.println(item.status);
```

#### Output

```none
Registration doesn't work
2020-01-25 (exact date you will see depends on when you run the code)
Open
```

> Note: ignore any difference in the format of the printed date; use default printing on your system

### Methods

- **revertStatus()** - returns the `status` to a previous state - e.g. from **Todo** to **Open**, from **Done** to **InProgress**, etc (no effect if the status is **Open**)
- **advanceStatus()** - advances the `status` to a next state - e.g. from **Open** to **Todo**, from **Done** to **Verified**, etc (no effect if the status is **Verified**)

#### Example

```java
BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
System.out.println(item.status);
item.advanceStatus();
System.out.println(item.status);
item.advanceStatus();
System.out.println(item.status);
item.revertStatus();
System.out.println(item.status);
```

#### Output

```none
Open
Todo
InProgress
Todo
```

- **viewInfo()** - returns information about the current BoardItem in format `'title', [status | dueDate]`

#### Example

```java
BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
System.out.println(item.viewInfo());
```

#### Output

```none
'Registration doesn't work', [Open | 2020-07-02]
```

> Note: ignore any difference in the format of the printed date; use default printing on your system

## 5. Board class

### Description

The **Board** class will be used to organize all the BoardItems that we create. In the future, we might want to use it for searching, grouping, viewing, storing...

For now, the **Board** will be no more than a collection of BoardItems. In the next couple of days, we will enhance it.  

### Fields

List of BoardItems - we must be able to add items to the board.

### Constructor

Create empty list of BoardItems.

### Methods

We will add some in the next chapter.

#### Example

```java
BoardItem item = new BoardItem("Registration doesn't work", LocalDate.now().plusDays(2));
item.advanceStatus();
BoardItem anotherItem = new BoardItem("Encrypt user data", LocalDate.now().plusDays(10));

Board board = new Board();

board.items.add(item);
board.items.add(anotherItem);

for (BoardItem boardItem : board.items) {
    boardItem.advanceStatus();
}

for (BoardItem boardItem : board.items) {
    System.out.println(boardItem.viewInfo());
}
```

#### Output

```none
'Registration doesn't work', [In Progress | 2020-07-02]
'Encrypt user data', [To Do | 2020-07-10]
```

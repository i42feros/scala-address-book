# Scala address book

## Overview

This application will read an addressBook file and will answer the following questions:

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?


## How to run

Assuming that you have sbt install, you can run the code with:
```
sbt run
```

After running it, you should see something like this: 
```
Address book app running!
* * Questions * *
- How many males are in the address book?
  3
- Who is the oldest person in the address book?
  Wes Jackson
- How many days older is Bill than Paul?
  2862 days older
```

If you want to test the code run:
```
sbt test
```


## Explanation

The program will load data from a given file path. It will parse the data into domain object and
load them in the `ReplyQuestionsService`. Then, by calling `printQuestionsFromData` it will get 
the answers of every question and print them.

With the solution given if a new file is added with different information, it will just require
to implement a new `FileParser` where it is just needed to create the method of how to parse each
line (array of string) in a domain object.

If new question is required, we just need to add them to the `HumanQuestionsService` and create
a new `QuestionAnswer` implementation.  

## Assumptions

- When reading a file, if it contains any invalid data we will ignore that row
- When matching by name, as in the question 3, if a name is duplicated in the file, it will pick up the first one.

## Possible improvements

- Instead of returning `Option` in the `DaysOlderThan` class, it could be done by using `Either`, so that
we can get more useful messages to the user

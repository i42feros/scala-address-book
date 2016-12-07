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
or you can test the code by running
```
 sbt test
 ```


## Explanation

// TODO

## Assumptions

- When reading a file, if it contains any invalid data we will ignore that row
- When matching by name, as in the question 3, if a name is duplicated in the file, it will pick up the first one.

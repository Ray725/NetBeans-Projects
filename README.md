# NetBeans-Projects
Repository for Java projects. 

This is a collection of small algorithmic projects and (eventually) some machine-learning based code.

## Sorting Project (specification from http://mindprod.com/project/projects.html):
This project is for tidying Java source code by alphabetizing the array initialisation statements. The user would mark array initialization statements he/she wanted sorted with a comment `/* sort */`. You would sort them all then write results back over the original.

What you sort looks like this:
```java
final static String[] ANIMALS = new String[] /* sort */ { "eland", "antelope", "hippopotamus”};
```

* The user may have a horizontal or vertical list. You should preserve that.
* The list could be Strings, longs, shorts, ints, chars, floats, doubles… You have to detect what kind the list is, and ensure all elements are the same type, and use a suitable comparator.
* If there are any expressions in the list you should sort the list of primitives before and after them, but leave the expressions in place.
* If there are objects in the list, you should abort the sort of that list.
* The good news is the parsing is duck simple. Just look for { , , }. It gets a little bit complicated with Strings since they can contain embedded commas. Check each entry with a regex.

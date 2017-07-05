## Binary Search Questions

This project contains interview questions that revolve around binary search.

### Questions:

**"Suppose we had an array of n integers sorted in ascending order. How quickly could we check if a given integer is in the array?"**

Since they are sorted, the best way to search through it is with a binary search. We can take advantage of the fact that it is sorted and use the properties of a binary search to eliminate an entire side of the array at each step.

The runtime complexity of this solution will be O(log(n)) since it will take log(n) to reduce the input size to 1.

The solution is contained in - FindInOrderedSet.java

**I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know. I put each word I didn't know at increasing indices in a huge array I created in memory. When I reached the end of the dictionary, I started from the beginning and did the same thing until I reached the page I started at.

Now I have an array of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet, reach the end, and then start from the beginning of the alphabet.**

Eg.
~~~
  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote", // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};
~~~

A solution for this would be to sort the array, then perform a linear search to find the item. This can be done in O(nlog(n)) + O(n) time. 

A faster solution would be to modify the binary search that will always break the array down until we get to a sub-array of size 1.

Since we don't have an element to search for, we only care about whether the string values at the start and end indices. The relationship in this type of half ordered array is as follows:

If the left (start) value is smaller than the right (end) value, we want to search the left side of the array.

If the left (start) value is greater than the right (end) value, we want to search the right side of the array. 

When we have broken down the array into the smallest size (1), we return the middle item.

The runtime complexity of this algorithm is O(log(n)) since it is still a binary search. The only difference in this algorithm is that we do not terminate when we have found the item and only terminate when we get to an array of size 1. The searching of the left and right sub-arrays is the same relationship.

This solution works for arrays that are sorted and partially-sorted, it is a good way to think about the use of a binary search.

**Find a duplicate, Space Edition™.

We have an array of integers, where:

The integers are in the range 1..n
The array has a length of n+1

It follows that our array has at least one integer which appears at least twice. But it may have several duplicates, and each duplicate may appear more than twice.

Write a function which finds an integer that appears more than once in our array.**

This solution again requires a modification to the binary search. We will have our base case when the array size is 1. In this instance, the middle value should be the duplicate.

The input gives us a hint as to which direction (left or right) to go. Because we know the integers range from 1 -> n, and the array is of size n + 1, we can take advantage of the knowledge that if the value of the item in the index is equal to the index, then it must be in its correct slot, and that the additional item should be on the right side of the array. 

If the index value and index do not equal, then we know that the duplicate item is on the left side of the array.  

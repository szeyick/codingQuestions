## Rotation Point

Write a function for finding the index of the "rotation point," which is where I started working from the beginning of the dictionary. This array is huge (there are lots of words I don't know) so we want to be efficient here.

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

### Naive Solution:

There can be a linear time O(n) solution for this. The idea would be to start at the beginning of the array, and compare with each adjacent value. If the current value is greater than (comes alphabetically after) the adjacent value, then the adjacent value is the rotation point.

Loop(words)
	currentWord = words[i]
	adjacentWord = words[i + 1]
	
	if (currentWord.compareTo(adjacentWord) >= 0) 
		keep going
	else 
		break
		
	return adjacent word 
	
This whilst linear will take quite a long time if the size of the input was large. 

### Optimal Solution:

The optimal solution which can be achieved in O(log(n)) time would be to use a modified binary search. Because we know that the words are in some type of order, we can take advantage of this relationship.

The implementation of the binary search is the same as usual, the only difference being the comparison that we make that defines whether we go left or right. For this, we always compare the middle value with the value at index 0 of the array.

Every item to the right of our rotation point is always alphabetically before the first item in the array.

So the rotation point is to our left if the current item is less than the first item. Else it's to our right.

function findPoint(left, right, input)
	if (left < right)
		middle = left + right / 2
		if (input[middle].compareTo(input[0]) < 0) 
			findPoint(left, middle)
		else 
			findPoint(middle + 1, right)
	else return left

We go left if the current item is smaller than the first item in the array. Terminate when left bound is greater than right bound

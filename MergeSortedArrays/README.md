## Merging Sorted Arrays

In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.

- Each order is represented by an "order id" (an integer).

We have our lists of orders sorted numerically already, in arrays. Write a function to merge our arrays of orders into one sorted array.

For example:

~~~
int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
~~~

Solution:

This solution can be achieved in O(m + n) time, where m is the first array, and n is the second array. We can take advantage of the fact that both arrays are ordered and it is a process of stepping through one of the arrays until it hits the end, then adding the rest of the second array.

This merge is in fact the merge function for merge sort.

We will need O(m + n) space since the merged arrays will sit in a new array.

mergeArrays(myArray, alicesArray)
	combinedArray = new int[myArray.length + alicesArray.length]
	loop (until end of myArray OR alicesArray)
		if (myArray[myIndex] > alicesArray[alicesIndex])
			combinedArray[combIndex] = alicesArray[alicesIndex]
			alicesIndex++
		else 
			combinedArray[combIndex] = myArray[myIndex]
			myIndex++
	add rest of non-empty array (myArray OR alicesArray) to combinedArray
	return combinedArray

Care needs to be taken here when iterating through the arrays. We want the loop to break when one of the two arrays has reached the end. 
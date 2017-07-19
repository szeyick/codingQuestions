## Inflight Entertainment.

Write a function that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.

When building your function:

- Assume your users will watch exactly two movies
- Don't make your users watch the same movie twice
- Optimize for runtime over memory

### Naive Solution:

A simple solution for this would be to use two loops, an outer loop that looks at the current index, and an inner loop that searches the rest of the array for the remaining value.

function findMovieLengths(flightLength, movieLengths)
	found = false;
	loop(movieLengths.start -> movieLengths.end)
		movieLength = movieLength[i]
		loop(movieLenghts[i + 1] -> movieLengths.end)
			otherMovieLength = movieLength[i + 1]
			if (flightLength - movieLength == otherMovieLength) {
				found = true
			}
		}
	}
	return found
}

This solution takes O(n^2) since we are required to scan through the input n times, and the inner loop also scans through n times. 

### Middle Solution:

Another solution would be to sort the input. This will place the input in sorted order where we can then use a binary search to find the compliment value. To avoid finding the item that we used to calculate the compliment for, we can restrict the binary search to the currentIndex + 1 -> end so that it does not include the current value.

This will yield an O(n log(n)) solution as it defines the sorting and search.

function findMovieLengths(flightLength, movieLengths)
	found = false
	sort(movieLengths)
	loop(movieLengths[i] -> end)
		currentMovie = movieLengths[i];
		compliment = flightLength - currentMovie
		found = binarySearch(currentMovie, movieLengths, i + 1)
		if (found)
			found = true;
			break;
		}
	}
	return found

### Optimal Solution:

The optimal solution here would be to use a hash set to store the movies that we have already seen. Then with the compliment, we search this hash set to see if there is a movie that matches the compliment time. 

function findMovieLengths(flightLength, movieLengths)
	found = false
	seenMovies = hashSet
	loop(movieLengths)
		compliment = flightLength - movieLengths[i]
		if (seenMovies.contains(compliment)) 
			found = true;
			break;
		seenMovies.add(movieLengths[i])

This reduces the problem down to a linear time O(n) time. The reason that this works is because we are storing the movies in the set as we watch them, and look for the compliment before. Because we are only doing a single pass of the movie lengths input, we are guaranteed to not see the same movie twice.
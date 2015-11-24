# CLU
A program that writes programs


> Kevin Flynn: You are CLU.  
> CLU: I am CLU.  
> Kevin Flynn: You will create the perfect system.  
> CLU: I will create the perfect system.  
> Kevin Flynn: [embracing CLU] Together we're going to change the world, man.  
> -- from [TRON:Legacy](http://www.imdb.com/title/tt1104001/)


## Purpose

**C**odified **L**ikeness **U**tility is a [Clojure](http://clojure.org/) program that use genetic programming to rewrite and optimize your program. To be exact, CLU can't create new programs but can rewrite existing programs in a more efficient way (if a more efficient way can be found).

## How does it work ?

You require it in your [Clojure](http://clojure.org/) program and give it a list of namespaces to watch. Every [**pure**](https://en.wikipedia.org/wiki/Pure_function) function annotated as ^:evolvable will be watched and rewritten in other threads. Every calls to evolvable functions will be proxified through it. CLU will remember call parameters and returned results. After collecting enough data it will try to optimize the function. If a better one is found, CLU will archive the old one and replace it with the new one at runtime.

### What is a better function?
A function can be ranked using those criteria, sorted by priority:  

1. Result correctness
- Average execution time
- Cyclomatic complexity
- Usage of high order functions

### What should I do so ?

First, you need to create a function that is **pure** and **correct**. If your function throw exceptions, CLU will consider it "dead" and will give it a bad grade (will change in the future). If the result is not correct when CLU collect samples, CLU will evolve your function in the wrong way.  
Then, you need to give CLU some hints by annotating your evolvable functions:

- ^:evolvable : state if CLU should watch the function (**the function must be pure**).
- ^:min-samples *n* : CLU will collect at least *n* samples (parameters and results) before trying to improve this function.
- ^:comparator : A function that compare two results to check the correctness and return a number. Must return 0 if both results are the same or a number proportional to the differences.
- ^:using : A vector of functions that CLU can use **in addition to** the already used functions inside the current function.

CLU will take care of the rest. If you want to give it more details:

- ^:iterations *n*
- ^:migrations *n*
- ^:num-islands *n*
- ^:population-size *n*
- ^:tournament-size *n*
- ^:mutation-probability *n*
- ^:max-depth *n*
- ^:numbers [1 2 3 …]


### Where is the fitness function ?
CLU will use your ^:comparator function to evaluate the fitness according to its own criteria.

### What about the terminals and functions for the genetic algorithm?
CLU will explore the ^:evolvable function and find terminals and functions by itself.
If you wand to use more functions, use the ^:using annotation with a vector of functions.

### Can we improve CLU with CLU ?
That's the hidden purpose of this project ;) This and having fun.

## Where is the code ?
I'm working on it. This is not a easy task and I don't have enough time to work on it at the moment. During this time, this readme is more of a guideline. I will publish it as soon as I have something working properly !

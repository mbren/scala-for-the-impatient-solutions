//Higher order functions (Chapter 12 Exercises, p.153)

object Ch12_HigherOrderFunctions {

  //Q5
  // Write a function <largest(fun: (Int) => Int, inputs: Seq[Int])> that yields the largest value of a function within a given sequence of inputs.
  // For example, <largest(x => 10 * x - x * x, 1 to 10)> should return 25. Don't use a loop or recursion.

  def largest(fun: Int => Int, inputs: Seq[Int]): Int = inputs.map(fun).max

  //Q6
  // Modify the previous function to return the input at which the output is largest.
  // For example, <largestAt(fun: (Int) => Int, inputs: Seq[Int])> should return 5. Don't use a loop or recursion.

  // My approach was to zip the inputs and the results into a Vector of tuples.
  // For example, given test input (x => 10 * x - x * x, 1 to 10),
  // this will give ((1,9), (2,16), (3,21), (4,24), (5,25), (6,24), (7,21), (8,16), (9,9), (10,0))
  // After the tuples are created, it's easy to use reduceLeft to do a comparison on the results in the second position of the tuple to find the element with the max value.
  // The "._1" at the end returns the input value stored in position 1 of the max tuple

  def largestAt(fun: Int => Int, inputs: Seq[Int]): Int = inputs.zip(inputs.map(fun)).reduceLeft((a, b) => if (a._2 >= b._2) a else b)._1

  //Q7
  // It's easy to get a sequence of pairs, for example
  //val pairs = (1 to 10) zip (11 to 20)
  //Now suppose you want to do something with such a sequence - say, add up the values. But you can't do <pairs.map(_ + _)>
  //The function _ + _ takes two <Int> parameters, not an <(Int, Int)> pair. Write a function <adjustToPair> that receives a function of type <(Int, Int) => Int> and returns the
  // equivalent function that operates on a pair. For example, <adjustToPair(_ * _)((6,7)) is 42.
  //Then use this function in conjunction with <map> to compute the sums of the elements in <pairs>.

  def adjustToPair(f: (Int, Int) => Int): ((Int, Int)) => Int = {
    {case (param1, param2) => f(param1, param2)}
  }

}

import scala.math._

package mymath {

  //Q3: Write a package <random> with functions <nextInt() : Int, nextDouble(): Double>, and <setSeed(seed: Int): Unit>.
  // To generate random numbers, use the linear congruential generator
  // next = (previous * a + b) mod 2n
  // where a=1664525, b=1013904223, n=32, and the initial value of previous is <seed>.

  package object random {

    val a: Int = 1664525
    val b: Int = 1013904223
    val n: Int = 32
    var previous: BigInt = 0
    var next: BigInt = 0

    def setSeed(seed: Int): Unit = {
      previous = seed
    }

    // Returns the next "random" Int value from the number generator's sequence.
    def nextInt(): Int = {
      next = (previous * a + b) % scala.math.BigInt(2).pow(n)
      previous = next
      next.toInt
    }

    // Returns the next "random" double value.
    def nextDouble(): Double = 1.0 * nextInt() // Create a double by taking a random Int and multiplying by 1.0
  }

}
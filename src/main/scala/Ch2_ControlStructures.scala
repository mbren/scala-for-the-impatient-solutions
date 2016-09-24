class Ch2_ControlStructures {
  // Q6: Write a for loop for computing the product of the Unicode codes of all letters in a string.
  // For example, the product of the characters in "Hello" is 9415087488L. */
  def prodOfCodes(inStr: String) : Long = {
    var productOfLetters: Long = 1
    for (ch <- inStr)
      productOfLetters *= ch.toInt
    productOfLetters
  }

  // Q7: Solve the preceding exercise without writing a loop (Hint: look at the StringOps Scaladoc)
  def prodOfCodes2(inStr: String) : Long = inStr.map(_.toLong).product

  // Q8: Write a function product(s : String) that computes the product, as described in the preceding exercises
  def productOld(s: String): Long = s.map(_.toLong).product

  // Q9: Make the function of the preceding exercise a recursive function
  def product(s: String): Long =
    if (s isEmpty) 1 else s.head.toInt * product(s.tail)

  // Q10: Write a function that computes x^n, where n is an integer.
  // Use the following recursive defintion:
  //  x^0=1
  //  x^n = 1/x^-n if n is negative
  //  x^n = y^2 if n is even and positive, where y = x^(n/2)
  //  x^n = x*x^(n-1) if n is odd and positive
  //  don't use a return statement
  def computeRec(x: Double, n: Int): Double =
    n match {
      case 0 => 1
      case n if n < 0 => 1 / computeRec(x, -n) //n is Negative so do 1/x^-n
      case n if n % 2 == 0 => computeRec(x, n / 2) * computeRec(x, n / 2) //n is Positive and even
      case _ => x * computeRec(x, n - 1) //otherwise, n is Positive and odd
    }
}

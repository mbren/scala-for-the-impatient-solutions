object Ch13_Collections {

  //Collections (Chapter 13 Exercises, p. 179)
  //Q0a
  //I have a Vector of floating-point values called z. Show the code to sort this Vector (ascending, by the value)
  def sortAsc(z: Vector[Double]): Vector[Double] = z.sorted

  //Q0b
  //Given x, a List of integers, how can I get the first 3 values in the list?
  def take3(list: List[Int]): List[Int] = list.take(3)

  //Q0c
  //If I have a Map of [String, Int], and I want to get the value with the key "foo" from the map, but return a zero if
  // it is not present in the map, what could would I write?
  def getValForKey(key: String, m: Map[String, Int]): Int = m.getOrElse(key, 0)

  //Q0d
  //If I have a list of Int, and I want a new list containing only the odd values, what's the simplest way to do this?
  def oddVals(list: List[Int]): List[Int] = list.filter(a => a % 2 != 0)

  //Q0e
  //I have two lists of Ints and I want a new list that contains all the elements of both lists - show code
  def combineLists(aList: List[Int], bList: List[Int]): List[Int] = aList ::: bList

  //Q0f
  //How can I add one more int to a list of ints, producing a new list?
  def addAtHead(x: Int, list: List[Int]): List[Int] = x :: list

  //Q4
  //Write a function that receives a collection of strings and a map from strings to integers. Return a collection of
  // integers that are values of the map corresponding to one of the strings in the collection.
  // For example, given <Array("Tom", "Fred", "Harry")> and <Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)> return <Array(3,5)>.
  def getValsFromMap(arr: Array[String], m: Map[String, Int]): Array[Int] = arr.flatMap(m.get(_))

  //Q5
  //Implement a function that works just like <mkString>, using <reduceLeft>.
  //Returns a string representation of an Iterable object. Optionally, specify a separator or specify a prefix, separator, and suffix.
  def mkStringNew(collection: Seq[Any]): String =
    collection.map(_.toString).reduceLeft((a, b) => a + b)

  def mkStringNew(separator: String, collection: Seq[Any]): String =
    collection.map(_.toString).reduceLeft((a, b) => a + separator + b)

  def mkStringNew(prefix: String = "", separator: String = "", suffix: String = "", collection: Seq[Any]): String =
    prefix + collection.map(_.toString).reduceLeft((a, b) => a + separator + b) + suffix

  //Q9
  // A person writes a program that accepts a sequence of file names on the command line.
  // For each, they starts a new thread that reads the file and updates a letter frequency map
  //a) Why won't this work? (Give detailed explanation on why not)
  //This won't work because the HashMap might be getting mutated in one thread while the other threads are accessing it at the same time.
  //  val str: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
  //    "when an unknown printer took a galley of type and scrambled it to make a type specimen book."
  //  val frequenciesOld = new scala.collection.mutable.HashMap[Char, Int]
  //  for (c <- str) frequenciesOld(c) = frequenciesOld.getOrElse(c, 0) + 1

  //Q10
  //She reads a file into a string and wants to use a parallel collection to update the letter frequencies concurrently
  //on portions of the string. She uses the following code:
  //    val frequencies = new scala.collection.mutable.HashMap[Char, Int]
  //    for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1
  //    frequencies.toSeq.sortBy(_._2)
  //a) Why is this a terrible idea?
  // It concurrently mutates the hashmap.
  //b) How can he really parallelize the computation?
  //Use the par.aggregate function to iterate through the hashmap safely.
  def getFrequencies(str: String): scala.collection.mutable.Map[Char, Int] = {
    str.par.aggregate(scala.collection.mutable.Map[Char, Int]())( //initial condition
      (acc, c) => {
        acc + (c -> (acc.getOrElse(c, 0) + 1))
      }, //sequencing operation
      (x, y) => x ++ y.map { case (key, value) => key -> (value + x.getOrElse(key, 0)) } //combination operation
    )
  }
}


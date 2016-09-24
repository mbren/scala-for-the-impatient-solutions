object Ch3_Arrays {

  //Q7
  // Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc)
  def uniqueVals(arr: Array[Int]): Array[Int] = arr.distinct

  //Q9
  // Make a collection of all time zones returned by <java.util.TimeZone.getAvailableIDs> that are in America.
  // Strip off the <"America/"> prefix and sort the result.
  def getAmericanTimeZones(): Array[String] =
    java.util.TimeZone.getAvailableIDs(). //Get  all time zones
      filter(_.startsWith("America/")). //Grab only the American ones NOTE: This includes timezones in Canada.
      map(_.stripPrefix("America/")). //Remove the ("America/") prefix
      sorted // Sort the result.

}

//Class Instantiation/Constructors (Chapter 5 Exercises, p.63)

// Q8a
// The Car class has read-only properties for manufacturer, model name, and model year, and a read-write property for the license plate.
// Required properties: manufacturer, model name.
// Optionally, model year and license plate can also be specified in the constructor.
// If not, the model year is set to -1 and the license plate to an empty string.
// Which constructor are you choosing as the primary constructor? Why?
//   The primary constructor includes manufacturer and modelName because those are the required params that are needed in every constructor.
class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var licensePlate: String) {
  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1, "")
  }

  def this(manufacturer: String, modelName: String, modelYear: Int) {
    this(manufacturer, modelName, modelYear, "")
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName, -1, licensePlate)
  }
}

// Q8b
// Can you rewrite the Car class (call it CarAlt) from 8a using a single constructor with default parameters?
class CarAlt(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
}

//Q9
//See Constructors.java

// Q10
// Consider the class
//      class Employee(val name: String, var salary: Double) {
//        def this() { this("John Q. Public", 0.0) }
//      }
// Rewrite it to use explicit fields and a default primary constructor.
class Employee(empName: String = "John Q. Public", empSalary: Double = 0.0) {
  val name = empName
  var salary = empSalary
}


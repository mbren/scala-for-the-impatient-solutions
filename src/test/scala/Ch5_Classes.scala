import org.scalatest.{FunSpec, Matchers}

class Ch5_Classes extends FunSpec with Matchers {
  describe("*****Question 8a tests") {
    it("Car: Honda Civic") {
      val myCar: Car = new Car("Honda", "Civic")
      assert(myCar.manufacturer === "Honda")
      assert(myCar.modelName === "Civic")
      assert(myCar.modelYear === -1)
      assert(myCar.licensePlate === "")
    }
    it("Car2: Honda Civic 2003") {
      val myCar2: Car = new Car("Honda", "Civic", 2003)
      assert(myCar2.manufacturer === "Honda")
      assert(myCar2.modelName === "Civic")
      assert(myCar2.modelYear === 2003)
      assert(myCar2.licensePlate === "")
    }
    it("Car3: Honda Civic NNC445") {
      val myCar3: Car = new Car("Honda", "Civic", "NNC445")
      assert(myCar3.manufacturer === "Honda")
      assert(myCar3.modelName === "Civic")
      assert(myCar3.modelYear === -1)
      assert(myCar3.licensePlate === "NNC445")
      myCar3.licensePlate = "QWE432"
      assert(myCar3.licensePlate === "QWE432")
      //modelYear should not be settalbe
      //myCar3.modelYear = 1902
      //assert(myCar3.modelYear === 1902)
      //licensePlate should be settalbe
      myCar3.licensePlate = "QWE432"
      assert(myCar3.licensePlate === "QWE432")
    }
  }
  describe("*****Question 8b tests") {
    it("CarAlt: Honda Civic") {
      val myCarAlt: CarAlt = new CarAlt("Honda", "Civic")
      assert(myCarAlt.manufacturer === "Honda")
      assert(myCarAlt.modelName === "Civic")
      assert(myCarAlt.modelYear === -1)
      assert(myCarAlt.licensePlate === "")
    }
    it("myCarAlt3: Honda Civic NNC445") {
      val myCarAlt3: CarAlt = new CarAlt("Honda", "Civic", licensePlate = "NNC445")
      assert(myCarAlt3.manufacturer === "Honda")
      assert(myCarAlt3.modelName === "Civic")
      assert(myCarAlt3.modelYear === -1)
      assert(myCarAlt3.licensePlate === "NNC445")
      myCarAlt3.licensePlate = "QWE432"
      assert(myCarAlt3.licensePlate === "QWE432")
    }
  }
  describe("*****Question 10 tests") {
    it("default constructor") {
      val myEmployee: Employee = new Employee()
      assert(myEmployee.name === "John Q. Public")
      assert(myEmployee.salary === 0.0)
    }
    it("Jane Public + 1,000,000.00") {
      val myEmployee: Employee = new Employee("Jane Public", 1000000.00)
      assert(myEmployee.name === "Jane Public")
      assert(myEmployee.salary === 1000000.00)
    }
  }
}

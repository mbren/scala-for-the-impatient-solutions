//Chapter 5, Q9
// Reimplement the class of the preceding exercise in Java. How much shorter is the Scala class?
public class Ch5_Constructors {
    class Car {
        private String manufacturer;
        private String modelName;
        private int modelYear;
        public String licensePlate;

        public Car(String manufacturer, String modelName, int modelYear, String licensePlate) {
            this.manufacturer = manufacturer;
            this.modelName = modelName;
            this.modelYear = modelYear;
            this.licensePlate = licensePlate;
        }

        public Car(String manufacturer, String modelName) {
            this.manufacturer = manufacturer;
            this.modelName = modelName;
            this.modelYear = -1;
            this.licensePlate = "";
        }

        public Car(String manufacturer, String modelName, int modelYear) {
            this.manufacturer = manufacturer;
            this.modelName = modelName;
            this.modelYear = modelYear;
            this.licensePlate = "";
        }

        public Car(String manufacturer, String modelName, String licensePlate) {
            this.manufacturer = manufacturer;
            this.modelName = modelName;
            this.modelYear = -1;
            this.licensePlate = licensePlate;
        }

        public String manufacturer() {
            return this.manufacturer;
        }

        public String modelName() {
            return this.modelName;
        }

        public int modelYear() {
            return this.modelYear;
        }

        public String licensePlate() {
            return this.licensePlate;
        }

        public void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }
    }
}

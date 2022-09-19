public class RunCar{
    public static void main(String[] args) {
        Car Car1 = new Car("Camaro", "Red", "Cheverolet");
        Car1.printCarDetails();
        Car1.setPrice(50000);
        Car1.printCarDetails();
        Car Car2 = new Car("G Class", "Purple", "Mercedes", 200000);
        System.out.println("The Price of " + Car2.getModel() + " is $" + Car2.getPrice());
    }
}
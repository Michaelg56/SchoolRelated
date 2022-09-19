public class Car{
	private String model, color, make;
	private double price;
	
	public Car(String model, String color, String make) {
		this.model = model;
		this.color = color;
		this.make = make;
	}
	public Car(String model, String color, String make, double price) {
        this(model, color, make);
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    public String getModel() {
        return this.model;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void printCarDetails() {
        System.out.println("Car model: " + getModel() + ", Color: " + this.color + ", Make: " + this.make +
                ", Price: $" + getPrice());
    }
}
package Project;

public abstract class Vehicles implements Comparable<Vehicles>, Cloneable {

	// Declare the variables
	protected String modelName;
	protected String ModelNo;
	protected String Brand;
	protected String engineType;
	protected double tunkSize;
	protected double FuelConsumption;
	public Owner owner;

	// No-Argument constructer
	public Vehicles() {
		super();
	}

	// Arguments Constructer
	public Vehicles(String modelName, String modelNo, String brand, Owner owner, String engineType, double tunkSize,
			double fuelConsumption) throws Exception {
		super();
		this.modelName = modelName;
		ModelNo = modelNo;
		Brand = brand;
		setEngineType(engineType);
		this.tunkSize = tunkSize;
		FuelConsumption = fuelConsumption;
		this.owner = owner;
	}

	// Method to find and return the movable distance by multiply fuel consumption
	// by tank size
	public double Movable_distance() {
		double distance = FuelConsumption * tunkSize;
		return distance;
	}

	// Abstract method to find and return the cost of fuel for 100 km
	public abstract double costFor100Km() throws IllegalArgumentException;

	// Abstract method to calculate the fuel consumption when the air condition is
	// on
	public abstract void fuelConsumptionWithACOn();

	// Abstract method that turn on the condition if it was off, and return if we
	// turn it on or not
	public abstract boolean SetAirConditionOn();

	// Abstract method that turn off the condition if it was on, and return if we
	// turn it off or not
	public abstract boolean SetAirConditionOff();

	// Override clone object from cloneable interface to copy the vehicle into
	// another one
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicles v = (Vehicles) super.clone();
		v.owner = null;
		return v;
	}

	// toString method that return all information about the object
	@Override
	public String toString() {
		return "ModelName: " + modelName + ", Brand: " + Brand + ", Owner: " + owner.getName() + ", EngineType: "
				+ engineType + ", TankSize: " + tunkSize + ",\nFuelConsumption: "
				+ String.format("%.2f", FuelConsumption);
	}

	// override compareTo method from comparable interface to compare which costs
	// more
	@Override
	public int compareTo(Vehicles o) {
		try {
			if (this.costFor100Km() > o.costFor100Km())
				return 1;
			else if (this.costFor100Km() < o.costFor100Km())
				return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Setters and Getters

	// check that engine type is gasoline or diesel or hyprid and if not it will
	// throw an exception
	public void setEngineType(String engineType) throws IllegalArgumentException {
		if (!(engineType.equalsIgnoreCase("gasoline")) && !(engineType.equalsIgnoreCase("diesel"))
				&& !(engineType.equalsIgnoreCase("hybrid")))
			throw new IllegalArgumentException("Mismatch filling type of Petroleum.");
		this.engineType = engineType;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNo() {
		return ModelNo;
	}

	public void setModelNo(String modelNo) {
		ModelNo = modelNo;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getEngineType() {
		return engineType;
	}

	public double getTunkSize() {
		return tunkSize;
	}

	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

	public double getFuelConsumption() {
		return FuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		FuelConsumption = fuelConsumption;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
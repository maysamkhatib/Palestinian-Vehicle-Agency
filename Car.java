package Project;

public class Car extends Vehicles {
	// declare the variables
	private int Numberofseats;
	private boolean airConditionON = false;

	// no-argument constructer
	public Car() {
		super();
	}

	// argument constructer
	public Car(String modelName, String modelNo, String brand, Owner owner, String engineType, double tunkSize,
			double fuelConsumption, int n) throws Exception {
		super(modelName, modelNo, brand, owner, engineType, tunkSize, fuelConsumption);
		Numberofseats = n;
	}

	// check that engine type of car is gasoline or hyprid and if not it will
	// throw an exception
	@Override
	public void setEngineType(String engineType) throws IllegalArgumentException {
		if (!(engineType.equalsIgnoreCase("gasoline")) && !(engineType.equalsIgnoreCase("hybrid")))
			throw new IllegalArgumentException(
					"Mismatch filling type of Petroleum: The Car uses only gasoline engine.");
		this.engineType = engineType;
	}

	// Abstract method to find and return the cost of fuel for 100 km which it
	// depands on the petruleum type and fuel consumption
	// Car uses only gasoline so we prevent any other petroluem type
	@Override
	public double costFor100Km() {
		double cost;
		cost = (100 / FuelConsumption) * PetroleumType.getGasolinePrice();
		return cost;
	}

	// Abstract method that return if we turn it on or not
	@Override
	public boolean SetAirConditionOn() {
		// if the condition is off we should set it on and decrease the fuel consumption
		if (!airConditionON) {
			airConditionON = true;
			fuelConsumptionWithACOn();
			return true;
		}
		// it's already on so we didn't set it on
		return false;
	}

	// Abstract method that return if we turn it off or not
	@Override
	public boolean SetAirConditionOff() {
		// if the condition is on we should set it off and increase the fuel consumption
		// by 10% => FuelConsumption = FuelConsumption + (0.1 * FuelConsumption)
		if (airConditionON) {
			airConditionON = false;
			FuelConsumption = 1.1 * FuelConsumption;
			return true;
		}
		// it's already off so we didn't set it off
		return false;
	}

	// toString method that return all information about the object
	@Override
	public String toString() {
		try {
			return super.toString() + ", NumberofSeat: " + Numberofseats + ", Movable distance: "
					+ String.format("%.1f", costFor100Km()) + " km, Cost for 100 Km: "
					+ String.format("%.2f", costFor100Km()) + " NIS\n";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// method to calculate the fuel consumption if the air condition is on or not
	@Override
	public void fuelConsumptionWithACOn() {
		// if the air condition is on => FuelConsumption = FuelConsumption - (0.1 *
		// FuelConsumption)
		if (airConditionON) {
			FuelConsumption = 0.9 * FuelConsumption;
		}
	}

	// Setters and Getters
	public Boolean getAirConditionON() {
		return airConditionON;
	}

	public int getNumberofseats() {
		return Numberofseats;
	}

	public void setNumberofseats(int numberofseats) {
		Numberofseats = numberofseats;
	}

}

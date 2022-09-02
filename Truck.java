package Project;

public class Truck extends Vehicles {
	// declare the variables
	private int NumberOfSeats;
	private boolean airConditionON;
	private int power;

	// no-argument constructer
	public Truck() {
		super();
	}

	// argument constructer
	public Truck(String modelName, String modelNo, String brand, Owner owner, String engineType, double tunkSize,
			double fuelConsumption, int n, int p) throws Exception {
		super(modelName, modelNo, brand, owner, engineType, tunkSize, fuelConsumption);
		NumberOfSeats = n;
		power = p;
	}

	// check that engine type of truck is diesel and if not it will
	// throw an exception
	@Override
	public void setEngineType(String engineType) throws IllegalArgumentException {
		if (!(engineType.equalsIgnoreCase("diesel")))
			throw new IllegalArgumentException(
					"Mismatch filling type of Petroleum: The Car uses only gasoline engine.");
		this.engineType = engineType;
	}

	// Abstract method to find and return the cost of fuel for 100 km which it
	// depands on the petruleum type and fuel consumption
	// Truck uses only diesel so we prevent any other petroluem type
	@Override
	public double costFor100Km() throws IllegalArgumentException {
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
		if (airConditionON) {
			// if the condition is on we should set it off and increase the fuel consumption
			// by 10% => FuelConsumption = FuelConsumption + (0.2 * FuelConsumption)
			airConditionON = false;
			FuelConsumption = 1.2 * FuelConsumption;
			return true;
		}
		// it's already off so we didn't set it off
		return false;
	}

	// toString method that return all information about the object
	@Override
	public String toString() {
		try {
			return super.toString() + ", NumberofSeat: " + NumberOfSeats + ", Movable distance: "
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
		if (airConditionON) {
			// if the air condition is on => FuelConsumption = FuelConsumption - (0.2 *
			// FuelConsumption)
			FuelConsumption = 0.8 * FuelConsumption;
		}
	}

	// Setters and Getters
	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	public boolean isAirConditionON() {
		return airConditionON;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
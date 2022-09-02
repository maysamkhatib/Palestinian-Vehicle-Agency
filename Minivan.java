package Project;

public class Minivan extends Vehicles {
	// declare the variables
	private int NumberOfSeats;
	private boolean airConditionON;
	private boolean hasOutoDoors;

	// no-argument constructer
	public Minivan() {
		super();
	}

	// argument constructer
	public Minivan(String modelName, String modelNo, String brand, Owner owner, String engineType, double tunkSize,
			double fuelConsumption, int n, boolean h) throws Exception {
		super(modelName, modelNo, brand, owner, engineType, tunkSize, fuelConsumption);
		NumberOfSeats = n;
		hasOutoDoors = h;
	}

	// Abstract method to find and return the cost of fuel for 100 km which it
	// depands on the petruleum type and fuel consumption
	@Override
	public double costFor100Km() {
		double cost;
		cost = (100 / FuelConsumption) * PetroleumType.pricePetroleumType(engineType);
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
		// by 10% => FuelConsumption = FuelConsumption + (0.2 * FuelConsumption)
		if (airConditionON) {
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
		return super.toString() + ", NumberofSeat: " + NumberOfSeats + ", Movable distance: "
				+ String.format("%.1f", costFor100Km()) + " km, Cost for 100 Km: "
				+ String.format("%.2f", costFor100Km()) + " NIS\n";
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

	public boolean getHasOutoDoors() {
		return hasOutoDoors;
	}

	public void setHasOutoDoors(boolean hasOutoDoors) {
		this.hasOutoDoors = hasOutoDoors;
	}

	public boolean getAirConditionON() {
		return airConditionON;
	}

}

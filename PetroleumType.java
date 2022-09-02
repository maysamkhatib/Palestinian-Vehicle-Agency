package Project;

public class PetroleumType {
	// Declare the variables
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	private static double gasolinePrice = 5.23;
	private static double dieselPrice = 4.02;
	private String type;

	// No-argument Constructer
	public PetroleumType() {

	}

	// Argument Constructer
	public PetroleumType(String type) throws IllegalArgumentException {
		setType(type);
	}

	// Method to check the petroluem type and make sure there are no inputs we don't
	// want
	// It gives error if we entered wrong petroluem type.
	public void check() throws IllegalArgumentException {
		if (!(type.equalsIgnoreCase("gasoline")) && !(type.equalsIgnoreCase("diesel"))
				&& !(type.equalsIgnoreCase("hybrid")))
			throw new IllegalArgumentException("Mismatch filling type of Petroleum.");
	}

	// Method to return the price of petroleum according to its type
	public static double pricePetroleumType(String type) throws IllegalArgumentException {
		if (type.equalsIgnoreCase("diesel")) {
			return dieselPrice;
		} else if (type.equalsIgnoreCase("gasoline")) {
			return gasolinePrice;
		} else if (type.equalsIgnoreCase("hybrid")) {
			return gasolinePrice;
		} else
			throw new IllegalArgumentException("Mismatch filling type of Petroleum.");
	}

	// Setters and Getters
	public static double getGasolinePrice() {
		return gasolinePrice;
	}

	public static void setGasolinePrice(double gasolinePrice) {
		PetroleumType.gasolinePrice = gasolinePrice;
	}

	public double getDieselPrice() {
		return dieselPrice;
	}

	public static void setDieselPrice(double dieselPrice) {
		PetroleumType.dieselPrice = dieselPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws IllegalArgumentException {
		check();
		this.type = type;
	}

}

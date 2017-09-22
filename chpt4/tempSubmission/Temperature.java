
/**a class to store temperature
 * chpt 4 number 7
 * IT504
 * @author Courtney Landau
 */
import java.text.DecimalFormat;

public class Temperature {
	private double temperature;
	private char scale;
	DecimalFormat formatter = new DecimalFormat("##0.0");
	
	//constructors
	//--------------
	
	public Temperature() {
		temperature = 0;
		scale = 'C';
	}
	
	public Temperature(double tempInput) {
		temperature = tempInput;
		scale = 'C';
	}
	
	public Temperature(char scaleInput) {
		char input = Character.toUpperCase(scaleInput);
		if (input != 'C' && input != 'F') {
			System.out.println("Invalid entry.");
			System.exit(1);
		}
		else scale = input;
		temperature = 0;
	}
	
	public Temperature(double temperature, char scale) {
//		char input = Character.toUpperCase(scale);
		this.temperature = temperature;
		this.scale = Character.toUpperCase(scale);
	}
	
	//get methods
	//--------------
	
	public String getCelsius() {
		if (scale == 'C') {
			return formatter.format(temperature);
		}
		else {
			double celsiusTemp = 5*(temperature - 32)/9;
			return formatter.format(celsiusTemp) ;
		}
	}
	
	public String getFahrenheit() {
		if(scale == 'F') {
			return formatter.format(temperature);
		}
		else {
			double fahrenheitTemp = 9*(temperature/5) + 32;
			return formatter.format(fahrenheitTemp);
		}
	}
	
	//set methods
	//--------------------
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public void setScale(char scale) {
		if (Character.toUpperCase(scale) != 'C' && Character.toUpperCase(scale) != 'F') {
			System.out.println("Error: incorrect scale. Enter C or F.");
			System.exit(0);
		}
		else {
			this.scale = Character.toUpperCase(scale);
		}
	}
	
	public void setTempAndScale(double temperature, char scale) {
		if (Character.toUpperCase(scale) != 'C' && Character.toUpperCase(scale) != 'F') {
			System.out.println("Error: incorrect scale. Enter C or F.");
			System.exit(0);
		}
		else {
			this.scale = Character.toUpperCase(scale);
			this.temperature = temperature;
		}
	}
	
	//comparison methods
	//--------------------
	
	public boolean sameScale(Temperature temperature) {
		// helper function to determine if the scales of two Temperatures are the same
		return scale == temperature.scale;
	}
	
	
	public boolean equals(Temperature otherTemperature) {
		if (!sameScale(otherTemperature)) {
			if (this.scale == 'F') {
				return getFahrenheit().equals(otherTemperature.getFahrenheit());
			}
			else if (this.scale == 'C') {
				return getCelsius().equals(otherTemperature.getCelsius());
			}
		}
		return (temperature == otherTemperature.temperature);
	}
	
	public boolean lessThan(Temperature otherTemperature) {
		if (sameScale(otherTemperature)) {
			return temperature < otherTemperature.temperature;
		}
		else {
			if (this.scale == 'F') {
				return temperature < (Double.parseDouble(otherTemperature.getFahrenheit()));
			}
			return temperature < Double.parseDouble(otherTemperature.getCelsius());
		}
	}
	
	public boolean greaterThan(Temperature otherTemperature) {
		if (sameScale(otherTemperature)) {
			return temperature > otherTemperature.temperature;
		}
		else {
			if (this.scale == 'F') {
				return temperature > (Double.parseDouble(otherTemperature.getFahrenheit()));
			}
			return temperature > Double.parseDouble(otherTemperature.getCelsius());
		}
	}
	
	public String toString() {
		return (formatter.format(temperature) + " degrees " + this.scale);
	}

}

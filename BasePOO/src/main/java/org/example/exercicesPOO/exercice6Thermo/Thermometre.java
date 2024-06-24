package org.example.exercicesPOO.exercice6Thermo;

public class Thermometre {
    private final double ZERO_ABSOLUE = 273.15;
    private double temperatureKelvin;

    public Thermometre(double temperatureKelvin, UniteTemperature unite) {
        switch (unite) {
            case KELVIN -> setTemperatureKelvin(temperatureKelvin);
            case CELSIUS -> setTemperatureCelsius(temperatureKelvin);
            case FAHRENHEIT -> setTemperatureFahrenheit(temperatureKelvin);
        }
    }

    public double getTemperatureKelvin() {
        return temperatureKelvin;
    }

    public double getTemperatureCelsius() {
        return temperatureKelvin - ZERO_ABSOLUE;
    }

    public double getTemparatureFahrenheit() {
        return (temperatureKelvin - ZERO_ABSOLUE) * (9.0/5) + 32;
    }

    public void setTemperatureKelvin(double temperatureKelvin) {
        this.temperatureKelvin = temperatureKelvin;
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureKelvin = temperatureCelsius + ZERO_ABSOLUE;
    }

    public void setTemperatureFahrenheit(double temperatureFahrenheit) {
        this.temperatureKelvin = (temperatureFahrenheit - 32) * (5.0 / 9) + ZERO_ABSOLUE;
    }

    @Override
    public String toString() {
        return "Thermometre{" +
                "temperatureKelvin=" + getTemperatureKelvin() +
                ", temperatureCelsius=" + getTemperatureCelsius() +
                ", temperatureFahrenheit=" + getTemparatureFahrenheit() +
                '}';
    }
}

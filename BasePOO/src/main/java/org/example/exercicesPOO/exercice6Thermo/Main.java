package org.example.exercicesPOO.exercice6Thermo;

public class Main {
    public static void main(String[] args) {
        Thermometre thermo = new Thermometre(20, UniteTemperature.CELSIUS);
        System.out.println(thermo);
        thermo.setTemperatureFahrenheit(50);
        System.out.println(thermo);
        thermo.setTemperatureCelsius(30);
        System.out.println(thermo);
        thermo.setTemperatureKelvin(270);
        System.out.println(thermo);
    }
}

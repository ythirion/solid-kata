package com.codurance.lsp;

public class FillingStation {

    public void refuel(PetrolCar petrolCar) {
        petrolCar.fillUpWithFuel();
    }

    public void charge(ElectricityPowered vehicle) {
        vehicle.chargeBattery();
    }
}
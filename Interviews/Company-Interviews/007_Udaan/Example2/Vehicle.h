#pragma once

#include <bits/stdc++.h>
using namespace std;

enum class VehicleSize
{
    motorcycle = 0,
    car = 1,
    bus = 2
};

class Vehicle
{
    private:
        string numberPlate;

    public:
        Vehicle() : numberPlate("XXXX") {};
        Vehicle(string numberPlate) : numberPlate(numberPlate) {};
        string getNumberPlate() const;
        virtual VehicleSize getSize() const = 0;
        virtual ~Vehicle();
};

class Motorcycle : public Vehicle
{
    private:
        const VehicleSize size = VehicleSize::motorcycle;
        static int numOfVehicles;

    public:
        Motorcycle() : Vehicle("M" + to_string(numOfVehicles)) { ++numOfVehicles; };
        Motorcycle(string numberPlate) : Vehicle(numberPlate) { ++numOfVehicles; };
        virtual VehicleSize getSize() const;
        virtual ~Motorcycle();
};

class Car : public Vehicle
{
    private:
        const VehicleSize size = VehicleSize::car;
        static int numOfVehicles;

    public:
        Car() : Vehicle("C" + to_string(numOfVehicles)) { ++numOfVehicles; };
        Car(string numberPlate) : Vehicle(numberPlate) { ++numOfVehicles; };
        virtual VehicleSize getSize() const;
        virtual ~Car();
};

class Bus : public Vehicle
{
    private:
        const VehicleSize size = VehicleSize::bus;
        static int numOfVehicles;

    public:
        Bus() : Vehicle("B" + to_string(numOfVehicles)) { ++numOfVehicles; };
        Bus(string numberPlate) : Vehicle(numberPlate) { ++numOfVehicles; };
        virtual VehicleSize getSize() const;
        virtual ~Bus();
};
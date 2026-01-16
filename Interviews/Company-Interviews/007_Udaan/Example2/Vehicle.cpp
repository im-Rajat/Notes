#include "Vehicle.h"

string Vehicle::getNumberPlate() const
{
    return numberPlate;
}

Vehicle::~Vehicle()
{

}

// Motorcycle Class

int Motorcycle::numOfVehicles = 0;

VehicleSize Motorcycle::getSize() const
{
    return size;
}

Motorcycle::~Motorcycle()
{

}

// Car Class

int Car::numOfVehicles = 0;

VehicleSize Car::getSize() const
{
    return size;
}

Car::~Car()
{

}

// Bus Class

int Bus::numOfVehicles = 0;

VehicleSize Bus::getSize() const
{
    return size;
}

Bus::~Bus()
{

}


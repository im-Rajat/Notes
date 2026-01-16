#include "ParkingSpot.h"

SpotSize ParkingSpot::getSize() const
{
    return size;
}

string ParkingSpot::getSizeName() const
{
    if(size == Small)
    {
        return "Small";
    }
    else if(size == Compact)
    {
        return "Compact";
    }
    else if(size == Large)
    {
        return "Large";
    }
    else
    {
        return "Unknown";
    }
}

Vehicle* ParkingSpot::getVehicleReference() const
{
    return vehicle;
}

string ParkingSpot::getID() const
{
    return id;
}

bool ParkingSpot::isOccupied() const
{
    return vehicle != nullptr;
}

void ParkingSpot::parkVehicle(Vehicle* vehicle)
{
    this->vehicle = vehicle;
}

void ParkingSpot::unparkVehicle()
{
    this->vehicle = nullptr;
}

ostream &operator<<(ostream &out, const ParkingSpot &spot)
{
    string isOccupied = spot.isOccupied() ? spot.vehicle->getNumberPlate() : "unoccupied";
    out << spot.id << " | " << spot.getSizeName() << " | " << isOccupied;
    return out;
}
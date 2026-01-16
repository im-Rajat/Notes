enum VehicleSize { Motorcycle, Compact, Large };

// Vehicle abstract class
class Vehicle {
    vector<ParkingSpot> parkingSpots;
    string licensePlate;
    int spotsNeeded;
    VehicleSize size;

public:
    int getSpotsNeeded() {
        return spotsNeeded;
    }
    VehicleSize getSize() {
        return size;
    }
    // Park vehicle in the spot
    void parkInSpot(ParkingSpot spot) {
        parkingSpots.push_back(spot);
    }
    // Remove vehicle from spot
    // We let the vehicle to call parkingspot's removeVehicle method
    // We don't clear vehicle's parking spots in parkingspot's removeVehicle function
    // This is because vehicle initiate the leaving spot behavior
    void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i ++) {
            parkingSpots[i].removeVehicle();
        }
        parkingSpots.clear();
    }
    // Check if the spot is big enough for the vehicle
    virtual boolean canFitInSpot(ParkingSpot spot) = 0;
};

class Bus : public Vehicle {
public:
    Bus() {
        spotsNeeded = 5;
        size = Large;
    }
    // Check if the spot is a Large 
    // Does not check if there are 5 spots.
    bool canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == Large;
    }
};

class Car : public Vehicle {
public:
    Car() {
        spotsNeeded = 1;
        size = Compact;
    }
    // Check if the spot is a Compact or a Large
    bool canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == Large || spot.getSize() == Compact;
    }
};

class Motorcycle : public Vehicle {
public:
    Motorcycle() {
        spotsNeeded = 1;
        size = Motorcycle;
    }
    // Check if the spot is a Motorcycle, a Compact, or a Large
    bool canFitInSpot(ParkingSpot spot) {
        return true;
    }
};
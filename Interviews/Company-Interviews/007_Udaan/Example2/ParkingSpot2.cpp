class ParkingSpot {
    Vehicle vehicle;
    VehicleSize spotSize;
    int row;
    int spotNumber;
    Level level;

public:
    ParkingSpot(Level lvl, int r, int n, VehicleSize vs) {
        level = lvl;
        row = r;
        spotNumber = n;
        spotSize = vs;
    }

    bool isAvailable() {
        return vehicle == NULL;
    }

    // Check if the spot is big enough and is available
    // This compares the size only, does not check if it has enough spots
    bool canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    // Park vehicle in this spot
    // We do this in the parkingspot class because the parkingspot class
    // usually has whether this spot is avaialbe information. 
    bool park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    int getRow() {
        return row;
    }

    int getSpotNumber() {
        return spotNumber;
    }

    VehicleSize getSize() {
        return spotSize;
    }

    // Remove vehicle from spot
    void removeVehicle() {
        vehicle = NULL;
    }
};
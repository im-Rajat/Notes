#pragma once

#include <bits/stdc++.h>
using namespace std;

#include "ParkingSpot.h"

class ParkingLot
{
    private:
        map<string, ParkingSpot*> parkingSpots;
        map<string, ParkingSpot*> parkedVehicles;
        string generateID(int level, int row, int position);
    
    public:
        ParkingLot(vector<vector<pair<int, SpotSize>>> parkingSpots);
        ~ParkingLot();
        void parkVehicle(Vehicle &vehicle);
        vector<string> getAdjacentSpots(string id, int count);
        void unparkVehicle(Vehicle& vehicle);
        bool canFitVehicle(SpotSize spotsize, VehicleSize vehicleSize);
        void printParkingSpots();
};
#pragma once

#include <bits/stdc++.h>
using namespace std;

#include "Vehicle.h"

enum SpotSize
{
    Small = 0,
    Compact = 1,
    Large = 2
};

class ParkingSpot
{
    private:
        SpotSize size;
        string id;
        int level;
        int row;
        int position;
        Vehicle* vehicle = nullptr;

    public:
        ParkingSpot(string id, int level, int row, int position, SpotSize size) : id(id), level(level), position(position), size(size) {};
        SpotSize getSize() const;
        string getSizeName() const;
        Vehicle* getVehicleReference() const;
        string getID() const;
        bool isOccupied() const;
        void parkVehicle(Vehicle* vehicle);
        void unparkVehicle();
        virtual ~ParkingSpot() {};

        friend ostream &operator<<(ostream &out, const ParkingSpot &sopt);
};
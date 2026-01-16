#include "ParkingLot.h"

ParkingLot::ParkingLot(vector<vector<pair<int, SpotSize>>> parkingSpots)
{
    ParkingSpot* spot;
    string id;
    for (int level = 0; level < parkingSpots.size(); ++level)
    {
        for (int row = 0; row < parkingSpots[level].size(); ++row)
        {
            for (int position = 0; position < parkingSpots[level][row].first; ++position)
            {
                id = generateID(level + 1, row + 1, position + 1);
                spot = new ParkingSpot(id, level + 1, row + 1, position + 1, parkingSpots[level][row].second);
                this->parkingSpots[id] = spot;
            }
        }
    }
}

ParkingLot::~ParkingLot()
{
    for (auto it = parkingSpots.begin(); it != parkingSpots.end(); it++)
    {
        delete (*it).second;
    }
}

string ParkingLot::generateID(int level, int row, int position)
{
    string result = "";
    result += (level >= 10) ? to_string(level) : '0' + to_string(level);
    result += (row >= 10) ? to_string(row) : '0' + to_string(row);
    result += (position >= 10) ? to_string(position) : '0' + to_string(position);
    return result;
}

void ParkingLot::parkVehicle(Vehicle &vehicle)
{
    ParkingSpot *spot = nullptr;
    auto it = parkingSpots.begin();
    vector<string> adjacentSpots;
    while (it != parkingSpots.end())
    {
        spot = it->second;
        if (!spot->isOccupied() && canFitVehicle(spot->getSize(), vehicle.getSize()))
        {

            // If the vehicle is bus, find if the adjacent parking spaces are free and allot accordingly
            if (vehicle.getSize() == VehicleSize::bus)
            {
                adjacentSpots = getAdjacentSpots(spot->getID(), 4);
                auto spot_it = adjacentSpots.begin();
                for (; spot_it != adjacentSpots.end(); spot_it++)
                {
                    if (parkingSpots.find(*spot_it) == parkingSpots.end() || parkingSpots[*spot_it]->isOccupied())
                    {
                        break;
                    }
                }
                if (spot_it != adjacentSpots.end())
                {
                    it++;
                    continue;
                }
                else
                {
                    for (spot_it = adjacentSpots.begin(); spot_it!=adjacentSpots.end(); spot_it++)
                    {
                        parkingSpots[*spot_it]->parkVehicle(&vehicle);
                    }
                }
            }

            spot->parkVehicle(&vehicle);
            parkedVehicles[vehicle.getNumberPlate()] = spot;
            break;
        }
        it++;
    }
    if (it == parkingSpots.end())
    {
        throw "Parking space not available for " + vehicle.getNumberPlate();
    }
}

vector<string> ParkingLot::getAdjacentSpots(string id, int count)
{
    vector<string> spots;
    string row_id = id.substr(0, 4);
    int position = stoi(id.substr(4));
    string pos;
    for (int i = 1; i <= count; ++i)
    {
        pos = (position + i) >= 10 ? to_string(position+i) : '0' + to_string(position + i);
        spots.push_back(row_id + pos);
    }
    return spots;
}

void ParkingLot::unparkVehicle(Vehicle & vehicle)
{
    auto it = parkedVehicles.find(vehicle.getNumberPlate());
    if (it == parkedVehicles.end())
    {
        throw "The vehicle is not parked anymore.";
        return;
    }
    if (vehicle.getSize() == VehicleSize::bus)
    {
        vector<string> spots = getAdjacentSpots(it->second->getID(), 4);
        for (int i = 0; i < spots.size(); ++i)
        {
            parkingSpots[spots[i]]->unparkVehicle();
        }
    }
    it->second->unparkVehicle();
    parkedVehicles.erase(it);
}

bool ParkingLot::canFitVehicle(SpotSize spotSize, VehicleSize vehicleSize)
{
    return static_cast<int>(vehicleSize) <= static_cast<int>(spotSize);
}

void ParkingLot::printParkingSpots()
{
    auto it = parkingSpots.begin();
    while (it != parkingSpots.end())
    {
        cout << (*(*it).second) << endl;
        it++;
    }
}
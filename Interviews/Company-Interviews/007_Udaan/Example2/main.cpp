#include "ParkingLot.h"

int main()
{
	vector<vector<pair<int, SpotSize>>> parkingSpotsData;
	string parkingDataFileName = "parkingSpots.in";
	ifstream dataFile;
	int levels, rows, numberOfSpots, type;
	pair<int, SpotSize> base_pair;
	dataFile.open(parkingDataFileName);

	if (dataFile)
    {
		dataFile >> levels;
		for (int i = 0; i < levels; ++i)
        {
			dataFile >> rows;
			vector<pair<int, SpotSize>> rowsVector;
			for (int j = 0; j < rows; ++j)
            {
				dataFile >> numberOfSpots >> type;
				base_pair = make_pair(numberOfSpots, SpotSize(type));
				rowsVector.push_back(base_pair);
			}
			parkingSpotsData.push_back(rowsVector);
		}
	}

	dataFile.close();

	ParkingLot myParkingLot(parkingSpotsData);

	int choice = 1;
	string id = "";
	Vehicle *vehicle = nullptr;
	map<string, Vehicle*> vehicles;
	while (choice)
    {
		cout << endl << "Select an option ; 0 to exit" << endl;
		cout << "1. Park a new motorcycle | 2. Park a new Car | 3. Park a new Bus | 4. Unpark | 5. Print" << endl;
		cin >> choice;
		switch (choice)
        {
		case 1:
			vehicle = new Motorcycle();
			goto parking;
		case 2:
			vehicle = new Car();
			goto parking;
		case 3:
			vehicle = new Bus();
			goto parking;
		case 4:
			cout << "Enter a vehicle id: ";
			cin >> id;
			id[0] = toupper(id[0]);
			if (vehicles.find(id) != vehicles.end())
            {
				try
                {
					myParkingLot.unparkVehicle(*(vehicles[id]));
				}
                catch (const string &e)
                {
					cout << e << endl;
				}
			}
            else
            {
				cout << "Vehicle ID is invalid" << endl;
			}
			break;
		case -1:
		parking:
			vehicles[vehicle->getNumberPlate()] = vehicle;
			try {
				myParkingLot.parkVehicle(*vehicle);
			} catch (const string&e) {
				cout << e << endl;
			}
			break;
		case 5:
			myParkingLot.printParkingSpots();
			break;
		default:
			cout << "Please enter a valid choice" << endl;
			break;
		}

		if (cin.fail())
        {
			cout << "ERROR -- You did not enter an integer";

			// get rid of failure state
			cin.clear();

			// discard 'bad' character(s) 
			cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

		}
	}
	
	myParkingLot.printParkingSpots();

    return 0;
}


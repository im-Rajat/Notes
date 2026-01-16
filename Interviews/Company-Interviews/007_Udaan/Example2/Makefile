CC = g++

CFLAGS = -c -Wall
LDFLAGS =

SOURCES = main.cpp ParkingLot.cpp ParkingSpot.cpp Vehicle.cpp
OBJECTS = $(SOURCES:.cpp=.o)

EXECUTABLE = a

all: $(SOURCES) $(EXECUTABLE)

.cpp.o:
	$(CC) $(CFLAGS) $< -o $@

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) -o $@ $^

clean:
	rm -rf *.o $(EXECUTABLE) 

install:
	./$(EXECUTABLE)
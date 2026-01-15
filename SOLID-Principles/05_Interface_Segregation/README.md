# Interface Segregation Principle

- Keep interfaces small and specific.
- Interface should only have methods that are applicable to all child classes.
- If an interface contains a method applicable to some child classes then we need to force the rest to provide dummy implementation. Move such methods to a new interface.

### Bad Implementation :

- Vehicle interface contains the fly() method which is not supported by all vehicles i.e. Bus, Car, etc. Hence they've to forcefully provide a dummy implementation.
- It violates the Interface Segregation principle as shown below:

```java
public interface Vehicle {
    void accelerate() {}
    void applyBreaks() {}
    void fly() {}
}

public class Aeroplane implements Vehicle {
    @Override
    public void accelerate() {...}

    @Override
    public void applyBreaks() {...}

    @Override
    public void fly() {...}
}
// Aeroplane implements all methods as it supports all operations

public class Bus implements Vehicle {
    @Override
    public void accelerate() {...}

    @Override
    public void applyBreaks() {...}

    @Override
    public void fly() { 
        // dummy implementation
    }
}
//Here bus provide dummy implementation for fly() method as it didn't support fly
```

### Good Implementation :

- Pulling out fly() method into new Flyable interface solves the issue.
- Now, Vehicle interface contains methods supported by all Vehicles.
- And, Aeroplane implements both Vehicle and Flyable interface as it can fly too.

```java
public interface Vehicle {
    void accelerate() {}
    void applyBreaks() {}
}

public interface Flyable {
    void fly() {}
}

public class Aeroplane implements Vehicle, Flyable {
    @Override
    public void accelerate() {...}

    @Override
    public void applyBreaks() {...}

    @Override
    public void fly() {...}
}
// Aeroplane class implements both Vehicle and Flyable interface

public class Bus implements Vehicle {
    @Override
    public void accelerate() {...}

    @Override
    public void applyBreaks() {...}
}
// Bus implements only vehicle interface as it didn't support fly()
```
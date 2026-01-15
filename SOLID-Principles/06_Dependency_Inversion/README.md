# Dependency Inversion Principle

- High-level modules should not depend on low-level modules.
- Both High-level & low-level should depend on abstractions.
- In other words, Class should depend on abstractions (interface and abstract class) instead of concrete implementations. It makes our classes de-coupled with each other. If implementation changes then the class referring to it via abstraction won't change.

### Bad Implementation :

- Here, the LightSwitch class directly depends on a specific low-level module (LEDBulb).
- If we want to switch to a different type of bulb (a new low-level module), you would need to modify the LightSwitch class, violating the Dependency Inversion Principle.

```java
// High-level module
class LightSwitch {
    private Bulb bulb;

    public LightSwitch() {
        this.bulb = new LEDBulb();  // High-level module depends on a specific low-level module
    }

    public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}

// Low-level module
class LEDBulb {
    public void turnOn() {
        // Code to turn on an LED bulb
    }

    public void turnOff() {
        // Code to turn off an LED bulb
    }
}
```

### Good Implementation :

- Here, the LightSwitch class depends on an abstraction (Bulb interface) rather than a specific low-level module.
- Different types of bulbs (like LEDBulb and CFLBulb) can be easily added without modifying the LightSwitch class, demonstrating adherence to the Dependency Inversion Principle.

```java
// High-level module
class LightSwitch {
    private Bulb bulb;

    public LightSwitch(Bulb bulb) {
        this.bulb = bulb; // High-level module depends on an abstraction
    }

    public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}

// Abstraction (Interface)
interface Bulb {
    void turnOn();
    void turnOff();
}

// Low-level modules implementing the abstraction
class LEDBulb implements Bulb {
    public void turnOn() {
        // Code to turn on an LED bulb
    }

    public void turnOff() {
        // Code to turn off an LED bulb
    }
}

class CFLBulb implements Bulb {
    public void turnOn() {
        // Code to turn on an CFL bulb
    }

    public void turnOff() {
        // Code to turn off an CFL bulb
    }
}
```
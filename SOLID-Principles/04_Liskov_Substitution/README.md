# Liskov Substitution Principle

- Child Classes should be replaceable with Parent Classes without breaking the behavior of our code.
- Substitutability is a principle in object-oriented programming stating that, in a computer program, if S is a subtype of T, then objects of type T may be replaced with objects of type S

### Bad Implementation :

```java
public class Bird {
    public void fly() {}
}

public class Duck extends Bird {}

// The duck can fly because it is a bird, but what about this:

public class Ostrich extends Bird {}

// Ostrich is a bird, but it can't fly, Ostrich class is a subtype of class Bird, but it shouldn't be able to use the fly method, that means we are breaking the LSP principle.
```

### Good Implementation :

```java
public class Bird {}

public class FlyingBird extends Bird {
    public void fly() {}
}

public class Duck extends FlyingBird {}
public class Ostrich extends Bird {}
```
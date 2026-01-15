# Single Responsibility Principle

- A class should always have one responsibility and there should be only a single reason to change it.

### Bad Implementation :

- Below Employee class contains personal details, business logic to perform a few calculations, and DB logic to save/update.
- Our class is tightly coupled, hard to maintain, multiple reasons to modify this class.

```cpp
public class Employee {
    private String fullName;
    private String dateOfJoining;
    private String annualSalaryPackage;

    // standard getters and setters methods

    // business logic
    public long calculateEmployeeSalary(Employee emp) {...}
    public long calculateEmployeeLeaves(Employee emp) {...}
    public long calculateTaxOnSalary(Employee emp) {...}

    // data persistence logic
    public Employee saveEmployee(Employee emp) {...}
    public Employee updateEmployee(Employee emp) ...}
}
```

### Good Implementation :

- We can split a single Employee class into multiple classes as per their specific responsibility.
- It made our class loosely coupled, easy to maintain, and only single reason to modify.

```java
public class Employee {
    private String fullName;
    private String dateOfJoining;
    private String annualSalaryPackage;

    // standard getters and setters methods
}

public class EmployeeService {
    // ...

    public long calculateEmployeeSalary(Employee emp) {...}
    public long calculateEmployeeLeaves(Employee emp) {...}
    public long calculateTaxOnSalary(Employee emp) {...}
}

public class EmployeeDAO {
    // ...

    public Employee saveEmployee(Employee emp) {...}
    public Employee updateEmployee(Employee emp) {...}
}
```
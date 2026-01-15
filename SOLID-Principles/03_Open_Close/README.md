# Open Close Principle

- Class should be Open for Extension but Closed for Modification.

### Bad Implementation :

- Below EmployeeSalary class calculates salary based on employee type: Permanent and Contractual.
- Issue: In the future, if a new type (Part-time Employee) comes then the code needs to be modified to calculate the salary based on employee type.

```java
public class EmployeeSalary {
    public long calculateSalary(Employee emp) {
        long salary = null;

        if (emp.getType().equals("PERMANENT")) {
            salary = (totalWorkingDay * basicPay) + getCompanyBenefits() + getBonus();
        }
        else if (emp.getType().equals("CONTRACT")) {
            salary = (totalWorkingDay * basicPay);
        }
    }

    return salary;
}
```

### Good Implementation :

- We can introduce a new interface EmployeeSalary and create two child classes for Permanent and Contractual Employees.
- By doing this, when a new type comes then a new child class needs to be created and our core logic will also not change from this.

```java
public interface EmployeeSalary {
    public long calculateSalary();
}

public class PermanentEmployeeSalary implements EmployeeSalary {
    @Override
    public long calculateSalary() {
        salary = (totalWorkingDay * basicPay) + getCompanyBenefits() + getBonus();
    }
}

public class ContractEmployeeSalary implements EmployeeSalary {
    @Override
    public long calculateSalary() {
        salary = (totalWorkingDay * basicPay);
    }
}
```

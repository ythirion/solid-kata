## SOLID Kata

### SRP

* Extract Printer logic in a dedicated class
* Use IntelliJ to demonstrate the power
  * final fields in ccountService
* Use lombok to remove useless code

### OCP

* Create Employee inheritance
* Use private field

BONUS : add a new type of employee -> `BigBoss`

What do you have to do ?

### LSP

* Code smell : instanceof check

```java
public void refuel(Vehicle vehicle) {
    if (vehicle instanceof PetrolCar) {
        vehicle.fillUpWithFuel();
    }
}

public void charge(Vehicle vehicle) {
    if (vehicle instanceof ElectricCar) {
        vehicle.chargeBattery();
    }
}
```

* Review inheritance

```java
public abstract class Vehicle {
  	//Common to each vehicles
    private boolean engineStarted = false;

    public void startEngine() {
        this.engineStarted = true;
    }

    public boolean engineIsStarted() {
        return engineStarted;
    }

    public void stopEngine() {
        this.engineStarted = false;
    }

  	//Force implementation -> should be isolated in interfaces
    public abstract void fillUpWithFuel();

    public abstract void chargeBattery();
}
```

* Create Interfaces : `ElectricityPowered`, `PetrolPowered`

```java
public class ElectricCar extends Vehicle implements ElectricityPowered
public class PetrolCar extends Vehicle implements PetrolPowered
```

* Now we can refactor the `FillingStation`

```java
public class FillingStation {

    public void refuel(PetrolCar petrolCar) {
        petrolCar.fillUpWithFuel();
    }

    public void charge(ElectricCar electricCar) {
        electricCar.chargeBattery();
    }
}
```

* Create subtype of cars : `VWDieselCar`, `TeslaCar` for example
  * Use them in your tests
  * No more instanceof anywhere
  * More cleaner Inheritance

### ISP

```java
public class Bird implements Animal {
  	// exactly what we want to avoid
    public void bark() { }
    public void run() {
        System.out.print("Bird is running");
    }
    public void fly() {
        System.out.print("Bird is flying");
    }
}
```

* Split the `Animal` interface : `Barking`, `Running`, `Flying`

  ```java
  public interface Animal {
      void fly();
      void run();
      void bark();
  }
  ```

* Change the `Bird`, `Dog` implements part

### DIP

* Find the code smell

```java
public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
          			// Ask questions about this line
                // Impact on testing
                .forEach(email -> new EmailSender().send(email));
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}
```

* Inject the `EmailSender`
  * Ask question about how to do it : method, constructor, property
* Impact on the tests ?
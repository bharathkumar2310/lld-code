FactoryPattern
       
              Factory Pattern is a creational design pattern which abstracts the object creation so that the client code does ot know
              the exact class being instantiated. It uses a factory/ method to create a object


              The Factory Method is a creational design pattern that defines an interface for creating objects 
              but lets subclasses decide which object to instantiate. It promotes loose coupling by delegating object creation to a method, 
              making the system more flexible and extensible.



```java

import java.io.*;

// Library classes
        abstract class Vehicle {
            public abstract void printVehicle();
        }
        
        class TwoWheeler extends Vehicle {
            public void printVehicle() {
                System.out.println("I am two wheeler");
            }
        }

        class FourWheeler extends Vehicle {
            public void printVehicle() {
                System.out.println("I am four wheeler");
            }
        }

// Client (or user) class
        class Client {
            private Vehicle pVehicle;
        
            public Client(int type) {
                if (type == 1) {
                    pVehicle = new TwoWheeler();
                } else if (type == 2) {
                    pVehicle = new FourWheeler();
                } else {
                    pVehicle = null;
                }
            }
        
            public void cleanup() {
                if (pVehicle != null) {
                    pVehicle = null;
                }
            }
        
            public Vehicle getVehicle() {
                return pVehicle;
            }
        }

// Driver program
        public class GFG {
            public static void main(String[] args) {
                Client pClient = new Client(1);
                Vehicle pVehicle = pClient.getVehicle();
                if (pVehicle != null) {
                    pVehicle.printVehicle();
                }
                pClient.cleanup();
            }
        }





```


Issues with the Current Design

        Tight coupling: Client depends directly on product classes.
        Violation of SRP: Client handles both product creation and usage.
        Hard to extend: Adding a new vehicle requires modifying the client.


With Factory Pattern: 

```java 
// Library classes
        abstract class Vehicle {
            public abstract void printVehicle();
        }
        
        class TwoWheeler extends Vehicle {
            public void printVehicle() {
                System.out.println("I am two wheeler");
            }
        }
        
        class FourWheeler extends Vehicle {
            public void printVehicle() {
                System.out.println("I am four wheeler");
            }
        }
        
// Factory Interface
        interface VehicleFactory {
            Vehicle createVehicle();
        }
        
// Concrete Factory for TwoWheeler
        class TwoWheelerFactory implements VehicleFactory {
            public Vehicle createVehicle() {
                return new TwoWheeler();
            }
        }
        
// Concrete Factory for FourWheeler
        class FourWheelerFactory implements VehicleFactory {
            public Vehicle createVehicle() {
                return new FourWheeler();
            }
        }
        
// Client class
        class Client {
            private Vehicle pVehicle;
        
            public Client(VehicleFactory factory) {
                pVehicle = factory.createVehicle();
            }
        
            public Vehicle getVehicle() {
                return pVehicle;
            }
        }
        
// Driver program
        public class GFG {
            public static void main(String[] args) {
                VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
                Client twoWheelerClient = new Client(twoWheelerFactory);
                Vehicle twoWheeler = twoWheelerClient.getVehicle();
                twoWheeler.printVehicle();
        
                VehicleFactory fourWheelerFactory = new FourWheelerFactory();
                Client fourWheelerClient = new Client(fourWheelerFactory);
                Vehicle fourWheeler = fourWheelerClient.getVehicle();
                fourWheeler.printVehicle();
            }
        }

```
I ---> Interface Segregation Principle

          states that client should not be forced on methods that they donot use
         In other words:

                Don’t create fat (big) interfaces.
                Split them into smaller, focused interfaces


Example without ISP : 

Imagine a Worker interface:

```java 
        public interface Worker {
            void work();
        
            void eat();
        
            void sleep();
        }
        
        
        // Now two classes implement it:
        
        public class HumanWorker implements Worker {
            public void work() {
            }
        
            public void eat() {
            }
        
            public void sleep() {
            }
        }
        
        public class RobotWorker implements Worker {
            public void work() {
            }
        
            public void eat() {
                // 🤨 Robot doesn't eat
            }
        
            public void sleep() {
                // 🤨 Robot doesn't sleep
            }
        }
```


🚨 What’s wrong here?

        RobotWorker is forced to implement eat() and sleep()
        These methods make no sense for robots
        Changes in eat() logic can affect RobotWorker unnecessarily

➡️ This breaks ISP


1️⃣ Forced meaningless methods (dummy implementations)

⚠️ Issue

    Method exists but has no meaning
    Reader cannot trust the interface
    Signals wrong abstraction

💥 Impact

    Confusing API
    Bugs when someone later calls fly()

2️⃣ Runtime failures (hidden bombs)

    class Car implements Vehicle {
        public void fly() {
            throw new UnsupportedOperationException();
        }
    }

⚠️ Issue

    Compiles fine
    Blows up at runtime

💥 Impact

    Production crashes
    Violates LSP too



Example With ISP : 


✅ Solution: Apply Interface Segregation Principle

Split the big interface into small, specific interfaces.

```java 
        //Step 1: Create focused interfaces
        public interface Workable {
            void work();
        }
        
        public interface Eatable {
            void eat();
        }
        
        public interface Sleepable {
            void sleep();
        }
        
        //Step 2: Implement only what is needed
        
        public class HumanWorker implements Workable, Eatable, Sleepable {
            public void work() {
            }
        
            public void eat() {
            }
        
            public void sleep() {
            }
        }
        
        public class RobotWorker implements Workable {
            public void work() {
            }
}
```
✅ Benefits

        No useless methods
        Cleaner code
        Easy to change & extend
        Follows ISP
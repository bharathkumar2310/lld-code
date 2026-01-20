L ---> Liskov Substitution Principle

            states that object of superclass should be replaceable with objects of sub class
       without affecting program's expected behavior or correctness i.e(subclass should not change the meaning of behaivour
       which parent class defines)

       If class B is a child of class A, then we should be able to replace A with B without breaking the program.

Example :

Without LSP :

```java


        class Bird {
            public void fly() {
                System.out.println("Bird is flying");
            }
        }
        
        class Ostrich extends Bird {
            @Override
            public void fly() {
                throw new UnsupportedOperationException("Ostrich can't fly");
            }
        }
```

❗ What’s the problem?

            Bird bird = new Ostrich();
            bird.fly();  // 💥 Runtime crash

🧩 Why is this wrong in design?

Because:

        Bird promised: “I can fly”
        Ostrich breaks the promise
        Child class removes behavior


❌ Problem 1: Defensive coding everywhere

        if (bird instanceof Ostrich) {
            // don't fly
        } else {
            bird.fly();
        }
      
                or


        try {
            bird.fly();
        } catch (Exception e) {
            // ignore
        }


➡️ Code becomes:

        Ugly
        Hard to maintain
        Error-prone

❌ Problem 2: Silent logical bugs

        try {
            bird.fly();
        } catch (Exception e) {
            // ignore
        }

Now:

        Bird didn’t fly
        Program thinks everything is fine


❌ Problem 3: Violation spreads everywhere

Once one class violates LSP:

    Every caller must “know” the exception
    One bad child class infects the entire codebase



Example with LSP : 

```java


//✅ Correct Design (Following LSP)
        //Step 1: Separate behavior properly
        interface Flyable {
            void fly();
        }
        
        //Step 2: Base class without false promises
        class Bird {
            public void eat() {
                System.out.println("Bird is eating");
            }
        }
        
        //Step 3: Only flying birds implement Flyable
        class Sparrow extends Bird implements Flyable {
            public void fly() {
                System.out.println("Sparrow flying");
            }
        }
        
        class Ostrich extends Bird {
        // No fly() here
        }
        
        //✔ Now substitution works safely
        Bird bird1 = new Sparrow();   // OK
        Bird bird2 = new Ostrich();   // OK
        
        Flyable flyable = new Sparrow();
        flyable.fly();                // OK
```


👉 No crashes, no lies, no broken expectations
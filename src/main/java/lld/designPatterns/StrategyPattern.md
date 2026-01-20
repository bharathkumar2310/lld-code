Strategy Pattern :
         
              Strategy Pattern is a behavioural pattern which defines a family of algotithms/ behaviors each in seperate 
              class and can make them interchangeable at run time.

             Strategy Pattern is a behavioral design pattern where a behavior (algorithm) is moved out of a class
            put into separate interchangeable classes and the original class delegates that behavior instead of implementing it

            Strategy Pattern is a behavioral design pattern that encapsulates a behavior (algorithm) in a separate class 
            so it can be assigned to a context and changed dynamically at runtime.

```java
                    public interface SortingStrategy {
                        void sort(String[] array);
                    }


                class BubbleSortStrategy implements SortingStrategy {
                    @Override
                    public void sort(String[] array) {
                        System.out.println("Sorting using Bubble Sort");
                        // Bubble sort implementation
                    }
                }
                
                class MergeSortStrategy implements SortingStrategy {
                    @Override
                    public void sort(String[] array) {
                        System.out.println("Sorting using Merge Sort");
                        // Merge sort implementation
                    }
                }
                
                class QuickSortStrategy implements SortingStrategy {
                    @Override
                    public void sort(String[] array) {
                        System.out.println("Sorting using Quick Sort");
                        // Quick sort implementation
                    }
                }
                
                class SortingContext {
                    private SortingStrategy strategy;
                    
                        public SortingContext(SortingStrategy strategy) {
                            this.strategy = strategy;
                        }
                    
                        public void performSort(String[] array) {
                            strategy.sort(array);
                        }
                    
                        public void setSortingStrategy(SortingStrategy strategy) {
                            this.strategy = strategy;
                        }
                }
                
                public class Client {
                    public static void main(String[] args) {
                        // Create SortingContext with BubbleSortStrategy
                        SortingContext sortingContext = new SortingContext(new BubbleSortStrategy());
                        String[] array1 = {"cpp","c","java","python3","csharp","html","css","javascript","php","cpp14","cobol","dart","go","julia","kotlin","lisp","matlab","node","objc","perl","r","rust","ruby","scala","swift","solidity","xml"};
                        sortingContext.performSort(array1); // Output: Sorting using Bubble Sort
                        
                        // Change strategy to MergeSortStrategy
                        sortingContext.setSortingStrategy(new MergeSortStrategy());
                        String[] array2 = {"cpp","c","java","python3","csharp","html","css","javascript","php","cpp14","cobol","dart","go","julia","kotlin","lisp","matlab","node","objc","perl","r","rust","ruby","scala","swift","solidity","xml"};
                        sortingContext.performSort(array2); // Output: Sorting using Merge Sort
                
                        // Change strategy to QuickSortStrategy
                        sortingContext.setSortingStrategy(new QuickSortStrategy());
                        String[] array3 = {"cpp","c","java","python3","csharp","html","css","javascript","php","cpp14","cobol","dart","go","julia","kotlin","lisp","matlab","node","objc","perl","r","rust","ruby","scala","swift","solidity","xml"};
                        sortingContext.performSort(array3); // Output: Sorting using Quick Sort
                        }
                }
```


Without Strategy Pattern 


```java

            class SortingContext {
            
                public void sort(String[] array, String sortingType) {
            
                    if ("BUBBLE".equals(sortingType)) {
                        System.out.println("Sorting using Bubble Sort");
                        // bubble sort logic
                    }
                    else if ("MERGE".equals(sortingType)) {
                        System.out.println("Sorting using Merge Sort");
                        // merge sort logic
                    }
                    else if ("QUICK".equals(sortingType)) {
                        System.out.println("Sorting using Quick Sort");
                        // quick sort logic
                    }
                    else {
                        throw new IllegalArgumentException("Invalid sorting type");
                    }
                }
            }
            
            
            public class Client {
                public static void main(String[] args) {
            
                    SortingContext context = new SortingContext();
            
                    String[] array = {
                            "cpp","c","java","python3","csharp","html","css","javascript"
                    };
            
                    context.sort(array, "BUBBLE");
                    context.sort(array, "MERGE");
                    context.sort(array, "QUICK");
                }
            }

```



⚠️ Disadvantages of NOT using Strategy Pattern
1️⃣ Too many if-else / switch statements

        As sorting algorithms grow:
        
                if (type.equals("BUBBLE")) { ... }
                else if (type.equals("MERGE")) { ... }
                else if (type.equals("QUICK")) { ... }
                else if (type.equals("HEAP")) { ... }
                else if (type.equals("RADIX")) { ... }


❌ Code becomes unreadable
❌ Hard to maintain

2️⃣ Violates Open–Closed Principle ❌

Classes should be open for extension but closed for modification

                Every time you add a new sorting algorithm:
                    - You must modify SortingContext
                    - Risk of breaking existing code
                With Strategy:
                    - Just add a new class
                    - No change in Context

3️⃣ Context class becomes bloated ❌

        class SortingContext {
        // bubble sort code
        // merge sort code
        // quick sort code
        }


❌ Too many responsibilities
❌ Poor separation of concerns

4️⃣ Tight coupling ❌

SortingContext depends on concrete algorithms

    Cannot reuse sorting logic elsewhere
    Hard to refactor

With Strategy:

    Context depends only on interface

5️⃣ No runtime flexibility ❌

Without Strategy:

    context.sort(array, "BUBBLE");


Behavior is controlled by strings

        Error-prone
        No compile-time safety

With Strategy:

    context.setSortingStrategy(new QuickSortStrategy());


✔ Type-safe
✔ Flexible

6️⃣ Hard to unit test ❌

Without Strategy:

    Must test entire SortingContext
    Cannot isolate algorithm

With Strategy:

    Each sorting algorithm can be tested independently.


----------------------------------------------------------------------------------------------------------------------

Example 2:

Without Strategy 

```java
abstract class Duck {

    public void fly() {
        System.out.println("Flying");
    }

    public void quack() {
        System.out.println("Quack");
    }

    public void floatOnWater() {
        System.out.println("Floating");
    }

    public abstract void display();
}


class WildDuck extends Duck {
    public void display() {
        System.out.println("I'm a wild duck");
    }
}

class DomesticDuck extends Duck {
    public void display() {
        System.out.println("I'm a domestic duck");
    }
}

class WoodenDuck extends Duck {
    public void fly() {
        throw new UnsupportedOperationException("Wooden duck can't fly");
    }

    public void quack() {
        throw new UnsupportedOperationException("Wooden duck can't quack");
    }

    public void floatOnWater() {
        throw new UnsupportedOperationException("Wooden duck can't float");
    }

    public void display() {
        System.out.println("I'm a wooden duck");
    }
}


```


🚨 Problems with this design

Forced behavior

        WoodenDuck is forced to override methods it doesn’t support
Violates Liskov Substitution Principle

        WoodenDuck cannot safely replace Duck

Rigid inheritance

        Changing fly behavior affects all ducks

Code duplication

        Similar overrides across ducks

No runtime flexibility

        Can’t change behavior dynamically




With Startegy :
     
         We seperate each behaviour as classes


```java

// Behavior interfaces
        interface FlyBehavior {
            void fly();
        }
        
        interface QuackBehavior {
            void quack();
        }
        
        interface FloatBehavior {
            void floatOnWater();
        }

// Concrete Fly behaviors
        class FlyWithWings implements FlyBehavior {
            public void fly() {
                System.out.println("Flying with wings");
            }
        }
        
        class NoFly implements FlyBehavior {
            public void fly() {
                System.out.println("Cannot fly");
            }
        }

// Concrete Quack behaviors
            class LoudQuack implements QuackBehavior {
                public void quack() {
                    System.out.println("Quack!");
                }
            }
            
            class MuteQuack implements QuackBehavior {
                public void quack() {
                    System.out.println("Silent duck");
                }
            }

// Concrete Float behaviors
            class FloatOnWater implements FloatBehavior {
                public void floatOnWater() {
                    System.out.println("Floating on water");
                }
            }
            
            class NoFloat implements FloatBehavior {
                public void floatOnWater() {
                    System.out.println("Cannot float");
                }
            }

// Context: Duck
        abstract class Duck {
            protected FlyBehavior flyBehavior;
            protected QuackBehavior quackBehavior;
            protected FloatBehavior floatBehavior;
        
            // Constructor injection
            public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior, FloatBehavior floatBehavior) {
                this.flyBehavior = flyBehavior;
                this.quackBehavior = quackBehavior;
                this.floatBehavior = floatBehavior;
            }
        
            public void performFly() {
                flyBehavior.fly();
            }
        
            public void performQuack() {
                quackBehavior.quack();
            }
        
            public void performFloat() {
                floatBehavior.floatOnWater();
            }
        
            public abstract void display();
        
            // Setter injection to change behavior at runtime
            public void setFlyBehavior(FlyBehavior flyBehavior) {
                this.flyBehavior = flyBehavior;
            }
        
            public void setQuackBehavior(QuackBehavior quackBehavior) {
                this.quackBehavior = quackBehavior;
            }
        
            public void setFloatBehavior(FloatBehavior floatBehavior) {
                this.floatBehavior = floatBehavior;
            }
        }

// Concrete Ducks
        class WildDuck extends Duck {
            public WildDuck() {
                super(new FlyWithWings(), new LoudQuack(), new FloatOnWater());
            }
        
            public void display() {
                System.out.println("I'm a wild duck");
            }
        }
        
        class WoodenDuck extends Duck {
            public WoodenDuck() {
                super(new NoFly(), new MuteQuack(), new NoFloat());
            }
        
            public void display() {
                System.out.println("I'm a wooden duck");
            }
        }

// Client
        public class Main {
            public static void main(String[] args) {
        
                System.out.println("=== Wild Duck ===");
                Duck wildDuck = new WildDuck();
                wildDuck.display();
                wildDuck.performFly();   // Flying with wings
                wildDuck.performQuack(); // Quack!
                wildDuck.performFloat(); // Floating on water
        
                System.out.println("\n=== Wooden Duck ===");
                Duck woodenDuck = new WoodenDuck();
                woodenDuck.display();
                woodenDuck.performFly();   // Cannot fly
                woodenDuck.performQuack(); // Silent duck
                woodenDuck.performFloat(); // Cannot float
        
                System.out.println("\n=== Change Wild Duck Behavior at Runtime ===");
                wildDuck.setFlyBehavior(new NoFly());
                wildDuck.setQuackBehavior(new MuteQuack());
                wildDuck.performFly();   // Cannot fly
                wildDuck.performQuack(); // Silent duck
            }
        }




```
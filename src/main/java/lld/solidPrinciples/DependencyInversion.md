D ---> Dependency Inversion Principle

        states that High Level modules should not depend on low level modules rather it should only
    rely on abstractions(abstract class and interfaces)

        high-level modules should not depend on low-level modules; both should depend on abstractions.
        Abstractions should not depend on details; details should depend on abstractions.
   
        We are inverting the dependency from inplementations to abstractions

Example without DIP :

```java
        class MySQLDatabase {
            public void connect() {
                System.out.println("Connecting to MySQL");
            }
        }
        
        class UserService {
            private MySQLDatabase db = new MySQLDatabase();
        
            public void saveUser() {
                db.connect();
                System.out.println("User saved");
            }
        }
    
```


UserService directly depends on MySQLDatabase

If tomorrow you want:

    PostgreSQL
    MongoDB
    In-memory DB for testing

👉 You must modify UserService

        private MongoDatabase db = new MongoDatabase(); // change needed ❌

❌ Problems

        Violates Open-Closed Principle
        Hard to test
        Code is tightly coupled
        One change breaks many places

Example with DIP : 



/️⃣ Applying DIP (WITH abstraction)

```java
        
        //Step 1: Create abstraction (interface)
        interface Database {
            void connect();
        }
        
        //Step 2: Low-level modules implement abstraction
        class MySQLDatabase implements Database {
            public void connect() {
                System.out.println("Connecting to MySQL");
            }
        }
        
        class MongoDatabase implements Database {
            public void connect() {
                System.out.println("Connecting to MongoDB");
            }
        }
        
        //Step 3: High-level module depends on abstraction
        class UserService {
            private Database database;
        
            public UserService(Database database) {
                this.database = database;
            }
        
            public void saveUser() {
                database.connect();
                System.out.println("User saved");
            }
        }
        
        //Step 4: Use it (Main method)
        public class Main {
            public static void main(String[] args) {
        
                Database db = new MySQLDatabase();
                UserService service = new UserService(db);
                service.saveUser();
        
                // switch DB easily
                Database mongoDb = new MongoDatabase();
                UserService service2 = new UserService(mongoDb);
                service2.saveUser();
            }
        }

```

    This reduces coupling, improves testability, and allows behavior to change without modifying existing business logic.


4️⃣ Why this is called Dependency Inversion

Before DIP

        UserService ───> MySQLDatabase

After DIP

    UserService ───> Database (interface)
    MySQLDatabase ───> Database (interface)


➡️ Dependency direction is inverted
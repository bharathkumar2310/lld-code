O  ---> Open Closed Principle

          states that Java Components(Classes, Functions) should be open for extension and closed
          for modification

         -- You should be able to add new behavior WITHOUT changing existing working code
         -- OCP is achieved here using polymorphism instead of conditional logic.

2️⃣ Why this principle exists (real problem)

Imagine:

        Your code is already tested
        It is working in production
        If you modify existing code:
        You may break something else
        Old bugs can reappear
        Production issues happen
        
      1.  👉 OCP protects existing, stable code.
      2.  Easier to add new features
❌ Without OCP

To add:

        Festival discount
        Loyalty discount
        Referral discount
        You keep editing one big class.

Result:
            
            Long methods
            Huge if-else
            Fear of change

         3. Better readability & understanding


Example :

Without OCP : 


We want to send notifications.
Today:

    Email
    SMS
    Push notification

```java
class NotificationService {

    public void send(String type, String message) {

        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL: " + message);

        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);

        } else if (type.equals("PUSH")) {
            System.out.println("Sending PUSH notification: " + message);
        }
    }
}



```

What happens when a new type comes (WhatsApp)?

        else if (type.equals("WHATSAPP")) {
            System.out.println("Sending WHATSAPP message");
        }
  

❌ Problems

        You modify existing class
        Risk breaking email/SMS
        Many if-else
        Class keeps growing
        
        👉 Violates Open–Closed Principle


✅ WITH Open–Closed Principle

                Step 1️⃣ Create an abstraction
        
```java 
        public interface Notification {
            void send(String message);
        }
``` 

                    Step 2️⃣ Create implementations

```java 
        public class EmailNotification implements Notification {
            public void send(String message) {
                System.out.println("Sending EMAIL: " + message);
            }
        }
        
        public class SmsNotification implements Notification {
            public void send(String message) {
                System.out.println("Sending SMS: " + message);
            }
        }
        
        public class PushNotification implements Notification {
            public void send(String message) {
                System.out.println("Sending PUSH notification: " + message);
            }
        }

```

                            Step 3️⃣ Use abstraction

```java 
        class NotificationService {
        
            private Notification notification;
        
            public NotificationService(Notification notification) {
                this.notification = notification;
            }
        
            public void send(String message) {
                notification.send(message);
            }
        }
        
        
        //Step 4️⃣ Add new behavior WITHOUT changing old code
        public class WhatsAppNotification implements Notification {
            public void send(String message) {
                System.out.println("Sending WHATSAPP: " + message);
            }
        }
```
✅ Result

        NotificationService unchanged
        Existing code untouched
        Just add a new class
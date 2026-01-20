S -> Single Responsibility Principle
        
             states that a class should only have one reason to change
             (i.e) a class should encapsulate only one business or technical responsibility.
              (i.e) should have only 1 responsibility

“have one reason to change means say a PaymentService's methods logic can 
only change if the payment related reason changes happen not when other reason makes that change”


Without SRP:

```java 

        class StudentReport {
        
            int marks;
        
            StudentReport(int marks) {
                this.marks = marks;
            }
        
            int calculateGrade() {
                if (marks >= 90) return 'A';
                if (marks >= 75) return 'B';
                return 'C';
            }
        
            void saveToFile() {
                System.out.println("Saving report to file");
            }
        
            void printReport() {
                System.out.println("Printing report");
            }
        }
 ```

With SRP:

```java
        
        class GradeCalculator {
            int calculateGrade(int marks) {
                if (marks >= 85) return 'A';
                if (marks >= 75) return 'B';
                return 'C';
            }
        }
        
        class ReportSaver {
            void save() {
                System.out.println("Saving report");
            }
        }
        
        
        class ReportPrinter {
            void print() {
                System.out.println("Printing report");
            }
        }

```



1️⃣ High Risk of Bugs : 

          If you are changing anything like marks ---> score , you need to go through each and
    every place where marks is used

2️⃣ Hard to Understand Code

4️⃣ Difficult to Test
Want to test only grade calculation?

        You still need:
        StudentReport object
        Saving & printing logic present
5️⃣ Poor Reusability

6️⃣ Tight Coupling
What does this mean?

    Grade logic depends on:
    
        How saving works
        How printing works
        Even though they are unrelated.
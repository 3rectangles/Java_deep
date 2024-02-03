
/*
# Java Functional Interfaces, Lambda Expressions, and Method References

## Functional Interfaces
A functional interface is an interface that contains only one abstract method. They can be instantiated with lambda expressions or method references.

## Lambda Expressions
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

## Method References
A method reference is used to refer to a method without invoking it. It needs an object (or class, for static methods) and a method name. The syntax is `object::methodName` or `Class::staticMethodName`.


## Example
Consider a simple example where we have a `MathOperation` functional interface with a `calculate` method. This method takes two integers and performs a calculation on them. We'll also have a `Calculator` class that uses this interface.
*/



// Define a functional interface MathOperation with a single abstract method calculate.
@FunctionalInterface
public interface MathOperation {
    int calculate(int a, int b);
}

// Create a Calculator class that takes a MathOperation as a parameter.
public class Calculator {
    private MathOperation operation;

    // Constructor to set the MathOperation for the Calculator.
    public Calculator(MathOperation operation) {
        this.operation = operation;
    }

    // Method to execute the calculation using the provided MathOperation.
    public int execute(int a, int b) {
        return operation.calculate(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate Calculator with a lambda expression as the MathOperation.
        Calculator calculator = new Calculator((a, b) -> a + b);

        // Execute the calculation and print the result.
        int result = calculator.execute(5, 3);
        System.out.println(result);  // Outputs: 8
    }
}



// Assuming there is a static method in some class:
// public static int add(int a, int b) {
//     return a + b;
// }

// ...

// Using a method reference to the static method add in SomeClass.
Calculator calculator = new Calculator(SomeClass::add);

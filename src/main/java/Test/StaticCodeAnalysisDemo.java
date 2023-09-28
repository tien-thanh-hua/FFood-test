package Test;

import java.util.ArrayList;
import java.util.List;

public class StaticCodeAnalysisDemo {

  // Warning: Unused variable
  private int unusedVariable;
  int unusedVariable2;

  // Warning: Unused private method
  private int unusedMethod() {
    return 42;
  }

  // Warning: Duplicate code
  private void duplicateCode() {
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
    System.out.println("Hello");
  }

  // Error: Missing return statement
  public int missingReturnStatement(int x) {
    if (x > 0) {
      return x;
    }
    // Missing return statement here
  }

  // Error: Unreachable code
  public int unreachableCode() {
    System.out.println("Hello");
    final int x = 100;
    if (x < 0) {
      int z = 0;
      return z;
    }
    return 0;
    System.out.println("World");
  }

  // Error: Void methods cannot return a value
  public void noReturnStatement(int x) {
    System.out.println("Hello");
    return x;
  }

  // Error: Infinite loop
  public void infiniteLoop() {
    while (true) {
      // Infinite loop
    }
  }

  // Warning: Unused method parameter
  public void unusedParameter(String param1, int param2) {
    System.out.println(param1);
  }

  // Warning: Very high cyclomatic complexity
  public void veryHighCyclomaticComplexity(int x, int y, boolean flag1, boolean flag2, boolean flag3) {
    if (x > 0) {
      if (y > 0) {
        if (flag1) {
          System.out.println("x and y are positive, and flag1 is true");
        } else {
          System.out.println("x and y are positive, but flag1 is false");
        }
      } else {
        if (flag2) {
          System.out.println("x is positive, y is non-positive, and flag2 is true");
        } else {
          System.out.println("x is positive, y is non-positive, but flag2 is false");
        }
      }
    } else {
      if (flag3) {
        System.out.println("x is non-positive, and flag3 is true");
      } else {
        System.out.println("x is non-positive, but flag3 is false");
      }
    }
  }

  // Error: Division by zero
  public int divideByZero(int numerator, int denominator) {
    return numerator / denominator; // Possible division by zero
  }

  // Error: Potential null pointer dereference
  public void nullPointerDereference(String str) {
    System.out.println(str.length()); // str may be null
  }

  // Error: Index out of bounds
  public void indexOutOfBounds() {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    int value = numbers.get(1); // Index out of bounds
  }

  public static void main(String[] args) {
    StaticCodeAnalysisDemo demo = new StaticCodeAnalysisDemo();
    demo.unusedVariable = 10;

    int result = demo.missingReturnStatement(5);
    System.out.println("Result: " + result);

    int divisionResult = demo.divideByZero(10, 0);
    System.out.println("Division Result: " + divisionResult);

    demo.unusedParameter("Hello", 42);

    demo.nullPointerDereference(null);

    demo.indexOutOfBounds();

    demo.infiniteLoop();
  }
}

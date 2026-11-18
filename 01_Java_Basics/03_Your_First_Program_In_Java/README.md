# Lesson 03: Your First Program in Java (`public static void main`, Class Structure, `javac` & `java`)

## 1. Anatomy of a Java Program
Every line of executable code in Java must live inside a **class**. Let's dissect the canonical Java program line by line:

```java
package _01_Java_Basics._03_Your_First_Program_In_Java;

public class Example {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

### Dissecting `public class Example`
- **`package ...;`**: Declares the namespace folder hierarchy this class belongs to. Must be the **first non-comment statement** in the file.
- **`public`**: An **access modifier** that makes this class visible everywhere, allowing the JVM to load it from outside the package.
- **`class`**: Keyword used to declare a new class blueprint.
- **`Example`**: The class identifier. **Rule:** If a class is declared `public`, its name **must exactly match the filename** (`Example.java`), including capitalization!

### Dissecting `public static void main(String[] args)`
The `main` method is the **entry point** where the JVM starts program execution:
- **`public`**: Must be `public` so the external JVM launcher can invoke it.
- **`static`**: Means the method belongs to the `Example` **class itself**, not to an instance object. The JVM can call `Example.main(...)` immediately without creating an object first (`new Example()`).
- **`void`**: The return type. `void` means this method does not return any value to the JVM when it finishes.
- **`main`**: The exact method name the JVM searches for (case-sensitive: `Main` will not work!).
- **`(String[] args)`**: An array of `String` objects holding any **command-line arguments** passed when launching the program (e.g., `java Example arg1 arg2`).

---

## 2. Comments in Java
Comments are ignored by the compiler (`javac`) except Javadoc comments, which can generate HTML documentation:
1. **Single-line comment**: `// Everything to the end of the line`
2. **Multi-line block comment**: `/* Can span multiple lines */`
3. **Javadoc comment**: `/** Placed above classes/methods for API docs */`

---

## 3. Syntax Rules
1. **Case Sensitivity**: Java is strictly case-sensitive (`System` != `system`, `main` != `Main`).
2. **Curly Braces `{ }`**: Define code blocks (class body, method body). Every opening `{` must have a matching closing `}`.
3. **Semicolons `;`**: Every executable statement in Java must end with a semicolon `;`.

---

## 4. Common Pitfalls
- **Filename / Class Name Mismatch**: Naming the file `example.java` while declaring `public class Example` results in:
  `error: class Example is public, should be declared in a file named Example.java`.
- **Missing `static` or Wrong `main` Signature**: Writing `public void main(String[] args)` compiles without error (it's just a normal method), but fails at runtime with:
  `Error: Main method is not static in class Example`.
- **Forgetting Quotes Around Strings**: `System.out.println(Hello);` fails because the compiler looks for a variable named `Hello`.

---

## 5. Real-World Use Cases
- **Command-Line Utilities (`String[] args`)**: Backend batch jobs, database migration runners (like Flyway/Liquibase CLI), and microservice entry points (`SpringApplication.run(Application.class, args)`) read configuration flags directly from `String[] args`.

# Lesson 02: How to Install Java (Setting Up JDK, PATH Configuration, IDE vs. CLI)

## 1. Choosing a JDK Distribution & LTS Version
Java follows a **6-month release cadence** (March and September), with **Long-Term Support (LTS)** releases designated every 2 years (Java 8, 11, **17**, **21**, 25).
- **Why Target Java 17+ LTS?** Java 17+ is the modern enterprise baseline required by frameworks like **Spring Boot 3+** and **Jakarta EE 10+**.
- **Popular OpenJDK Distributions**:
  - **Eclipse Temurin (Adoptium)** — Vendor-neutral, community-standard OpenJDK.
  - **Oracle JDK** — Official Oracle build.
  - **Amazon Corretto / Azul Zulu / Microsoft Build of OpenJDK** — Cloud-optimized builds.

---

## 2. Setting Up `JAVA_HOME` and `PATH`
When you type `javac` or `java` in a terminal (PowerShell, Command Prompt, Bash, Zsh), the operating system searches the directories listed in your **`PATH`** environment variable.

### Step 1: Set `JAVA_HOME`
Point `JAVA_HOME` to the **root directory** of your JDK installation (do **not** include `\bin` in `JAVA_HOME`):
- **Windows**: `C:\Program Files\Java\jdk-17.0.1`
- **macOS**: `/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home`
- **Linux**: `/usr/lib/jvm/java-17-openjdk-amd64`

### Step 2: Prepend `%JAVA_HOME%\bin` to `PATH`
Add the `bin` subfolder (which contains `javac.exe` and `java.exe`) to your system `PATH`:
- **Windows (PowerShell temporary session)**:
  ```powershell
  $env:JAVA_HOME = "C:\Program Files\Java\jdk-17.0.1"
  $env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
  ```
- **macOS / Linux (`~/.zshrc` or `~/.bashrc`)**:
  ```bash
  export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
  export PATH="$JAVA_HOME/bin:$PATH"
  ```

### Step 3: Verify Installation
Run both commands in your terminal to confirm the compiler (`javac`) and runtime (`java`) match:
```bash
java --version
javac --version
```

---

## 3. CLI Compilation vs. Integrated Development Environments (IDEs)

| Feature | Command Line (CLI: `javac` / `java`) | Modern IDE (IntelliJ IDEA, VS Code, Eclipse) |
| :--- | :--- | :--- |
| **Transparency** | Shows exact `.class` generation, classpath (`-cp`), and package directories. | Automates compilation behind the scenes on save/run. |
| **Best For** | Learning how Java works under the hood, CI/CD pipelines, Docker builds. | Large-scale software engineering, refactoring, interactive debugging. |
| **Single-File Launch** | `java Example.java` *(JEP 330, Java 11+ compiles in memory and runs directly!)* | Click the green "Run" gutter icon. |

---

## 4. Common Pitfalls
1. **Multiple JDKs Installed (`java` vs. `javac` Version Mismatch)**:
   - If an older JDK 8 is listed *before* JDK 17 in your Windows `PATH`, running `javac` might compile with Java 17 (producing class version `61.0`), while `java` runs with Java 8 (which only understands up to `52.0`), causing:
     `java.lang.UnsupportedClassVersionError: Example has been compiled by a more recent version of the Java Runtime`.
2. **Putting `\bin` inside `JAVA_HOME`**:
   - Tools like Maven (`mvn`) and Gradle (`gradle`) append `/bin/java` to `JAVA_HOME`. If `JAVA_HOME` already ends with `\bin`, Maven looks for `\bin\bin\java` and fails!

---

## 5. Real-World Use Cases
- **CI/CD Build Pipelines (GitHub Actions / Jenkins)**: Build scripts explicitly validate `JAVA_HOME` and JDK major versions before running `mvn clean package` to guarantee reproducible production artifacts.

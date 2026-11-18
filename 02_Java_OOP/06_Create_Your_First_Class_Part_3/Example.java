package _02_Java_OOP._06_Create_Your_First_Class_Part_3;

/**
 * Lesson 06: Create Your First Class (Part 3) — The `this` Keyword
 * Demonstrates:
 * 1. The `x = x` field-shadowing bug vs. resolving shadowing with `this.x = x`
 * 2. Proof that `this` holds the exact same memory identity as the caller's object reference
 * 3. Fluent Method Chaining by returning `this`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LESSON 06: THE `this` KEYWORD & SHADOWING      ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. DEMONSTRATING THE `x = x` SHADOWING BUG VS. `this.x = x` FIX
        // -----------------------------------------------------------------
        System.out.println("--- [1] Field Shadowing Bug vs. `this.` Fix ---");
        ShadowDemo demo = new ShadowDemo();

        demo.setUsernameBuggy("Alice_Admin");
        System.out.println("After setUsernameBuggy(\"Alice_Admin\") : username = "
                + demo.getUsername() + " (Still null! Parameter assigned to itself!)");

        demo.setUsernameFixed("Alice_Admin");
        System.out.println("After setUsernameFixed(\"Alice_Admin\") : username = "
                + demo.getUsername() + " (Fixed with `this.username = username`!)");
        System.out.println();

        // -----------------------------------------------------------------
        // 2. VERIFYING WHAT `this` POINTS TO AT RUNTIME
        // -----------------------------------------------------------------
        System.out.println("--- [2] Verifying `this` Object Identity ---");
        System.out.println("Caller reference `demo` identityHashCode : " + System.identityHashCode(demo));
        demo.printThisIdentity();
        System.out.println();

        // -----------------------------------------------------------------
        // 3. FLUENT METHOD CHAINING (`return this;`)
        // WHY: Returning `this` from mutator methods allows callers to configure
        // an object in one expressive statement (like StringBuilder or HttpRequest).
        // -----------------------------------------------------------------
        System.out.println("--- [3] Fluent Method Chaining (`return this;`) ---");
        HttpEndpointConfig endpoint = new HttpEndpointConfig()
                .setHost("api.payments.internal")
                .setPort(8443)
                .setTimeoutMs(5000)
                .setUseHttps(true);

        endpoint.printConfig();
    }
}

/**
 * Contrasts the shadowing self-assignment bug with proper `this.field = field` resolution.
 */
class ShadowDemo {
    private String username;

    // BUGGY SETTER: Parameter `username` shadows field `username`!
    public void setUsernameBuggy(String username) {
        username = username; // Assigns the parameter to ITSELF! Field `this.username` stays null!
    }

    // FIXED SETTER: `this.username` explicitly targets the instance field on the Heap!
    public void setUsernameFixed(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void printThisIdentity() {
        System.out.println("Inside method `this` identityHashCode    : " + System.identityHashCode(this));
    }
}

/**
 * Demonstrates Fluent API design by returning `this` from each setter.
 */
class HttpEndpointConfig {
    private String host = "localhost";
    private int port = 80;
    private int timeoutMs = 1000;
    private boolean useHttps = false;

    public HttpEndpointConfig setHost(String host) {
        this.host = host;
        return this; // Returns the current object so the next `.setXxx()` call can chain!
    }

    public HttpEndpointConfig setPort(int port) {
        this.port = port;
        return this;
    }

    public HttpEndpointConfig setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
        return this;
    }

    public HttpEndpointConfig setUseHttps(boolean useHttps) {
        this.useHttps = useHttps;
        return this;
    }

    public void printConfig() {
        String protocol = this.useHttps ? "https" : "http";
        System.out.printf("Configured Endpoint -> %s://%s:%d (Timeout: %dms)%n",
                protocol, this.host, this.port, this.timeoutMs);
    }
}

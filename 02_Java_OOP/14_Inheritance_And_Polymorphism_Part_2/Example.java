package _02_Java_OOP._14_Inheritance_And_Polymorphism_Part_2;

/**
 * Lesson 14: Inheritance and Polymorphism (Part 2)
 * Demonstrates:
 * 1. Upcasting subclass instances into a polymorphic `NotificationChannel[]` array
 * 2. Dynamic Method Dispatch (the JVM calls the actual runtime object's method)
 * 3. Safe Downcasting with Java 17 Pattern Matching for `instanceof`
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 14: UPCASTING & RUNTIME POLYMORPHISM      ");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // 1. UPCASTING INTO A POLYMORPHIC ARRAY
        // WHY: Even though `EmailChannel`, `SmsChannel`, and `SlackChannel` are
        // different classes, they all extend `NotificationChannel` (IS-A)!
        // We can store all of them in a single `NotificationChannel[]` array!
        // -----------------------------------------------------------------
        NotificationChannel[] channels = {
            new EmailChannel("ops-team@company.com"),
            new SmsChannel("+1-555-0199"),
            new SlackChannel("#prod-alerts")
        };

        // -----------------------------------------------------------------
        // 2. DYNAMIC METHOD DISPATCH (Runtime Polymorphism)
        // WHY: In the loop below, the compile-time type of `channel` is
        // `NotificationChannel`, yet at runtime the JVM dynamically dispatches
        // `channel.sendAlert(...)` to EmailChannel, SmsChannel, and SlackChannel!
        // -----------------------------------------------------------------
        System.out.println("--- [1] Polymorphic Broadcast Loop (Dynamic Dispatch) ---");
        for (NotificationChannel channel : channels) {
            channel.sendAlert("Database CPU exceeded 90%!");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // 3. SAFE DOWNCASTING WITH JAVA 17 `instanceof` PATTERN MATCHING
        // WHY: `verifyCarrierSignal()` only exists on `SmsChannel`, not on the
        // parent `NotificationChannel`. Using `instanceof SmsChannel sms` safely
        // checks the runtime type and creates the downcast variable `sms`!
        // -----------------------------------------------------------------
        System.out.println("--- [2] Safe Downcasting with `instanceof` Pattern Matching ---");
        for (NotificationChannel channel : channels) {
            if (channel instanceof SmsChannel sms) {
                sms.verifyCarrierSignal(); // Child-only method safely invoked!
            }
        }
    }
}

class NotificationChannel {
    private String recipient;

    public NotificationChannel(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void sendAlert(String message) {
        System.out.println("  [Generic Channel] To " + this.recipient + ": " + message);
    }
}

class EmailChannel extends NotificationChannel {
    public EmailChannel(String emailAddress) {
        super(emailAddress);
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("  [SMTP Email]      To <" + getRecipient() + "> | Subject: ALERT | Body: " + message);
    }
}

class SmsChannel extends NotificationChannel {
    public SmsChannel(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("  [Cellular SMS]    To " + getRecipient() + " -> \"" + message + "\"");
    }

    // Specialized method that ONLY exists on SmsChannel (not on NotificationChannel)
    public void verifyCarrierSignal() {
        System.out.println("  [SMS Diagnostic]  5G Carrier signal verified for " + getRecipient() + ".");
    }
}

class SlackChannel extends NotificationChannel {
    public SlackChannel(String channelName) {
        super(channelName);
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("  [Slack Webhook]   Posted in " + getRecipient() + ": :rotating_light: " + message);
    }
}

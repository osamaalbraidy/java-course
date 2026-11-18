package _02_Java_OOP._18_Interfaces_In_Java;

/**
 * Lesson 18: Interfaces in Java — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Polymorphic Notifiable Interface ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Multiple Interface Implementation ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: Combining `extends` and `implements` ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // Coding against the `Notifiable` interface allows `main()` to treat `EmailService`
        // and `WebhookService` identically inside a single `Notifiable[]` array!
        Notifiable[] services = {
            new EmailService(),
            new WebhookService()
        };

        for (Notifiable service : services) {
            service.sendNotification("Server deployed!");
        }
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Implementing both `WifiConnectable` and `Schedulable` gives `SmartThermostat`
        // both capabilities without needing multiple class inheritance!
        SmartThermostat nest = new SmartThermostat();
        nest.connectToWifi("Home-5GHz");
        nest.scheduleTask("22:00 Daily");
    }

    public static void solveProblem3() {
        // WHY WE USED THIS WAY:
        // In Java, a class can combine `extends` (IS-A `CloudResource`) with `implements`
        // (CAN-DO `Encryptable, Auditable`). Note that `extends` must always precede `implements`!
        AwsS3Bucket bucket = new AwsS3Bucket("us-east-1", "prod-backups");
        bucket.printRegion();
        bucket.enableEncryption();
        bucket.writeAuditLog();
    }
}

// -----------------------------------------------------------------
// Problem 1 Interfaces & Classes
// -----------------------------------------------------------------
interface Notifiable {
    void sendNotification(String message);
}

class EmailService implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("[Channel: EmailService]   -> Sending Email: " + message);
    }
}

class WebhookService implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("[Channel: WebhookService] -> POSTing JSON Webhook: " + message);
    }
}

// -----------------------------------------------------------------
// Problem 2 Interfaces & Classes
// -----------------------------------------------------------------
interface WifiConnectable {
    void connectToWifi(String ssid);
}

interface Schedulable {
    void scheduleTask(String cronTime);
}

class SmartThermostat implements WifiConnectable, Schedulable {
    @Override
    public void connectToWifi(String ssid) {
        System.out.println("[SmartThermostat] Connected to Wi-Fi network: \"" + ssid + "\"");
    }

    @Override
    public void scheduleTask(String cronTime) {
        System.out.println("[SmartThermostat] Scheduled Eco-Mode at: \"" + cronTime + "\"");
    }
}

// -----------------------------------------------------------------
// Problem 3 Base Class, Interfaces & Subclass
// -----------------------------------------------------------------
class CloudResource {
    private String region;

    public CloudResource(String region) {
        this.region = region;
    }

    public void printRegion() {
        System.out.println("CloudResource [Region: " + this.region + "]");
    }
}

interface Encryptable {
    String DEFAULT_CIPHER = "AES-256";

    void enableEncryption();
}

interface Auditable {
    void writeAuditLog();
}

class AwsS3Bucket extends CloudResource implements Encryptable, Auditable {
    private String bucketName;

    public AwsS3Bucket(String region, String bucketName) {
        super(region);
        this.bucketName = bucketName;
    }

    @Override
    public void enableEncryption() {
        System.out.println("  -> [Encryptable] Bucket '" + this.bucketName
                + "' encrypted with " + DEFAULT_CIPHER);
    }

    @Override
    public void writeAuditLog() {
        System.out.println("  -> [Auditable]   Audit log generated for bucket '" + this.bucketName + "'");
    }
}

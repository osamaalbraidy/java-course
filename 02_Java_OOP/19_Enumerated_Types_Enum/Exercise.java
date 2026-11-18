package _02_Java_OOP._19_Enumerated_Types_Enum;

/**
 * Lesson 19: Enumerated Types (Enum) — Exercise Solutions
 */
public class Exercise {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Traffic Light State Machine ===");
        solveProblem1();

        System.out.println("\n=== Problem 2: Rich HttpStatusCode Enum ===");
        solveProblem2();

        System.out.println("\n=== Problem 3: SupportTicket with PriorityLevel Enum ===");
        solveProblem3();
    }

    public static void solveProblem1() {
        // WHY WE USED THIS WAY:
        // `TrafficSignal.values()` returns all constants in order, and a Java 17 `switch`
        // expression maps each enum constant exhaustively without needing a `default` branch!
        for (TrafficSignal signal : TrafficSignal.values()) {
            String action = switch (signal) {
                case RED    -> "STOP completely behind the line";
                case YELLOW -> "PREPARE to stop safely";
                case GREEN  -> "PROCEED with caution";
            };
            System.out.printf("Signal %-6s (Ordinal %d) -> Action: %s%n",
                    signal.name(), signal.ordinal(), action);
        }
    }

    public static void solveProblem2() {
        // WHY WE USED THIS WAY:
        // Storing the numeric HTTP code (`200`, `404`, `500`) and message inside the
        // `HttpStatusCode` enum keeps the status code and its business meaning (`isError()`)
        // bundled together in one type-safe object!
        HttpStatusCode[] testStatuses = {
            HttpStatusCode.OK,
            HttpStatusCode.NOT_FOUND,
            HttpStatusCode.INTERNAL_ERROR
        };

        for (HttpStatusCode status : testStatuses) {
            System.out.printf("HTTP %d [%-14s] : %s (Is Error? %b)%n",
                    status.getCode(), status.name(), status.getDescription(), status.isError());
        }
    }

    public static void solveProblem3() {
        SupportTicket t1 = new SupportTicket(901, "Typo on About page", PriorityLevel.LOW);
        SupportTicket t2 = new SupportTicket(902, "Production database unreachable", PriorityLevel.CRITICAL);

        System.out.println(t1);
        System.out.println(t2);
    }
}

// -----------------------------------------------------------------
// Problem 1 Enum
// -----------------------------------------------------------------
enum TrafficSignal {
    RED,
    YELLOW,
    GREEN
}

// -----------------------------------------------------------------
// Problem 2 Enum
// -----------------------------------------------------------------
enum HttpStatusCode {
    OK(200, "Success"),
    CREATED(201, "Resource Created"),
    BAD_REQUEST(400, "Client Error: Invalid Syntax"),
    NOT_FOUND(404, "Client Error: Endpoint Missing"),
    INTERNAL_ERROR(500, "Server Error: Unhandled Exception");

    private final int code;
    private final String description;

    HttpStatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isError() {
        return this.code >= 400;
    }
}

// -----------------------------------------------------------------
// Problem 3 Enum & Domain Class
// -----------------------------------------------------------------
enum PriorityLevel {
    LOW(48),
    MEDIUM(24),
    HIGH(8),
    CRITICAL(1);

    private final int slaHours;

    PriorityLevel(int slaHours) {
        this.slaHours = slaHours;
    }

    public int getSlaHours() {
        return slaHours;
    }
}

class SupportTicket {
    private int ticketId;
    private String issueSummary;
    private PriorityLevel priority;

    public SupportTicket(int ticketId, String issueSummary, PriorityLevel priority) {
        this.ticketId = ticketId;
        this.issueSummary = issueSummary;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("Ticket #%d [Priority: %-8s| Response SLA: %2dh] -> Issue: %s",
                this.ticketId,
                this.priority.name(),
                this.priority.getSlaHours(),
                this.issueSummary);
    }
}

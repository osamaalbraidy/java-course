package _02_Java_OOP._17_Abstract_Class_And_Abstract_Method;

/**
 * Lesson 17: Abstract Class and Abstract Method
 * Demonstrates:
 * 1. Declaring an `abstract class` (`ReportExporter`) with fields, a constructor,
 *    concrete methods, and `abstract` methods
 * 2. Enforcing mandatory `@Override` implementations in concrete subclasses (`PdfExporter`, `CsvExporter`)
 * 3. Using an `abstract` class reference for runtime polymorphism
 */
public class Example {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" LESSON 17: ABSTRACT CLASS & ABSTRACT METHOD      ");
        System.out.println("==================================================\n");

        // ReportExporter raw = new ReportExporter("Q4 Sales"); // <-- COMPILE ERROR: Cannot instantiate abstract class!

        // -----------------------------------------------------------------
        // 1. POLYMORPHIC ARRAY OF ABSTRACT CLASS REFERENCES
        // WHY: While we cannot call `new ReportExporter(...)`, we CAN hold
        // concrete subclasses inside `ReportExporter[]` references and call
        // both concrete (`exportReport`) and abstract (`renderBody`) methods!
        // -----------------------------------------------------------------
        ReportExporter[] exporters = {
            new PdfReportExporter("Q4 Financial Audit", true),
            new CsvReportExporter("Q4 Financial Audit", ',')
        };

        for (ReportExporter exporter : exporters) {
            exporter.exportReport("Revenue=$1.2M;Expenses=$800K;Net=$400K");
            System.out.println();
        }
    }
}

/**
 * ABSTRACT SUPERCLASS:
 * Defines shared state (`reportTitle`), a constructor (called via `super`),
 * a concrete template workflow (`exportReport`), and two `abstract` methods
 * that every concrete subclass is FORCED by the compiler to implement!
 */
abstract class ReportExporter {
    private String reportTitle;

    public ReportExporter(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    // CONCRETE TEMPLATE METHOD: Orchestrates the workflow using the abstract hooks below
    public final void exportReport(String rawData) {
        System.out.println("--- Exporting [" + this.reportTitle + "] as ." + getFileExtension() + " ---");
        String formattedOutput = formatPayload(rawData);
        System.out.println(formattedOutput);
        System.out.println("--- Export Complete (" + formattedOutput.length() + " bytes written) ---");
    }

    // ABSTRACT METHODS: No body `{ }`, end with `;`!
    // Every concrete subclass MUST implement both of these methods!
    public abstract String getFileExtension();

    protected abstract String formatPayload(String rawData);
}

/**
 * CONCRETE SUBCLASS #1: Implements all abstract methods for PDF generation.
 */
class PdfReportExporter extends ReportExporter {
    private boolean encrypted;

    public PdfReportExporter(String reportTitle, boolean encrypted) {
        super(reportTitle);
        this.encrypted = encrypted;
    }

    @Override
    public String getFileExtension() {
        return "pdf";
    }

    @Override
    protected String formatPayload(String rawData) {
        String lockBadge = this.encrypted ? "[AES-256 Encrypted PDF]" : "[Unencrypted PDF]";
        return "  " + lockBadge + " Header: " + getReportTitle() + " | Content: { " + rawData + " }";
    }
}

/**
 * CONCRETE SUBCLASS #2: Implements all abstract methods for CSV generation.
 */
class CsvReportExporter extends ReportExporter {
    private char delimiter;

    public CsvReportExporter(String reportTitle, char delimiter) {
        super(reportTitle);
        this.delimiter = delimiter;
    }

    @Override
    public String getFileExtension() {
        return "csv";
    }

    @Override
    protected String formatPayload(String rawData) {
        String csvRows = rawData.replace(';', this.delimiter);
        return "  [CSV Stream] \"" + getReportTitle() + "\"" + this.delimiter + csvRows;
    }
}

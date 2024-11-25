package Example4;

public class CS_SubsystemBase {

    private String className = "";

    public CS_SubsystemBase() {
        className = this.getClass().getSimpleName().toUpperCase();
        System.out.println("[" + className + "] Instantiated");
    }

    /**
     * Print a formatted string prefixed with the subsystem name.
     *
     * @param format The format string.
     * @param args   The arguments referenced by the format specifiers in the format string.
     */
    protected void printf(String format, Object... args) {
        String formattedMessage = String.format(format, args);
        System.out.println("[" + className + "] " + formattedMessage);
    }

    /**
     * Print a given string prefixed with the subsystem name.
     *
     * @param string The string to print.
     */
    protected void println(String string) {
        this.printf(string);
    } 
}

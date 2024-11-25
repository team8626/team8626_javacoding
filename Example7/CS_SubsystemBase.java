package Example7;

public abstract class CS_SubsystemBase {

    private String className = "";

    public CS_SubsystemBase() {
        Dashboard.registerSubsystem(this);
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
    
    /**
     * Abstract method to update the Dashboard.
     * Subclasses must implement this method.
     */
    public abstract void updateDashboard();
        
}

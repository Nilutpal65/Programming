package VendingMachine;

public class NotFullPaidException extends RuntimeException {
    @Override
    public String getMessage() {
        return message + remaining;
    }

    public int getRemaining() {
        return remaining;
    }

    private String message;
    private int remaining;

    public NotFullPaidException(String message, int remaining){
        this.message = message;
        this.remaining = remaining;
    }
}

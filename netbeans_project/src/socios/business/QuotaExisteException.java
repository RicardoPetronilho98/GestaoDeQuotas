package socios.business;

public class QuotaExisteException extends Exception {

    public QuotaExisteException() {
        super();
    }

    public QuotaExisteException(String msg) {
        super(msg);
    }
}

package socios.business;

public class QuotaNaoExisteException extends Exception {

    public QuotaNaoExisteException() {
        super();
    }

    public QuotaNaoExisteException(String msg) {
        super(msg);
    }
}

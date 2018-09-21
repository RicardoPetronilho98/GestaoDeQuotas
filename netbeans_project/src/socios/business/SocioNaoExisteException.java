package socios.business;

public class SocioNaoExisteException extends Exception{

    public SocioNaoExisteException() {
        super();
    }

    public SocioNaoExisteException(String msg) {
        super(msg);
    }
}

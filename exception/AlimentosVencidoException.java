package exception;

public class AlimentosVencidoException extends RuntimeException {
    public AlimentosVencidoException(String mensagem) {
        super(mensagem);
    }
}
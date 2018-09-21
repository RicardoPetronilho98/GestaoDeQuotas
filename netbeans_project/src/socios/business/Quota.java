package socios.business;

import java.time.LocalDate;

public class Quota implements Comparable<Quota>{

    private String cod; // identificação da Quota
    private float numerario;
    private LocalDate dataDePagamento;

    /**
     * Construtor vazio.
     */
    public Quota() {
        this.cod = "";
        this.numerario = 0f;
        this.dataDePagamento = LocalDate.now();
    }

    /**
     * Construtor parametrizado.
     * @param cod código de identificação da Quota.
     * @param numerario valor pago da Quota.
     * @param dataDePagamento data de pagamento da Quota.
     */
    public Quota(String cod, float numerario, LocalDate dataDePagamento) {
        this.cod = cod;
        this.numerario = numerario;
        this.dataDePagamento = dataDePagamento;
    }

    /**
     * Construtor cópia.
     * @param outraQuota Quota a ser copiada.
     */
    public Quota(Quota outraQuota) {
        this.cod = outraQuota.getCod();
        this.numerario = outraQuota.getNumerario();
        this.dataDePagamento = outraQuota.getDataDePagamento();
    }

    /**
     * Devolve o código de identificação da Quota.
     * @return retorna o código de identificação da Quota.
     */
    public String getCod() {
        return cod;
    }

    /**
     * Define o código de identificação da Quota.
     * @param cod código de identificação a ser definido.
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * Devolve o valor pago da Quota.
     * @return retorna o valor pago da Quota.
     */
    public float getNumerario() {
        return numerario;
    }

    /**
     * Define o valor pago da Quota.
     * @param numerario valor pago a ser definido.
     */
    public void setNumerario(float numerario) {
        this.numerario = numerario;
    }

    /**
     * Devolve a data de pagamento da Quota.
     * @return retorna a data de pagamento da Quota.
     */
    public LocalDate getDataDePagamento() {
        return dataDePagamento;
    }

    /**
     * Define a data de pagamento da Quota.
     * @param dataDePagamento data de pagamento a ser definida.
     */
    public void setDataDePagamento(LocalDate dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    /**
     * Devolve uma Quota cópia da atual.
     * @return retorna uma Quota cópia da atual.
     */
    @Override
    public Quota clone() {
        return new Quota(this);
    }

    /**
     * Devolve a representação da Quota atual em formato String.
     * @return retorna a Quota atual em formato String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Quota{");
        sb.append("cod=").append(this.cod.toString()).append(", ");
        sb.append("numerario=").append(String.valueOf(this.numerario)).append(", ");
        sb.append("dataDePagamento=").append(this.dataDePagamento.toString()).append("}");
        return sb.toString();
    }

    /**
     * Indica se o Object o é equivalente em valor à Quota atual.
     * @param o Object o a ser equiparado.
     * @return retorna true caso o Object o e a Quota atual sejam iguais em valor, retorna false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Quota outraQuota = (Quota) o;
        return this.cod.equals(outraQuota.getCod()) &&
                this.numerario == outraQuota.getNumerario() &&
                this.dataDePagamento.equals(outraQuota.getDataDePagamento());
    }

    /**
     * Compara a Quota atual com outra Quota em termos de ordenação natural.
     * @param outraQuota outra Quota a ser comparada.
     * @return retorna o ratio de comparação (-1, 0 ou 1).
     */
    @Override
    public int compareTo(Quota outraQuota) {
        // Nota: para facilitar, uso o compareTo() implementado na Class String
        return this.getCod().compareTo(outraQuota.getCod());
    }
}

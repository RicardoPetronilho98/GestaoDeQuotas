package socios.business;

import java.util.HashMap;
import java.util.Map;

public class Socio extends Aluno {

    private Map<String, Quota> quotas;

    public Socio() {
        super();
        this.quotas = new HashMap<>();
    }

    public Socio(String nome, int idade, char sexo, String cod, Map<String, Quota> quotas) throws ParametrosInvalidosException {
        super(nome, idade, sexo, cod);
        this.setQuotas(quotas);
    }

    public Socio(Socio outroAluno) {
        super(outroAluno);
        this.quotas = outroAluno.getQuotas();
    }

    public Map<String, Quota> getQuotas() {
        Map<String, Quota> res = new HashMap<>();
        for(Map.Entry<String, Quota> entry: this.quotas.entrySet())
            res.put(entry.getKey(), entry.getValue().clone());
        return res;
    }

    public void setQuotas(Map<String, Quota> quotas) throws ParametrosInvalidosException  {
        if (quotas == null) throw new ParametrosInvalidosException("quotas=null");
        this.quotas = new HashMap<>();
        for(Map.Entry<String, Quota> entry: quotas.entrySet())
            this.quotas.put(entry.getKey(), entry.getValue().clone());
    }

    @Override
    public Socio clone() {
        return new Socio(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Socio{");
        sb.append("nome=").append(this.getNome()).append(", ");
        sb.append("idade=").append(String.valueOf(this.getIdade())).append(", ");
        sb.append("sexo=").append(String.valueOf(this.getSexo())).append(", ");
        sb.append("cod=").append(this.getCod()).append(", ");
        sb.append("quotas=").append(this.quotas).append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Socio outraSocio = (Socio) o;
        return super.equals(o) &&
                this.quotas.equals(outraSocio.getQuotas());
    }

    public void addQuota(Quota q) throws QuotaExisteException {
        if (this.quotas.containsKey(q.getCod())) throw new QuotaExisteException(q.getCod());
        this.quotas.put(q.getCod(), q.clone());
    }

    public void removeQuota(String cod) throws QuotaNaoExisteException {
        if (!this.quotas.containsKey(cod)) throw new QuotaNaoExisteException(cod);
        this.quotas.remove(cod);
    }

}

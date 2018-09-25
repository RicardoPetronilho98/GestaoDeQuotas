package socios.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SGQ extends Observable {

    private Map<String, Socio> socios;
    private int currentId;

    public SGQ() {
        this.socios = new HashMap<>();
        this.currentId = 999;

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }

    public SGQ(Map<String, Socio> info, int currentId) {
        this.setSocios(info);
        this.currentId = currentId;

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }

    public SGQ(SGQ outroSGQ) {
        this.socios = outroSGQ.getSocios();
        this.currentId = outroSGQ.getCurrentId();

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }

    public Map<String, Socio> getSocios() {
        Map<String, Socio> res = new HashMap<>();
        for(Map.Entry<String, Socio> entry: this.socios.entrySet())
            res.put(entry.getKey(), entry.getValue().clone());
        return res;
    }

    public void setSocios(Map<String, Socio> info) {
        this.socios = new HashMap<>();
        for(Map.Entry<String, Socio> entry: info.entrySet())
            this.socios.put(entry.getKey(), entry.getValue().clone());

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }

    public int getCurrentId() {
        return this.currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    @Override
    public SGQ clone() {
        return new SGQ(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SGQ{");
        sb.append("socios=").append(this.socios.toString()).append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        SGQ outroSGQ = (SGQ) o;
        return this.socios.equals(outroSGQ.getSocios());
    }

    public void addSocio(Socio s) throws SocioExisteException {
        if (this.socios.containsKey(s.getCod())) throw new SocioExisteException(s.getCod());
        this.socios.put(s.getCod(), s.clone());

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }

    public void removeSocio(String cod) throws SocioNaoExisteException {
        if (!this.socios.containsKey(cod)) throw new SocioNaoExisteException(cod);
        this.socios.remove(cod);

        /** notifica os Observadores que este objecto foi alterado */
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Adiciona um Observer a um Sócio.
     * @param cod código do Sócio 
     * @param o Observer
     */
    public void addObserverToSocio(String cod, Observer o) {
        this.socios.get(cod).addObserver(o);
    }
    
    public void addQuota(String cod, Quota q) throws QuotaExisteException {
        this.socios.get(cod).addQuota(q);
    }
}

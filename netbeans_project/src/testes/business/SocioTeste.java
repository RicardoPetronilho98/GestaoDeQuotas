package testes.business;

import socios.business.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SocioTeste {

    public static void main(String[] args) throws Exception {

        // teste do Construtor vazio e do toString()
        System.out.println(new Socio());

        // teste do Construtor parametrizado
        Aluno a = new Aluno("Ricardo", 20, 'M', "a81744");

        Quota q1 = new Quota("1", 1f, LocalDate.now());
        Quota q2 = new Quota("2", 2f, LocalDate.now());
        Quota q3 = new Quota("3", 3f, LocalDate.now());

        Map<String, Quota> map = new HashMap<>();
        map.put(q1.getCod(), q1);
        map.put(q2.getCod(), q2);
        map.put(q3.getCod(), q3);

        // teste do Construtor parametrizado
        Socio s1 = new Socio("Ricardo", 20, 'M', "a81744", map);
        System.out.println(s1);

        // Teste dos setters()
        Socio s2 = new Socio();
        s2.setNome("Ricardo");
        s2.setIdade(20);
        s2.setSexo('M');
        s2.setCod("a81744");
        s2.setQuotas(map);

        // teste do equals()
        System.out.println(s1.equals(s2)); // suposto dar true
        s2.setQuotas(new HashMap<>());
        System.out.println(s1.equals(s2)); // suposto dar false

        // Teste do clone() e Construtor cópia
        System.out.println(s2.clone().equals(s2)); // suposto dar true

        Socio s = new Socio("Ricardo", 20, 'M', "a81744", new HashMap<>());

        // Teste do addQuota(), removeQuota()
        try {
            s.addQuota(q1);
            s.addQuota(q2);
            s.addQuota(q3);

            s.removeQuota(q1.getCod());
        } catch (QuotaExisteException e){
            e.printStackTrace();
        } catch (QuotaNaoExisteException e){
            e.printStackTrace();
        }

        System.out.println(s);
    }
}

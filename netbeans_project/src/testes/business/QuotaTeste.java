package testes.business;

import socios.business.Quota;

import java.time.LocalDate;

public class QuotaTeste {

    public static void main(String[] args) {

        // teste do Construtor vazio e do toString()
        System.out.println(new Quota());

        // teste do Construtor parametrizado
        Quota q1 = new Quota("1", 222.222f, LocalDate.now());
        System.out.println(q1);

        // Teste dos setters()
        Quota q2 = new Quota();
        q2.setCod("1");
        q2.setNumerario(222.222f);
        q2.setDataDePagamento(LocalDate.now());

        // teste do equals()
        System.out.println(q2.equals(q1)); // suposto dar true
        q2.setNumerario(223.223f);
        System.out.println(q2.equals(q1)); // suposto dar false

        // Teste do clone() e Construtor cópia
        System.out.println(q2.clone().equals(q2)); // suposto dar true

    }
}

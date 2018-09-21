package testes.business;

import socios.business.Aluno;

public class AlunoTeste {

    public static void main(String[] args) {

        // teste do Construtor vazio e do toString()
        System.out.println(new Aluno());

        // teste do Construtor parametrizado
        Aluno a1 = new Aluno("Ricardo", 20, 'M', "a81744");
        System.out.println(a1);

        // Teste dos setters()
        Aluno a2 = new Aluno();
        a2.setNome("Ricardo");
        a2.setIdade(20);
        a2.setSexo('M');
        a2.setCod("a81744");

        // teste do equals()
        System.out.println(a2.equals(a1)); // suposto dar true
        a2.setIdade(21);
        System.out.println(a2.equals(a1)); // suposto dar false

        // Teste do clone() e Construtor cópia
        System.out.println(a2.clone().equals(a2)); // suposto dar true
    }
}

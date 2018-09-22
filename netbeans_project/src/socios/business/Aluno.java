package socios.business;

public class Aluno {

    private String nome;
    private int idade;
    private char sexo;
    private String cod; // número de aluno ex: a81744

    /**
     * Construtor vazio.
     */
    public Aluno() {
        this.nome = "";
        this.idade = 0;
        this.sexo = 'F';
        this.cod = "";
    }

    /**
     * Construtor parametrizado.
     * @param nome nome do Aluno.
     * @param idade idade do Aluno.
     * @param sexo sexo do Aluno.
     * @param cod código de identificação do Aluno.
     */
    public Aluno(String nome, int idade, char sexo, String cod) throws ParametrosInvalidosException {
        this.setNome(nome);
        this.setIdade(idade);
        this.setSexo(sexo);
        this.setCod(cod);
    }

    /**
     * Construtor cópia.
     * @param outroAluno Aluno a ser copiado.
     */
    public Aluno(Aluno outroAluno) {
        this.nome = outroAluno.getNome();
        this.idade = outroAluno.getIdade();
        this.sexo = outroAluno.getSexo();
        this.cod = outroAluno.getCod();
    }

    /**
     * Devolve o nome do Aluno.
     * @return retorna o nome do Aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do Aluno.
     * @param nome nome a ser definido.
     */
    public void setNome(String nome) throws ParametrosInvalidosException {
        if (nome == null || nome.equals("")) throw new ParametrosInvalidosException(nome);
        this.nome = nome;
    }

    /**
     * Devolve a idade do Aluno.
     * @return retorna a idade do Aluno.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do Aluno.
     * @param idade idade a ser definida.
     */
    public void setIdade(int idade) throws ParametrosInvalidosException {
        if (idade <= 0) throw new ParametrosInvalidosException(Integer.toString(idade));
        this.idade = idade;
    }

    /**
     * Devolve o sexo do Aluno.
     * @return retorna o sexo do Aluno.
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Define o sexo do Aluno.
     * @param sexo sexo a ser definido.
     */
    public void setSexo(char sexo) throws ParametrosInvalidosException {
        if (sexo == ' ') throw new ParametrosInvalidosException(Character.toString(sexo));
        this.sexo = sexo;
    }

    /**
     * Devolve o código de identificação do Aluno.
     * @return retorna o código de identificação do Aluno.
     */
    public String getCod() {
        return cod;
    }

    /**
     * Define o código de identificação do Aluno.
     * @param cod código de identificação do Aluno a ser definido.
     */
    public void setCod(String cod) throws ParametrosInvalidosException {
        if (cod == null || cod.equals("")) throw new ParametrosInvalidosException(cod);
        this.cod = cod;
    }

    /**
     * Devolve um Aluno cópia do atual.
     * @return retorna um Aluno cópia do atual.
     */
    public Aluno clone() {
        return new Aluno(this);
    }

    /**
     * Devolve a representação do Aluno atual em formato String.
     * @return retorna o Aluno atual em formato String.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Aluno{");
        sb.append("nome=").append(this.nome.toString()).append(", ");
        sb.append("idade=").append(String.valueOf(this.idade)).append(", ");
        sb.append("sexo=").append(String.valueOf(this.sexo)).append(", ");
        sb.append("cod=").append(this.cod.toString()).append("}");
        return sb.toString();
    }

    /**
     * Indica se o Object o é equivalente em valor ao Aluno atual.
     * @param o Object o a ser equiparado.
     * @return retorna true caso o Object o e o Aluno atual sejam iguais em valor, retorna false caso contrário.
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Aluno outroAluno = (Aluno) o;
        return this.nome.equals(outroAluno.getNome()) &&
                this.idade == outroAluno.getIdade() &&
                this.sexo == outroAluno.getSexo() &&
                this.cod.equals(outroAluno.getCod());
    }
}
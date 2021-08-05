
package entities;

public class Funcionario implements Entity {
    private int ID;
    private String nome;
    private String cpf;
    private String dataContratacao;
    private float salario;

    public Funcionario(int ID, String nome, String cpf, String dataContratacao, float salario) {
        this.ID = ID;
        this.nome = nome;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }
    public Funcionario(String nome, String cpf, String dataContratacao, float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }
    
    public void setID(int ID){
        this.ID = ID;
      }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}

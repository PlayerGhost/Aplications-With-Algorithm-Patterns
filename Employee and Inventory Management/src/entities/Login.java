
package entities;

public class Login implements Entity {
    int ID;
    String cpf;
    String password;

    public Login(int ID, String cpf, String password) {
        this.ID = ID;
        this.cpf = cpf;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }
}

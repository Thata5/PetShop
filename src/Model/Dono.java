
package Model;

public class Dono {
  String CPF,Endereco,Telefone,Nascimento;
  int ID;

    public Dono(String CPF, String Endereco, String Telefone, String Nascimento, int ID) {
        this.CPF = CPF;
        this.Endereco = Endereco;
        this.Telefone = Telefone;
        this.Nascimento = Nascimento;
        this.ID = ID;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
 
}

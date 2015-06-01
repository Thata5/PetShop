
package Model;

public class Animal {
    String Raca,Cor,Tamanho,Obs,Nome,Nascimento;
    int ID;

    public Animal(String Raca, String Cor, String Tamanho, String Obs, String Nome, String Nascimento, int ID) {
        this.Raca = Raca;
        this.Cor = Cor;
        this.Tamanho = Tamanho;
        this.Obs = Obs;
        this.Nome = Nome;
        this.Nascimento = Nascimento;
        this.ID = ID;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

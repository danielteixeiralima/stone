//classe que registra e encapsula os dados de cada usuário
package stone;




public class Funcionarios {
    
    public String nome;
    public int idade;
    public String cargo;
    
    public Funcionarios(String nome, int idade, String cargo) {
    
    }
    public Funcionarios(){
    
    }
    
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        nome = this.nome;
    }
    
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        idade = this.idade;
    }
    
    public String getCargo(){
        return this.cargo;
    }
    public void setCargo(String cargo){
        cargo = this.cargo;
    }

    
    
    
}

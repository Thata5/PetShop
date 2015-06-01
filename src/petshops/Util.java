
package petshops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Classe para criar tabela(substituir nosso terminal)
public class Util {
        
       public static Connection conecta() throws SQLException{
    Connection conexao = null;

        String url = "jdbc:mysql://localhost/petShop";  //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "123456"; //senha do MySQL
        try{
            conexao = DriverManager.getConnection(url, user, password);
}catch(SQLException sqlex){
System.out.println("Erro na conexão "+ sqlex);
}
        return conexao;
 }
       
       public void desconecta(Connection conexao){
try{
conexao.close();
}catch(SQLException sqlex){
System.out.println("Erro na conexão "+ sqlex);
}
}
       public static void CriaTabela(String nomeTabela,String atributos) throws SQLException {
            Statement statement = null;
            Connection conexao = null;
        try {
            conexao = conecta();
            statement = conexao.createStatement();
            String createTableSQL = "CREATE TABLE "+nomeTabela+"("+atributos+");";
            System.out.println(createTableSQL);
               statement.execute(createTableSQL); // executa o comando de criação
            System.out.println("Tabela \"nomeTabela\" foi criada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {   // sempre feche o statement a conexão com banco
            if (statement != null) {
                statement.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        }
    }
       public static void criaBanco(String banco) throws SQLException{
         String  sql="CREATE DATABASES"+banco;
           Connection conexao = conecta();
           Statement stmt = conexao.createStatement();
           stmt.execute(sql);
           
           
       }
   
      public static void main(String [] args)throws SQLException {
        criaBanco("PetShop");
        CriaTabela("Dono","ID´ INT NULL AUTO_INCREMENT,"+
                "CPF´VARCHAR(11) NULL,"+
                "Endereco´VARCHAR(45)NULL,"+
                "Telefone´VARCHAR(45)NULL,"+
                "Nome´VARCHAR(45)NULL,"+
                "Nascimento´VARCHAR(45)NULL,"+
                "PRIMARY KEY('ID')");
        CriaTabela("Animal",  "`IDAnimal` INT NULL AUTO_INCREMENT,"+
  "`Raca` VARCHAR(45) NULL,"+
  "`Cor` VARCHAR(45) NULL,"+
  "`Tamanho` VARCHAR(20) NULL,"+
  "`Obs` VARCHAR(45) NULL,"+
  "`Nome` VARCHAR(45) NULL,"+
  "`Nascimento` VARCHAR(45) NULL,"+
  "`Dono_ID` INT NOT NULL,"+
  "PRIMARY KEY (`idAnimal`, `Dono_ID`),"+
  "INDEX `fk_Animal_Dono1_idx` (`Dono_ID` ASC),"+
  "CONSTRAINT `fk_Animal_Dono1`"+
   " FOREIGN KEY (`Dono_ID`)"+
    "REFERENCES `mydb`.`Dono` (`ID`)"+
    "ON DELETE NO ACTION"+
    "ON UPDATE NO ACTION");
        
   CriaTabela("Servico","`ID` INT NULL AUTO_INCREMENT,"+
  "`Nome` VARCHAR(45) NULL,"+
  "`Descricao` VARCHAR(45) NULL,"+
  "PRIMARY KEY (`ID`)");
   CriaTabela("Agenda","`Horario` INT NULL,"+
  "`ID` INT NULL AUTO_INCREMENT,"+
  "`Animal_idAnimal` INT NOT NULL,"+
  "`Servico_ID` INT NOT NULL,"+
  "PRIMARY KEY (`ID`, `Animal_idAnimal`, `Servico_ID`),"+
  "INDEX `fk_Agenda_Animal_idx` (`Animal_idAnimal` ASC),"+
  "INDEX `fk_Agenda_Servico1_idx` (`Servico_ID` ASC),"+
  "CONSTRAINT `fk_Agenda_Animal`"+
    "FOREIGN KEY (`Animal_idAnimal`)"+
    "REFERENCES `mydb`.`Animal` (`idAnimal`)"+
    "ON DELETE NO ACTION"+
    "ON UPDATE NO ACTION,"+
  "CONSTRAINT `fk_Agenda_Servico1`"+
    "FOREIGN KEY (`Servico_ID`)"+
    "REFERENCES `mydb`.`Servico` (`ID`)"+
    "ON DELETE NO ACTION"+
    "ON UPDATE NO ACTION");
}
}

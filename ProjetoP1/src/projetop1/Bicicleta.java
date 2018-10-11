
package projetop1;


public class Bicicleta extends Veiculo{
        public Bicicleta(){//construtor padrão da bicicleta
        this.setVelocidade(1);
    }
        public void cam(int posLinha, int posColuna){//função para setar linhas e colunas
        this.setColuna(posColuna);
        this.setLinha(posLinha);
        
    }
}

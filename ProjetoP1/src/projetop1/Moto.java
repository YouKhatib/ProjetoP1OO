
package projetop1;


public class Moto extends Veiculo{
    
    public Moto(){//construtor padrão da moto
        this.setVelocidade(3);
    }
        public void mot(int posLinha, int posColuna){ //função para setar linhas e colunas
        this.setColuna(posColuna);
        this.setLinha(posLinha);
        
    }
    
}

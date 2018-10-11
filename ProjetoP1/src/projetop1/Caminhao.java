
package projetop1;

public class Caminhao extends Veiculo{
    public Caminhao(){//construtor padrão do caminhão
        this.setVelocidade(1);
    }
        public void cam(int posLinha, int posColuna){//função para setar linhas e colunas
        this.setColuna(posColuna);
        this.setLinha(posLinha);
        
    }
}

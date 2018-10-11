
package projetop1;

import java.util.Random;

public class Carro extends Veiculo {

    public Carro(){ //construtor padrão do carro
        this.setVelocidade(2);
    }
    public void car(int posLinha, int posColuna){//função para setar linhas e colunas
        this.setColuna(posColuna);
        this.setLinha(posLinha);
        
    }


}

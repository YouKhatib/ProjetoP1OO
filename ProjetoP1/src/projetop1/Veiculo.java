
package projetop1;
import java.util.Random;

public class Veiculo {
    protected int x, y,velocidade;//declaração de variaves
    protected String cor;
    protected boolean fabrica;
    public Veiculo(){
        
    }
    public Veiculo(int linha, int coluna, int vel, boolean fabr, String cr){
        this.setColuna(coluna); //seto as colunas, linhas, e a velocidade dos veículos
        this.setLinha(linha);
        this.setVelocidade(vel);
    }

    public void move(Veiculo a, int v){ /*função que realiza o movimento.
        a função recebe o veiculo e a velocidade(quantidade de casas que anda)
        */
        Random rand = new Random();
        
        int random = rand.nextInt(4) + 1;//gera um número aleatório de 1 a 4
        
        if (random == 1){//caso o número seja 1, o veiculo se moverá para baixo.
            a.setLinha(a.getLinha() +v);
            if (a.getLinha() > 29){ 
                a.setLinha(1);/*se a linha do veículo for maior que 29,
                ele aparecerá do outro lado
                */
            }
        }
        if (random == 2){//caso o número seja 2, o veiculo se moverá para cima.
            a.setLinha(a.getLinha() -v);
            if (a.getLinha() < 1){
                a.setLinha(29);/*se a linha do veículo for menor que 1,
                ele aparecerá do outro lado
                */
            }
        }
        if (random == 3){//caso o número seja 3, o veiculo se moverá para a direita.
            a.setColuna(a.getColuna() +v);
                if (a.getColuna() > 59){
                a.setColuna(1);/*se a coluna do veículo for maior que 59,
                ele aparecerá do outro lado
                */
            }
        }
        if (random == 4){//caso o número seja 4, o veiculo se moverá para a esquerda.
            a.setColuna(a.getColuna() -v);
            if (a.getColuna() < 1){
                a.setColuna(59);/*se a coluna do veículo for menor que 1,
                ele aparecerá do outro lado
                */
            }
        }        
    }
    

    public void setLinha(int l){//funcao para setar a linha
        this.y = l;
    }
    public void setColuna(int c){//funcao para setar a coluna
        this.x = c;
    }
    public void setVelocidade(int v){//funcao para setar a velocidade
        this.velocidade = v;
    }
    public void setCor(String color){//funcao para setar a cor
        this.cor = color;
    }
    
    public int getLinha(){//funcao get da linha
        return y;
    }
    public int getColuna(){//funcao get da coluna
        return x;
    }
    public int getVelocidade(){//funcao get da velocidade
        return velocidade;
    }
    public String getCor(){//funcao get da cor
        return cor;
    }
}

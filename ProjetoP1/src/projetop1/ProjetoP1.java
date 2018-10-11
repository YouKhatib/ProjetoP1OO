/*Projeto P1 de Orientação a Objetos - CC3642 - Nome: Youssef Ali El Khatib - R.A: 22.217.034-2 - Data de entrega: 13/10/2018
Objetivo: Desenvolver uma aplicação de diversos objetos criados a partir de 4
veículos: carro, caminhão, moto e bicicleta. No "mapa", existem fábricas, quando
um tipo de veículo passa por uma fábrica, aparece outro veículo do mesmo tipo em
uma região aleatória do mapa. Quando ocorre uma colisão entre o caminhão e uma
moto/carro/bicicleta, os três citados por último desaparecem; quando ocorre uma
colisão entre o carro e a moto/bicicleta, os dois últimos desaparecem, e, por
fim, quando há uma colisão entre a moto e a bicicleta, a bicicleta desaparece.
*/
package projetop1;
import java.util.ArrayList;       //]
import java.util.Random;          //}
import java.util.logging.Level;   //}Importação de bibliotecas.
import java.util.logging.Logger;  //]
public class ProjetoP1 {
    public static void main(String[] args) {
        Random rand = new Random(); /* Utilizando a biblioteca random, crio o
        objeto rand, que utilizarei para obter números aleatórios*/
        Mapa mapa = new Mapa(); //Crio o objeto do tipo Mapa
        int contador = 1; /*crio um inteiro contador, utilizado para realizar
        a movimentação da bicicleta */
        ArrayList <Veiculo> carros = new ArrayList<>();
        ArrayList <Veiculo> motos = new ArrayList<>();
        ArrayList <Veiculo> caminhoes = new ArrayList<>();
        ArrayList <Veiculo> bicicletas = new ArrayList<>(); /*Crio os ArrayLists
        do tipo Veiculo para todos os tipos de veículos utilizados*/
        for (int i = 0; i < 10; i++){  //Atribuir para os 10 veículos iniciais
            carros.add(new Carro()); //Adiciono um objeto do tipo Carro a ArrayList
            motos.add(new Moto()); //Adiciono um objeto do tipo Moto a ArrayList
            caminhoes.add(new Caminhao()); //Adiciono um objeto do tipo Caminhao a ArrayList
            bicicletas.add(new Bicicleta());//Adiciono um objeto do tipo Bicicleta a ArrayList
            int lncar = rand.nextInt(29) + 1; //Calculo coordenadas aleatórias para a linha do carro
            int clncar = rand.nextInt(59) + 1;//Calculo coordenadas aleatórias para a coluna do carro
            int lnmot = rand.nextInt(29) + 1; //Calculo coordenadas aleatórias para a linha da moto
            int clnmot = rand.nextInt(59) + 1;//Calculo coordenadas aleatórias para a coluna da moto
            int lncam = rand.nextInt(29) + 1; //Calculo coordenadas aleatórias para a linha do caminhao
            int clncam = rand.nextInt(59) + 1;//Calculo coordenadas aleatórias para a coluna do caminhao
            int lnbic = rand.nextInt(29) + 1; //Calculo coordenadas aleatórias para a linha da bicicleta
            int clnbic = rand.nextInt(59) + 1;//Calculo coordenadas aleatórias para a coluna da bicicleta
            carros.get(i).setLinha(lncar); //Seto a linha para os carros
            carros.get(i).setColuna(clncar);//Seto a coluna para os carros
            caminhoes.get(i).setLinha(lncam);//Seto a linha para os caminhões
            caminhoes.get(i).setColuna(clncam);//Seto a coluna para os caminhões
            motos.get(i).setLinha(lnmot); //Seto a linha para as motos
            motos.get(i).setColuna(clnmot);//Seto a coluna para as motos
            bicicletas.get(i).setLinha(lnbic);//Seto a linha para as bicicletas
            bicicletas.get(i).setColuna(clnbic);//Seto a coluna para as bicicletas
            mapa.atualizaMapaCarro(carros.get(i));//Chamo a função para atualizar o mapa para os carros
            mapa.atualizaMapaMoto(motos.get(i));//Chamo a função para atualizar o mapa para as motos
            mapa.atualizaMapaCaminhao(caminhoes.get(i));//Chamo a função para atualizar o mapa para os caminhões
            mapa.atualizaMapaBicicleta(bicicletas.get(i));//Chamo a função para atualizar o mapa para as bicicletas
        }
        while(true){ //Looping para o mapa rodar infinitamente
            try {
                Thread.sleep(300); //Método para imprimir uma vez a cada 0.3s
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjetoP1.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.printf("Carros(verde): %d " //Imprimindo a quantidade de Carros,
                            + " Motos(amarelo): %d "//Motos
                            + "Caminhoes(azul claro): %d "//Caminhões
                            + "Bicicletas(vermelho): %d",//e bicicletas existem.
                            carros.size(), motos.size(),
                            caminhoes.size(), bicicletas.size());
            mapa.imprimeMapa(); //Imprime o mapa
            mapa.limpaMapa(); //Limpa o mapa para que os objetos não deixem rastros
            for(int o = 2; o < carros.size(); o++){ //For para imprimir os carros
                mapa.move(carros.get(o), carros.get(o).getVelocidade()); //Move os carros
                mapa.atualizaMapaCarro(carros.get(o)); //Atualiza o mapa
                if (mapa.fabricaCarro(carros.get(o)) == true){ /*função para
                    checar se algum carro passou por uma fábrica
                    */
                    carros.add(new Carro()); //caso tenha passado, adiciona um novo objeto
                    int line = rand.nextInt(29) + 1; //linha aleatória para ele aparecer
                    int column = rand.nextInt(59) + 1;//coluna aleatória para ele aparecer
                    carros.get(carros.size() - 1).setLinha(line); //Seta a linha
                    carros.get(carros.size() - 1).setColuna(column);//Seta a coluna
                }
                if (carros.size() > 2){ 
                    for (int s = 0; s < caminhoes.size(); s++){//Checa a colisão com os caminhões
                        if (mapa.bateCarroCaminhao(carros.get(o-2),
                                                   caminhoes.get(s)) == true){/*Caso a função que checa 
                            as colisões retorne true, remove o carro
                            */
                            carros.remove(o-2);
                        }
                    }
                }
                if (carros.size() == 2){
                        carros.remove(1);
                        carros.remove(0);
                }
            }
            for(int o = 2; o < caminhoes.size(); o++){//For para imprimir os caminhões
                mapa.move(caminhoes.get(o), caminhoes.get(o).getVelocidade());//Move os caminhões
                mapa.atualizaMapaCaminhao(caminhoes.get(o));//Atualiza o mapa
                if (mapa.fabricaCaminhao(caminhoes.get(o)) == true){/*função para
                    checar se algum caminhão passou por uma fábrica
                    */
                    caminhoes.add(new Caminhao());//caso tenha passado, adiciona um novo objeto
                    int line = rand.nextInt(29) + 1;//linha aleatória para ele aparecer
                    int column = rand.nextInt(59) + 1;//coluna aleatória para ele aparecer
                    caminhoes.get(caminhoes.size() - 1).setLinha(line);//Seta a linha
                    caminhoes.get(caminhoes.size() - 1).setColuna(column);//Seta a coluna
                }
            }
            for(int o = 2; o < motos.size(); o++){//For para imprimir as motos
                mapa.move(motos.get(o), motos.get(o).getVelocidade());//Move as motos
                mapa.atualizaMapaMoto(motos.get(o));//Atualiza o mapa
                if (mapa.fabricaMoto(motos.get(o)) == true){/*função para
                    checar se alguma moto passou por uma fábrica
                    */
                    motos.add(new Moto());//caso tenha passado, adiciona um novo objeto
                    int line = rand.nextInt(29) + 1;//linha aleatória para ele aparecer
                    int column = rand.nextInt(59) + 1;//coluna aleatória para ele aparecer
                    motos.get(motos.size() - 1).setLinha(line);//Seta a linha
                    motos.get(motos.size() - 1).setColuna(column);//Seta a coluna
                }
                if (motos.size() > 2){
                    for (int p = 0; p < carros.size(); p++){ //Checa colisões com os carros
                        if (mapa.bateMotoCarro(motos.get(o-2), 
                                               carros.get(p)) == true){/*Caso a função que checa 
                            as colisões retorne true, remove o carro
                            */
                            motos.remove(o-2); 
                        }
                    }
                }
                 if (motos.size() > 2){ 
                    for (int s = 0; s < caminhoes.size(); s++){//Checa colisão com caminhões
                        if (mapa.bateMotoCaminhao(motos.get(o-2),
                                                  caminhoes.get(s)) == true){/*Caso a função que checa 
                            as colisões retorne true, remove a moto
                            */
                            motos.remove(o-2);
                        }
                    }
                }
                if (motos.size() == 2){
                    motos.remove(1);
                    motos.remove(0);
                }
            }

            for(int o = 2; o < bicicletas.size(); o++){//for para imprimir as bicicletas
                if( contador % 2 == 0){//Cas o contador seja para, a bicicleta se move
                    mapa.move(bicicletas.get(o), bicicletas.get(o).getVelocidade());
                }
                mapa.atualizaMapaBicicleta(bicicletas.get(o));//atualiza o mapa
                if (mapa.fabricaBic(bicicletas.get(o)) == true){/*função
                    para checar se alguma bicicleta passou por uma fábrica
                    */
                    bicicletas.add(new Bicicleta());/*Caso a função retorne true,
                    adiciona uma nova bicicleta
                    */
                    int line = rand.nextInt(29) + 1;//Escolhe uma linha aleatória
                    int column = rand.nextInt(59) + 1;//Escolhe uma coluna aleatória
                    bicicletas.get(bicicletas.size() - 1).setLinha(line);//seta a linha
                    bicicletas.get(bicicletas.size() - 1).setColuna(column);//seta a coluna
                }
            if (bicicletas.size() > 2){
                for (int f = 0; f < motos.size(); f++){ //For para checar a colisão com as motos
                    if (mapa.bateBicicletaMoto(bicicletas.get(o-2),
                                               motos.get(f)) == true){
                        bicicletas.remove(o-2);//caso haja colisão, remove o objeto
                    }
                }
            }
            if (bicicletas.size() > 2){
                for (int f = 0; f < carros.size(); f++){//for para checar colisão com os carros
                    if (mapa.bateBicicletaCarro(bicicletas.get(o-2),
                                                carros.get(f)) == true){
                        bicicletas.remove(o-2);//caso haja colisão, remove o objeto
                    }
                 }
            }
            if (bicicletas.size() > 2){
                for (int f = 0; f < caminhoes.size(); f++){//for para checar colisão com caminhões
                    if (mapa.bateBicicletaCaminhao(bicicletas.get(o-2),
                                                   caminhoes.get(f)) == true){
                        bicicletas.remove(o-2);//caso haja colisão, remove o objeto
                    }
                }
            }
            if (bicicletas.size() == 2 || bicicletas.size() == 1){
                bicicletas.remove(0);
            }
            contador +=1;//soma mais um ao contador
            }   
        }
    }
}

   


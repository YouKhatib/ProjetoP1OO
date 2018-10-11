package projetop1;

public class Mapa extends Carro{
    private int linhas, colunas, i, j, borda, fabrica, c, cm, m, b;//declarção de variaveis
    private int mapa[][];//declaração da matriz do mapa
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; //cor branca
    public static final String ANSI_BLUE_BACKGROUND = "\033[44m";    //cor azul
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";//cor roxa
    public static final String ANSI_RESET = "\u001B[0m";             //reseta a cor
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";//cor verde
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";//cor amarela
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";//cor vermelha
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";//cor azul clara
    
    public Mapa(){//construtor do mapa
        linhas = 30;
        colunas = 60;
        mapa = new int[linhas][colunas];
        borda = 7; //valor da borda
        fabrica = 8; //valor das fabricas
        c = 1; //valor do carro
        m = 2; //valor da moto
        cm = 3; //valor do caminhão
        b = 4; //valor da bicicleta
    }
    
    public void criaMapa(){ //função que cria o mapa
        for (i = 0; i < linhas; i++){
            for (j = 0; j < colunas; j++){
                if (i == 0 || i == 29){
                    mapa[i][j] = borda; //colocando o valor da borda
                }
                if (j == 0 || j == 59){
                    mapa[i][j] = borda; //colocando o valor da borda
                }
                if (i >= 5 && i <= 7 && j >= 10 && j <= 14){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
                if (i >= 5 && i <= 7 && j >= 40 && j <= 44){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
                if (i >= 15 && i <= 17 && j >= 10 && j <= 14){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
                if (i >= 15 && i <= 17 && j >= 40 && j <= 44){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
                if (i >= 23 && i <= 25 && j >= 10 && j <= 14){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
                if (i >= 23 && i <= 25 && j >= 40 && j <= 44){
                    mapa[i][j] = fabrica; //colocando o valor das fabricas
                }
            }
        }
    }

    public boolean bateMotoCarro(Veiculo moto, Veiculo carro){ //funçao que checa a colisão entre a moto e o carro
        if(moto.getLinha()  == carro.getLinha() && moto.getColuna() == carro.getColuna()){
            return true;/*Caso a linha e a coluna do carro e da moto forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    public boolean bateMotoCaminhao(Veiculo moto, Veiculo caminhao){ //funçao que checa a colisão entre a moto e o caminhão
        if(moto.getLinha()  == caminhao.getLinha() && moto.getColuna() == caminhao.getColuna()){
            return true;/*Caso a linha e a coluna da moto e do caminhão forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    public boolean bateCarroCaminhao(Veiculo carro, Veiculo caminhao){//funçao que checa a colisão entre o carro e o caminhão
        if(carro.getLinha()  == caminhao.getLinha() && carro.getColuna() == caminhao.getColuna()){
            return true;/*Caso a linha e a coluna do carro e do caminhão forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    public boolean bateBicicletaMoto(Veiculo bicicleta, Veiculo moto){//funçao que checa a colisão entre a bicicleta e a moto
        if(bicicleta.getLinha()  == moto.getLinha() && bicicleta.getColuna() == moto.getColuna()){
            return true;/*Caso a linha e a coluna da bicicleta e da moto forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    public boolean bateBicicletaCarro(Veiculo bicicleta, Veiculo carro){//funçao que checa a colisão entre a bicicleta e o carro
        if(bicicleta.getLinha()  == carro.getLinha() && bicicleta.getColuna() == carro.getColuna()){
            return true;/*Caso a linha e a coluna da bicicleta e do carro forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    public boolean bateBicicletaCaminhao(Veiculo bicicleta, Veiculo caminhao){//funçao que checa a colisão entre a bicicleta e o caminhão
        if(bicicleta.getLinha()  == caminhao.getLinha() && bicicleta.getColuna() == caminhao.getColuna()){
            return true;/*Caso a linha e a coluna da bicicleta e do caminhão forem as
            mesmas,ocorre colisão
            */
        }
        else{
            return false;
        }
    }
    


    public void limpaMapa(){ //função que limpa o mapa
        for (int k = 0; k < linhas; k++){
            for (int l = 0; l < colunas; l++){
                mapa[k][l] = 0;
            }
        }
    }
    
    public void imprimeMapa(){ //função que imprime o mapa
        System.out.println();
        for (int q = 0; q < linhas; q++){
            for (int p = 0; p < colunas; p++){
                if(mapa[q][p] == 0){ //caso o valor da posição seja 0, pintará de azul escuro
                    System.out.print(ANSI_BLUE_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == borda){ //caso o valor da posição seja 7, pintará de branco
                    System.out.print(ANSI_WHITE_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == fabrica){ //caso o valor da posição seja 8, pintará de roxo
                    System.out.print(ANSI_PURPLE_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == c){//caso o valor da posição seja 1, pintará de verde
                    System.out.print(ANSI_GREEN_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == m){//caso o valor da posição seja 2, pintará de amarelo
                    System.out.print(ANSI_YELLOW_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == cm){//caso o valor da posição seja 3, pintará de azul claro
                    System.out.print(ANSI_CYAN_BACKGROUND +" "+ ANSI_RESET);
                }
                if(mapa[q][p] == b){//caso o valor da posição seja 4, pintará de vermelho
                    System.out.print(ANSI_RED_BACKGROUND +" "+ ANSI_RESET);
                }
            }
            System.out.print("\n");
        }
    }
    public boolean fabricaMoto(Veiculo mot){ /*função que checa se a moto passou por uma fabrica.
        Compara a posição da moto com a posução das fabricas, se ela se encontrar
        em uma dessas posições, retorna true, o que levará para a criação de outro
           veículo do mesmo tipo*/
        if (mot.getLinha() >= 5 && mot.getLinha() <= 7 && mot.getColuna() >= 10 && mot.getColuna() <= 14){
            return true;
        }
        if (mot.getLinha() >= 5 && mot.getLinha() <= 7 && mot.getColuna() >= 40 && mot.getColuna() <= 44){
            return true;
        }
        if (mot.getLinha() >= 15 && mot.getLinha() <= 17 && mot.getColuna() >= 10 && mot.getColuna() <= 14){
            return true;
        }
        if (mot.getLinha() >= 15 && mot.getLinha() <= 17 && mot.getColuna() >= 40 && mot.getColuna() <= 44){
            return true;
        }
        if (mot.getLinha() >= 23 && mot.getLinha() <= 25 && mot.getColuna() >= 10 && mot.getColuna() <= 14){
            return true;
        }
        if (mot.getLinha() >= 23 && mot.getLinha() <= 25 && mot.getColuna() >= 40 && mot.getColuna() <= 44){
            return true;
        }
        else{
            return false;
        }
    }   
    public boolean fabricaBic(Veiculo bic){/*função que checa se a bicicleta passou por uma fabrica.
        Compara a posição da bicicleta com a posução das fabricas, se ela se encontrar
        em uma dessas posições, retorna true, o que levará para a criação de outro
        veículo do mesmo tipo*/
        if (bic.getLinha() >= 5 && bic.getLinha() <= 7 && bic.getColuna() >= 10 && bic.getColuna() <= 14){
            return true;
        }
        if (bic.getLinha() >= 5 && bic.getLinha() <= 7 && bic.getColuna() >= 40 && bic.getColuna() <= 44){
            return true;
        }
        if (bic.getLinha() >= 15 && bic.getLinha() <= 17 && bic.getColuna() >= 10 && bic.getColuna() <= 14){
            return true;
        }
        if (bic.getLinha() >= 15 && bic.getLinha() <= 17 && bic.getColuna() >= 40 && bic.getColuna() <= 44){
            return true;
        }
        if (bic.getLinha() >= 23 && bic.getLinha() <= 25 && bic.getColuna() >= 10 && bic.getColuna() <= 14){
            return true;
        }
        if (bic.getLinha() >= 23 && bic.getLinha() <= 25 && bic.getColuna() >= 40 && bic.getColuna() <= 44){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean fabricaCarro(Veiculo car){/*função que checa se o carro passou por uma fabrica.
        Compara a posição do carro com a posução das fabricas, se ele se encontrar
        em uma dessas posições, retorna true, o que levará para a criação de outro
        veículo do mesmo tipo*/
        if (car.getLinha() >= 5 && car.getLinha() <= 7 && car.getColuna() >= 10 && car.getColuna() <= 14){
            return true;
        }
        if (car.getLinha() >= 5 && car.getLinha() <= 7 && car.getColuna() >= 40 && car.getColuna() <= 44){
            return true;
        }
        if (car.getLinha() >= 15 && car.getLinha() <= 17 && car.getColuna() >= 10 && car.getColuna() <= 14){
            return true;
        }
        if (car.getLinha() >= 15 && car.getLinha() <= 17 && car.getColuna() >= 40 && car.getColuna() <= 44){
            return true;
        }
        if (car.getLinha() >= 23 && car.getLinha() <= 25 && car.getColuna() >= 10 && car.getColuna() <= 14){
            return true;
        }
        if (car.getLinha() >= 23 && car.getLinha() <= 25 && car.getColuna() >= 40 && car.getColuna() <= 44){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean fabricaCaminhao(Veiculo cam){/*função que checa se o caminhão passou por uma fabrica.
        Compara a posição do caminhão com a posução das fabricas, se ele se encontrar
        em uma dessas posições, retorna true, o que levará para a criação de outro
        veículo do mesmo tipo*/
        if (cam.getLinha() >= 5 && cam.getLinha() <= 7 && cam.getColuna() >= 10 && cam.getColuna() <= 14){
            return true;
        }
        if (cam.getLinha() >= 5 && cam.getLinha() <= 7 && cam.getColuna() >= 40 && cam.getColuna() <= 44){
            return true;
        }
        if (cam.getLinha() >= 15 && cam.getLinha() <= 17 && cam.getColuna() >= 10 && cam.getColuna() <= 14){
            return true;
        }
        if (cam.getLinha() >= 15 && cam.getLinha() <= 17 && cam.getColuna() >= 40 && cam.getColuna() <= 44){
            return true;
        }
        if (cam.getLinha() >= 23 && cam.getLinha() <= 25 && cam.getColuna() >= 10 && cam.getColuna() <= 14){
            return true;
        }
        if (cam.getLinha() >= 23 && cam.getLinha() <= 25 && cam.getColuna() >= 40 && cam.getColuna() <= 44){
            return true;
        }
        else{
            return false;
        }
    }

    public void atualizaMapaCarro(Veiculo veic){//função que atualiza os carros
        criaMapa();
        mapa[veic.getLinha()][veic.getColuna()] = 1;/*receba a posição e substitui
        o valor do local por 1
        */
    }
    public void atualizaMapaMoto(Veiculo veic){//função que atualiza as motos
        criaMapa();
        mapa[veic.getLinha()][veic.getColuna()] = 2;/*receba a posição e substitui
        o valor do local por 2
        */
    }
    public void atualizaMapaCaminhao(Veiculo veic){//função que atualiza os caminhões
        criaMapa();
        mapa[veic.getLinha()][veic.getColuna()] = 3;/*receba a posição e substitui
        o valor do local por 3
        */
    }
    public void atualizaMapaBicicleta(Veiculo veic){//função que atualiza as bicicletas
        criaMapa();
        mapa[veic.getLinha()][veic.getColuna()] = 4;/*receba a posição e substitui
        o valor do local por 4
        */
    }
}

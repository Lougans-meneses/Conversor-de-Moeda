package teste;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner leitura = new Scanner(System.in);
    API api;

    public void initializeApi() throws IOException, InterruptedException {
        api = new API();
    }

    public void lineDecoration() {
        System.out.println("====================================");
    }

    public void showWelcomeMessage() {
        this.lineDecoration();
        System.out.println("Conversor de Moedas v1");
        this.lineDecoration();
    }

    public void showOptions() {
        System.out.println(
                """
                1- Dólar Estado Unidense (USD)
                2- Real (BRL)
                3- Euro (EUR)
                4- Libra Esterlina (GBP)
                5 - Iene (JPY)
                6 - Franco Suíço (CHF)
                7 - Dolar Canadense (CAD)
                8 - Renminbi/Yuan (RMB)
                9 - Peso Argentino (ARS)"""
        );
    }

    public void nextConvert() {
        System.out.println(
                """
                1 - Continuar
                0 - Sair"""
        );
    }

    public double getValue() {
        System.out.println("Qual valor deseja converter?");
        return leitura.nextDouble();
    }

    public int getCurrencyTypeIn() {
        leitura.nextLine();
        System.out.println("De qual moeda será feita a conversão?");
        this.showOptions();
        return leitura.nextInt();
    }

    public int getCurrencyTypeOut() {
        this.showOptions();
        System.out.println("Para qual moeda será feita a conversão?");
        this.showOptions();
        return leitura.nextInt();
    }

    public void loopConverter() {
        int escolha = 1;
        while (escolha != 0) {
            double value = this.getValue();
            int currencyFrom = this.getCurrencyTypeIn();
            int currencyTo = this.getCurrencyTypeOut();
            try {
                api.getMoeda().convertCurrency(value, currencyFrom, currencyTo);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("A opção escolhida não é válida");
                System.out.println(e);
            } finally {
                this.lineDecoration();
                this.nextConvert();
                escolha = leitura.nextInt();
            }
        }
    }

    public void init() {
        this.showWelcomeMessage();
        this.loopConverter();
        System.out.println("Finalizando o programa :)");
        lineDecoration();
    }
}
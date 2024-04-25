package teste;

public class ConversorMoedas {

    private double usd = 1;
    double[] currencies;

    public ConversorMoedas(Moedas moedas) {
        double brl = moedas.BRL();
        double eur = moedas.EUR();
        double gbp = moedas.GBP();
        double jpy = moedas.JPY();
        double chf = moedas.CHF();
        double cad = moedas.CAD();
        double cny = moedas.CNY();
        double ars = moedas.ARS();
        currencies = new double[]{usd, brl, eur, gbp, jpy, chf, cad, cny, ars};
    }

    public void convertCurrency(double value, int initialCurrency, int finalCurrency) {
        initialCurrency--;
        finalCurrency--;
        double result;
        double cambioTax = (currencies[finalCurrency]/usd) / (currencies[initialCurrency]/usd);
        result = cambioTax * value;
        System.out.println("O resultado da conversão é $ %.2f".formatted((result)));
    }

}
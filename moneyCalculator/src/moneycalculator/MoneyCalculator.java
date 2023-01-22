package moneycalculator;

import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.persistence.files.CurrencyLoaderFromFile;
import moneycalculator.persistence.rest.ExchangeRateLoaderFromWebService;
import moneycalculator.view.swing.MoneyCalculatorSwing;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile("currencies");
        List<Currency> currencies = currencyLoaderFromFile.currencyLoader();
        
        ExchangeRateLoaderFromWebService exchangerateLoaderFromWebService = new ExchangeRateLoaderFromWebService();
        
        MoneyCalculatorSwing moneyCalculatorSwing = new MoneyCalculatorSwing(currencies, exchangerateLoaderFromWebService);
    }
}

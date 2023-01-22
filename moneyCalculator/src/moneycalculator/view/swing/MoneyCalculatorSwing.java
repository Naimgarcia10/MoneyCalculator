package moneycalculator.view.swing;

import java.util.List;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistence.rest.ExchangeRateLoaderFromWebService;

public class MoneyCalculatorSwing {
    private final List<Currency> currencies;
    private final ExchangeRateLoaderFromWebService exchangerateLoaderFromWebService;
    private DialogSwing moneyCalculatorDialogSwing;

    public MoneyCalculatorSwing(List<Currency> currencies, ExchangeRateLoaderFromWebService exchangerateLoaderFromWebService) {
        this.currencies = currencies;
        this.exchangerateLoaderFromWebService = exchangerateLoaderFromWebService;

        Money money = new Money(0.0, this.currencies.get(0));
        this.moneyCalculatorDialogSwing = new DialogSwing(this.currencies, 
                                                                         this.exchangerateLoaderFromWebService, money);
        new MoneyCalculatorGUISwing(this.moneyCalculatorDialogSwing, "Money Calculator");
        
    }
    
    
    
}

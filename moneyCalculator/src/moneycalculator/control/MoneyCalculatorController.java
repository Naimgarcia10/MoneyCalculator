package moneycalculator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.view.swing.DialogSwing;

public class MoneyCalculatorController implements ActionListener {
    private final DialogSwing moneyCalculatorDialogSwing;

    public MoneyCalculatorController(DialogSwing moneyCalculatorDialogSwing) {
        this.moneyCalculatorDialogSwing = moneyCalculatorDialogSwing;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Money money = this.moneyCalculatorDialogSwing.getMoney();
       Currency currencyFrom = money.getCurrency();
       Currency currencyTo = this.moneyCalculatorDialogSwing.getCurrencyTo();
       ExchangeRate exchangeRate = this.moneyCalculatorDialogSwing.getExchangeRateLoaderFromWebService().exchangerateLoader(currencyFrom, currencyTo);
       
       //this.moneyCalculatorDialogSwing.getMoneyCalculatorDisplaySwing().refreshMoney(new Money(exchangeRate.getRate() * money.getAmount(), currencyTo));
       this.moneyCalculatorDialogSwing.refreshMoney(new Money(exchangeRate.getRate() * money.getAmount(), currencyTo));
    }
}

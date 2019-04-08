package guru.springframework;

import com.sun.jdi.event.MonitorContendedEnteredEvent;

/**
 * 08-04-19
 *
 * @author Tom
 */
public class Bank {
    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);

        //        Sum sum = (Sum) source;
//        int amount = sum.augend.amount + sum.addend.amount;
//        return new Money(amount, toCurrency);

//        if (source instanceof Money) return (Money) source;
//        Sum sum = (Sum) source;
//        return sum.reduce(toCurrency);
    }
}

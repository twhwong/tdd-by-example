package guru.springframework;

/**
 * 08-04-19
 *
 * @author Tom
 */
public class Sum implements Expression{
    Money augend;
    Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
    // reduce means combine two Money objects to one Money object
    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}

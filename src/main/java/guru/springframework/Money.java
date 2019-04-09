package guru.springframework;

/**
 * 08-04-19
 *
 * @author Tom
 */
public class Money implements Expression {

    final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency(){
        return currency;
    }

    public boolean equals(Object obj) {
        Money money = (Money) obj;
        // check the amount and not the object itself.
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    /* Terms
    Augend - first value in an addition operation
    Addend - second value in an addition operation
     */
    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}

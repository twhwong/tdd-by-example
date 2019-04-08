package guru.springframework;

/**
 * 08-04-19
 *
 * @author Tom
 */
public class Money implements Expression {

    protected int amount;
    protected String currency;

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
    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public boolean equals(Object obj) {
        Money money = (Money) obj;
        // check the amount and not the object itself.
//        return amount == money.amount && getClass().equals(obj.getClass());
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public Money reduce(String to) {
        return this;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    /* Terms
    Augend - first value in an addition operation
    Addend - second value in an addition operation
     */
    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }
}

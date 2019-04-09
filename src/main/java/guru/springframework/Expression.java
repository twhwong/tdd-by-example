package guru.springframework;

/**
 * 08-04-19
 *
 * @author Tom
 */
public interface Expression {

    Money reduce(Bank bank, String to);
    Expression plus(Expression addend);
    Expression times(int multiplier);

}

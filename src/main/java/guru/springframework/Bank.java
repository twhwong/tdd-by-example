package guru.springframework;

import java.util.HashMap;

/**
 * 08-04-19
 *
 * @author Tom
 */
class Bank {

    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
        //System.out.println(rateMap.values());
    }

    public int rate(String from, String to) {
//        return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
        if (from.equals(to)) {
            return 1;
        } else {
//            System.out.println(rateMap.get(new Pair(from, to)));
            return rateMap.get(new Pair(from, to));
        }
    }
}

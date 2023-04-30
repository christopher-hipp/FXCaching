import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] currencies = {"USD", "GBP", "EUR", "CAD",};
        double cache = 0;

        Random rand = new Random();
        String incoming = currencies[rand.nextInt(currencies.length)];
        String outgoing = currencies[rand.nextInt(currencies.length)];
        cache = getRate();

        int minutes = 0;
        while (true) {
            if (minutes > 60) {
                System.out.println("An hour has passed");
                break;
            }

            if (minutes > 0) {
                if (minutes % 10 == 0) {
                    System.out.println();
                    System.out.println("–––– Ten minutes has passed ––––");
                    System.out.println("Querying the exchange rate again");
                    System.out.println();

                    cache = getRate();
                }
            }

            System.out.println("Payment from " + incoming + " to " + outgoing);
            System.out.println("The exchange rate is " + cache);
            System.out.println();

            Thread.sleep(1000);
            minutes++;
        }
    }

    // Method with arbitrary values used as the exchange rate
    public static double getRate() {
        double[] rates = {0.79, 0.88, 0.93, 0.97, 1.01, 1.10, 1.23, 1.35, 1.42, 1.51,};
        Random rand = new Random();
        int index = rand.nextInt(rates.length);
        double rate = rates[index];
        return rate;
    }
}

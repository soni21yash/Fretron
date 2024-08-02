// Apple distributor Question
import java.util.*;

public class Fretron {

    public static void main(String args[]) {
        ArrayList<Integer> weights = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter apple weight in grams (-1 to stop): ");
            int weight = sc.nextInt();
            if (weight == -1) break;
            weights.add(weight);
        }
        
        Collections.sort(weights, Collections.reverseOrder());

        int totalWeight = weights.stream().mapToInt(Integer::intValue).sum();
        double targetRam = 0.5 * totalWeight;
        double targetSham = 0.3 * totalWeight;
        double targetRahim = 0.2 * totalWeight;

        ArrayList<Integer> ramApples = new ArrayList<>();
        ArrayList<Integer> shamApples = new ArrayList<>();
        ArrayList<Integer> rahimApples = new ArrayList<>();
        
        distribute(weights, ramApples, targetRam);
        distribute(weights, shamApples, targetSham);
        distribute(weights, rahimApples, targetRahim);

        System.out.println("\nDistribution Result:");
        System.out.println("Ram: " + ramApples);
        System.out.println("Sham: " + shamApples);
        System.out.println("Rahim: " + rahimApples);
    }

    private static void distribute(ArrayList<Integer> weights, ArrayList<Integer> personApples, double targetWeight) {
        int i = 0;
        while (i < weights.size()) {
            int weight = weights.get(i);
            if (sum(personApples) + weight <= targetWeight) {
                personApples.add(weight);
                weights.remove(i);
            } else {
                i++;
            }
        }
    }

    private static int sum(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

}

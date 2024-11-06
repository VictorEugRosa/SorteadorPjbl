import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sorteador {
    private ArrayList<String> items;
    private Random random;

    public Sorteador() {
        items = new ArrayList<>();
        random = new Random();
    }

    public void adicionarItem(String item) {
        if (item != null && !item.isEmpty()) {
            items.add(item);
        }
    }

    public String sortearItem() {
        if (!items.isEmpty()) {
            int index = random.nextInt(items.size());
            return items.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public Set<Integer> sortearIntervalo(int min, int max, int quantidade) {
        Set<Integer> resultados = new HashSet<>();
        if (min > max || quantidade <= 0 || quantidade > (max - min + 1)) {
            return null;
        }

        while (resultados.size() < quantidade) {
            int numero = random.nextInt(max - min + 1) + min;
            resultados.add(numero);
        }
        
        return resultados;
    }
}

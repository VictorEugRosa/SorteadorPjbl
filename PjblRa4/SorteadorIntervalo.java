import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SorteadorIntervalo {
    private Random random;

    public SorteadorIntervalo() {
        random = new Random();
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SorteadorPalavras {
    private ArrayList<String> palavras;
    private Random random;

    public SorteadorPalavras() {
        palavras = new ArrayList<>();
        random = new Random();
    }

    public void adicionarPalavra(String palavra) {
        if (palavra != null && !palavra.isEmpty()) {
            palavras.add(palavra);
        }
    }

    public List<String> sortearPalavras(int quantidade) {
        if (quantidade <= 0 || quantidade > palavras.size()) {
            return Collections.emptyList(); 
        }

        List<String> copiaPalavras = new ArrayList<>(palavras);
        Collections.shuffle(copiaPalavras, random);
        return copiaPalavras.subList(0, quantidade);
    }

    public ArrayList<String> getPalavras() {
        return palavras;
    }
}

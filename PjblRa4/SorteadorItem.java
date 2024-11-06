import java.util.ArrayList;
import java.util.List;

public class SorteadorItem {
    private List<String> itens;

    public SorteadorItem() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public String sortearItem() {
        if (itens.isEmpty()) {
            return "Nenhum item adicionado!";
        }
        int indice = (int) (Math.random() * itens.size());
        return "Item Sorteado: " + itens.get(indice);
    }
}

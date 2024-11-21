import unittest
#from SorteadorItem import SorteadorItem

class TestSorteadorItem(unittest.TestCase):
    def setUp(self):
        self.sorteador = SorteadorItem()

    def test_adicionar_item(self):
        self.sorteador.adicionar_item("Item 1")
        self.assertIn("Item 1", self.sorteador.itens, "O item deveria estar na lista após ser adicionado.")

    def test_sortear_item_com_itens(self):
        self.sorteador.adicionar_item("Item 1")
        self.sorteador.adicionar_item("Item 2")
        sorteado = self.sorteador.sortear_item()
        self.assertIn(sorteado.replace("Item Sorteado: ", ""), self.sorteador.itens,
                      "O item sorteado deve ser um dos itens adicionados.")

    def test_sortear_item_sem_itens(self):
        resultado = self.sorteador.sortear_item()
        self.assertEqual(resultado, "Nenhum item disponível para sorteio.",
                         "A mensagem deve indicar que não há itens disponíveis para sorteio.")

if __name__ == "__main__":
    unittest.main()

import unittest
import random
from SorteadorPalavras import SorteadorPalavras

class TestSorteadorPalavras(unittest.TestCase):

    def setUp(self):
        self.sorteador = SorteadorPalavras()
        self.sorteador.adicionar_palavra("maçã")
        self.sorteador.adicionar_palavra("banana")
        self.sorteador.adicionar_palavra("laranja")

    def test_adicionar_palavra(self):
        self.sorteador.adicionar_palavra("morango")
        self.assertIn("morango", self.sorteador.get_palavras(), "A palavra deveria estar na lista após ser adicionada.")

    def test_sortear_palavras_valido(self):
        resultado = self.sorteador.sortear_palavras(2)
        self.assertEqual(len(resultado), 2, "Deve retornar exatamente 2 palavras")
        self.assertTrue(all(palavra in self.sorteador.get_palavras() for palavra in resultado), "As palavras sorteadas devem ser da lista original.")


    def test_sortear_palavras_invalido(self):
        resultado = self.sorteador.sortear_palavras(0)
        self.assertEqual(resultado, [], "O sorteio deve retornar uma lista vazia se a quantidade for 0.")

    def test_sortear_palavras_maior_que_lista(self):
        resultado = self.sorteador.sortear_palavras(4)
        self.assertEqual(len(resultado), 3, "Deve retornar no máximo 3 palavras, pois é o total disponível.")

if __name__ == "__main__":
    unittest.main()

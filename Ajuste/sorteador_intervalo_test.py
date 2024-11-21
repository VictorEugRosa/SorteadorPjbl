import unittest
import random
from SorteadorIntervalo import SorteadorIntervalo

class TestSorteadorIntervalo(unittest.TestCase):

    def setUp(self):
        self.sorteador = SorteadorIntervalo()

    def test_sorteio_intervalo_valido(self):
        resultado = self.sorteador.sortear_intervalo(1, 10, 5)
        self.assertIsNotNone(resultado, "O sorteio não deve ser nulo")
        self.assertEqual(len(resultado), 5, "Deve retornar exatamente 5 números")
        self.assertTrue(all(1 <= num <= 10 for num in resultado), "Os números sorteados devem estar entre 1 e 10")

    def test_sorteio_intervalo_invertido(self):
        resultado = self.sorteador.sortear_intervalo(10, 1, 5)
        self.assertIsNone(resultado, "O sorteio deve retornar None quando o intervalo é invertido")

    def test_sorteio_quantidade_maior_que_intervalo(self):
        resultado = self.sorteador.sortear_intervalo(1, 5, 6)
        self.assertIsNone(resultado, "O sorteio deve retornar None quando a quantidade é maior que o intervalo")

    def test_sorteio_intervalo_tamanho_1(self):
        resultado = self.sorteador.sortear_intervalo(5, 5, 1)
        self.assertIsNotNone(resultado, "O sorteio não deve ser nulo")
        self.assertEqual(len(resultado), 1, "Deve retornar exatamente 1 número")
        self.assertIn(5, resultado, "O número sorteado deve ser 5")

    def test_sorteio_intervalo_grande(self):
        resultado = self.sorteador.sortear_intervalo(1, 1000000, 100)
        self.assertIsNotNone(resultado, "O sorteio não deve ser nulo")
        self.assertEqual(len(resultado), 100, "Deve retornar exatamente 100 números")
        self.assertTrue(all(1 <= num <= 1000000 for num in resultado), "Algum número sorteado está fora do intervalo [1, 1000000]")

if __name__ == "__main__":
    unittest.main()

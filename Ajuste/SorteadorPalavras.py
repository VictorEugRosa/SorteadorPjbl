import random

class SorteadorPalavras:
    def __init__(self):
        self.palavras = []

    def adicionar_palavra(self, palavra):
        if palavra:
            self.palavras.append(palavra)

    def sortear_palavras(self, quantidade):
        if quantidade <= 0:
            return []

        quantidade = min(quantidade, len(self.palavras))

        copia_palavras = self.palavras[:]
        random.shuffle(copia_palavras)
        return copia_palavras[:quantidade]

    def get_palavras(self):
        return self.palavras

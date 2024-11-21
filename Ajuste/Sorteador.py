import random  # Adicionado o import do módulo random

class Sorteador:
    def __init__(self):
        self.itens = []

    def adicionar_item(self, item):
        self.itens.append(item)

    def sortear_item(self):
        if not self.itens:
            return "Nenhum item adicionado!"
        indice = random.randint(0, len(self.itens) - 1)
        return f"Item Sorteado: {self.itens[indice]}"

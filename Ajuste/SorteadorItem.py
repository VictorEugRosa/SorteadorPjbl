import random

class SorteadorItem:
    def __init__(self):
        self.itens = []

    def adicionar_item(self, item):
        self.itens.append(item)

    def sortear_item(self):
        if not self.itens:
            return "Nenhum item disponível para sorteio."
        item_sorteado = random.choice(self.itens)
        return f"Item Sorteado: {item_sorteado}"

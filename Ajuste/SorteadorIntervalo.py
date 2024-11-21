import random  

class SorteadorIntervalo:
    def __init__(self):
        pass

    def sortear_intervalo(self, min_val, max_val, quantidade):
        if min_val > max_val or quantidade <= 0 or quantidade > (max_val - min_val + 1):
            return None

        resultados = set()
        while len(resultados) < quantidade:
            numero = random.randint(min_val, max_val)
            resultados.add(numero)

        return resultados
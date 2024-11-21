from Sorteador import Sorteador
from SorteadorItem import SorteadorItem
from SorteadorIntervalo import SorteadorIntervalo
from SorteadorPalavras import SorteadorPalavras

def main():
    sorteador_item = SorteadorItem()
    sorteador_intervalo = SorteadorIntervalo()
    sorteador_palavras = SorteadorPalavras()

    while True:
        print("\nEscolha o Modo de Sorteio:")
        print("1. Adicionar Item")
        print("2. Sortear Item")
        print("3. Sorteio por Intervalo")
        print("4. Adicionar Palavra")
        print("5. Sortear Palavra")
        print("6. Sair")
        opcao = input("Digite o número da opção desejada: ")

        if opcao == "1":
            item = input("Digite o item para adicionar: ")
            sorteador_item.adicionar_item(item)
            print("Item adicionado:", item)

        elif opcao == "2":
            resultado = sorteador_item.sortear_item()
            print("Item sorteado:", resultado)

        elif opcao == "3":
            min_val = int(input("Digite o valor mínimo: "))
            max_val = int(input("Digite o valor máximo: "))
            quantidade = int(input("Digite a quantidade de números a sortear: "))
            resultado = sorteador_intervalo.sortear_intervalo(min_val, max_val, quantidade)
            print("Números sorteados:", resultado)

        elif opcao == "4":
            palavra = input("Digite a palavra para adicionar: ")
            sorteador_palavras.adicionar_palavra(palavra)
            print("Palavra adicionada:", palavra)

        elif opcao == "5":
            quantidade = int(input("Quantas palavras deseja sortear? "))
            resultado = sorteador_palavras.sortear_palavras(quantidade)
            print("Palavras sorteadas:", resultado)

        elif opcao == "6":
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    main()

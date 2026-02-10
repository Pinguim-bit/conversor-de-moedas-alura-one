package br.com.desafioalura.conversor;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mensagemDeErro = "";
        boolean closeApp = false;

        //Menu Principal
        do {
            System.out.println("br.com.desafioalura.conversor.Conversor de Moedas\n");
            System.out.println("Mais usadas:");
            System.out.println("1) Dólar americano para Real brasileiro");
            System.out.println("2) Real brasileiro para Dólar americano");
            System.out.println("3) Peso argentino para Real brasileiro");
            System.out.println("4) Real brasileiro para Peso argentino");
            System.out.println("5) Mais opções");
            System.out.println("6) Sair");
            if(!mensagemDeErro.isEmpty()) System.out.println(mensagemDeErro);
            System.out.print("\nDigite uma opção: ");

            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    mensagemDeErro = "";
                    submenu("Quantidade de Dólares: ","USD","BRL","US$", "R$");
                    break;

                case "2":
                    mensagemDeErro = "";
                    submenu("Quantidade de Reais: ", "BRL", "USD",  "R$", "US$");
                    break;

                case "3":
                    mensagemDeErro = "";
                    submenu("Quantidade de Peso argentino: ", "ARS", "BRL", "ARS$", "R$");
                    break;

                case "4":
                    mensagemDeErro = "";
                    submenu("Quantidade de Reais: ", "BRL", "ARS", "R$", "ARS$");
                    break;

                case "5":
                    mensagemDeErro = "";
                    closeApp = maisOpcoes();
                    break;

                case "6":
                    System.out.println("Até breve!");
                    break;

                default:
                    mensagemDeErro = "OPÇÃO INVÁLIDA! TENTE NOVAMENTE!";
                    break;

            }

            if(opcao.equals("6")) break;
            if(closeApp) break;

        }while(true);
    }

    public static void submenu(String texto, String moedaDe, String moedaPara, String moedaDeNome, String moedaParaNome){
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(texto);
                int quantidade = scanner.nextInt();
                String resultado = moedaDeNome
                        + quantidade
                        + " equivalem a "
                        + moedaParaNome
                        + Conversor.moedas(moedaDe, moedaPara, quantidade);


                System.out.println("\n" + resultado);
                System.out.println("\nPressione ENTER para continuar");
                scanner.nextLine();
                scanner.nextLine();
                break;
            }catch (Exception e){
                System.out.println("Valor inválido! Tente novamente.");
                //limpar o buffer
                scanner.nextLine();
            }
        }while(true);
    }

    public static boolean maisOpcoes(){
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Mais Opções: ");
            System.out.println("""
                    Lista de Códigos Disponíveis ( talvez tenha mais =) ):
                    (código de moeda ISO 4217 de três letras)
                    
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileiro
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar americano
                    
                    Digite "voltar" para retornar ao menu anterior
                    Digite "sair" para encerrar o programa
                    """);
            System.out.println("Digite o código da moeda para converter, a moeda alvo e a quantidade!");

            try {
                System.out.print("Código da moeda que deseja converter: ");
                String moedaDe = scanner.nextLine();
                if(moedaDe.trim().equalsIgnoreCase("voltar")) break;
                if(moedaDe.trim().equalsIgnoreCase("sair")) return true;

                System.out.print("Código da moeda para qual ela será convertida: ");
                String moedaPara = scanner.nextLine();
                if(moedaDe.trim().equalsIgnoreCase("voltar")) break;
                if(moedaDe.trim().equalsIgnoreCase("sair")) return true;

                System.out.print("Digite a quantidade: ");
                String quantidade = scanner.nextLine();
                if(moedaDe.trim().equalsIgnoreCase("voltar")) break;
                if(moedaDe.trim().equalsIgnoreCase("sair")) return true;

                BigDecimal resultado = Conversor.moedas(moedaDe.toUpperCase(), moedaPara.toUpperCase(), Integer.parseInt(quantidade));
                System.out.println("\n" + moedaDe.toUpperCase() + " " + quantidade + " equivalem a " + moedaPara.toUpperCase() + " " + resultado);

                System.out.println("Pressione ENTER para continuar");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Tente Novamente!\nPressione ENTER para continuar.");
                scanner.nextLine();
            }
        } while (true);

        return false;
    }
}

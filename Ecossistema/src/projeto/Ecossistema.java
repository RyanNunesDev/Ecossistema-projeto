package projeto;

import java.util.Scanner;

public class Ecossistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║ Bem-vindo ao Simulador de Ecossistema!       ║");
        System.out.println("║ Este simulador permitirá que você observe um ║");
        System.out.println("║ ecossistema simulado em ação, com leões e    ║");
        System.out.println("║ zebras interagindo em uma floresta virtual.  ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print("║ Digite o número de     ║\n");
        System.out.print("║ plantas na floresta:");
        int numeroPlantas = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print("║ Digite o número de     ║\n");
        System.out.print("║ leões na floresta: ");
        int numeroLeoes = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        System.out.println("╔════════════════════════╗");
        System.out.print("║ Digite o número de     ║\n");
        System.out.print("║ zebras na floresta: ");
        int numeroZebras = scanner.nextInt();
        System.out.println("╚════════════════════════╝");

        Floresta floresta = new Floresta();

        String[] nomesReaisPlantas = {"Grama", "Arbusto", "Folha", "Flor", "Samambaia", "Cacto", "Erva", "Rosa", "Bromélia", "Orquídea", "gramíneas", "herbáceas", "galhos"};

        for (int i = 0; i < numeroPlantas; i++) {
            int nutricao = 10;
            int randomIndex = (int) (Math.random() * nomesReaisPlantas.length);
            String nomePlanta = nomesReaisPlantas[randomIndex];
            floresta.adicionarPlanta(new Planta(nomePlanta, nutricao));
        }

        for (int i = 0; i < numeroLeoes; i++) {
            Animal leao = new Animal("Leão", 5, 100);
            floresta.adicionarAnimal(leao);
        }

        for (int i = 0; i < numeroZebras; i++) {
            Animal zebra = new Animal("Zebra", 3, 50);
            floresta.adicionarAnimal(zebra);
        }

        System.out.println("Simulação de Ecossistema iniciada...\n");

        int iteracao = 0;

        while (true) {
            iteracao++;
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║           ITERAÇÃO " + iteracao + "		       ║");
            System.out.println("╚══════════════════════════════════════╝");

            floresta.simularInteracoes();

            System.out.println("\n");
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║   ESTADO DOS ANIMAIS NA FLORESTA:    ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("\n");
            floresta.listarAnimais();
            System.out.println("\n");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            	
            }

            boolean todasZebrasMortas = true;
            for (Animal animal : floresta.getAnimais()) {
                if (animal.getSpecies().equals("Zebra") && animal.estaVivo()) {
                    todasZebrasMortas = false;
                    break;
                }
            }

            if (todasZebrasMortas) {
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║       TODAS AS ZEBRAS MORRERAM.      ║");
                System.out.println("║       SIMULAÇÃO ENCERRADA :)         ║");
                System.out.println("╚══════════════════════════════════════╝");
                break;
            }
        }

        scanner.close();
    }
}
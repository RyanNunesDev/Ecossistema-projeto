package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planta {
    private String nome;
    private int nutricao;

        public Planta(String nome, int nutricao) {
            this.nome = nome;
            this.nutricao = nutricao;
        }

        public String getName() {
            return this.nome;
        }

        public int getNutricao() {
            return nutricao;
        }

        public static List<Planta> criarPlantas(int numeroPlantas) {
            List<Planta> plantas = new ArrayList<>();
            String[] nomesReaisPlantas = {"Grama", "Arbusto", "Folha", "Flor", "Samambaia", "Cacto", "Erva", "Rosa", "Bromélia", "Orquídea", "gramíneas", "herbáceas", "galhos"};
            Random random = new Random();

            for (int i = 0; i < numeroPlantas; i++) {
                int nutricao = random.nextInt(31) + 10;
                int randomIndex = random.nextInt(nomesReaisPlantas.length);
                String nomePlanta = nomesReaisPlantas[randomIndex];
                plantas.add(new Planta(nomePlanta, nutricao));
            }

            return plantas;
        }
}
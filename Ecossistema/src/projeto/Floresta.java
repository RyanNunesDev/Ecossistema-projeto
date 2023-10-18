package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floresta {
    private List<Animal> animais;
    private List<Planta> plantas;
    
    private List<Animal> zebras;

    public Floresta() {
        this.animais = new ArrayList<>();
        this.plantas = new ArrayList<>();
        this.zebras = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
        if (animal.getSpecies().equals("Zebra")) {
            this.zebras.add(animal);
        }
 }
    
    public void removerAnimalMorto(Animal animal) {
        animais.remove(animal);
        if (animal.getSpecies().equals("Zebra")) {
            zebras.remove(animal);
        }
    }

    public void iniciarSimulacao(int numeroPlantas) {
        List<Planta> plantas = Planta.criarPlantas(numeroPlantas);

        for (Planta planta : plantas) {
            adicionarPlanta(planta);
        }
    }
    
    public void adicionarPlanta(Planta planta) {
        this.plantas.add(planta);
    }

    public List<Animal> getAnimais() {
        return this.animais;
    }

    public List<Planta> getPlantas() {
        return this.plantas;
    }
    
    public List<Animal> getZebras() {
        return this.zebras;
    }

    public void simularInteracoes() {
        Random random = new Random();

        List<Animal> animaisRemover = new ArrayList<>();

        for (Animal animal : animais) {
            if (animal.getSpecies().equals("Leão")) {
                int randomIndex = random.nextInt(animais.size());
                Animal outraPresa = animais.get(randomIndex);
                if (outraPresa.getSpecies().equals("Zebra")) {
                    animal.atacar(outraPresa);
                }
            } else if (animal.getSpecies().equals("Zebra")) {
                int shouldEat = random.nextInt(2);
                if (shouldEat == 1) {
                    animal.comerPlantaAleatoria(plantas);
                } else {
                    String identificador = animal.getSpecies() + animal.getCount();
                    System.out.println("" + identificador + " não encontrou nenhuma planta para comer.");
                }
                if (animal.getVida() <= 0) {
                    animaisRemover.add(animal);
                }
            }
        }

        for (Animal animal : animaisRemover) {
            removerAnimalMorto(animal);
        }
    }
    
    public void listarAnimais() {
        System.out.println("╔══════════════════════════════════════════════╗");
        for (Animal animal : animais) {
        	String identificador = animal.getSpecies() + animal.getCount();
            System.out.println("║ Animal = " + identificador + ", Vida = " + animal.getVida() + addSpaces(animal.getSpecies(), animal.getVida()) + "║");
        }
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    public String addSpaces(String species, int vida) {
        int totalSpaces = 43 - 16 - species.length() - String.valueOf(vida).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSpaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
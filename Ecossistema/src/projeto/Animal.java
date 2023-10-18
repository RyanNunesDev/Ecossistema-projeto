package projeto;

import java.util.Random;
import java.util.List;

public class Animal {
    private String species;
    public int age;
    private int vida;
    private int count;
    private String type;
    
    private static int zebraCount = 0;
    private static int leaoCount = 0;
    
    private static final Random random = new Random();

    public Animal(String species, int age, int vida) {
        this.species = species;
        this.age = age;
        this.vida = vida;
        if (species.equals("Zebra")) {
            zebraCount++;
            count = zebraCount;
        } else if (species.equals("Leão")) {
            leaoCount++;
            count = leaoCount;
        }
        this.type = species + count;
    }
    
    public void comerPlantaAleatoria(List<Planta> plantas) {
        if (this.species.equals("Zebra")) {
            if (this.vida < 50) {
            	if (!plantas.isEmpty()) {
                    Random random = new Random();
                    int indexPlanta = random.nextInt(plantas.size());
                    Planta planta = plantas.get(indexPlanta);
                    System.out.println(this.type + " está comendo a planta " + planta.getName() + " e recuperou " + planta.getNutricao() + " de vida.");
                    this.vida = Math.min(100, this.vida + planta.getNutricao());
                    plantas.remove(indexPlanta);
                } else {
                    System.out.println("Não há plantas para a " + this.type + " comer.");
                }
            } else {
                System.out.println(this.type + " não está com fome. Sua vida está cheia.");
            }
            }
        }

    public void atacar(Animal outroAnimal) {
        if (this.species.equals("Leão") && outroAnimal.species.equals("Zebra")) {
            System.out.println(this.type + " atacou " + outroAnimal.type);
            int randomDano = random.nextInt(11) + 5;
            outroAnimal.receberDano(randomDano);
        }
    }
    
    public void ataque() {
        if (this.species.equals("Leão")) {
            System.out.println(this.type + " está atacando!");
        }
    }

    public String getSpecies() {
        return species;
    }

    public int getVida() {
        return vida;
    }
    

    public void serComido(Animal animal) {
        if (this.species.equals("Zebra")) {
            System.out.println(this.type + " está sendo atacada por " + animal.type);
            this.vida -= 10;
            if (this.vida <= 0) {
                System.out.println(this.type + " morreu!");
            }
        } else {
            System.out.println(this.type + " está comendo " + animal.type);
        }
    }

    public void comerPlanta(Planta planta) {
        System.out.println(this.type + " está comendo a planta " + planta.getName());
        int randomRecuperacao = random.nextInt(16) + 5;
        this.vida = Math.min(100, this.vida + randomRecuperacao);
    }
    

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.type + " morreu!");
        } else {
            if (this.species.equals("Zebra")) {
                System.out.println(this.type + " recebeu " + dano + " de dano.");
            }
        }
    }
    public boolean estaVivo() {
        return this.vida > 0;
    }
    
    public int getCount() {
        return count;
    }
}
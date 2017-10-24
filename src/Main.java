import java.util.ArrayList;

public class Main {

    private static GeneticAlgorithm alg;
    private static Chromosome chromosome;

    public static void inputFile()
    {

    }

    public static void output()
    {

    }

    public static void main(String[] args) {
        chromosome = new FloatingChromosome();
        alg = new GeneticAlgorithm();
        alg.setPopulation(new ArrayList<Chromosome>());
        alg.setSelected(new ArrayList<Chromosome>());
        alg.setOffsprings(new ArrayList<Chromosome>());
        alg.setReplacer(new GenerationalReplacement());

        inputFile();
        alg.init(chromosome);
        alg.run();
        output();
    }
}

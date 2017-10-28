import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static GeneticAlgorithm alg;
    private static Chromosome chromosome;

    public static void inputFile(Scanner input)
    {
        int numberPoints,degree;
        numberPoints = input.nextInt();
        degree = input.nextInt();
        chromosome.setLength(degree+1);
        ((FloatingChromosome)chromosome).points.clear();
        for(int i = 0 ; i< numberPoints; i++)
        {
            ((FloatingChromosome)chromosome).points.add(new Point(input.nextDouble(), input.nextDouble()));
        }
    }

    public static void output()
    {
        double maxValue = 0;
        Chromosome best = null;
        for(Chromosome c: alg.getPopulation() )
        {
            if(c.fitness()>maxValue)
            {
                maxValue = c.fitness();
                best = c;
            }
        }
        System.out.println(best.genes);
        System.out.println(1.0/best.fitness());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input_exp.txt"));
        int test_cases = input.nextInt();

        for(int i=0; i<test_cases; i++)
        {
            chromosome = new FloatingChromosome();
            alg = new GeneticAlgorithm();
            alg.setPopulation(new ArrayList<Chromosome>());
            alg.setSelected(new ArrayList<Chromosome>());
            alg.setOffsprings(new ArrayList<Chromosome>());
            alg.setReplacer(new GenerationalReplacement());

            inputFile(input);
            alg.init(chromosome);
            alg.run();
            System.out.print("Case "+(i+1)+": ");
            output();
        }
        input.close();
    }
}

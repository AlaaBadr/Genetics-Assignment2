import java.util.ArrayList;

public class FloatingChromosome extends Chromosome<Double> {

    Double max = 10.0, min = -10.0;
    static ArrayList<Point> points = new ArrayList<>();
    static double b = 0.5;

    FloatingChromosome() {
    }

    @Override
    public Chromosome<Double> init()
    {
        Chromosome chromosome = new FloatingChromosome();
        genes = new ArrayList<>();

        for(int i=0; i<length; i++)
        {
            genes.add(min + Math.random()*(max-min));
        }

        chromosome.setGenes(genes);
        return chromosome;
    }

    @Override
    public double fitness()
    {
        double sum = 0.0;
        for(int i=0; i<points.size(); i++)
        {
            double temp = 0;
            for(int j = 0; j< length ; j++)
            {
                temp+= genes.get(j)*Math.pow(points.get(i).x,j);
            }
            temp -= points.get(i).y;
            sum += (temp*temp);
        }
        return points.size()/sum;
    }

    @Override
    public void flip(int index)
    {
        double deltaL,deltaU,y,deltaI;
        deltaL = genes.get(index) - min;
        deltaU = max - genes.get(index);
        double decider = Math.random();
        if(decider < 0.5)
        {
            y = deltaL;
        }
        else
        {
            y = deltaU;
        }
        deltaI= y*(1-(Math.pow(Math.pow(Math.random(),(1-generationNumber/totalGenerations)),b)));
        if(decider < 0.5)
        {
           genes.set(index,genes.get(index)-deltaI);
        }
        else
        {
            genes.set(index,genes.get(index)+deltaI);
        }

    }
}

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

abstract class Administartive_territorial_unit implements Population, Serializable{
    int population;
    double square;
    int fertility;
    int mortality;
    Administartive_territorial_unit(){
        this.population =0;
        this.square = 0;
        this.fertility = 0;
        this.mortality =0;
    }
    Administartive_territorial_unit(int population, double square, int fertility, int mortality){
        this.population = population;
        this.square = square;
        this.fertility = fertility;
        this.mortality = mortality;
    }
    //Функция вычисляет и возвращает плотность населения
    @Override
    public double density_of_population(){return population/square;}
    //Функция вычисляет и возвращает естественный прирост
    @Override
    public int natural_population_growth(){return fertility-mortality;}
    abstract void show();

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getFertility() {
        return fertility;
    }

    public void setFertility(int fertility) {
        this.fertility = fertility;
    }

    public int getMortality() {
        return mortality;
    }

    public void setMortality(int mortality) {
        this.mortality = mortality;
    }
}


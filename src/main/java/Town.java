import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Town extends Administartive_territorial_unit implements PopulatedLocality{
    private String name_town;
    transient private Region region;
    private int year_of_foundation;

    Town() {
        super();
        this.name_town = null;
        this.region = null;
        this.year_of_foundation = 0;
    }

    Town(String nt, Region r, int year, int population, double square, int fertility, int mortality) {
        super(population, square, fertility, mortality);
        this.name_town = nt;
        this.region = r;
        this.year_of_foundation = year;
    }

    public void show() {
        System.out.printf("Город: %s %s, количество лет с основания: %d, вид города: %s, плотность насления: %.3f, естественный прирост: %d.\n", name_town,
                this.region.getName_region(), this.age_of_populated_locality(), this.type_of_populated_locality(), this.density_of_population(), this.natural_population_growth());
    }

    private void writeObject(ObjectOutputStream os) throws IOException{
        os.defaultWriteObject();
        os.writeObject(region.getName_region());
        os.writeObject(region.getFertility());
        os.writeObject(region.getMortality());
        os.writeObject(region.getPopulation());
        os.writeObject(region.getSquare());
    }

    private void readObject(ObjectInputStream is) throws  IOException, ClassNotFoundException{
        is.defaultReadObject();
        String name= (String) is.readObject();
        int fertility = (int) is.readObject();
        int mortality = (int) is.readObject();
        int population = (int) is.readObject();
        double square = (double) is.readObject();
        region = new Region(name,population,square,fertility,mortality);

    }

    //Функция вычисляет и возвращает значение возраста города
    @Override
    public int age_of_populated_locality() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR) - year_of_foundation;
    }

    //Функция определяет и возвращает тип города
    @Override
    public String type_of_populated_locality() {
        String type;
        if (population <= 50_000) {
            type = "малый";
        } else if (population <= 100_000 && population > 50_000) {
            type = "средний";
        } else if (population > 100_000 && population <= 250_000) {
            type = "большой";
        } else if (population > 250_000 && population <= 1_000_000) {
            type = "крупный";
        } else {
            type = "миллионик";
        }
        return type;
    }

    public String getName_town() {
        return name_town;
    }

    public void setName_town(String name_town) {
        this.name_town = name_town;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getYear_of_foundation() {
        return year_of_foundation;
    }

    public void setYear_of_foundation(int year_of_foundation) {
        this.year_of_foundation = year_of_foundation;
    }
}

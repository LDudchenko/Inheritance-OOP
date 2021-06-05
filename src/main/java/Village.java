import java.util.Calendar;
import java.util.GregorianCalendar;

public class Village extends Administartive_territorial_unit implements PopulatedLocality {
    private String name_village;
    private Region region;
    private int year_of_foundation;

    Village() {
        super();
        this.name_village = null;
        this.region = new Region();
        this.year_of_foundation = 0;
    }

    Village(String nv, Region r, int year, int population, double square, int fertility, int mortality) {
        super(population, square, fertility, mortality);
        name_village = nv;
        region = r;
        year_of_foundation = year;
    }

    public void show() {
        System.out.printf("Село: %s %s, количество лет с основания: %d, вид села: %s, плотность насления: %.3f, естественный прирост: %d.\n", name_village,
                this.region.getName_region(), this.age_of_populated_locality(), this.type_of_populated_locality(), this.density_of_population(), this.natural_population_growth());

    }

    //Функция вычисляет и возвращает значение возраста села
    @Override
    public int age_of_populated_locality() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR) - year_of_foundation;
    }

    //Функция определяет и возвращает тип села
    @Override
    public String type_of_populated_locality() {
        String type;
        if (population <= 200) {
            type = "малое";
        } else if (population <= 1000 && population > 200) {
            type = "среднее";
        } else if (population > 1000 && population <= 3000) {
            type = "большое";
        } else {
            type = "крупное";
        }
        return type;
    }

    public String getName_village() {
        return name_village;
    }

    public void setName_village(String name_village) {
        this.name_village = name_village;
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

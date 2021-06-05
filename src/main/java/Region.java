public class Region extends Administartive_territorial_unit {
    private String name_region;

    Region() {
        super();
        this.name_region = null;
    }

    Region(String nr, int population, double square, int fertility, int mortality) {
        super(population, square, fertility, mortality);
        this.name_region = nr;
    }

    void show() {
        System.out.printf("%s, плотность насления: %.3f, естественный прирост: %d.\n", name_region, this.density_of_population(), this.natural_population_growth());
    }

    public String getName_region() {
        return name_region;
    }

    public void setName_region(String name_region) {
        this.name_region = name_region;
    }
}

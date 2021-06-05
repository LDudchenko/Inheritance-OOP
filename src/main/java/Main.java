import java.io.*;

public class Main {
    public static void main(String[] args) {
        Region zakarpatska_region = new Region("Закарпатская область", 1254000, 12753, 13883, 15353);
        Town uzhgorod = new Town("Ужгород", zakarpatska_region, 872, 112447, 40, 1203, 1400);
        Village zarechie = new Village("Заречье", zakarpatska_region, 1242, 3939, 34.30, 55, 79);

        //Сериализация класса, у которого есть transient поле
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(uzhgorod);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Десериализация класса, у которого есть transient поле
        Town readObj = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("file.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readObj = (Town) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (uzhgorod.getPopulation() == readObj.getPopulation() && uzhgorod.getMortality() == readObj.getMortality() &&
                uzhgorod.getFertility() == readObj.getFertility() && uzhgorod.getSquare() == readObj.getSquare() && uzhgorod.getName_town().equals(readObj.getName_town()) &&
                uzhgorod.getYear_of_foundation() == readObj.getYear_of_foundation()
                && uzhgorod.getRegion().getName_region().equals(readObj.getRegion().getName_region())
                && uzhgorod.getRegion().getFertility() == readObj.getRegion().getFertility() && uzhgorod.getRegion().getMortality()
                == readObj.getRegion().getMortality() && uzhgorod.getRegion().getPopulation() == readObj.getRegion().getPopulation()
                && uzhgorod.getRegion().getSquare() == readObj.getRegion().getSquare()) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }

        //Сериализация класса, у которого нет transient поля
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file2.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(zarechie);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Десериализация класса, у которого нет transient поля
        Village readObj2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("file2.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readObj2 = (Village) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (zarechie.getPopulation() == readObj2.getPopulation() && zarechie.getMortality() == readObj2.getMortality() &&
                zarechie.getFertility() == readObj2.getFertility() && zarechie.getSquare() == readObj2.getSquare() && zarechie.getName_village().equals(readObj2.getName_village()) &&
                zarechie.getYear_of_foundation() == readObj2.getYear_of_foundation()
                && zarechie.getRegion().getName_region().equals(readObj2.getRegion().getName_region()) && zarechie.getRegion().getFertility() == readObj2.getRegion().getFertility() && zarechie.getRegion().getMortality()
                == readObj2.getRegion().getMortality() && zarechie.getRegion().getPopulation() == readObj2.getRegion().getPopulation()
                && zarechie.getRegion().getSquare() == readObj2.getRegion().getSquare()) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Создайте унаследованный класс ГорячийНапиток с дополнительным полем int температура.

// Создайте класс АвтоматГорячихНапитков, реализующий интерфейс ТорговыйАвтомат 
//и реализуйте перегруженный метод getProduct(int name, int volume, int temperature), выдающий продукт, соответствующий имени, объему и температуре.

// В main проинициализируйте несколько ГорячихНапитков и АвтоматГорячихНапитков и позвольте покупателю купить товар.


class Drink{
    int name;
    int volume;
    
    public Drink(int name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    public int getName() {
        return name;
    }
    public void setName(int name) {
        this.name = name;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    @Override
    public String toString() {
        return "Напиток [название =" + name + ", объем =" + volume + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name;
        result = prime * result + volume;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Drink other = (Drink) obj;
        if (name != other.name)
            return false;
        if (volume != other.volume)
            return false;
        return true;
    }
    
}

class HotDrink extends Drink{
    int temperature;

    public HotDrink(int name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Горячий напиток  [название =" + name + ", объем =" + volume + ",температура =" + temperature + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + temperature;
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        HotDrink other = (HotDrink) obj;
        if (temperature != other.temperature)
            return false;
        return true;
    }

}

class Vending_machine{
    private List<HotDrink> drinks = new ArrayList<>();

    public Vending_machine(List<HotDrink> drinks) {
        this.drinks = drinks;
    }
    public HotDrink getProduct(int name, int volume, int temperature){
        for(HotDrink drink : drinks){
            if(drink.name == name && drink.volume == volume && drink.temperature == temperature)
                return drink;
        }
        return null;
    }
    public List<HotDrink> getDrinks() {
        return drinks;
    }
    public void setDrinks(List<HotDrink> drinks) {
        this.drinks = drinks;
    }
}
class DZ1{
    public static void main(String[] args) {
        HotDrink tia = new HotDrink(1, 10, 60);
        HotDrink coldcola = new HotDrink(2, 10, 15);
        HotDrink orange_juice = new HotDrink(3, 10, 20);
        HotDrink multifruit = new HotDrink(4, 10, 20);
        List<HotDrink> drinks = new ArrayList<>();
        drinks.add(tia);
        drinks.add(coldcola);
        drinks.add(orange_juice);
        drinks.add(multifruit);
        Vending_machine barniMasMachine = new Vending_machine(drinks);
        System.out.print("Введите номер продукта 1 - чай, 2 - кокакола, 3 - апельсиновый сок, 4 - мультифрукт:");
        Scanner str_primer = new Scanner(System.in,"cp866");
        int name = 0, volume = 0, temperature = 0;
        try
            {          
            name  = Integer.parseInt(str_primer.nextLine().trim());  
            }
        catch (NumberFormatException nfe)
            {
                System.out.println("Введенные данные не являются натуральным числом" );
            }
        System.out.print("Введите объем продукта все буталки по 10 см2:");
        try
            {          
            volume  = Integer.parseInt(str_primer.nextLine().trim());  
            }
        catch (NumberFormatException nfe)
            {
                System.out.println("Введенные данные не являются натуральным числом" );
            }
        System.out.print("Введите желаемую температура продукта:");
        try
            {          
            temperature  = Integer.parseInt(str_primer.nextLine().trim());  
            }
        catch (NumberFormatException nfe)
            {
                System.out.println("Введенные данные не являются натуральным числом" );
            }
        str_primer.close();
        System.out.println(barniMasMachine.getProduct(name, volume, temperature)); 
    }    

        

}
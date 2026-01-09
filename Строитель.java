import java.util.*;

// 1. Продукт (House)
class House {
    private String walls;
    private String doors;
    private String windows;
    private String roof;
    private boolean hasPool;
    private boolean hasGarage;
    
    public House() {
        this.hasPool = false;
        this.hasGarage = false;
    }
    
    // Setters (обычно package-private, чтобы их вызывал только Builder)
    void setWalls(String walls) { this.walls = walls; }
    void setDoors(String doors) { this.doors = doors; }
    void setWindows(String windows) { this.windows = windows; }
    void setRoof(String roof) { this.roof = roof; }
    void setHasPool(boolean hasPool) { this.hasPool = hasPool; }
    void setHasGarage(boolean hasGarage) { this.hasGarage = hasGarage; }
    
    @Override
    public String toString() {
        List<String> features = new ArrayList<>();
        if (walls != null) features.add("стены: " + walls);
        if (doors != null) features.add("двери: " + doors);
        if (windows != null) features.add("окна: " + windows);
        if (roof != null) features.add("крыша: " + roof);
        features.add("бассейн: " + (hasPool ? "есть" : "нет"));
        features.add("гараж: " + (hasGarage ? "есть" : "нет"));
        return "Дом(" + String.join(", ", features) + ")";
    }
}

// 2. Абстрактный Строитель
abstract class HouseBuilder {
    protected House house;
    
    public HouseBuilder() {
        this.house = new House();
    }
    
    public abstract void buildWalls();
    public abstract void buildDoors();
    public abstract void buildWindows();
    public abstract void buildRoof();
    
    // Необязательные шаги с реализацией по умолчанию
    public void buildPool() {
        house.setHasPool(false);
    }
    
    public void buildGarage() {
        house.setHasGarage(false);
    }
    
    public House getHouse() {
        return house;
    }
}

// 3. Конкретный строитель
class WoodenHouseBuilder extends HouseBuilder {
    @Override
    public void buildWalls() {
        house.setWalls("деревянные");
    }
    
    @Override
    public void buildDoors() {
        house.setDoors("деревянные");
    }
    
    @Override
    public void buildWindows() {
        house.setWindows("деревянные рамы");
    }
    
    @Override
    public void buildRoof() {
        house.setRoof("деревянная черепица");
    }
    
    @Override
    public void buildPool() {
        house.setHasPool(true); // В деревянных домах всегда есть бассейн
    }
}

// 4. Директор
class Director {
    public House buildSimpleHouse(HouseBuilder builder) {
        builder.buildWalls();
        builder.buildDoors();
        builder.buildWindows();
        builder.buildRoof();
        return builder.getHouse();
    }
    
    public House buildLuxuryHouse(HouseBuilder builder) {
        builder.buildWalls();
        builder.buildDoors();
        builder.buildWindows();
        builder.buildRoof();
        builder.buildPool();   // Дополнительная опция
        builder.buildGarage(); // Дополнительная опция
        return builder.getHouse();
    }
}

// 5. Демонстрация использования
public class BuilderExample {
    public static void main(String[] args) {
        System.out.println("Пример работы Строителя\n");
        
        WoodenHouseBuilder builder = new WoodenHouseBuilder();
        Director director = new Director();
        
        // Директор строит дома по стандартным планам
        House simpleHouse = director.buildSimpleHouse(builder);
        System.out.println("Простой дом: " + simpleHouse);
        
        // Нужно создать нового строителя, так как предыдущий уже использован
        WoodenHouseBuilder builderForLux = new WoodenHouseBuilder();
        House luxuryHouse = director.buildLuxuryHouse(builderForLux);
        System.out.println("Дом люкс:    " + luxuryHouse);
        
        // Клиент может строить и без директора (кастомная сборка)
        System.out.println("\nКастомная сборка без директора:");
        WoodenHouseBuilder customBuilder = new WoodenHouseBuilder();
        customBuilder.buildWalls();
        customBuilder.buildDoors();
        // Пропускаем окна и крышу, сразу добавляем гараж
        customBuilder.buildGarage();
        House customHouse = customBuilder.getHouse();
        System.out.println("Кастомный дом: " + customHouse);
    }
}

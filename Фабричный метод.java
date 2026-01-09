import java.util.*;

// 1. Общий интерфейс Продукта (Transport)
interface Transport {
    void deliver(String cargo);
}

// 2. Конкретные продукты
class Truck implements Transport {
    @Override
    public void deliver(String cargo) {
        System.out.println("[Грузовик] Доставляем '" + cargo + "' по дороге.");
    }
}

class Ship implements Transport {
    @Override
    public void deliver(String cargo) {
        System.out.println("[Корабль]  Доставляем '" + cargo + "' по морю.");
    }
}

// 3. Абстрактный Создатель (Logistics)
abstract class Logistics {
    public abstract Transport createTransport();
    
    // Бизнес-логика, использующая фабричный метод
    public void planDelivery(String cargo) {
        Transport transport = createTransport();
        transport.deliver(cargo);
    }
}

// 4. Конкретные создатели
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck(); // Фабричный метод создаёт конкретный продукт
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship(); // Фабричный метод создаёт другой продукт
    }
}

// 5. Демонстрация использования
public class FactoryMethodExample {
    public static void main(String[] args) {
        System.out.println("Пример работы Фабричного метода\n");
        
        Logistics roadCompany = new RoadLogistics();
        Logistics seaCompany = new SeaLogistics();
        
        roadCompany.planDelivery("хлеб");
        seaCompany.planDelivery("нефть");
        
        // Легкое добавление новой логистики
        System.out.println("\nДобавили авиадоставку:");
        
        class Plane implements Transport {
            @Override
            public void deliver(String cargo) {
                System.out.println("[Самолет]  Доставляем '" + cargo + "' по воздуху.");
            }
        }
        
        class AirLogistics extends Logistics {
            @Override
            public Transport createTransport() {
                return new Plane();
            }
        }
        
        Logistics airCompany = new AirLogistics();
        airCompany.planDelivery("скоропортящиеся товары");
    }
}

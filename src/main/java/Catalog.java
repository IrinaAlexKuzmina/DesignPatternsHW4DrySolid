import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog extends Product implements CatalogGroup<Product> {
    private static HashMap<Integer, Product> catalog = new HashMap<>();
    private static ArrayList<Product> arrCatalog = new ArrayList<>();


    public static Product get(Integer key) {
        return catalog.get(key);
    }

    public static void printCatalog() {
        System.out.println("Список возможных товаров для покупки \t Цена");
        arrCatalog.forEach(System.out::println);
    }

    public Catalog(String name, Double price, TypeProduct typeProduct, WeightUnit unit) {
        super(name, price, typeProduct, unit);
        catalog.put(this.getIdentifier(), this);
        arrCatalog.add(this);
    }

    @Override
    public List<Product> getProductsOfType(TypeProduct typeProduct) {
        return arrCatalog.stream().filter(x -> x.getTypeProduct() == typeProduct).collect(Collectors.toList());
    }

    @Override
    public long getNumberOfProductType(TypeProduct typeProduct) {
        return arrCatalog.stream().filter(x -> x.getTypeProduct() == typeProduct).count();
    }

    @Override
    public String toString() {
        return "identifier=" + this.getIdentifier() +
                ",\t name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", typeProduct=" + this.getTypeProduct() + "(" + getNumberOfProductType(this.getTypeProduct()) + ")" +
                ", unit=" + this.getUnit();
    }
}

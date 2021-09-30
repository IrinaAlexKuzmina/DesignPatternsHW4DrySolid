public class Product {

    private static int counter = 0;

    private final int identifier;
    private final String name;
    private final Double price;
    private final TypeProduct typeProduct;
    private final WeightUnit unit;

    public Product(String name, Double price, TypeProduct typeProduct, WeightUnit unit) {
        this.identifier = counter;
        this.name = name;
        this.price = Math.round(price * 100.0) / 100.0;
        this.typeProduct = typeProduct;
        this.unit = unit;

        counter += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return identifier == product.identifier;
    }

    @Override
    public int hashCode() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public int getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "identifier=" + identifier +
                ",\t name='" + name + '\'' +
                ", price=" + price +
                ", typeProduct=" + typeProduct +
                ", unit=" + unit;
    }
}










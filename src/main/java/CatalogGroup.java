import java.util.List;

public interface CatalogGroup<T> {
    public List<T> getProductsOfType(TypeProduct typeProduct);
    public long getNumberOfProductType(TypeProduct typeProduct);
}

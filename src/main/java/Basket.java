public class Basket {
    private static Double resultSum = 0.0;

    private final Double numberOf;
    private final Product product;
    private final Double sum;

    public Basket(Double numberOf, Product product) {

        this.product = product;
        this.sum = Math.round(product.getPrice() * numberOf * 100.0) / 100.0;

        resultSum += this.sum;

        switch (product.getUnit()) {
            case PIECE:
                this.numberOf = Math.round(numberOf) * 1.0;
                break;
            case KILOGRAM:
            case LITER:
                this.numberOf = Math.round(numberOf * 1000.0) / 1000.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + product.getUnit());
        }
    }

    public static Double getResultSumSum() {
        return resultSum;
    }

    @Override
    public String toString() {

        return "товар = " + product.getName() + " (арт." + product.getIdentifier() + ")" +
                ",\t количество = " + numberOf + " " + product.getUnit() +
                ", цена за ед-цу = " + product.getPrice() +
                ", общая сумма = " + sum;
    }
}

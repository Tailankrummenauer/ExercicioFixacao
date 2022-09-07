public class ImportedProduct extends Product {

    private Double customsfee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsfee) {
        super(name, price);
        this.customsfee = customsfee;
    }

    public Double getCustomsfee() {
        return customsfee;
    }

    public void setCustomsfee(Double customsfee) {
        this.customsfee = customsfee;
    }

   

    public Double totalPrice() {
        return getPrice() + customsfee;
    }


     // fazer a mostragem dos dados.
    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: $ )" + String.format("%.2f", customsfee);

    }

}
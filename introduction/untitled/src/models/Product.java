package models;

public class Product {

    private Integer id;
    private String name;
    private Float price;
    private Integer stock;
    private Boolean isActive;

    public Product() {

    }

    public Product(Integer id, String name, Float price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id <= 0)
            System.out.println("Atenção: O ID não pode ser menor ou igual a 0.");

        else
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty())
            System.out.println("Atenção: O nome do produto não pode estar em branco.");

        else
            this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Nome: " + name + " - Preço = $" + price + " - Estoque: " + stock + " - Ativo: " + isActive;
    }
}

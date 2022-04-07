package patterns.builder;

public class ProductBuilder {

    private String name;
    private int id;
    private int quantity;
    private String description;
    private String comments;
    private int price;

    public String getName() {
        return name;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;

    }

    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public ProductBuilder setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public Product build(){
        Product product = new Product();
        product.setPrice(price);
        product.setComments(comments);
        product.setDescription(description);
        product.setId(id);
        product.setName(name);
        product.setQuantity(quantity);
        return product;
    }
    
}

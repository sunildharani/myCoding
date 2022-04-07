package patterns.builder;

public class MainClass {
    public static void main(String[] args){
        Product product = new ProductBuilder().setDescription("desc").setId(1)
                .setName("ashdha").build();
    }

}

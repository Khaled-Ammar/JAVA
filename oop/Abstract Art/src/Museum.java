import java.sql.SQLOutput;

public class Museum {
    public static void main(String[] args) {

        Painting painting1 = new Painting("oil");
        Painting painting2 = new Painting("Watercolor");
        Painting painting3 = new Painting("Acrylic");

        Sculpture sculpture1 = new Sculpture("Marble");
        Sculpture sculpture2 = new Sculpture("Bronze");
        Sculpture sculpture3 = new Sculpture("Porcelain");
        System.out.println(painting1.getPaintType());
    }

}

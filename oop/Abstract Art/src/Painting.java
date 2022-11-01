public class Painting extends Art{
    private String paintType;

    public Painting(String paintType) {
        super("MonaLisa", "Zaki", "Oh so hooot");
        this.paintType = paintType;
    }

    @Override
    public void viewArt() {

    }

    public String getPaintType() {
        return paintType;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }
}

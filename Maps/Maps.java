import java.util.HashMap;
public class Maps {
    public static void  Challange() {
        HashMap<String, String> song = new HashMap<String, String>();
        song.put("Song1", "song11");
        song.put("Song2", "song22");
        song.put("Song3", "song33");
        song.put("Song4", "song44");

        String val = song.get("Song2");
        System.out.println("track title for Song2 : "+val);
        for (String i : song.keySet()) {
        System.out.println("Track: " + i + " Lyrics: " + song.get(i));
}

    }
}
import java.util.ArrayList;
import java.util.Random;
public class TestPuzzling {
	public static void main(String[] args) {
		Puzzling generator = new Puzzling();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("The Random Array (TenRolls) is : "+randomRolls);
		String rand = generator.getRandomLetter();
        System.out.println("The Random Letter is : "+rand);
        String password = generator.generatePassword();
        System.out.println("The Password is : "+password);
        String password2 = generator.getNewPasswordSet(80);
        System.out.println("The New Password is : "+password2);
        generator.shuffleArray();
	}
}


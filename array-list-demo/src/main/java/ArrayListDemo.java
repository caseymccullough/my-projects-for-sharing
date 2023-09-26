import java.util.ArrayList; // don't forget this!
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Player> roster = new ArrayList<>();
		
		Player p1 = new Player ("Jordan", "guard", 30.1);
		Player p2 = new Player ("Nash", "guard", 14.3);
		Player p3 = new Player ("Chamerlain", "center", 30);
		Player p4 = new Player ("McCullough", "bench", 1.2);
		Player p5 = new Player ("Jordan", "guard", 30.1);

		roster.add(p1);
		roster.add(p2);
		roster.add(p3);
		roster.add(p4);
		
		for (int j = 0; j < roster.size(); j++)
			System.out.println (roster.get(j));  // implicit call to toString()
		
		
		Player replacement = new Player ("Abdul-Jabbar", "center", 20.1);
		roster.set (2, replacement);
		
		for (int j = 0; j < roster.size(); j++)
			System.out.println (roster.get(j));  // implicit call to toString()
		
		int index = roster.indexOf(p5);
		if (index == -1)
			System.out.println (p5.getName() + " not found");
		else
			System.out.println (p5.getName() + " found at " + index);
		
	}

}

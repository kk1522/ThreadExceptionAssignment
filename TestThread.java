import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.Random;

public class TestThread {
	public static void main(String[] args) {
		TextField tf[];
		SetFrame setFrame = new SetFrame();
		tf = setFrame.setFrameMethod();
		SetColor green = new SetColor(tf, Color.green);
		SetColor red = new SetColor(tf, Color.red);
		green.start();
		red.start();

	}
}

class SetColor extends Thread {

	TextField[] txtField;
	Color c;
	Random rn = new Random();
	public static int greenCount = 0;
	public static int redCount = 0;

	public SetColor(TextField[] txtField, Color color) {
		super();
		this.txtField = txtField;
		c = color;
	}

	public void run() {

		while ((greenCount + redCount) < 10) {
			int i = rn.nextInt((10 - 0 + 0) + 0);
			Color currentColor = txtField[i].getBackground();
				
			System.out.println("Text field "+i);
			if (currentColor.equals(Color.WHITE) && c.equals(Color.green)) {
				System.out.println("if statement 1");
				greenCount++;
				txtField[i].setBackground(c);
			} else if (currentColor.equals(Color.WHITE) && c.equals(Color.red)) {
				redCount++;
				txtField[i].setBackground(c);
				System.out.println("if statement 2");
			} else if (Color.red.equals(currentColor) && Color.green.equals(c)) {
				redCount--;
				greenCount++;
				txtField[i].setBackground(c);
				System.out.println("if statement 3");
			} else if (Color.green.equals(currentColor) && Color.red.equals(c)) {
				redCount++;
				greenCount--;
				txtField[i].setBackground(c);
				System.out.println("if statement 4");
			}

			System.out.println("red team :" + redCount);
			System.out.println("green team :" + greenCount);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class SetFrame {

	public TextField[] setFrameMethod() {
		Frame f = new Frame();
		
		f.setSize(700, 300);
		f.setVisible(true);
		f.setLayout(new GridLayout());
		TextField textField[] = new TextField[10];
		for (int i = 0; i < 10; i++) {
			TextField tf = new TextField(10);
			textField[i] = tf;
			f.add(textField[i]);
		}
		return textField;

	}

}

package lab9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cse131.ArgsProcessor;
import lab9.Drawable;
import lab9.scenes.*;
import lab9.scenes.ifs.*;
import edu.princeton.cs.introcs.StdDraw;

public class SceneComposer {



	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		//
		// for demo only, remove this code and write your own to do what
		//   is needed for this lab
		while(true) {
			StdDraw.show(10);
			for (int i=0; i < 10; ++i) {
				Forest f = new Forest(5);
				f.draw(); f.draw(); f.draw(); f.draw();
				Leaves l = new Leaves(5);
				l.draw(); l.draw();
			}
			Bubbles b = new Bubbles(10);
			b.draw();
			StdDraw.show(10);
			String resp = ap.nextString("Again?");
			if (resp.equals("no")) {
				break;
			}
			else {
				new Clear().draw();
			}
		}
		//
		// end of demo code
		//
	}

}

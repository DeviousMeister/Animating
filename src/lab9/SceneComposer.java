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
		Map<String, Drawable> init = new HashMap<>();
		List<Drawable> firstDraw = new LinkedList<Drawable>();
		List<Drawable> newDraws = new LinkedList<Drawable>();

		firstDraw.add(new Forest(10));
		firstDraw.add(new Leaves(5));
		firstDraw.add(new Bubbles(15));
		firstDraw.add(new Dragon(0.1, 0.5, 0.3));

		Sequence seqInit = new Sequence(firstDraw);
		init.put("init", seqInit);

		while (true) {
			StdDraw.show(100);
			String resp = ap.nextString("Express yourself: ");
			if(init.get(resp)!=null){
				init.get(resp).draw();
			}
			if(resp.equals("record")){
				boolean recordOn = true;
				while(recordOn){
					String whatAdd = ap.nextString("What do you want to add?");

						if(whatAdd.equals("bubbles")){
							newDraws.add(new Bubbles(10));
						}
						if(whatAdd.equals("forests")){
							newDraws.add(new Forest(20));
						}
						if(whatAdd.equals("circles")){
							newDraws.add(new Circle(6, 5, 0.2));
						}
						if(whatAdd.equals("polygons")){
							newDraws.add(new Poly(9));
						}
						if(whatAdd.equals("leaves")){
							newDraws.add(new Leaves(8));
						}

					else if(whatAdd.equals("done")){
						String name = ap.nextString("What do you want to name this?");
						Sequence newSeq = new Sequence(newDraws);
						init.put(name, newSeq);
						init.get(name).draw();
						recordOn = false;
					}
				}
			}
			if (resp.equals("end")) {
				break;
			}
			if (resp.equals("clear")) {
				new Clear().draw();
			}
			StdDraw.show(100);
		}
	}

}

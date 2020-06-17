import java.util.ArrayList;
import java.util.Random;

class SuperCircleDrawer {
    private final int CANVAS_WIDTH = 800;
    private final int CANVAS_HEIGHT = 600;  

    Random rng;
    ArrayList<Circle> holder;

    public SuperCircleDrawer(int numCircles){
        rng = new Random();
        holder = new ArrayList<Circle>();
        for (int i = 0; i < numCircles; i++){
            Circle newCircle = new Circle(rng.nextInt(100)+1);
            newCircle.moveTo(rng.nextInt(CANVAS_WIDTH), rng.nextInt(CANVAS_HEIGHT));
            holder.add(newCircle);
        }
    }

    public void addCircle(Circle newCircle){
        newCircle.makeVisible();
        holder.add(newCircle);
    }

    public void drawCircles(){
        for(Circle c : holder){
            c.makeVisible();
        }
    }

    public void eraseCircles(){
        for(Circle c : holder){
            c.makeInvisible();
        }
    }

    public void eraseCircles(int minDiameter){
        for(Circle c : holder){
            if(c.getDiameter() < minDiameter){
                c.makeInvisible();
            }
        }
    }

    public void removeSmallest(){
        int smIndx = 0;
        int smVal = holder.get(0).getDiameter();
        for (int i = 1 ; i < holder.size() ; i++){
            Circle c = holder.get(i);
            if (c.getDiameter() < smVal){
                smIndx = i;
                smVal = c.getDiameter();
            }
        }
        Circle smallest = holder.get(smIndx);
        smallest.makeInvisible();
        holder.remove(smIndx);
    }

    public void replace(Circle c1, Circle c2){
        int repIndx = holder.indexOf(c1);
        if ( repIndx >= 0 ){
            Circle c = holder.get(repIndx);
            c.makeInvisible();
            holder.set(repIndx, c2);
        }
    }

    public void replaceLargest(Circle rc) {
        int lgIndx = 0;
        int lgVal = holder.get(0).getDiameter();
        for (int i = 1 ; i < holder.size() ; i++){
            Circle c = holder.get(i);
            if (c.getDiameter() > lgVal){
                lgIndx = i;
                lgVal = c.getDiameter();
            }
        }
        Circle largest = holder.get(lgIndx);
        largest.makeInvisible();
        replace(largest,rc);
    }

}


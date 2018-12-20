package design;


class SquarePeg{
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
class RoundHole{


    private final int raius;
    public RoundHole(int raius) {
        this.raius = raius;
        System.out.println("max squarePeg is"+raius*Math.sqrt(2));
    }

    public int getRaius() {
        return raius;
    }
}
class  SquarePegAdapter{
    private  final  SquarePeg squarePeg;

    public SquarePegAdapter(double width) {
        squarePeg = new SquarePeg(width);
    }
    public void adapt(RoundHole roundHole){
        double amount=squarePeg.getWidth()-roundHole.getRaius()*Math.sqrt(2);
        System.out.println("reducing squarepeg"+squarePeg.getWidth()+"by"+(amount<0?0:amount)+"amount");
        if(amount>0){
            squarePeg.setWidth(roundHole.getRaius()*Math.sqrt(2));
            System.out.println("new width is"+squarePeg.getWidth());
        }
    }
}
public class BasicAdapter {
    public static void main(String[] args) {
        RoundHole roundHole=new RoundHole(5);
        SquarePegAdapter squarePegAdapter;
        for(int i=6;i<10;i++){
            squarePegAdapter =new SquarePegAdapter((double)i);
            squarePegAdapter.adapt(roundHole);
        }
    }

}

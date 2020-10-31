package practice.task06;

public class Cube {
    private CubeMode mode;

    public Cube() {
        this(CubeMode.FAIR);
    }

    public Cube(CubeMode mode) {
        this.mode = mode;
    }

    public int getNext() {
        if (mode == CubeMode.UNFAIR) {
            return 6;
        }else{
            return (int)(Math.random()*6) + 1;
        }
    }
}

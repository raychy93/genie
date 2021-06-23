public class Karma {

    private int Up;

    public Karma(int Up) {

        this.Up = Up;



    }

    public int getUp()
    {

        return this.Up;
    }

    public int totalKarm()
    {

        return this.Up;
    }

    public int incrementUp(int increase)
    {
        return this.Up++;

    }

    public int decrement(int Down){

       return this.Up-=Down;

    }

    @Override
    public String toString() {

        return "Your karma is: " + totalKarm();

    }

}

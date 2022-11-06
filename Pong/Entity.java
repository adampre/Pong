public class Entity 
{
    public int x;
    public int y;

    public int width;
    public int height;

    public Entity speed;

    public Entity(int x, int y, int width, int height, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        speed = new Entity(xSpeed, ySpeed);
    }

    public Entity(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        speed = null;
    }

    public Entity(int x, int y)
    {
        this.x = x;
        this.y = y;

        width = 0;
        height = 0;

        speed = null;
    }
}

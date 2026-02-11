public abstract class Sprite {

    // Declaring fields
    protected double x, y;
    protected double width, height;
    protected double velocityX, velocityY;
    protected boolean onGround;

    // Defining Constructor
    public Sprite(double x, double y, double width, double height) {
        // Initializing the fields
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.onGround = false;
    }

    // Method to update the position of the sprite
    public void updatePos() {
        x += velocityX;
        y += velocityY;
    }

    // Method to check if the sprite is colliding
    public boolean isColliding(Sprite other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }

    // Methods for returning edges
    public double getLeft() { return x; }
    public double getRight() { return x + width; }
    public double getTop() { return y; }
    public double getBottom() { return y + height; }

    // Implementing gravity
    public void applyGravity(double gravity) {
        velocityY += gravity;
    }

    public void stopVertical() {
        velocityY = 0;
    }
}

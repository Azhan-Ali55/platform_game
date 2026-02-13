public abstract class Sprite {

    // Declaring fields
    protected static final double GRAVITY = 0.5;
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

    // Getters for returning edges
    public double getLeft() { return x; }
    public double getRight() { return x + width; }
    public double getTop() { return y; }
    public double getBottom() { return y + height; }

    // Getters for position and size
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }

    // Setters for position
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    // Getter to return if the sprite is on ground
    public boolean isOnGround() { return onGround; }
    // Setter to set the sprite on the ground
    public void setOnGround(boolean onGround) { this.onGround = onGround; }

    // Implementing gravity
    public void applyGravity() {
        velocityY += GRAVITY;
    }

    // Updating Sprite
    public void update() {
        applyGravity();   // or leave empty
        updatePos();
    }

    // Method to stop vertical velocity
    public void stopVertical() {
        velocityY = 0;
    }
}

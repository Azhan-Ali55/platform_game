public abstract class Enemy extends Sprite {
    // Variables to hold Enemy stats
    protected double movementSpeed;
    protected boolean movingLeft;

    // Constructor to set initial conditions
    public Enemy(double x, double y, double width, double height, double movementSpeed) {
        // Calling Sprite constructor to set initial values
        super(x, y, width, height);
        this.movementSpeed = movementSpeed;
        this.movingLeft = true;
    }

    // Movement logic for Enemy
    public void move() {
        if (movingLeft) {
            velocityX = -movementSpeed;
        }
        else {
            velocityX = movementSpeed;
        }
    }

    // Update method to update speed, postion and gravity
    @Override
    public void update() {
        move();
        applyGravity();
        updatePos();
    }

    // Reverse direction method
    public void reverseDirection() {
        movingLeft = !movingLeft;
    }
}

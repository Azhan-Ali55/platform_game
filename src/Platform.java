public class Platform extends Sprite {

    // For moving platforms
    private boolean isMoving;
    private double movingSpeed;

    // Initialize the initial stats
    public Platform(double x, double y, double width, double height) {
        // Calling Sprite constructor to set initial variables
        super(x, y, width, height);
        this.isMoving = false;
        this.movingSpeed = 0.0;
    }

    // Constructor for moving platforms
    public Platform(double x, double y, double width, double height, double movingSpeed) {
        // Calling Sprite constructor to set initial variables
        super(x, y, width, height);
        this.isMoving = true;
        this.movingSpeed = movingSpeed;
    }

    // Update method to update the speed of the platform
    @Override
    public void update() {
        if (isMoving) {
            x += movingSpeed;
        }
    }

}

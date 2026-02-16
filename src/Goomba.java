public class Goomba extends Enemy{

    // Initialize the initial stats using constructor
    public Goomba(double x, double y, double width, double height, double speed) {
        // Calling Sprite constructor to set initial variables
        super(x, y, width, height, speed);
    }

    // Update method to update x coordinate
    @Override
    public void update() {
        x += movementSpeed;
    }
}

public class Player extends Sprite{

    // Declaring variables to hold player stats
    private int health;
    private int score;
    private double movementSpeed;
    private double jumpingStrength;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean jumping;

    // Constructor to set default stats for the player
    public Player(double x, double y, double width, double height) {
       // Calling Sprite constructor to set initial variables
        super(x, y, width, height);
       // Initializing the Player stats
        this.health = 3;
        this.score = 0;
        this.movementSpeed = 3.0;
        this.jumpingStrength = -10.0;
        this.movingLeft = false;
        this.movingRight = false;
        this.jumping = false;
    }

    // Defining movement methods for the player
    public void moveLeft() {
        movingLeft = true;
        movingRight = false;
        velocityX = -movementSpeed;

    }

    public void moveRight() {
        movingRight = true;
        movingLeft = false;
        velocityX = movementSpeed;
    }

    public void stopMovement() {
        movingLeft = false;
        movingRight = false;
        velocityX = 0;
    }

    // Defining method for jumping
    public void jump() {
        if (onGround) {
            velocityY = jumpingStrength;
            onGround = false;
        }
    }

    // Adding palyer specific logic
    @Override
    public void update() {
        super.applyGravity();
        super.updatePos(); // Update position
    }

    // Getter and updater methods for the player's stats
    public int getHealth() { return health; }
    public int getScore() { return score; }
    public void addScore(int points) { score += points; }
    public void takeDamage(int dmg) { health -= dmg; }

}

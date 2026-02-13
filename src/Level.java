import java.util.List;
import java.util.ArrayList;

public class Level {
    private Player player; // Check for player collisions
    private List<Enemy> enemies; // Check for enemy collisions
    private List<Platform> platforms;  // List to store multiple platform

    // Constructor to initialize the initial stats
    public Level(Player player) {
        this.player = player;
        this.platforms = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    // Method to add platforms
    public void addPlatform(Platform platform) {
        platforms.add(platform);
    }

    // Method to add enemies
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    // Method for collision checking
    public void checkPlayerPlatformCollision() {

        // Enhanced for loop to move through Array List to check all the platforms
        for (Platform platform : platforms) {
            // Check player collision
            if (player.isColliding(platform)) {
                // Ensure player lands on top of the platoform
                if (player.getBottom() >= platform.getTop() && player.getTop() < platform.getTop()) {
                    // Updating variables
                    player.setY(platform.getTop() - player.getHeight()); // Setting new position of y
                    player.stopVertical();                               // Stopping player vertically
                    player.setOnGround(true);                            // Set OnGround to true
                }
            }
        }

        // Initially the player is not on platform
        boolean onPlatform = false;
        double margin = 1.0;
        // Enhanced for loop to move through all the platforms
        for (Platform platform : platforms) {
            // Aligning the player horizontally
            boolean horizontallyAligned = player.getRight() > platform.getLeft() && player.getLeft() < platform.getRight();
            // If difference between player's bottom and platform's top is less than margin. Then set onPlatform to true
            if (Math.abs(player.getBottom() - platform.getTop()) < margin) {
                onPlatform = true;
                break;
            }
        }

        if (!onPlatform)
            player.setOnGround(false);
    }

    // Method for checking player and enemy collision
    public void checkPlayerEnemyCollisions() {
        for (Enemy enemy : enemies) {
            if (player.isColliding(enemy)) {
                player.takeDamage(1);
            }
        }
    }

    // Update Method
    public void update() {
        // Update player stats
        player.update();

        // Moving through platforms
        for (Platform platform : platforms) {
            platform.update(); // Update platform stats
        }

        // Moving through enemies
        for (Enemy enemy : enemies) {
            enemy.update();    // Update enemy stats
        }

        checkPlayerPlatformCollision();
        checkPlayerEnemyCollisions();
    }
}

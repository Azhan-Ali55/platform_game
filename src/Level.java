import java.util.List;
import java.util.ArrayList;

public class Level {
    private Player player; // Check for player collisions
    private List<Enemy> enemies // Check for enemy collisions
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

                }
            }
        }
    }
}

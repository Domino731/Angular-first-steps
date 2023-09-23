package environment.resources;

import com.badlogic.gdx.math.Vector2;

public class ParabolicMotion {
    public float currentX = 0;
    public float currentY = 0;
    private Vector2 itemPosition;
    private Vector2 itemVelocity;
    private float gravity;
    public ParabolicMotion(float initialX, float initialY, float initialVelocity, float angle, float gravity) {
        // Initialize item properties
        itemPosition = new Vector2(initialX, initialY); // Starting point A
        itemVelocity = new Vector2((float) 2, (float) 3); // Initial velocity (adjust as needed)
    }

    public void update(float deltaTime) {
        // Update item position based on velocity and gravity
        itemPosition.x += itemVelocity.x * deltaTime;
        itemPosition.y += itemVelocity.y * deltaTime;
        itemVelocity.y -= gravity * deltaTime;
        currentX = itemPosition.x;
        currentY = itemPosition.y;
    }

}






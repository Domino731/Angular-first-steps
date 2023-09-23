package environment.resources;

public class ParabolicMotion {
    private float initialX; // Początkowa pozycja X
    private float initialY; // Początkowa pozycja Y
    private float initialVelocity; // Początkowa prędkość początkowa
    private float angle; // Kąt wyrzutu w radianach
    private float gravity; // Przyspieszenie grawitacyjne

    private float time = 0; // Aktualny czas
    private float maxX; // Maksymalna odległość na osi X
    private float maxY; // Maksymalna wysokość

    public ParabolicMotion(float initialX, float initialY, float initialVelocity, float angle, float gravity) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.initialVelocity = initialVelocity;
        this.angle = angle;
        this.gravity = gravity;

        // Oblicz maksymalną odległość na osi X i maksymalną wysokość
        maxX = (initialVelocity * initialVelocity * Math.sin(2 * angle)) / gravity;
        maxY = (initialVelocity * initialVelocity * Math.sin(angle) * Math.sin(angle)) / (2 * gravity);
    }

    public void update(float deltaTime) {
        // Aktualizuj czas
        time += deltaTime;

        // Oblicz pozycję X i Y na podstawie równań ruchu
        float currentX = initialX + (initialVelocity * Math.cos(angle) * time);
        float currentY = initialY + (initialVelocity * Math.sin(angle) * time) - (0.5f * gravity * time * time);

        // Jeśli obiekt upadł już na ziemię, zatrzymaj aktualizację
        if (currentY <= 0) {
            time = 0; // Zresetuj czas
            currentY = 0; // Ustal pozycję Y na ziemi
        }
    }
}






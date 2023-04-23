import {Point} from "pixi.js";

class Entity {
  constructor(sprite) {
    this.sprite = sprite;
    this.position = new Point(0, 0);
    this.velocity = new Point(0, 0);
    this.acceleration = new Point(0, 0);
  }

  update(delta) {
    // Update position based on velocity and acceleration
    this.velocity.x += this.acceleration.x * delta;
    this.velocity.y += this.acceleration.y * delta;
    this.position.x += this.velocity.x * delta;
    this.position.y += this.velocity.y * delta;

    // Update sprite position
    this.sprite.position.x = this.position.x;
    this.sprite.position.y = this.position.y;
  }

  // Setters for position, velocity, and acceleration
  setPosition(x, y) {
    this.position.x = x;
    this.position.y = y;
  }

  setVelocity(x, y) {
    this.velocity.x = x;
    this.velocity.y = y;
  }

  setAcceleration(x, y) {
    this.acceleration.x = x;
    this.acceleration.y = y;
  }
}
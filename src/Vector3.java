public class Vector3 {
  public float x, y, z;

  public Vector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  // Multiplicação por matriz (rotação/translação)
  public Vector3 multiply(float[][] matrix) {
    float newX = x * matrix[0][0] + y * matrix[1][0] + z * matrix[2][0] + matrix[3][0];
    float newY = x * matrix[0][1] + y * matrix[1][1] + z * matrix[2][1] + matrix[3][1];
    float newZ = x * matrix[0][2] + y * matrix[1][2] + z * matrix[2][2] + matrix[3][2];
    return new Vector3(newX, newY, newZ);
  }
}

import java.awt.Graphics;
import java.util.List;

public class Renderer {
  private float fov = 800; // Campo de visão
  // Projeta um ponto 3D em 2D

  public int[] projectPoint(Vector3 point, int screenWidth, int screenHeight) {
    float aspectRatio = (float) screenWidth / screenHeight;
    float x = (point.x * fov) / (point.z + 5) * aspectRatio + screenWidth / 2;
    float y = (-point.y * fov) / (point.z + 5) + screenHeight / 2;
    return new int[] { (int) x, (int) y };
  }

  // Desenha uma malha 3D
  public void renderMesh(Graphics g, Mesh mesh, int screenWidth, int screenHeight) {
    for (int[] triangle : mesh.triangles) {
      Vector3 v1 = mesh.vertices.get(triangle[0]);
      Vector3 v2 = mesh.vertices.get(triangle[1]);
      Vector3 v3 = mesh.vertices.get(triangle[2]);

      int[] p1 = projectPoint(v1, screenWidth, screenHeight);
      int[] p2 = projectPoint(v2, screenWidth, screenHeight);
      int[] p3 = projectPoint(v3, screenWidth, screenHeight);

      // Desenha o triângulo
      g.drawPolygon(
          new int[] { p1[0], p2[0], p3[0] },
          new int[] { p1[1], p2[1], p3[1] },
          3);
    }
  }
}
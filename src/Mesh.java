import java.util.ArrayList;
import java.util.List;

public class Mesh {
  public List<Vector3> vertices;
  public List<int[]> triangles;

  public Mesh() {
    vertices = new ArrayList<>();
    triangles = new ArrayList<>();

    // Vértices do cubo (8 pontos)
    vertices.add(new Vector3(-1, -1, -1)); // 0
    vertices.add(new Vector3(1, -1, -1)); // 1
    vertices.add(new Vector3(1, 1, -1)); // 2
    vertices.add(new Vector3(-1, 1, -1)); // 3
    vertices.add(new Vector3(-1, -1, 1)); // 4
    vertices.add(new Vector3(1, -1, 1)); // 5
    vertices.add(new Vector3(1, 1, 1)); // 6
    vertices.add(new Vector3(-1, 1, 1)); // 7

    // Triângulos do cubo (12 faces)
    triangles.add(new int[] { 0, 1, 2 });
    triangles.add(new int[] { 0, 2, 3 }); // Frente
    triangles.add(new int[] { 4, 5, 6 });
    triangles.add(new int[] { 4, 6, 7 }); // Trás
    triangles.add(new int[] { 0, 4, 7 });
    triangles.add(new int[] { 0, 7, 3 }); // Esquerda
    triangles.add(new int[] { 1, 5, 6 });
    triangles.add(new int[] { 1, 6, 2 }); // Direita
    triangles.add(new int[] { 0, 1, 5 });
    triangles.add(new int[] { 0, 5, 4 }); // Baixo
    triangles.add(new int[] { 3, 2, 6 });
    triangles.add(new int[] { 3, 6, 7 }); // Cima
  }
}
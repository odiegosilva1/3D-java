import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {
  private Mesh cube = new Mesh();
  private Renderer renderer = new Renderer();
  private Timer timer;
  private float angle = 0;

  public Main() {
    timer = new Timer(16, this); // ~60 FPS
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.WHITE);

    // Rotaciona o cubo
    float[][] rotationMatrix = {
        { (float) Math.cos(angle), 0, (float) Math.sin(angle), 0 },
        { 0, 1, 0, 0 },
        { (float) -Math.sin(angle), 0, (float) Math.cos(angle), 0 },
        { 0, 0, 0, 1 }
    };

    // Aplica rotação aos vértices
    Mesh rotatedCube = new Mesh();
    for (Vector3 vertex : cube.vertices) {
      rotatedCube.vertices.add(vertex.multiply(rotationMatrix));
    }

    renderer.renderMesh(g, rotatedCube, getWidth(), getHeight());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    angle += 0.02; // Animação
    repaint();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Motor 3D Básico");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new Main());
    frame.setVisible(true);
  }
}
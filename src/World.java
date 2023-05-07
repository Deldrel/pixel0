import java.awt.*;

public class World {
    public byte[][] grid;

    public World(int n) {
        grid = new byte[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = (byte) (Math.random() * 6);
                grid[i][j] = 6;
            }
        }
    }

    public void draw(Graphics g, int offsetX, int offsetY, float scale) {
        int x, y;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                x = (int) (i * scale + offsetX);
                y = (int) (j * scale + offsetY);
                if (x < -scale || x > params.windowSize || y < -scale || y > params.windowSize)
                    continue;
                if (i == params.selectedX && j == params.selectedY)
                    g.setColor(Color.RED);
                else
                    g.setColor(convertToColor(grid[i][j]));
                g.fillRect(x, y, (int) (scale), (int) (scale));
            }
        }
    }

    public Color convertToColor(byte b) {
        return switch (b) {
            case 0 -> Color.RED;
            case 1 -> Color.ORANGE;
            case 2 -> Color.YELLOW;
            case 3 -> Color.GREEN;
            case 4 -> Color.BLUE;
            case 5 -> Color.MAGENTA;
            case 6 -> Color.WHITE;
            default -> Color.BLACK;
        };
    }
}

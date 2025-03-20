package app.screen.thum;

import java.awt.*;
import javax.swing.*;

public class FixedGridLayout implements LayoutManager {
    private int columns;

    public FixedGridLayout(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("El número de columnas debe ser mayor a 0.");
        }
        this.columns = columns;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // No se utiliza en este layout.
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // No se utiliza en este layout.
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            int count = parent.getComponentCount();
            int rows = (int) Math.ceil((double) count / columns);
            int width = 0;
            int height = 0;

            for (int i = 0; i < count; i++) {
                Dimension d = parent.getComponent(i).getPreferredSize();
                width = Math.max(width, d.width);
                height = Math.max(height, d.height);
            }

            Insets insets = parent.getInsets();
            return new Dimension(
                insets.left + insets.right + columns * width,
                insets.top + insets.bottom + rows * height
            );
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return preferredLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            int count = parent.getComponentCount();

            // Si no hay componentes, no hacemos nada.
            if (count == 0) {
                return;
            }

            // Verificar que columnas sea válido.
            if (columns <= 0) {
                throw new IllegalStateException("El número de columnas debe ser mayor que 0.");
            }

            // Calcular filas.
            int rows = (int) Math.ceil((double) count / columns);

            // Verificar que filas sea válido.
            if (rows == 0) {
                rows = 1; // Garantizamos al menos una fila.
            }

            Insets insets = parent.getInsets();
            int width = parent.getWidth() - insets.left - insets.right;
            int height = parent.getHeight() - insets.top - insets.bottom;

            // Evitar divisiones por cero.
            int cellWidth = Math.max(1, width / columns);
            int cellHeight = Math.max(1, height / rows);

            for (int i = 0; i < count; i++) {
                Component c = parent.getComponent(i);
                Dimension d = c.getPreferredSize();

                int row = i / columns;
                int col = i % columns;

                int x = insets.left + col * cellWidth + (cellWidth - d.width) / 2;
                int y = insets.top + row * cellHeight + (cellHeight - d.height) / 2;

                c.setBounds(x, y, d.width, d.height);
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("El número de columnas debe ser mayor a 0.");
        }
        this.columns = columns;
    }
}

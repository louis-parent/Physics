package physics.simulator;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import physics.entity.Entity;
import physics.entity.Paintable;
import physics.entity.Updatable;
import physics.simulator.controller.Keyboard;
import physics.simulator.controller.Mouse;

public class Simulator extends JFrame
{
	private static final long serialVersionUID = -8235839290137621745L;

	public static final int UPDATE_MILLIS_DELAY = 33;

	public static final int DEFAULT_WIDTH = 1080;
	public static final int DEFAULT_HEIGHT = 720;

	private int width;
	private int height;

	private Set<Entity> entities;

	public Simulator(Entity... entities)
	{
		this(Simulator.DEFAULT_WIDTH, Simulator.DEFAULT_HEIGHT, entities);
	}

	public Simulator(int width, int height, Entity... entities)
	{
		this.setSize(width, height);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addMouseListener(Mouse.getInstance());
		this.addKeyListener(Keyboard.getInstance());

		this.width = width;
		this.height = height;
		
		this.entities = Stream.of(entities).collect(Collectors.toSet());
	}

	public boolean addEntity(Entity entity)
	{
		return this.entities.add(entity);
	}

	public boolean removeEntity(Entity entity)
	{
		return this.entities.remove(entity);
	}

	public void start()
	{
		new Thread(() -> {
			SwingUtilities.invokeLater(() -> {
				this.setVisible(true);
				this.launchUpdates();
			});
		}).start();
	}

	private void launchUpdates()
	{
		new Timer(Simulator.UPDATE_MILLIS_DELAY, (ActionEvent e) -> {
			this.tick();
		}).start();
	}

	private void tick()
	{
		this.update();

		SwingUtilities.invokeLater(() -> {
			this.repaint();
		});
	}

	public void update()
	{
		for(Updatable updatable : this.entities)
		{
			updatable.update();
		}
	}

	@Override
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		for(Paintable drawable : this.entities)
		{
			drawable.paint(g);
		}
	}

	@Override
	public int getWidth()
	{
		return this.width;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}
}

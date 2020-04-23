package physics.simulator.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import physics.math.Vector2D;

public class Mouse extends MouseAdapter
{
	private static Mouse instance;

	private static boolean isHover = true;
	private static MouseButton pressedButton = MouseButton.NONE;
	private static Vector2D position = Vector2D.getNull();

	@Override
	public void mousePressed(MouseEvent event)
	{
		this.updateClickedButton(event.getButton());
		this.updatePosition(event.getXOnScreen(), event.getYOnScreen());
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		this.updateClickedButton(MouseButton.NONE.getId());
		this.updatePosition(event.getXOnScreen(), event.getYOnScreen());
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		this.updatePosition(event.getXOnScreen(), event.getYOnScreen());
	}

	@Override
	public void mouseEntered(MouseEvent event)
	{
		this.updateHoverState(true);
		this.updatePosition(event.getXOnScreen(), event.getYOnScreen());
	}

	@Override
	public void mouseExited(MouseEvent event)
	{
		this.updateHoverState(true);
		this.updatePosition(event.getXOnScreen(), event.getYOnScreen());
	}

	private void updateClickedButton(int button)
	{
		Mouse.pressedButton = MouseButton.forId(button);
	}

	private void updatePosition(int x, int y)
	{
		Mouse.position = new Vector2D(x, y);
	}

	private void updateHoverState(boolean bool)
	{
		Mouse.isHover = bool;
	}

	public static boolean isButtonPressed(MouseButton button)
	{
		return Mouse.isHover && (Mouse.pressedButton == button);
	}

	public static boolean isLeftButtonPressed()
	{
		return Mouse.isHover && (Mouse.pressedButton == MouseButton.LEFT);
	}

	public static boolean isMiddleButtonPressed()
	{
		return Mouse.isHover && (Mouse.pressedButton == MouseButton.MIDDLE);
	}

	public static boolean isRightButtonPressed()
	{
		return Mouse.isHover && (Mouse.pressedButton == MouseButton.RIGHT);
	}

	public static Vector2D getPosition()
	{
		return Mouse.position;
	}

	public static boolean isHover()
	{
		return Mouse.isHover;
	}

	public static Mouse getInstance()
	{
		if(Mouse.instance == null)
		{
			Mouse.instance = new Mouse();
		}

		return Mouse.instance;
	}

	public static enum MouseButton
	{
		NONE(MouseEvent.NOBUTTON), LEFT(MouseEvent.BUTTON1), MIDDLE(MouseEvent.BUTTON2), RIGHT(MouseEvent.BUTTON3);

		private final int id;

		private MouseButton(int buttonId)
		{
			this.id = buttonId;
		}

		@Override
		public String toString()
		{
			return "Mouse " + this.name().toLowerCase() + " button";
		}

		public int getId()
		{
			return this.id;
		}

		public static MouseButton forId(int id)
		{
			if(id == LEFT.id)
			{
				return LEFT;
			}
			else if(id == MIDDLE.id)
			{
				return MIDDLE;
			}
			else if(id == RIGHT.id)
			{
				return RIGHT;
			}
			else
			{
				return NONE;
			}
		}
	}
}

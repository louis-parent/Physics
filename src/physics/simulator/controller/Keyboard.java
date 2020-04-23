package physics.simulator.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Keyboard extends KeyAdapter
{
	private static Keyboard instance;

	private static Map<Integer, Boolean> keyCodePressed = new HashMap<Integer, Boolean>();
	private static Map<Character, Boolean> keyCharPressed = new HashMap<Character, Boolean>();

	private static Map<ControlKey, Boolean> controlKeyPressed = new HashMap<ControlKey, Boolean>();

	@Override
	public void keyPressed(KeyEvent event)
	{
		this.updatePressedKey(event, true);
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		this.updatePressedKey(event, false);
	}

	private void updatePressedKey(KeyEvent event, boolean isPressed)
	{
		Keyboard.keyCodePressed.put(event.getKeyCode(), isPressed);
		Keyboard.keyCharPressed.put(event.getKeyChar(), isPressed);

		Keyboard.controlKeyPressed.put(ControlKey.SHIFT, event.isShiftDown());
		Keyboard.controlKeyPressed.put(ControlKey.CTRL, event.isControlDown());
		Keyboard.controlKeyPressed.put(ControlKey.ALT, event.isAltDown());
	}

	public static boolean isKeyPressed(char k)
	{
		return Keyboard.getMapBoolean(k, Keyboard.keyCharPressed);
	}

	public static boolean isKeyPressed(int k)
	{
		return Keyboard.getMapBoolean(k, Keyboard.keyCodePressed);
	}

	public static boolean isKeyPressed(ControlKey k)
	{
		return Keyboard.getMapBoolean(k, Keyboard.controlKeyPressed);
	}

	private static boolean getMapBoolean(Object key, Map<? extends Object, Boolean> map)
	{
		Boolean bool = map.get(key);
		return bool == null ? false : true;
	}

	public static Keyboard getInstance()
	{
		if(Keyboard.instance == null)
		{
			Keyboard.instance = new Keyboard();
		}

		return Keyboard.instance;
	}

	public static enum ControlKey
	{
		NONE, SHIFT, CTRL, ALT;

		@Override
		public String toString()
		{
			return this.name().toLowerCase();
		}

		public static ControlKey fromString(String str)
		{
			switch(str)
			{
				case "shift":
					return SHIFT;

				case "ctrl":
					return CTRL;

				case "alt":
					return ALT;

				default:
				case "none":
					return NONE;
			}
		}
	}
}

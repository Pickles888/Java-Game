package org.programmingGame;

import java.util.ArrayList;
import java.util.List;

import org.programmingGame.Constants.Input;

public class Keyboard {
	public enum GameInput {
		MOVELEFT,
		MOVERIGHT,
		MOVEUP,
		MOVEDOWN,
		ATTACK,
	}

	private boolean[] keys = new boolean[256];

	public List<GameInput> getInputs() {
		List<GameInput> inputs = new ArrayList<>();

		if (pressed(Input.up))
			inputs.add(GameInput.MOVEUP);
		if (pressed(Input.down))
			inputs.add(GameInput.MOVEDOWN);
		if (pressed(Input.right))
			inputs.add(GameInput.MOVERIGHT);
		if (pressed(Input.left))
			inputs.add(GameInput.MOVELEFT);

		return inputs;
	}

	private boolean pressed(int code) {
		return keys[code];
	}

	public void setKeycode(int code, boolean val) {
		keys[code] = val;
	}
}

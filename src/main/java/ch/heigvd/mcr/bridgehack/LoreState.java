package ch.heigvd.mcr.bridgehack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LoreState extends BasicGameState {
    public static final int ID = 2;
    private BridgeHack game;

    private final String title = "Welcome in BridgeHack";
    private final String lore = "Your adventure just start here.\n" +
            "Your destiny is to find the lost item somewhere in this dungeon.\n" +
            "But your trip seems not to be easy... The item is on the third level\n" +
            "of the dungeon. When you find it, you will be able to get out thanks a portal.\n" +
            "Unfortunately, you will have to fight against many creatures.";
    private final String choose = "Its time to make your choice. Please select a race and a roll";


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        this.game = (BridgeHack) stateBasedGame;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        graphics.drawString(title, 0, 50);
        graphics.drawString(game.getUsername() + "!", 200, 50);
        graphics.drawString(lore, 0, 80);
        graphics.drawString(choose, 0, 250);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) {

    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void keyReleased(int key, char c) {
        game.enterState(MapState.ID);
    }
}

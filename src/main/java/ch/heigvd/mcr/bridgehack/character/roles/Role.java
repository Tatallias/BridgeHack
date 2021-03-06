package ch.heigvd.mcr.bridgehack.character.roles;

import ch.heigvd.mcr.bridgehack.character.StatModifier;
import lombok.Getter;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Abstract class representing a role
 */
public abstract class Role {
    // Base path to image resources
    static final private String IMG_BASE_PATH = "/src/main/resources/img/";

    private Animation idleAnimation;
    private Animation runAnimation;
    @Getter
    private StatModifier statModifier;

    /**
     * Role constructor
     *
     * @param baseImgName The base image name for this role
     */
    public Role(String baseImgName, StatModifier statModifier){
        String imageBasePath = IMG_BASE_PATH + baseImgName;

        this.statModifier = statModifier;

        idleAnimation = new Animation();
        runAnimation = new Animation();

        try {
            for (int i = 0; i < 4; ++i) {
                idleAnimation.addFrame(new Image(imageBasePath + "_idle_anim_f" + i + ".png"), 100);
                runAnimation.addFrame(new Image(imageBasePath + "_run_anim_f" + i + ".png"), 100);
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Render a character
     *
     * @param g      The graphics object to draw onto
     * @param moving Whether the character is moving
     * @param x      The x component of the character's position
     * @param y      The y component of the character's position
     */
    public void render(Graphics g, boolean moving, int x, int y) {
        if (moving) {
            g.drawAnimation(runAnimation, x, y - 16);
        } else {
            g.drawAnimation(idleAnimation, x, y - 16);
        }
    }
}

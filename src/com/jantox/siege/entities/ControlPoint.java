package com.jantox.siege.entities;

import com.jantox.siege.Resources;
import com.jantox.siege.Vector3D;
import com.jantox.siege.entities.Entity;

import static org.lwjgl.opengl.GL11.*;

public class ControlPoint extends Entity {

    public ControlPoint(Vector3D pos) {
        super(pos);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render() {
        glPushMatrix();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);

        glColor4f(1,1,1, 1);

        glBindTexture(GL_TEXTURE_2D, Resources.getTexture(2).getTextureID());

        glTranslatef((float)pos.x, (float)pos.y, (float)pos.z);
        glScalef(5,5, 5);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex3f(-1, 0, -1);
        glTexCoord2f(1, 0);
        glVertex3f(1, 0, -1);
        glTexCoord2f(1, 1);
        glVertex3f(1, 0, 1);
        glTexCoord2f(0, 1);
        glVertex3f(-1, 0, 1);
        glEnd();

        glEnable(GL_DEPTH_TEST);

        //glCallList(Resources.getModel(2));
        glPopMatrix();
    }
}

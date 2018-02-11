/* CS2150Coursework.java
 * geraghtt		Thomas Geraghty		160115497
 *
 * Scene Graph:
 *  Scene origin
 *  |
 *		Earth
 *			|	Sun (Ry sunAngle)
 *		Satellite Body
 *			|	Satellite left arm (Rx solarPanelRotationAngle)
 *			|	Satellite right arm (Rx solarPanelRotationAngle)
 */
package geraghtt;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;
import GraphicsLab.*;
import geraghtt.models.*;


/**
 * My submission is a geosynchronous satellite (orbital speed same as earths rotation, making satellite
 * hang in single space relative to earth). You can see the sun rising and setting, illuminating both the
 * earth and the satellite. The satellites solar panels can be spun by using the up and down keys.
 *
 *
 * <p>Controls:
 * <ul>
 * <li>Press the escape key to exit the application.</li>
 * <li>Press up and down to rotate to the solar panels</li>
 * <li>While viewing the scene along the x, y or z axis, use the up and down cursor keys
 *      to increase or decrease the viewpoint's distance from the scene origin</li>
 * </ul>
 * </p>
 */
public class CS2150Coursework extends GraphicsLab {
    //declares program variables
    private static Texture earthTexture;
    private static Texture sunTexture;
    private static float sunAngle = 300f;
    private static float solarPanelRotationAngle = 35.0f;
    private static Satellite satellite;


    public static void main(String args[]) {
        new CS2150Coursework().run(WINDOWED,"CS2150 Coursework Submission",0.02f);
    }

    protected void initScene() throws Exception {
        // Load textures and assign them to respective texture.
    	// Earth texture from http://planetpixelemporium.com/earth.html
        earthTexture = loadTexture("geraghtt/textures/earth.bmp");
        // Sun texture from http://planetpixelemporium.com/earth.html
        sunTexture = loadTexture("geraghtt/textures/sun.jpg");
        // Enable lighting
        GL11.glEnable(GL11.GL_LIGHTING);
        // Re-normalise due to using scaling (causing issues with lighting normals if not recalculated)
        GL11.glEnable(GL11.GL_NORMALIZE);

        satellite = new Satellite();;

        // No ambient lighting
        float ambient0[]  = {0.0f, 0.0f, 0.0f, 0.0f};
        // Set lighting to be white.
        float diffuse0[] = {1f, 1f, 1f, 1.0f};
        // Create light and enable it, assigning ambient0 and diffuse0 to their respective assignments.
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, FloatBuffer.wrap(ambient0));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, FloatBuffer.wrap(diffuse0));
        GL11.glEnable(GL11.GL_LIGHT0);
    }

    protected void checkSceneInput() {
        // Spins solar panels counter-clockwise if rotation angle is more then -80 degrees
    	// when UP key is pushed
        if(Keyboard.isKeyDown(Keyboard.KEY_UP) && solarPanelRotationAngle < 180.0f)
        {
            solarPanelRotationAngle += 5f * getAnimationScale(); // Make the house go around if the R key is pressed
        }
        // Spins solar panels clockwise if rotation angle is more then -180 degrees
        // when DOWN key is pushed
        if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && solarPanelRotationAngle > -180.0f)
        {
            solarPanelRotationAngle -= 5f * getAnimationScale(); // Make the house go around if the R key is pressed
        }
        // Resets animation to beginning when SPACEBAR is pushed.
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            resetAnimations();
        }
    }

    protected void updateScene() {
        // Checks if sunAngle is more then 360, if more than 360, reset back to zero,
        // otherwise continue to increment sunAngle value by 1 * animation scale.
        if(sunAngle < 360) {
            sunAngle += +1f * getAnimationScale();
        } else {
            sunAngle = 0;
        }
    }

    protected void renderScene() {
        // Draw the earth
        GL11.glPushMatrix();
        {
            GL11.glPushMatrix();
            {
                // Enable texture for earth sphere
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                // Binds earth texture to sphere
                GL11.glBindTexture(GL11.GL_TEXTURE_2D, earthTexture.getTextureID());
                // Generates texture map for a sphere.
                GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
                GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
                GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_SPHERE_MAP);
                GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_SPHERE_MAP);

                // Define the transformation applied on the sphere
                GL11.glTranslatef(0f, 0f, -10.0f);
                GL11.glRotatef(60f, 0.0f, 1.0f, -5f);

                // Rotates the texture mapped to the earth sphere.
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glTranslatef(0f, 0f, 0.0f);
                GL11.glRotatef(60f, 0.0f, 0.1f, 0f);
                GL11.glTranslatef(0, 0f, -10f);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);

                // Draw sphere
                new Sphere().draw(1f, 64, 64);
                // Disables texture (to stop earth texture continuing to be applied to all future objects)
                GL11.glDisable(GL11.GL_TEXTURE_2D);
            }
            GL11.glPopMatrix();

            // Draw sun

            // Enables texture for sun sphere
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            // Binds sun texture to the spjhere
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, sunTexture.getTextureID());
            // Generates texture maps for sphere object.
            GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
            GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_SPHERE_MAP);
            GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_SPHERE_MAP);

            // Translates sun sphere
            GL11.glTranslatef(0f, 0f, -10.0f);
            // Rotates sun sphere around earth sphere origin, 
            // with rotation angle being increased automatically in the updateScene method.
            GL11.glRotatef(sunAngle, 0f, 1f, 0f);
            GL11.glTranslatef(4.65f, 0f, 0f);
            float positionSun[] = {0.0f, 0.0f, 0.0f, 1f};
            // Updates position of light0 (sun light).
            GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, FloatBuffer.wrap(positionSun));
            GL11.glTranslatef(0.35f, 0f, 0f);

            // Draws sun sphere.
            new Sphere().draw(0.3f, 32, 32);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
        }
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        {
            // Translates Satellite model
            GL11.glTranslatef(0.1f,0.25f,-11.45f);
            GL11.glScalef(0.01f,0.01f,0.01f);
            GL11.glRotatef(60f,-3f,0f,2f);
            // Draw satellite body
            satellite.drawBody();


            GL11.glPushMatrix();
            {
                // Rotates both arms of the satellite based on solarPanelRotationAngle
                GL11.glRotatef(solarPanelRotationAngle, 1f, 0f, 0f);
                // Draw satellite arms.
                satellite.drawRightArm();
                satellite.drawLeftArm();
            }
            GL11.glPopMatrix();
        }
    }

    protected void setSceneCamera() {
        // call the default behaviour defined in Coursework.geraghtt.GraphicsLab. This will set a default perspective projection
        // and default camera settings ready for some custom camera positioning below...  
        super.setSceneCamera();
        
        // position the camera up near the satellite
        GLU.gluLookAt(0.05f,0.25f,-11.65f, 2f,1f,1f, 0.0f,1.0f,0.0f);
   }

   private void resetAnimations() {
       //resets values to default
       sunAngle = 300f;
       solarPanelRotationAngle = 35.0f;
   }

    private void cleanupScene() {
        //wipes satellite model and destroys display.
        satellite = null;
        Display.destroy();
    }
}
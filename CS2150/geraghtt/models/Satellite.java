package geraghtt.models;

import GraphicsLab.*;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Satellite {

    // Shine amount on the solar panel
    private static final float solarPanelShineAmount = 30.0f;
    // Specular reflection amount for solar panel
    private static final float solarPanelSpecular[] = {1.0f, 1.0f, 1.0f, 1.0f};
    // Diffuse reflection amount for solar panel
    private static final float solarPanelDiffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
    // Default amount of shine
    private static final float defaultShine  = 0f;
    // Default specular reflection amount
    private static final float defaultSpecular[] = {0f, 0f, 0f, 1f};
    // Default diffuse amount
    private static final float defaultDiffuse[]  = {0.8f, 0.8f, 0.8f, 1.0f};

    // Sstatic texture fields for solar panel texture.
    private static Texture solarPanelTexture;


    public Satellite() {
        //Attempt to load textures, write to console if unable
        try {
            loadTexture();
        } catch (Exception ex) {
            System.out.println("Unable to load texture");
        }
    }

    private void loadTexture() throws Exception {
        // Loads solar panel texture
        solarPanelTexture = TextureLoader.getTexture("jpg", ResourceLoader.getResourceAsStream("geraghtt/textures/solar-panel.jpg"), true);
        // Solar panel texture from https://www.wholesalesolar.com/images/module_folder/KC210GX-LPU.jpg
    }

    public void drawBody() {
        {
            Vertex v1 = new Vertex(-0.5f, -0.5f, 1f); //left bottom front
            Vertex v2 = new Vertex(-0.5f, 0.5f, 1f); //left top front
            Vertex v3 = new Vertex(0.5f, 0.5f, 1f); //right top front
            Vertex v4 = new Vertex(0.5f, -0.5f, 1f); //right bottom front
            Vertex v5 = new Vertex(-0.5f, -0.5f, -0.5f); //left bottom back
            Vertex v6 = new Vertex(-0.5f, 0.5f, -0.5f); //left top back
            Vertex v7 = new Vertex(0.5f, 0.5f, -0.5f); //right top back
            Vertex v8 = new Vertex(0.5f, -0.5f, -0.5f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            Colour.RED.submit();
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:

            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            Colour.BLUE.submit();
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        {
            Vertex v1 = new Vertex(-0.25f, -0.25f, -0.5f); //left bottom back
            Vertex v2 = new Vertex(-0.25f, 0.25f, -0.5f); //left top back
            Vertex v3 = new Vertex(0.25f, 0.25f, -0.5f); //right top back
            Vertex v4 = new Vertex(0.25f, -0.25f, -0.5f); //right bottom back
            Vertex v5 = new Vertex(-0.25f, -0.25f, -1f); //left bottom front
            Vertex v6 = new Vertex(-0.25f, 0.25f, -1f); //left top front
            Vertex v7 = new Vertex(0.25f, 0.25f, -1f); //right top front
            Vertex v8 = new Vertex(0.25f, -0.25f, -1f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void drawRightArm() {
        //sets up default reflections for arm section of arm (not solar panels)
        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, defaultShine);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, FloatBuffer.wrap(defaultSpecular));
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, FloatBuffer.wrap(defaultDiffuse));

        //right arm
        {
            Vertex v1 = new Vertex(3.25f, -0.2f, 0.20f); //left bottom front
            Vertex v2 = new Vertex(3.25f, 0.2f, 0.20f); //left top front
            Vertex v3 = new Vertex(0.5f, 0.2f, 0.20f); //right top front
            Vertex v4 = new Vertex(0.5f, -0.2f, 0.20f); //right bottom front
            Vertex v5 = new Vertex(3.25f, -0.2f, -0.20f); //left bottom back
            Vertex v6 = new Vertex(3.25f, 0.2f, -0.20f); //left top back
            Vertex v7 = new Vertex(0.5f, 0.2f, -0.20f); //right top back
            Vertex v8 = new Vertex(0.5f, -0.2f, -0.20f); //right bottom back


            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();


            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();


            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                v7.submit();
                v3.submit();
                v2.submit();
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                v4.submit();
                v8.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }

        //right arm back solar panel connector
        {
            Vertex v1 = new Vertex(3f, -0.10f, 0.30f); //left bottom back
            Vertex v2 = new Vertex(3f, 0.10f, 0.30f); //left top back
            Vertex v3 = new Vertex(1f, 0.10f, 0.30f); //right top back
            Vertex v4 = new Vertex(1f, -0.10f, 0.30f); //right bottom back
            Vertex v5 = new Vertex(3f, -0.10f, 0.20f); //left bottom front
            Vertex v6 = new Vertex(3f, 0.10f, 0.20f); //left top front
            Vertex v7 = new Vertex(1f, 0.10f, 0.20f); //right top front
            Vertex v8 = new Vertex(1f, -0.10f, 0.20f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                v7.submit();
                v3.submit();
                v2.submit();
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                v4.submit();
                v8.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }

        //right arm front solar panel connector
        {
            Vertex v1 = new Vertex(3f, -0.10f, -0.30f); //right bottom back
            Vertex v2 = new Vertex(3f, 0.10f, -0.30f); //right top back
            Vertex v3 = new Vertex(1f, 0.10f, -0.30f); //left top back
            Vertex v4 = new Vertex(1f, -0.10f, -0.30f); //left bottom back
            Vertex v5 = new Vertex(3f, -0.10f, -0.20f); //right bottom front
            Vertex v6 = new Vertex(3f, 0.10f, -0.20f); //right top front
            Vertex v7 = new Vertex(1f, 0.10f, -0.20f); //left top front
            Vertex v8 = new Vertex(1f, -0.10f, -0.20f); //left bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);


        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, solarPanelShineAmount);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, FloatBuffer.wrap(solarPanelSpecular));
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, FloatBuffer.wrap(solarPanelDiffuse));

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, solarPanelTexture.getTextureID());
        //right arm solar panel 1
        {
            Vertex v1 = new Vertex(2.75f, -0.025f, 3f); //left bottom front
            Vertex v2 = new Vertex(2.75f, 0.025f, 3f); //left top front
            Vertex v3 = new Vertex(2.125f, 0.025f, 3f); //right top front
            Vertex v4 = new Vertex(2.125f, -0.025f, 3f); //right bottom front
            Vertex v5 = new Vertex(2.75f, -0.025f, 0.30f); //left bottom back
            Vertex v6 = new Vertex(2.75f, 0.025f, 0.30f); //left top back
            Vertex v7 = new Vertex(2.125f, 0.025f, 0.30f); //right top back
            Vertex v8 = new Vertex(2.125f, -0.025f, 0.30f); //right bottom back


            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }

        //right arm solar panel 2
        {
            Vertex v1 = new Vertex(1.875f, -0.025f, 3f); //left bottom front
            Vertex v2 = new Vertex(1.875f, 0.025f, 3f); //left top front
            Vertex v3 = new Vertex(1.25f, 0.025f, 3f); //right top front
            Vertex v4 = new Vertex(1.25f, -0.025f, 3f); //right bottom front
            Vertex v5 = new Vertex(1.875f, -0.025f, 0.30f); //left bottom back
            Vertex v6 = new Vertex(1.875f, 0.025f, 0.30f); //left top back
            Vertex v7 = new Vertex(1.25f, 0.025f, 0.30f); //right top back
            Vertex v8 = new Vertex(1.25f, -0.025f, 0.30f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }

        //right arm solar panel 3
        {
            Vertex v1 = new Vertex(2.75f, -0.025f, -3f); //right bottom back
            Vertex v2 = new Vertex(2.75f, 0.025f, -3f); //right top back
            Vertex v3 = new Vertex(2.125f, 0.025f, -3f); //left top back
            Vertex v4 = new Vertex(2.125f, -0.025f, -3f); //left bottom back
            Vertex v5 = new Vertex(2.75f, -0.025f, -0.30f); //right bottom front
            Vertex v6 = new Vertex(2.75f, 0.025f, -0.30f); //right top front
            Vertex v7 = new Vertex(2.125f, 0.025f, -0.30f); //left top front
            Vertex v8 = new Vertex(2.125f, -0.025f, -0.30f); //left bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //right arm solar panel 4
        {
            Vertex v1 = new Vertex(1.875f, -0.025f, -3f); //left bottom back
            Vertex v2 = new Vertex(1.875f, 0.025f, -3f); //left top back
            Vertex v3 = new Vertex(1.25f, 0.025f, -3f); //right top back
            Vertex v4 = new Vertex(1.25f, -0.025f, -3f); //right bottom back
            Vertex v5 = new Vertex(1.875f, -0.025f, -0.30f); //left bottom front
            Vertex v6 = new Vertex(1.875f, 0.025f, -0.30f); //left top front
            Vertex v7 = new Vertex(1.25f, 0.025f, -0.30f); //right top front
            Vertex v8 = new Vertex(1.25f, -0.025f, -0.30f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public void drawLeftArm(){
        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, defaultShine);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, FloatBuffer.wrap(defaultSpecular));
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, FloatBuffer.wrap(defaultDiffuse));

        //left arm
        {
            Vertex v1 = new Vertex(-3.25f, -0.2f, 0.20f); //left bottom front
            Vertex v2 = new Vertex(-3.25f, 0.2f, 0.20f); //left top front
            Vertex v3 = new Vertex(-0.5f, 0.2f, 0.20f); //right top front
            Vertex v4 = new Vertex(-0.5f, -0.2f, 0.20f); //right bottom front
            Vertex v5 = new Vertex(-3.25f, -0.2f, -0.20f); //left bottom back
            Vertex v6 = new Vertex(-3.25f, 0.2f, -0.20f); //left top back
            Vertex v7 = new Vertex(-0.5f, 0.2f, -0.20f); //right top back
            Vertex v8 = new Vertex(-0.5f, -0.2f, -0.20f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //left arm solar panel connector
        {
            Vertex v1 = new Vertex(-3f, -0.10f, 0.30f); //left bottom front
            Vertex v2 = new Vertex(-3f, 0.10f, 0.30f); //left top front
            Vertex v3 = new Vertex(-1f, 0.10f, 0.30f); //right top front
            Vertex v4 = new Vertex(-1f, -0.10f, 0.30f); //right bottom front
            Vertex v5 = new Vertex(-3f, -0.10f, 0.20f); //left bottom back
            Vertex v6 = new Vertex(-3f, 0.10f, 0.20f); //left top back
            Vertex v7 = new Vertex(-1f, 0.10f, 0.20f); //right top back
            Vertex v8 = new Vertex(-1f, -0.10f, 0.20f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //left arm solar panel connector
        {
            Vertex v1 = new Vertex(-3f, -0.10f, 0.30f); //left bottom front
            Vertex v2 = new Vertex(-3f, 0.10f, 0.30f); //left top front
            Vertex v3 = new Vertex(-1f, 0.10f, 0.30f); //right top front
            Vertex v4 = new Vertex(-1f, -0.10f, 0.30f); //right bottom front
            Vertex v5 = new Vertex(-3f, -0.10f, 0.20f); //left bottom back
            Vertex v6 = new Vertex(-3f, 0.10f, 0.20f); //left top back
            Vertex v7 = new Vertex(-1f, 0.10f, 0.20f); //right top back
            Vertex v8 = new Vertex(-1f, -0.10f, 0.20f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                v7.submit();
                v6.submit();
                v2.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                v4.submit();
                v1.submit();
                v5.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //right arm solar panel connector
        {
            Vertex v1 = new Vertex(-3f, -0.10f, -0.30f); //left bottom back
            Vertex v2 = new Vertex(-3f, 0.10f, -0.30f); //left top back
            Vertex v3 = new Vertex(-1f, 0.10f, -0.30f); //right top back
            Vertex v4 = new Vertex(-1f, -0.10f, -0.30f); //right bottom back
            Vertex v5 = new Vertex(-3f, -0.10f, -0.20f); //left bottom front
            Vertex v6 = new Vertex(-3f, 0.10f, -0.20f); //left top front
            Vertex v7 = new Vertex(-1f, 0.10f, -0.20f); //right top front
            Vertex v8 = new Vertex(-1f, -0.10f, -0.20f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                v7.submit();
                v3.submit();
                v2.submit();
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                v4.submit();
                v8.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, solarPanelShineAmount);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, FloatBuffer.wrap(solarPanelSpecular));
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, FloatBuffer.wrap(solarPanelDiffuse));


        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, solarPanelTexture.getTextureID());

        //left arm solar panel 1
        {
            Vertex v1 = new Vertex(-2.75f, -0.025f, 3f); //left bottom front
            Vertex v2 = new Vertex(-2.75f, 0.025f, 3f); //left top front
            Vertex v3 = new Vertex(-2.125f, 0.025f, 3f); //right top front
            Vertex v4 = new Vertex(-2.125f, -0.025f, 3f); //right bottom front
            Vertex v5 = new Vertex(-2.75f, -0.025f, 0.30f); //left bottom back
            Vertex v6 = new Vertex(-2.75f, 0.025f, 0.30f); //left top back
            Vertex v7 = new Vertex(-2.125f, 0.025f, 0.30f); //right top back
            Vertex v8 = new Vertex(-2.125f, -0.025f, 0.30f); //right bottom back

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //left arm solar panel 2
        {
            Vertex v1 = new Vertex(-1.875f, -0.025f, 3f); //left bottom front
            Vertex v2 = new Vertex(-1.875f, 0.025f, 3f); //left top front
            Vertex v3 = new Vertex(-1.25f, 0.025f, 3f); //right top front
            Vertex v4 = new Vertex(-1.25f, -0.025f, 3f); //right bottom front
            Vertex v5 = new Vertex(-1.875f, -0.025f, 0.30f); //left bottom back
            Vertex v6 = new Vertex(-1.875f, 0.025f, 0.30f); //left top back
            Vertex v7 = new Vertex(-1.25f, 0.025f, 0.30f); //right top back
            Vertex v8 = new Vertex(-1.25f, -0.025f, 0.30f); //right bottom back

            // draw the near face:
            Colour.WHITE.submit();
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v2.toVector(), v1.toVector(), v4.toVector()).submit();

                v3.submit();
                v2.submit();
                v1.submit();
                v4.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v6.toVector(), v5.toVector(), v1.toVector()).submit();

                v2.submit();
                v6.submit();
                v5.submit();
                v1.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v4.toVector(), v8.toVector()).submit();

                v7.submit();
                v3.submit();
                v4.submit();
                v8.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v6.toVector(), v2.toVector(), v3.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
            }
            GL11.glEnd();

            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v1.toVector(), v5.toVector(), v8.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
            }
            GL11.glEnd();

            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v7.toVector(), v8.toVector(), v5.toVector()).submit();

                v6.submit();
                v7.submit();
                v8.submit();
                v5.submit();
            }
            GL11.glEnd();
        }

        //left arm solar panel 3
        {
            Vertex v1 = new Vertex(-1.875f, -0.025f, -3f); //left bottom back
            Vertex v2 = new Vertex(-1.875f, 0.025f, -3f); //left top back
            Vertex v3 = new Vertex(-1.25f, 0.025f, -3f); //right top back
            Vertex v4 = new Vertex(-1.25f, -0.025f, -3f); //right bottom back
            Vertex v5 = new Vertex(-1.875f, -0.025f, -0.30f); //left bottom front
            Vertex v6 = new Vertex(-1.875f, 0.025f, -0.30f); //left top front
            Vertex v7 = new Vertex(-1.25f, 0.025f, -0.30f); //right top front
            Vertex v8 = new Vertex(-1.25f, -0.025f, -0.30f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }

        {
            //left arm solar panel 4
            Vertex v1 = new Vertex(-2.75f, -0.025f, -3f); //left bottom back
            Vertex v2 = new Vertex(-2.75f, 0.025f, -3f); //left top back
            Vertex v3 = new Vertex(-2.125f, 0.025f, -3f); //right top back
            Vertex v4 = new Vertex(-2.125f, -0.025f, -3f); //right bottom back
            Vertex v5 = new Vertex(-2.75f, -0.025f, -0.30f); //left bottom front
            Vertex v6 = new Vertex(-2.75f, 0.025f, -0.30f); //left top front
            Vertex v7 = new Vertex(-2.125f, 0.025f, -0.30f); //right top front
            Vertex v8 = new Vertex(-2.125f, -0.025f, -0.30f); //right bottom front

            // draw the near face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(), v4.toVector(), v1.toVector(), v2.toVector()).submit();

                v3.submit();
                v4.submit();
                v1.submit();
                v2.submit();
            }
            GL11.glEnd();

            // draw the left face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v2.toVector(), v1.toVector(), v5.toVector(), v6.toVector()).submit();

                v2.submit();
                v1.submit();
                v5.submit();
                v6.submit();
            }
            GL11.glEnd();

            // draw the right face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v8.toVector(), v4.toVector(), v3.toVector()).submit();

                v7.submit();
                v8.submit();
                v4.submit();
                v3.submit();
            }
            GL11.glEnd();

            // draw the top face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v7.toVector(), v3.toVector(), v2.toVector(), v6.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v7.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v3.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v2.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v6.submit();
            }
            GL11.glEnd();


            // draw the bottom face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(), v8.toVector(), v5.toVector(), v1.toVector()).submit();

                GL11.glTexCoord2f(0.0f, 0.0f);
                v4.submit();
                GL11.glTexCoord2f(0.0f, 0.5f);
                v8.submit();
                GL11.glTexCoord2f(0.5f, 0.5f);
                v5.submit();
                GL11.glTexCoord2f(0.5f, 0.0f);
                v1.submit();
            }
            GL11.glEnd();


            // draw the far face:
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v6.toVector(), v5.toVector(), v8.toVector(), v7.toVector()).submit();

                v6.submit();
                v5.submit();
                v8.submit();
                v7.submit();
            }
            GL11.glEnd();
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        }
    }
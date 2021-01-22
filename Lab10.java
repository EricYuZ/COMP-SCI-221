import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane; 
import javafx.scene.Scene;
import javafx.scene.shape.*; 
import javafx.scene.paint.Color; 
import javafx.scene.input.*;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;

public class Lab10 extends Application{
    private static final int SCENE_WIDTH = 640; 
    private static final int SCENE_HEIGHT = 480; 
    private static final int HEAD_RADIUS = 35; 
    private static final int TORSO_HEIGHT = 100; 
    private static final int CIRC_MAX_RADIUS = 100; 
    private static final int CIRC_MIN_RADIUS = 25;

    private static final int LEG_SIDE = 75;
    private static final int ARM_OFFSET = 25;
    private static final int ARM_LENGTH = 75;

    private double dx, dy;

    private Circle circle = null;

    public void start(Stage primaryStage) {
        Line torso = new Line(); 

        Pane pane = new Pane();

        Circle head = new Circle();
        head.setRadius(HEAD_RADIUS);
        head.setCenterX(SCENE_WIDTH / 2);
        head.setCenterY(SCENE_HEIGHT / 2);
        head.setStroke(Color.BLACK);
        head.setFill(Color.rgb(new java.util.Random().nextInt(256),
                new java.util.Random().nextInt(256), 
                new java.util.Random().nextInt(256)));

        torso.setStartX(head.getCenterX()); 
        torso.setStartY(head.getCenterY() + head.getRadius()); 
        torso.setEndX(head.getCenterX()); 
        torso.setEndY(head.getCenterY() + head.getRadius()+ TORSO_HEIGHT);
        torso.setStroke(Color.BLACK);

        Line larm = new Line();
        larm.setStartX(torso.getStartX()); 
        larm.setStartY(torso.getStartY() + ARM_OFFSET); 
        larm.setEndX(torso.getStartX() +  ARM_LENGTH); 
        larm.setEndY(torso.getStartY() + ARM_OFFSET);
        larm.setStroke(Color.BLACK);

        Line rarm = new Line();
        rarm.setStartX(torso.getStartX()); 
        rarm.setStartY(torso.getStartY() + ARM_OFFSET); 
        rarm.setEndX(torso.getStartX() - ARM_LENGTH); 
        rarm.setEndY(torso.getStartY() + ARM_OFFSET);
        rarm.setStroke(Color.BLACK);

        Line lleg = new Line();
        lleg.setStartX(torso.getEndX()); 
        lleg.setStartY(torso.getEndY()); 
        lleg.setEndX(torso.getEndX() + LEG_SIDE); 
        lleg.setEndY(torso.getEndY() + LEG_SIDE);
        lleg.setStroke(Color.BLACK);

        Line rleg = new Line();
        rleg.setStartX(torso.getEndX()); 
        rleg.setStartY(torso.getEndY()); 
        rleg.setEndX(torso.getEndX() - LEG_SIDE); 
        rleg.setEndY(torso.getEndY() + LEG_SIDE);
        rleg.setStroke(Color.BLACK);

        head.setOnMouseDragged(evt ->{

                if (circle != null){
                    double x1 = circle.getCenterX(),
                    y1 = circle.getCenterY(),
                    x2 = larm.getEndX(),
                    y2 = larm.getEndY(),
                    diffx = x1 - x2,
                    diffy = y1 - y2,
                    diffxsqu = diffx * diffx,
                    diffysqu = diffy * diffy,
                    dist = Math.sqrt(diffxsqu + diffysqu);
                    if (dist < circle.getRadius())
                    {
                        circle.setRadius(circle.getRadius() - 1.5);
                        if (circle.getRadius() < 5){
                            pane.getChildren().remove(circle);
                            circle = null;
                        }
                    }
                }

                head.setCenterX(evt.getX() - dx);
                head.setCenterY(evt.getY() - dy);

                torso.setStartX(head.getCenterX()); 
                torso.setStartY(head.getCenterY() + head.getRadius()); 
                torso.setEndX(head.getCenterX()); 
                torso.setEndY(head.getCenterY() + head.getRadius()+ TORSO_HEIGHT);

                larm.setStartX(torso.getStartX()); 
                larm.setStartY(torso.getStartY() + ARM_OFFSET); 
                larm.setEndX(torso.getStartX() +  ARM_LENGTH); 
                larm.setEndY(torso.getStartY() + ARM_OFFSET);

                rarm.setStartX(torso.getStartX()); 
                rarm.setStartY(torso.getStartY() + ARM_OFFSET); 
                rarm.setEndX(torso.getStartX() - ARM_LENGTH); 
                rarm.setEndY(torso.getStartY() + ARM_OFFSET);

                lleg.setStartX(torso.getEndX()); 
                lleg.setStartY(torso.getEndY()); 
                lleg.setEndX(torso.getEndX() + LEG_SIDE); 
                lleg.setEndY(torso.getEndY() + LEG_SIDE);

                rleg.setStartX(torso.getEndX()); 
                rleg.setStartY(torso.getEndY()); 
                rleg.setEndX(torso.getEndX() - LEG_SIDE); 
                rleg.setEndY(torso.getEndY() + LEG_SIDE);
            });

        pane.setOnMousePressed(evt -> {
                dx = evt.getX() - head.getCenterX();
                dy = evt.getY() - head.getCenterY();
            });

        pane.setOnMouseClicked(evt -> {
                if (evt.getButton() == MouseButton.SECONDARY) {
                    if (circle == null) {
                        circle = new Circle();
                        circle.setRadius(new java.util.Random().nextInt(CIRC_MAX_RADIUS));
                        circle.setCenterX(evt.getX());
                        circle.setCenterY(evt.getY());
                        circle.setStroke(Color.BLACK);
                        circle.setFill(Color.rgb(new java.util.Random().nextInt(256),
                                new java.util.Random().nextInt(256), 
                                new java.util.Random().nextInt(256)));

                        pane.getChildren().add(circle);
                    }
                    else
                    {
                        circle.setCenterX(evt.getX());
                        circle.setCenterY(evt.getY());
                    }
                }
            });

        pane.getChildren().addAll(head,torso,larm,lleg,rarm,rleg);
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT); 
        primaryStage.setScene(scene); 
        primaryStage.setTitle("Lab10");//@Zeyang Yu
        primaryStage.show();
    }
}

import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.scene.layout.Pane; 
import javafx.scene.Scene; 
import javafx.scene.shape.*; 
import javafx.scene.paint.Color; 
import javafx.scene.input.*;
import java.util.ArrayList;


public class Lab11 extends Application{
    private static final int SCENE_WIDTH = 640; 
    private static final int SCENE_HEIGHT = 480; 
    private static final int HEAD_RADIUS = 35;
    private static final int TORSO_HEIGHT = 100; 
    private static final int CIRC_MAX_RADIUS = 100; 
    private static final int CIRC_MIN_RADIUS = 25; // You might need to add other final values here.
    private ArrayList<Circle> theCircles = new ArrayList<Circle>();
    private double dx, dy;

    public void start(Stage primaryStage) { 
        Pane pane = new Pane();
        Circle head = new Circle(); 
        head.setRadius(HEAD_RADIUS); 
        head.setCenterX(0); 
        head.setCenterY(0);
        head.setStroke(Color.BLACK);
        head.setFill(Color.rgb(new java.util.Random().nextInt(256), new java.util.Random().nextInt(256), new java.util.Random().nextInt(256)));
        Line torso = new Line(); 
        torso.setStartX(head.getCenterX());
        torso.setStartY(head.getCenterY() + head.getRadius());
        torso.setEndX(head.getCenterX()); 
        torso.setEndY(head.getCenterY() + head.getRadius() + TORSO_HEIGHT); 
        torso.setStroke(Color.BLACK);
        Line hand = new Line(); 
        hand.setStartX(head.getCenterX()-2*head.getRadius());
        hand.setStartY(head.getCenterY() +2*head.getRadius());
        hand.setEndX(head.getCenterX() + 2*head.getRadius()); 
        hand.setEndY(head.getCenterY() + 2*head.getRadius()); 
        hand.setStroke(Color.BLACK);
        Line leg1 = new Line();
        leg1.setStartX(head.getCenterX());
        leg1.setStartY(head.getCenterY() + head.getRadius() + TORSO_HEIGHT);
        leg1.setEndX(head.getCenterX() - 2*head.getRadius()); 
        leg1.setEndY(head.getCenterY() + 5.5*head.getRadius()); 
        leg1.setStroke(Color.BLACK);
        Line leg2 = new Line();
        leg2.setStartX(head.getCenterX());
        leg2.setStartY(head.getCenterY() + head.getRadius() + TORSO_HEIGHT);
        leg2.setEndX(head.getCenterX() + 2*head.getRadius()); 
        leg2.setEndY(head.getCenterY() + 5.5*head.getRadius()); 
        leg2.setStroke(Color.BLACK);
        pane.setOnMouseDragged(evt -> { 
                head.setCenterX(evt.getX()-dx);
                head.setCenterY(evt.getY()-dy);
                torso.setStartX(evt.getX()-dx);
                torso.setEndX(evt.getX()-dx); 
                torso.setStartY(evt.getY()-dy+ head.getRadius());
                torso.setEndY(evt.getY()-dy+ head.getRadius() + TORSO_HEIGHT); 
                hand.setStartX(evt.getX()-dx-2*head.getRadius());
                hand.setEndX(evt.getX()-dx + 2*head.getRadius()); 
                hand.setStartY(head.getCenterY()-dy +2*head.getRadius());
                hand.setEndY(head.getCenterY()-dy + 2*head.getRadius()); 
                leg1.setStartX(evt.getX()-dx);
                leg1.setEndX(evt.getX()-dx - 2*head.getRadius()); 
                leg1.setStartY(head.getCenterY()-dy + head.getRadius() + TORSO_HEIGHT);
                leg1.setEndY(head.getCenterY() -dy+ 5.5*head.getRadius()); 
                leg2.setStartX(evt.getX()-dx);
                leg2.setEndX(evt.getX()-dx + 2*head.getRadius()); 
                leg2.setStartY(head.getCenterY() -dy+ head.getRadius() + TORSO_HEIGHT);
                leg2.setEndY(head.getCenterY() -dy+ 5.5*head.getRadius()); 
                
                for (int i = theCircles.size() - 1; i >= 0; i--) {
                    Circle theCircle = theCircles.get(i); 
                    
                    double x1 = theCircle.getCenterX(), y1 = theCircle.getCenterY(), x2 = hand.getEndX(), y2 = hand.getEndY();
                    double d = java.lang.Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
                
                    if(d<=theCircle.getRadius()){
                        int otherOne = new java.util.Random().nextInt(theCircles.size()); 
                        while (otherOne == i) 
                            otherOne = new java.util.Random().nextInt(theCircles.size());
                        Circle otherCircle = theCircles.get(otherOne);
                        otherCircle.setRadius(otherCircle.getRadius()+10);
                        theCircle.setRadius(otherCircle.getRadius()-10);
                        if(theCircle.getRadius()<5){
                            pane.getChildren().remove(theCircle); 
                            theCircles.remove(theCircle);
                        }
                    }
                }
            });
        pane.setOnMousePressed(evt -> {
                dx = evt.getX() - head.getCenterX();
                dy = evt.getY() - head.getCenterY(); 
            });
        pane.setOnMouseClicked(evt -> { 
                if (evt.getButton() == MouseButton.SECONDARY) {
                   // if(circle==null){
                        Circle circle = new Circle(); 
                        circle.setRadius(new java.util.Random().nextInt(50)+25); 
                        circle.setCenterX(evt.getX()); 
                        circle.setCenterY(evt.getY());
                        circle.setStroke(Color.BLACK);
                        circle.setFill(Color.rgb(new java.util.Random().nextInt(256), new java.util.Random().nextInt(256), new java.util.Random().nextInt(256)));
                        pane.getChildren().add(circle);
                        theCircles.add(circle);
                    //}else{
                      //  circle.setCenterX(evt.getX()); 
                      //  circle.setCenterY(evt.getY());
                    //}
                    // FILL IN THE DETAILS 
                }
            });
        pane.getChildren().addAll(head,torso,hand,leg1,leg2);
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT); 
        primaryStage.setScene(scene); 
        primaryStage.setTitle("Lab11"); 
        primaryStage.show();

    }
}

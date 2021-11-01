package sample;
//faire 9 rectangle avec les pos, mettre les 9 image avec un num qui correspond a leur emplacement qu.ils doivent aller verifie
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    public static void main(String[] args) {launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("PUZZLE");
        primaryStage.setWidth(600);
        primaryStage.setHeight(637);
        primaryStage.setResizable(true);

        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("BRAVO");
        win.setHeaderText("TU AS REUSSIT LE PUZZLE");
        Image image1 = new Image("file:mario0.jpg");
        ImageView i1= new ImageView();
        i1.setOnDragDetected((event)->{
            Dragboard dragboard = i1.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i1.getImage());
            dragboard.setContent(contenu);
        });
        Image image2 = new Image("file:mario1.jpg");
        ImageView i2= new ImageView();
        i2.setOnDragDetected((event)->{
            Dragboard dragboard = i2.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i2.getImage());
            dragboard.setContent(contenu);
        });
        Image image3 = new Image("file:mario2.jpg");
        ImageView i3= new ImageView();
        i3.setOnDragDetected((event)->{
            Dragboard dragboard = i3.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i3.getImage());
            dragboard.setContent(contenu);
        });
        Image image4 = new Image("file:mario3.jpg");
        ImageView i4= new ImageView();
        i4.setOnDragDetected((event)->{
            Dragboard dragboard = i4.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i4.getImage());
            dragboard.setContent(contenu);
        });
        Image image5 = new Image("file:mario4.jpg");
        ImageView i5= new ImageView();
        i5.setOnDragDetected((event)->{
            Dragboard dragboard = i5.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i5.getImage());
            dragboard.setContent(contenu);
        });
        Image image6 = new Image("file:mario5.jpg");
        ImageView i6= new ImageView();
        i6.setOnDragDetected((event)->{
            Dragboard dragboard = i6.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i6.getImage());
            dragboard.setContent(contenu);
        });
        Image image7 = new Image("file:mario6.jpg");
        ImageView i7= new ImageView();
        i7.setOnDragDetected((event)->{
            Dragboard dragboard = i7.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i7.getImage());
            dragboard.setContent(contenu);
        });
        Image image8 = new Image("file:mario7.jpg");
        ImageView i8= new ImageView();
        i8.setOnDragDetected((event)->{
            Dragboard dragboard = i8.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i8.getImage());
            dragboard.setContent(contenu);
        });
        Image image9 = new Image("file:mario8.jpg");
        ImageView i9= new ImageView();
        i9.setOnDragDetected((event)->{
            Dragboard dragboard = i9.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent contenu = new ClipboardContent();
            contenu.putImage(i9.getImage());
            dragboard.setContent(contenu);
        });
        ArrayList<Image> images = new ArrayList(Arrays.asList(image1, image2, image3, image4, image5, image6, image7, image8, image9));
        ArrayList<ImageView> imageViews = new ArrayList(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9));
        ArrayList<Image> imagesparf = new ArrayList(Arrays.asList(image1, image2, image3, image4, image5, image6, image7, image8, image9));



        int y=0;
        do{
            int x=(int) (Math.random()* images.size());
            imageViews.get(y).setImage(images.get(x));
            images.remove(x);
            y++;
        }while (y!=9);
        for (int x=0; x< imageViews.size();x++){
            images.add(imageViews.get(x).getImage());
        }
        win.setOnCloseRequest((event)->{
            int l=0;
            do{
                int x=(int) (Math.random()* images.size());
                imageViews.get(l).setImage(images.get(x));
                images.remove(x);
                l++;
            }while (l!=9);
            for (ImageView imageView : imageViews) {
                images.add(imageView.getImage());
            }
        });
        HBox topi = new HBox(imageViews.get(0),imageViews.get(1),imageViews.get(2));
        HBox midi = new HBox(imageViews.get(3),imageViews.get(4),imageViews.get(5));
        HBox boti = new HBox(imageViews.get(6),imageViews.get(7),imageViews.get(8));
        VBox seti = new VBox(topi,midi,boti);
        
        i1.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i1.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i1.getImage());
            i1.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });
        i2.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i2.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i2.getImage());
            i2.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });i3.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i3.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i3.getImage());
            i3.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });i4.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i4.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i4.getImage());
            i4.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });i5.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i5.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i5.getImage());
            i5.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });i6.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i6.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i6.getImage());
            i6.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });i7.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i7.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i7.getImage());
            i7.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });
        i8.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i8.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i8.getImage());
            i8.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();
            }
        });
        i9.setOnDragOver((event)->{
            event.acceptTransferModes(TransferMode.MOVE);

        });
        i9.setOnDragDropped((event)->{
            ImageView  source = (ImageView) event.getGestureSource();
            Image content = source.getImage();
            source.setImage(i9.getImage());
            i9.setImage(content);
            if(verif(imageViews,imagesparf)){
                win.show();

            }
        });

        StackPane root = new StackPane(seti);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed((event)->{
            if(event.isControlDown()&&event.getCode()==KeyCode.M){
                int l=0;
                do{
                    int x=(int) (Math.random()* images.size());
                    imageViews.get(l).setImage(images.get(x));
                    images.remove(x);
                    l++;
                }while (l!=9);
                for (ImageView imageView : imageViews) {
                    images.add(imageView.getImage());
                }
            }
        }
        );



        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public boolean verif (ArrayList<ImageView> imagesViews,ArrayList<Image> images){
        boolean win=false;
        int y=0;
        for(int x =0; x<imagesViews.size();x++){
            if(imagesViews.get(x).getImage()==images.get(x))
                y++;
        }
        if(y==9)
            win=true;
        return win;
    }
}



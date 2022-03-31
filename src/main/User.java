package main;

import javafx.stage.Stage;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class User implements IRiverCrossingController
{
    static int valid;
    boolean level;
    Level1 level1;
    Level2 level2;
    GameScreenController game;
    final int initx = 500;
    final int inity = 400;
    ArrayList <Sprite> rightBankCrossers = new ArrayList<Sprite>();
    ArrayList <Sprite> leftBankCrossers = new ArrayList<Sprite>();
    ArrayList <Sprite> spritescopy;
    Sprite spriteCopy;
    Sprite[] crossers ;
    Stage stage;
    private static User user;
    static ArrayList<Sprite> sprites;
    Stack<ArrayList<Sprite>> undo;
    Stack<ArrayList<Sprite>> redo;
     private User()
    {
        crossers = new Sprite[4];
        game = new GameScreenController();
        level1 = Level1.getLevel1();
        level2 = Level2.getLevel2();
        sprites = new ArrayList<>();
        undo = new Stack<>();
        redo = new Stack<>();
    }
    public static User getUser()
    {
        if(user == null)
            user = new User();
        return user;
    }
    @Override
    public void newGame(int level)
    {
        if(level == 1)
        {
            level1.getInitialCrossers();
            getInstructions(level);
        }
        else if(level == 2)
        {
            level2.getInitialCrossers();
            getInstructions(level);
        }
    }

    @Override
    public void resetGame(int level)
    {
        newGame(level);
    }

    @Override
    public void getInstructions(int level)
    {
        if(level==1)
        {
            level1.getInstructions();
        }
        else if (level == 2)
        {
            level2.getInstructions();
        }
    }

    @Override
    public void getCrossersOnRightBank()
    {

        for(int i =0 ; i<2 ; i++)
        {
            crossers[i] =level1.crossers.get(i);
        }
        for(int i =0; i<3;i++)
        {
            if(crossers[i] !=  game.boatCrossers.get(i))
            {
                rightBankCrossers.add(crossers[i]);
            }
        }
    }

    @Override
    public void getCrossersOnLeftBank()
    {
        for(int i =0 ; i<2 ; i++)
        {
            crossers[i] =level1.crossers.get(i);
        }
        for(int i =0; i<3;i++)
        {
            if(crossers[i] !=  game.boatCrossers.get(i))
            {
                leftBankCrossers.add(crossers[i]);
            }
        }
    }

    @Override
    public boolean isBoatOnLeftBank(int x,int y)
    {
        if(x == initx&& y == inity)
        {
            return true;
        }
        return false;
    }

    @Override
    public int getNumberOfSails()
    {
        return 0;
    }

    @Override
    public boolean canMove(List boatCrossers,int size)
    {
        boolean canmove = false;
        int y=4;
        //getCrossersOnLeftBank();
        for (int i=0;i<size;i++)
        {
            if(boatCrossers.get(i).equals(level1.farmer)||boatCrossers.get(i).equals(level2.farmer1)||boatCrossers.get(i).equals(level2.farmer2)||boatCrossers.get(i).equals(level2.farmer3)||boatCrossers.get(i).equals(level2.farmer4))
            {
                canmove = true;
            }
        }
        return canmove;
    }

    @Override
    public void doMove()
    {

    }

    @Override
    public boolean canUndo()
    {
        return false;
    }

    @Override
    public boolean canRedo()
    {
        return false;
    }

    @Override
    public void Undo()
    {
    }

    @Override
    public void Redo()
    {
    }

    @Override
    public void SaveGame(List sprites,int score)
    {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("sprites");
            doc.appendChild(rootElement);//////
            // sprite element...
            Element sprite = doc.createElement("sprite");
            rootElement.appendChild(sprite);
            if(sprites.size()==5) {
                valid=1;
                for (int i = 0; i < sprites.size(); i++) {
                    if (sprites.get(i).equals(level1.raft)) {
                        // boat
                        Attr attr = doc.createAttribute("boat");
                        attr.setValue("boat");
                        sprite.setAttributeNode(attr);
                        Element coordinatex = doc.createElement("boatx");
                        Attr attrType = doc.createAttribute("x");
                        attrType.setValue("x position");
                        coordinatex.setAttributeNode(attrType);
                        coordinatex.appendChild(doc.createTextNode(Double.toString(level1.raft.posX)));
                        sprite.appendChild(coordinatex);

                        Element coordinatey = doc.createElement("boaty");
                        Attr attrType1 = doc.createAttribute("y");
                        attrType1.setValue("y position");
                        coordinatey.setAttributeNode(attrType1);
                        coordinatey.appendChild(doc.createTextNode(Double.toString(level1.raft.posY)));
                        sprite.appendChild(coordinatey);
                    } else if (sprites.get(i).equals(level1.farmer1)) {
                        // farmer
                        Attr attr1 = doc.createAttribute("farmer");
                        attr1.setValue("farmer");
                        sprite.setAttributeNode(attr1);

                        Element coordinatex1 = doc.createElement("farmerx");
                        Attr attrType2 = doc.createAttribute("x");
                        attrType2.setValue("x position");
                        coordinatex1.setAttributeNode(attrType2);
                        coordinatex1.appendChild(doc.createTextNode(Double.toString(level1.farmer1.posX)));
                        sprite.appendChild(coordinatex1);

                        Element coordinatey1 = doc.createElement("farmery");
                        Attr attrType3 = doc.createAttribute("y");
                        attrType3.setValue("y position");
                        coordinatey1.setAttributeNode(attrType3);
                        coordinatey1.appendChild(doc.createTextNode(Double.toString(level1.farmer1.posY)));
                        sprite.appendChild(coordinatey1);
                    } else if (sprites.get(i).equals(level1.lion1)) {
                        // lion
                        Attr attr2 = doc.createAttribute("lion");
                        attr2.setValue("lion");
                        sprite.setAttributeNode(attr2);

                        Element coordinatex2 = doc.createElement("lionx");
                        Attr attrType4 = doc.createAttribute("x");
                        attrType4.setValue("x position");
                        coordinatex2.setAttributeNode(attrType4);
                        coordinatex2.appendChild(doc.createTextNode(Double.toString(level1.lion1.posX)));
                        sprite.appendChild(coordinatex2);

                        Element coordinatey2 = doc.createElement("liony");
                        Attr attrType5 = doc.createAttribute("y");
                        attrType5.setValue("y position");
                        coordinatey2.setAttributeNode(attrType5);
                        coordinatey2.appendChild(doc.createTextNode(Double.toString(level1.lion1.posY)));
                        sprite.appendChild(coordinatey2);
                    } else if (sprites.get(i).equals(level1.rabbit1)) {
                        // rabbit
                        Attr attr3 = doc.createAttribute("rabbit");
                        attr3.setValue("rabbit");
                        sprite.setAttributeNode(attr3);

                        Element coordinatex3 = doc.createElement("rabbitx");
                        Attr attrType6 = doc.createAttribute("x");
                        attrType6.setValue("x position");
                        coordinatex3.setAttributeNode(attrType6);
                        coordinatex3.appendChild(doc.createTextNode(Double.toString(level1.rabbit1.posX)));
                        sprite.appendChild(coordinatex3);

                        Element coordinatey3 = doc.createElement("rabbity");
                        Attr attrType7 = doc.createAttribute("y");
                        attrType7.setValue("y position");
                        coordinatey3.setAttributeNode(attrType7);
                        coordinatey3.appendChild(doc.createTextNode(Double.toString(level1.rabbit1.posY)));
                        sprite.appendChild(coordinatey3);
                    } else if (sprites.get(i).equals(level1.plant1)) {
                        // plant
                        Attr attr4 = doc.createAttribute("plant");
                        attr4.setValue("plant");
                        sprite.setAttributeNode(attr4);

                        Element coordinatex4 = doc.createElement("plantx");
                        Attr attrType8 = doc.createAttribute("x");
                        attrType8.setValue("x position");
                        coordinatex4.setAttributeNode(attrType8);
                        coordinatex4.appendChild(doc.createTextNode(Double.toString(level1.plant1.posX)));
                        sprite.appendChild(coordinatex4);

                        Element coordinatey4 = doc.createElement("planty");
                        Attr attrType9 = doc.createAttribute("y");
                        attrType9.setValue("y position");
                        coordinatey4.setAttributeNode(attrType9);
                        coordinatey4.appendChild(doc.createTextNode(Double.toString(level1.plant1.posY)));
                        sprite.appendChild(coordinatey4);


                    }
                }
                //score
                Attr attr10 = doc.createAttribute("Score");
                attr10.setValue("score");
                sprite.setAttributeNode(attr10);

                Element score1 = doc.createElement("score");
                Attr attrType10 = doc.createAttribute("score");
                attrType10.setValue("score");
                score1.setAttributeNode(attrType10);
                score1.appendChild(doc.createTextNode(Integer.toString(ScoreController.score)));
                sprite.appendChild(score1);
                //level 1
                Attr attr30 = doc.createAttribute("leveltype");
                attr30.setValue("level type");
                sprite.setAttributeNode(attr30);

                Element level7 = doc.createElement("leveltype");
                Attr level8 = doc.createAttribute("level");
                level8.setValue("level type");
                level7.setAttributeNode(level8);
                level7.appendChild(doc.createTextNode("level1"));
                sprite.appendChild(level7);
            }
        else {
                valid=2;
                for (int i = 0; i < sprites.size(); i++) {
                    if (sprites.get(i).equals(level2.raft))//add raft to level 2 and ake it level2.raft
                    {
                        // boat
                        Attr attr = doc.createAttribute("boat");
                        attr.setValue("boat");
                        sprite.setAttributeNode(attr);
                        Element coordinatex = doc.createElement("boat2x");
                        Attr attrType = doc.createAttribute("x");
                        attrType.setValue("x position");
                        coordinatex.setAttributeNode(attrType);
                        coordinatex.appendChild(doc.createTextNode(Double.toString(level2.raft.posX)));
                        sprite.appendChild(coordinatex);

                        Element coordinatey = doc.createElement("boat2y");
                        Attr attrType1 = doc.createAttribute("y");
                        attrType1.setValue("y position");
                        coordinatey.setAttributeNode(attrType1);
                        coordinatey.appendChild(doc.createTextNode(Double.toString(level2.raft.posY)));
                        sprite.appendChild(coordinatey);
                    } else if (sprites.get(i).equals(level2.farmer11)) {
                        // farmer1
                        Attr attr1 = doc.createAttribute("farmer1");
                        attr1.setValue("farmer1");
                        sprite.setAttributeNode(attr1);

                        Element coordinatex1 = doc.createElement("farmer1x");
                        Attr attrType2 = doc.createAttribute("x");
                        attrType2.setValue("x position");
                        coordinatex1.setAttributeNode(attrType2);
                        coordinatex1.appendChild(doc.createTextNode(Double.toString(level2.farmer11.posX)));
                        sprite.appendChild(coordinatex1);

                        Element coordinatey1 = doc.createElement("farmer1y");
                        Attr attrType3 = doc.createAttribute("y");
                        attrType3.setValue("y position");
                        coordinatey1.setAttributeNode(attrType3);
                        coordinatey1.appendChild(doc.createTextNode(Double.toString(level2.farmer11.posY)));
                        sprite.appendChild(coordinatey1);
                    } else if (sprites.get(i).equals(level2.farmer22)) {
                        // farmer 2
                        Attr attr2 = doc.createAttribute("farmer2");
                        attr2.setValue("farmer2");
                        sprite.setAttributeNode(attr2);

                        Element coordinatex2 = doc.createElement("farmer2x");
                        Attr attrType4 = doc.createAttribute("x");
                        attrType4.setValue("x position");
                        coordinatex2.setAttributeNode(attrType4);
                        coordinatex2.appendChild(doc.createTextNode(Double.toString(level2.farmer22.posX)));
                        sprite.appendChild(coordinatex2);

                        Element coordinatey2 = doc.createElement("farmer2y");
                        Attr attrType5 = doc.createAttribute("y");
                        attrType5.setValue("y position");
                        coordinatey2.setAttributeNode(attrType5);
                        coordinatey2.appendChild(doc.createTextNode(Double.toString(level2.farmer22.posY)));
                        sprite.appendChild(coordinatey2);
                    } else if (sprites.get(i).equals(level2.farmer33)) {
                        // farmer 3
                        Attr attr3 = doc.createAttribute("farmer3");
                        attr3.setValue("farmer3");
                        sprite.setAttributeNode(attr3);

                        Element coordinatex3 = doc.createElement("farmer3x");
                        Attr attrType6 = doc.createAttribute("x");
                        attrType6.setValue("x position");
                        coordinatex3.setAttributeNode(attrType6);
                        coordinatex3.appendChild(doc.createTextNode(Double.toString(level2.farmer33.posX)));
                        sprite.appendChild(coordinatex3);

                        Element coordinatey3 = doc.createElement("farmer3y");
                        Attr attrType7 = doc.createAttribute("y");
                        attrType7.setValue("y position");
                        coordinatey3.setAttributeNode(attrType7);
                        coordinatey3.appendChild(doc.createTextNode(Double.toString(level2.farmer33.posY)));
                        sprite.appendChild(coordinatey3);
                    } else if (sprites.get(i).equals(level2.farmer44)) {
                        // farmer 4
                        Attr attr4 = doc.createAttribute("farmer4");
                        attr4.setValue("farmer4");
                        sprite.setAttributeNode(attr4);

                        Element coordinatex4 = doc.createElement("farmer4x");
                        Attr attrType8 = doc.createAttribute("x");
                        attrType8.setValue("x position");
                        coordinatex4.setAttributeNode(attrType8);
                        coordinatex4.appendChild(doc.createTextNode(Double.toString(level2.farmer44.posX)));
                        sprite.appendChild(coordinatex4);

                        Element coordinatey4 = doc.createElement("farmer4y");
                        Attr attrType9 = doc.createAttribute("y");
                        attrType9.setValue("y position");
                        coordinatey4.setAttributeNode(attrType9);
                        coordinatey4.appendChild(doc.createTextNode(Double.toString(level2.farmer44.posY)));
                        sprite.appendChild(coordinatey4);
                    } else if (sprites.get(i).equals(level2.rabbit1)) {
                        // rabbit
                        Attr attr20 = doc.createAttribute("rabbit");
                        attr20.setValue("rabbit");
                        sprite.setAttributeNode(attr20);

                        Element coordinatex20 = doc.createElement("rabbit2x");
                        Attr attrType20 = doc.createAttribute("x");
                        attrType20.setValue("x position");
                        coordinatex20.setAttributeNode(attrType20);
                        coordinatex20.appendChild(doc.createTextNode(Double.toString(level2.rabbit1.posX)));
                        sprite.appendChild(coordinatex20);

                        Element coordinatey20 = doc.createElement("rabbit2y");
                        Attr attrType21 = doc.createAttribute("y");
                        attrType20.setValue("y position");
                        coordinatey20.setAttributeNode(attrType21);
                        coordinatey20.appendChild(doc.createTextNode(Double.toString(level2.rabbit1.posY)));
                        sprite.appendChild(coordinatey20);
                    }

                }
                //score
                Attr attr10 = doc.createAttribute("Score");
                attr10.setValue("score");
                sprite.setAttributeNode(attr10);

                Element score1 = doc.createElement("score");
                Attr attrType10 = doc.createAttribute("score");
                attrType10.setValue("score");
                score1.setAttributeNode(attrType10);
                score1.appendChild(doc.createTextNode(Integer.toString(Score2Controller.score)));
                sprite.appendChild(score1);
                //level 1
                Attr attr30 = doc.createAttribute("leveltype");
                attr30.setValue("level type");
                sprite.setAttributeNode(attr30);

                Element level7 = doc.createElement("leveltype");
                Attr level8 = doc.createAttribute("level");
                level8.setValue("level type");
                level7.setAttributeNode(level8);
                level7.appendChild(doc.createTextNode("level2"));
                sprite.appendChild(level7);
            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("savedGame1.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void LoadGame()
    {
       ////////////////////
        try {
            File inputFile = new File("savedGame1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("sprite");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println(eElement.getAttribute("x"));
           //         if(eElement.getElementsByTagName("leveltype").item(0).getTextContent().equals("level1"))
             if(valid == 1)
                    {

                        //boat
                        System.out.println("boatX value : "
                                + eElement
                                .getElementsByTagName("boatx")
                                .item(0)
                                .getTextContent());
                        GameScreenController.raftx = Double.parseDouble(eElement.getElementsByTagName("boatx").item(0).getTextContent());
                        System.out.println("boatY value : "
                                + eElement
                                .getElementsByTagName("boaty")
                                .item(0)
                                //farmer
                                .getTextContent());
                        GameScreenController.rafty = Double.parseDouble(eElement.getElementsByTagName("boaty").item(0).getTextContent());
                        System.out.println("farmerX value : "
                                + eElement
                                .getElementsByTagName("farmerx")
                                .item(0)
                                .getTextContent());
                        GameScreenController.farmerx = Double.parseDouble(eElement.getElementsByTagName("farmerx").item(0).getTextContent());
                        System.out.println("farmerY value : "
                                + eElement
                                .getElementsByTagName("farmery")
                                .item(0)
                                .getTextContent());
                        GameScreenController.farmery = Double.parseDouble(eElement.getElementsByTagName("farmery").item(0).getTextContent());
                        //lion
                        System.out.println("lionX value : "
                                + eElement
                                .getElementsByTagName("lionx")
                                .item(0)
                                .getTextContent());
                        GameScreenController.lionx = Double.parseDouble(eElement.getElementsByTagName("lionx").item(0).getTextContent());
                        System.out.println("lionY value : "
                                + eElement
                                .getElementsByTagName("liony")
                                .item(0)
                                .getTextContent());
                        GameScreenController.liony = Double.parseDouble(eElement.getElementsByTagName("liony").item(0).getTextContent());
                        //rabbit
                        System.out.println("rabbitX value : "
                                + eElement
                                .getElementsByTagName("rabbitx")
                                .item(0)
                                .getTextContent());
                        GameScreenController.rabbitx = Double.parseDouble(eElement.getElementsByTagName("rabbitx").item(0).getTextContent());
                        System.out.println("rabbitY value : "
                                + eElement
                                .getElementsByTagName("rabbity")
                                .item(0)
                                .getTextContent());
                        GameScreenController.rabbity = Double.parseDouble(eElement.getElementsByTagName("rabbity").item(0).getTextContent());
                        //plant
                        System.out.println("plantX value : "
                                + eElement
                                .getElementsByTagName("plantx")
                                .item(0)
                                .getTextContent());
                        GameScreenController.plantx = Double.parseDouble(eElement.getElementsByTagName("plantx").item(0).getTextContent());
                        System.out.println("plantY value : "
                                + eElement
                                .getElementsByTagName("planty")
                                .item(0)
                                .getTextContent());
                        GameScreenController.planty = Double.parseDouble(eElement.getElementsByTagName("planty").item(0).getTextContent());
                        System.out.println("score value : "
                                + eElement
                                .getElementsByTagName("score")
                                .item(0)
                                .getTextContent());
                        GameScreenController.loadscore = Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                    }
                    else {
                        //////////////////////////////////////////////////level 2
                        System.out.println("boatX value : "
                                + eElement
                                .getElementsByTagName("boat2x")
                                .item(0).getTextContent());
                        Level2Screen.raftx = Double.parseDouble(eElement.getElementsByTagName("boat2x").item(0).getTextContent());
                        System.out.println("boatY value : "
                                + eElement
                                .getElementsByTagName("boat2y")
                                .item(0)
                                //farmer 1
                                .getTextContent());
                        Level2Screen.rafty = Double.parseDouble(eElement.getElementsByTagName("boat2y").item(0).getTextContent());
                        System.out.println("farmer1X value : "
                                + eElement
                                .getElementsByTagName("farmer1x")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer1x = Double.parseDouble(eElement.getElementsByTagName("farmer1x").item(0).getTextContent());
                        System.out.println("farmer1Y value : "
                                + eElement
                                .getElementsByTagName("farmer1y")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer1y = Double.parseDouble(eElement.getElementsByTagName("farmer1y").item(0).getTextContent());
                        //farmer 2
                        System.out.println("farmer2X value : "
                                + eElement
                                .getElementsByTagName("farmer2x")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer2x = Double.parseDouble(eElement.getElementsByTagName("farmer2x").item(0).getTextContent());
                        System.out.println("farmer2Y value : "
                                + eElement
                                .getElementsByTagName("farmer2y")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer2y = Double.parseDouble(eElement.getElementsByTagName("farmer2y").item(0).getTextContent());
                        //farmer 3
                        System.out.println("farmer3X value : "
                                + eElement
                                .getElementsByTagName("farmer3x")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer3x = Double.parseDouble(eElement.getElementsByTagName("farmer3x").item(0).getTextContent());
                        System.out.println("farmer3Y value : "
                                + eElement
                                .getElementsByTagName("farmer3y")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer3y = Double.parseDouble(eElement.getElementsByTagName("farmer3y").item(0).getTextContent());
                        //farmer 4
                        System.out.println("farmer4X value : "
                                + eElement
                                .getElementsByTagName("farmer4x")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer4x = Double.parseDouble(eElement.getElementsByTagName("farmer4x").item(0).getTextContent());
                        System.out.println("farmer4Y value : "
                                + eElement
                                .getElementsByTagName("farmer4y")
                                .item(0)
                                .getTextContent());
                        Level2Screen.farmer4y = Double.parseDouble(eElement.getElementsByTagName("farmer4y").item(0).getTextContent());
                        //rabbit
                        System.out.println("rabbitX value : "
                                + eElement
                                .getElementsByTagName("rabbit2x")
                                .item(0)
                                .getTextContent());
                        Level2Screen.rabbitx = Double.parseDouble(eElement.getElementsByTagName("rabbit2x").item(0).getTextContent());
                        System.out.println("rabbitY value : "
                                + eElement
                                .getElementsByTagName("rabbit2y")
                                .item(0)
                                .getTextContent());
                        Level2Screen.rabbity = Double.parseDouble(eElement.getElementsByTagName("rabbit2y").item(0).getTextContent());
                        System.out.println("score value : "
                                + eElement
                                .getElementsByTagName("score")
                                .item(0)
                                .getTextContent());
                        Level2Screen.loadscore = Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SolveGame()
    {
    }

    public int getValid() {
        return valid;
    }
}

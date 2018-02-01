/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Anjay
 */
public class Checkerboard {
    private int nRows;
    private int nCols;
    private double bWidth;
    private double bHeight;
    private Color lColor;
    private Color dColor;
    private AnchorPane Board;
    
    public Checkerboard( int numRows, int numCols, double boardWidth,
double boardHeight)
    {
       this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public Checkerboard( int numRows, int numCols, double boardWidth,
double boardHeight, Color lightColor, Color darkColor)
    {
       this.nRows = numRows;
       this.nCols = numCols;
       this.bWidth = boardWidth;
       this.bHeight = boardHeight;
       this.lColor = lightColor;
       this.dColor = darkColor;
         
    }

    public int getNumRows()
    {
        return nRows;
    } 
    public int getNumCols()
    {
        return nCols;
    }
    
    public double getWidth()
    {
        return bWidth;
        
    }
    public double getHeight()
    {
        return bHeight;
    }
    public Color getLightColor()
    {
        return lColor;
    }
    public Color getDarkColor()
    {
        return dColor;
    }
    public double getRectangleWidth()
    {
        return  Math.ceil(bWidth/nCols);
    }
    public double getRectangleHeight()
    {
        return Math.ceil(bHeight/nRows);
    }
    
    public AnchorPane getBoard()
    {
       
        return Board;
    }
    
    public AnchorPane build()
    {
        Board = new AnchorPane();
        for (int row = 0; row < this.getNumRows(); row++) {
            for (int col = 0; col < this.getNumCols(); col++) {
                Rectangle rect;
                if(row%2 == col%2)
                {
                    rect = new Rectangle(this.getRectangleWidth(), this.getRectangleHeight(), lColor);  
                        
                }
                else
                {
                    rect = new Rectangle(this.getRectangleWidth(), this.getRectangleHeight(), dColor);
                }
                rect.setX(this.getRectangleWidth()*col);
                rect.setY(this.getRectangleHeight()*row);
                Board.getChildren().add(rect);
            }  
        }
        return Board;
        
    }
}

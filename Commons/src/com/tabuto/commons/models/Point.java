/**
* @author Francesco di Dio
* Date: 11 Ottobre 2010 20.36
* Titolo: Point.java
* Versione: 0.2.2 Rev.:1
*/


package com.tabuto.commons.models;

import java.io.Serializable;



/*
 * Copyright (c) 2010 Francesco di Dio.
 * tabuto83@gmail.com 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Classe che rappresenta un generico Punto sul Piano Cartesiano
 * 
 */

/**
 * <code>Point</code> 
 * <p>
 * Point is a class that represents a Point in the 2D Cartesian Plane.
 * <p>
 *
 * 
 * @author tabuto83
 * 
 * @version 0.2.2
 * 
 * 
 */

public class Point implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1532905975817848364L;

	/**
	 * Point's x coordinate
	 */
	public double x;
	/**
	 * Point's y coordinate
	 */
	public double y;

	/**
     * 
     * 	CONSTRUCTOR
     *  <p>
     *  Point()
     *  <p>
     * 	Creates new <code>Point</code> in Cartesian Plane with coordinates [0,0]
     *  <p>
     *  @see Point#Point(double, double)
     */
	

	public Point(){ x=0;y=0; }
	
	/**
	 *  CONTRUCTOR
	 *  <p>
	 *  Point(double a, double b)
	 *  <p>
	 *  Creates new <code>Point</code> in Cartesian Plane with coordinates [0,0]
	 *  <p>
	 *  @see Point#Point()
	 */
	public Point(double a, double b) { setPoint(a,b); }
	
	/**
	 * Accept two double numbers as the new Point's coordinates 
	 * @param a <code>double</code> The X coordinates of the new Point
	 * @param b <code>double</code> The X coordinates of the new Point
	 */
	public void setPoint(double a, double b){this.x=a; this.y=b;}
	
	/**
	 * Return the x Point's coordinates
	 * @return The Point's x coordinate 
	 */
	public double getX(){return this.x;}
	
	/**
	 * Return the x Point's coordinates
	 * @return The Point's y coordinate
	 */
	public double getY(){return this.y;}
	
	/**
	 * Set the new x coordinates of the <code>Point</code>
	 * @param a <code>double</code> Point's X coordinate
	 */
	public void setX(double a){this.x =a;}
	
	/**
	 * Set the new y coordinates of the <code>Point</code>
	 * @param a <code>double</code> Point's Y coordinate
	 */
	public void setY(double a){this.y =a;}
	
	/**
	 * Return the distance beetwin the <code>Point</code> p and this <code>Point</code>
	 * @param p <code>Point</code> The second point for calculate distance
	 * @return The Distance between points
	 */
	public double getDistance(Point p)
	{
		   double temp1 =  (  this.x - p.x) *  (  this.x - p.x ) ;
	       double temp2 =  (  this.y - p.y) *  (  this.y - p.y);
		   return   ( Math.sqrt( temp1 + temp2 ) );
	}
	
	/**
	 * Return <code>true</code> if the coordinates of two points are the same
	 */
	public boolean equalsTo(Point p)
	{
		if ( (this.x == p.getX() ) && ( this.y == p.getY() ) )
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		return "["+this.x+", " + this.y +"]";
	}
}

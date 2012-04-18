/**
* @author Francesco di Dio
* Date: 10 Novembre 2010 20.36
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


//Questa classe rappresenta un vettore nel piano BIDIMENSIONALE

/**
 * <code>Vettore</code> 
 * <p>
 * Vettore is a class that represents a Vector in the 2D Cartesian Plane.
 * <p>
 * Each Vettore has: 
 * <ul>
 * 		<li> {@link #module} <br>
 * 		<li> {@link #direction}<br>
 * 		<li> {@link #origin}<br>
 * 		<li> {@link #end} <br>
 * 		<li> Two components: {@link #i} and {@link #j}<br>
 * 		</ul>
 * <p>
 * By Default every Vettore live in a Cartesian Plane with origin's coordinate point
 * setting by default in the high left corner. But you can change the {@linkplain Vettore#JRif}
 * boolean value to <code>false</code> to accepts negative values coordinates by add it at the end 
 * of Constructor parameters.
 * <p>
 * You can add <code>Vettore</code> to each other using the {@link Vettore#add(Vettore)} method, or setting
 * a new position using appropriate methods.<br>
 * N.B.The Standard direction verse has a counterclockwise pattern:
* 
* <ul>
* <li> North direction is 3*PI/2 or 270°<br>
* <li> Est direction is 0.0 or 2*PI (0° or 360°)<br>
* <li> South direction is PI/2 or 90°<br>
* <li> West direction is PI or 180°<br>
* </ul>
 * 
 * @author tabuto83
 * 
 * @version 0.2.2
 * 
 * 
 */
public class Vettore implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5928225620606541488L;

	/**
	 * Origin {@link Point} of the vector
	 */
	public Point origin;
	
	/**
	 * End {@link Point} of the vector
	 */
	public Point end;
	
	/**
	 *  Flag to calculate the coordinate with the Java Standard:
	 *  The origin Point (0,0) is setting on the high left corner.
	 *  <br>
	 *  So, the coordinates are therefore always positive values.
	 *  <br>
	 *  This flag is <code>true</code> by default
	 */
	protected boolean JRif = true;
	
	/**
	 * The x coordinate's component
	 */
	protected double i; //Componente x 
	
	/**
	 * The y coordinate's component
	 */
	protected double j; //Componente y
	
	/**
	 * Direction of the Vettore is expressed in radians; Direction has values between 0 and 2*Math.PI.
	 * The Standard direction verse has a counterclockwise pattern:
	 * 
	 * <ul>
	 * <li> North direction is 3*PI/2 or 270°<br>
	 * <li> Est direction is 0.0 or 2*PI (0° or 360°)<br>
	 * <li> South direction is PI/2 or 90°<br>
	 * <li> West direction is PI or 180°<br>
	 * <ul>
	 */
	protected double direction; //direzione del vettore in radianti
	
	/**
	 * Vettore's module
	 */
	protected double module; //modulo del vettore
	
	/**
	 * Indicate the current verse of Vettore; NOT YET USED
	 */
	protected boolean verse = true; //Unused
	
	/**
	 * The current number error. This value  is important 
	 * to get consistent results beyond the error introduced by finite precision.
	 * <br>Default value is 0.00001 or 1x10E-5
	 * @see Vettore#setPrecision(double)
	 * @see Vettore#getPrecision()
	 */
	private double eps = 0.00001;

/*
* **************************************************************
* COSTRUTTORI
*/
	/**
	 * CONSTRUCTOR
	 * <p>
	 * Vettore()
	 * <p>
	 * Creates new <code>Vettore</code> where {@link #module}, {@link #direction}
	 * Components [{@link #i},{@link #j}], {@link Vettore#origin} and {@link Vettore#end} are setting to zero;
	 * <p>
	 * @see Vettore#Vettore(Point)
	 * @see Vettore#Vettore(double, double)
	 * @see Vettore#Vettore(Point, boolean)
	 * @see Vettore#Vettore(Point, Point)
	 * @see Vettore#Vettore(double, double, boolean)
	 * @see Vettore#Vettore(Point, double, double)
	 * @see Vettore#Vettore(Point, Point, boolean)
	 * @see Vettore#Vettore(double, double, double, double)
	 * @see Vettore#Vettore(Point, double, double, boolean)
	 * @see Vettore#Vettore(double, double, double, double, boolean)
	 */
	
public Vettore() 
{
	  origin = new Point(0,0);
	  end = new Point(0,0);
	  this.i=0;
	  this.j=0;
      this.setModule(0);
      this.setDirection(0);
      this.setComponentByPoints();	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(double double)
 * <p>
 * Creates new <code>Vettore</code> where {@link #module}, {@link #direction}
 * and Components  [{@link #i},{@link #j}] are setting to zero;
 * <br> The {@link Vettore#origin} and {@link Vettore#end} coordinates are [x,y];
 * <p>
 * @param x double
 * @param y double 
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore(double x, double y) 
{
	  origin = new Point(x,y);
	  end = new Point(x,y);
      setOrigin(x,y);
      setEnd(x,y);
      setModule(0);
      setDirection(0);
      setComponentByPoints();	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point)
 * <p>
 * Creates new <code>Vettore</code> where {@link #module}, {@link #direction} 
 * and components [{@link #i},{@link #j}] are zero;
 * <br> The {@link #origin} coordinates are setting by Point parameter;
 * <p>
 * @param o {@link Point}
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore(Point o) 
{
	this(o.x,o.y);	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(double double boolean)
 * <p>
 * Creates new <code>Vettore</code> where {@link #module}, {@link #direction} 
 * and components [{@link #i},{@link #j}] are zero;
 * <br> The {@link #origin}  and {@link #end}  coordinates are [x,y]; 
 * The boolean parameter set the {@link Vettore#JRif} variable;
 * <p>
 * @param x double
 * @param y double 
 * @param rif boolean
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */
public Vettore(double x, double y, boolean rif) 
{
      this.JRif = rif;
	  origin = new Point();
	  end = new Point();
      setOrigin(x,y);
      setEnd(x,y);
      setModule(0);
      setDirection(0);
      setComponentByPoints();	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point boolean)
 * <p>
 * Creates new <code>Vettore</code> where {@link #module}, {@link #direction} 
 * and components [{@link #i},{@link #j}] are zero;
 * <br> he {@link #origin}  and {@link #end}  coordinates are setting by {@link Point}; 
 * The boolean parameter set the {@link Vettore#JRif} variable;
 * <p>
 * @param o {@link Point}
 * @param rif boolean
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */
public Vettore(Point o, boolean rif ) 
{
	this.JRif = rif;
	  origin = new Point();
	  end = new Point();
    setOrigin(o.x,o.y);
    setEnd(o.x,o.y);
    setModule(0);
    setDirection(0);
    setComponentByPoints();	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(double x, double y, double d, double m)
 * <p>
 * Creates new <code>Vettore</code> setting m as new {@link #module}, d as new {@link #direction};
 * <br> The {@link #origin} coordinates are [x,y]; 
 * <p>
 * @param x double
 * @param y double 
 * @param d double
 * @param m double
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore(double x, double y, double d, double m) 
{
	  origin = new Point();
	  end = new Point();
      setOrigin(x,y);
      setModule(m);
      setDirection(d);
      setComponentByModule();
      setEnd(this.origin.getX() + this.i , this.origin.getY()+this.j );

		
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(double x, double y, double d, double m, boolean)
 * <p>
 * Creates new <code>Vettore</code> setting m as new {@link #module}, d as new {@link #direction};
 * <br> The {@link #origin} coordinates are [x,y]; 
 * The boolean parameter set the {@link Vettore#JRif} variable;
 * <p>
 * @param x double
 * @param y double 
 * @param d double
 * @param m double
 * @param rif boolean
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 */

public Vettore(double x, double y, double d, double m, boolean rif) 
{
        this.JRif = rif;
  	  	origin = new Point();
	    end = new Point();
        setOrigin(x,y);
        setModule(m);
        setDirection(d);
        setComponentByModule();
        setEnd(this.origin.getX() + this.i , this.origin.getY()+this.j );
}


/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point, double d, double m)
 * <p>
 * Creates new <code>Vettore</code> setting m as new {@link #module}, d as new {@link #direction};
 * <br> The {@link #origin} coordinates are setting by {@link Point} 
 * <p>
 * @param o Point
 * @param d double
 * @param m double
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(Point, double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore(Point o, double d, double m) 
{
  	  	origin = new Point();
	    end = new Point();
        setOrigin(o.getX(),o.getY());
        setModule(m);
        setDirection(d);
        setComponentByModule();
        setEnd(this.origin.getX() + this.i , this.origin.getY()+this.j );
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point, double d, double m, boolean)
 * <p>
 * Creates new <code>Vettore</code> setting m as new {@link #module}, d as new {@link #direction};
 * <br> The {@link #origin} coordinates are setting by {@link Point} 
 * The boolean parameter set the {@link Vettore#JRif} variable;
 * <p>
 * @param o Point
 * @param d double
 * @param m double
 * @param rif boolean
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore(Point o, double d, double m, boolean rif) 
{
        this.JRif = rif;
  	  	origin = new Point();
	    end = new Point();
        setOrigin(o.getX(),o.getY());
        setModule(m);
        setDirection(d);
        setComponentByModule();
        setEnd(this.origin.getX() + this.i , this.origin.getY()+this.j );
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point, Point)
 * <p>
 * Creates new <code>Vettore</code> setting {@link Point} [o] as 
 * new {@link #origin} and  {@link Point} [e] as new {@link #end} 
 * {@link #direction}, {@link #module} and Component [{@link #i},{@link #j}] are
 * setting in terms of this two Points.
 * <p>
 * @param o Point
 * @param e Point
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, Point, boolean)
 * @see Vettore#Vettore(Point, double, double)
 * @see Vettore#Vettore(double, double, double, double, boolean)
 */

public Vettore (Point o, Point e)
{
	origin = new Point();
	end = new Point();
	this.setOrigin(o.x, o.y);
	this.setEnd(e.x, e.y);
	this.setModule( o.getDistance(e) );
	this.setComponentByPoints();
	this.setDirectionByPoints(o, e);
	this.checkDirection();
	
}

/**
 * CONSTRUCTOR
 * <p>
 * Vettore(Point, Point, boolean)
 * <p>
 * Creates new <code>Vettore</code> setting {@link Point} [o] as 
 * new {@link #origin} and  {@link Point} [e] as new {@link #end} 
 * {@link #direction}, {@link #module} and Component [{@link #i},{@link #j}] are
 * setting in terms of this two Points.
 * The boolean parameter set the {@link Vettore#JRif} variable;
 * <p>
 * @param o Point
 * @param e Point
 * @param rif boolean
 * 
 * @see Vettore#Vettore()
 * @see Vettore#Vettore(Point)
 * @see Vettore#Vettore(Point, boolean)
 * @see Vettore#Vettore(Point, Point)
 * @see Vettore#Vettore(double, double)
 * @see Vettore#Vettore(double, double, boolean)
 * @see Vettore#Vettore(double, double, double, double)
 * @see Vettore#Vettore(Point, double, double)
 */

public Vettore (Point o, Point e, boolean rif)
{
	this.JRif = rif;
	  origin = new Point();
	  end = new Point();
	this.setOrigin(o.x, o.y);
	this.setEnd(e.x, e.y);
	this.setModule( o.getDistance(e) );
	this.setComponentByPoints();
	this.setDirectionByPoints(o, e);
	this.checkDirection();
	
}


/*
* **************************************************************
*  METODI PRIVATI e PROTETTI
*/

// Check the value of direction, and forces it to be between 0 and 2*PI
protected void checkDirection()
	{
	   // if (( this.origin.x > this.end.x  ) && (this.origin.y > this.end.y ) )
	   //		direction = direction + Math.PI;
		
		if (direction<0)
			direction = direction + 2*Math.PI;
		
		if (Math.toDegrees(direction)>360)
			direction =  Math.toRadians(  Math.toDegrees(direction)  % 360 );
	}

	
// Set the component in terms of module and direction
private void setComponentByModule()
	{
		this.i = this.module *  Math.cos(direction) ;
		this.j = this.module *  Math.sin(direction) ;
	}

//Set the component in terms of origin and End's points
private void setComponentByPoints()
	{
		this.i = this.end.x - this.origin.x;
		this.j = this.end.y - this.origin.y;
	}

//Set the direction 
protected void setDirection(double d)

	{
	if (d > 2*Math.PI)
		d = d % (2*Math.PI);
		if (d<0)
	      d = d + Math.PI;

		this.direction = d;
	}


//Set end point
protected void setEnd(double a, double b)
	{
		if (JRif)
		{
			if (a<0)
				a=0;
			if (b<0)
				b=0;
		}
		this.end.x=a;
		this.end.y=b;
	}

//set module
protected void setModule(double m)	
	{
	  if (m<0)
		m=0;
	  this.module=m;
	}

//set the origin point vector
protected void setOrigin(double a, double b)
	{
		if (JRif)
		{
			if (a<0)
				a=0;
			if (b<0)
				b=0;
		}
		this.origin.x=a;
		this.origin.y=b;
	}

/*
* **************************************************************
* METODI PUBBBLICI
*/

/**
 *  Return a new <code>Vettore</code> as sum of this and v <code>Vettore</code> parameter 
 *  @param v {@link Vettore}
 */
public Vettore add(Vettore v)
	{
		Point endPoint = new Point(this.origin.x + this.i + v.i, this.origin.y + this.j + v.j  );
		Vettore result = new Vettore(this.origin, endPoint);
		return result;
	}

/**
 * Return the product of the modules for the cosine of the angle betwee this vector and
 * the <code>Vettore</code> v parameter.
 * @param v {@link Vettore}
 * @return double scalar Product
 */
public double scalar(Vettore v)

{		double result;
		result = this.getModule() * v.getModule() * Math.cos( this.getDirectionRadians() - v.getDirectionRadians() );
		if (0 - Math.abs(result) < 0.000001 )
			result = 0;
		return result;
}

/**
 * Set the new value of <code>Vettore</code> components [{@link #i},{@link #j}] and update the values of 
 * {@link #module} , {@link #direction}
 * @param a double
 * @param b double
 */
public void setComponent(double a, double b)
	{
		//Change the vectore components
		this.i=a;
		this.j=b;

		this.end.x = this.origin.x + a;
		this.end.y = this.origin.y + b;

		this.setModule( origin.getDistance( this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}

/**
 * Set the new value of <code>Vettore</code> component {@link #i} and update the values of 
 * {@link #module} , {@link #direction}
 * @param a double
 */

public void setComponentX(double a)
	{

	//Change the vectore X component
		this.i=a;
		this.end.x = this.origin.x + a;
		this.setModule( this.origin.getDistance(this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}
/**
 * Set the new value of <code>Vettore</code> component {@link #j} and update the values of 
 * {@link #module} , {@link #direction}
 * @param a double
 */
public void setComponentY(double a)
	{
			//Change the vectore X component
		this.j=a;
		this.end.y = this.origin.y + a;
		this.setModule( this.origin.getDistance(end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}

/**
 * Return the <code>Vettore<code> value's component {@link #i}
 * @return double i
 */
public double getComponentX(){return this.i;}

/**
 * Return the <code>Vettore<code> value's component {@link #j}
 * @return double j
 */
public double getComponentY(){return this.j;}

/**
 * Set the new direction of <code>Vettore</code> in terms of slope between {@link #origin}  
 * and {@link #end} coordinates. 
 * <br>
 * THE {@link #origin} and {@link #end}  ARE NOT CHANGING BY THIS METHOD
 * @param o Point
 * @param e Point
 */

public void setDirectionByPoints(Point o, Point e )
{
	if ( Math.abs( (o.x - e.x) )< eps)
		this.direction= (Math.PI/2);
			if ( Math.abs( (o.y - e.y) )< eps)
				this.direction = 0;
	else
		this.setDirection( Math.atan( (o.y - e.y ) / (o.x - e.x) ) );
}


/**
 * Set the new direction of <code>Vettore</code> in terms of slope between Origin Point [ox,oy] coordinates 
 * and End Point [ex,ey] coordinates. 
 * <br>
 * THE {@link #origin} and {@link #end}  ARE NOT CHANGING BY THIS METHOD
 * @param ox double
 * @param oy double
 * @param ex double
 * @param ey double
 */
public void setDirectionByPoints(double ox,double oy,double ex,double ey )
{
	if ( Math.abs( (ox - ex) )< eps)
		this.direction= (Math.PI/2);
			if ( Math.abs( (oy - ey) )< eps)
				this.direction = 0;
	else
		this.setDirection( Math.atan( (oy - ey ) / (ox - ex) ) );
}
/**
 * Set the new {@link #direction} in degrees and calculate the new values of {@link #end}
 * and components [{@link #i}, {@link #j}]
 * @param d double 
 */
public void setNewDirectionDegree(int d)
	{
		//Change the direction, and the endPoint

		this.setDirection( Math.toRadians(d) );
		this.checkDirection();
		this.i = this.module *  Math.cos(direction) ;
		this.j = this.module *  Math.sin(direction) ;
		this.setEnd( this.origin.x + this.i , this.end.y + this.j  );
	}

/**
 * Set the new {@link #direction} in radians and calculare the new values of {@link #end}
 * and components [{@link #i}, {@link #j}]
 * @param rad double
 */
public void setNewDirectionRadians(double rad)
	{
			//Change the direction, and the endPoint
		this.setDirection( rad );
		this.checkDirection();
		this.i = this.module *  Math.cos(direction) ;
		this.j = this.module *  Math.sin(direction) ;
		this.setEnd( this.origin.x + this.i , this.end.y + this.j  );
	
	}

/**
 * Return the {@link #direction} value in radians
 * @return direction double
 */
public double getDirectionRadians(){return this.direction;}

/**
 * Return the {@link #direction} value in degrees
 * @return direction double
 */

public double getDirectionDegrees()
	{
		if (Math.toDegrees(this.direction)>360)
			return Math.toDegrees(this.direction)% 360;	
		else
			return Math.toDegrees(this.direction);
	}

/**
 * Set the new {@link #end} and calculate the new values of component [{@link #i}, {@link #j}], 
 * {@link #module} and {@link #direction}
 * @param e Point
 * 
 * @see  Vettore#setNewEnd(double,double)
 * @see Vettore#setNewEndX(double)
 * @see  Vettore#setNewEndY(double)
 */

public void setNewEnd(Point e)
	{
		this.setEnd( e.x, e.y);
		this.setComponentByPoints();
		this.setModule ( this.origin.getDistance(this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}
/**
 * Set the new {@link #end} coordinates and calculate the new values of component [{@link #i}, {@link #j}], 
 * {@link #module} and {@link #direction}
 * @param x double
 * @param y double
 * 
 * @see  Vettore#setNewEnd(Point)
 * @see Vettore#setNewEndX(double)
 * @see Vettore#setNewEndY(double)
 */
public void setNewEnd(double x, double y)
	{
		this.setEnd( x, y);
		this.setComponentByPoints();
		this.setModule ( this.origin.getDistance(this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}

/**
 * Set the new {@link #end} X coordinate and calculate the new values of component [{@link #i}, {@link #j}], 
 * {@link #module} and {@link #direction}
 * @param x double
 * @see Vettore#setNewEnd(double, double)
 * @see Vettore#setNewEnd(Point)
 * @see  Vettore#setNewEndY(double)
 */
public void setNewEndX(double x)
	{
		if (JRif)
			if (x<0)
				x=0;
		this.end.x=x;
		this.setComponentByPoints();
		this.setModule ( this.origin.getDistance(this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();

	}

/**
 * Set the new {@link #end} Y coordinate and calculate the new values of component [{@link #i}, {@link #j}],
 * {@link #module} and {@link #direction}
 * @param y double
 * @see Vettore#setNewEnd(double, double)
 * @see Vettore#setNewEnd(Point)
 * @see Vettore#setNewEndX(double)
 * 
 */

public void setNewEndY(double y)
	{
		if (JRif)
			if (y<0)
				y=0;
		this.end.y=y;
		this.setComponentByPoints();
		this.setModule ( this.origin.getDistance(this.end) );
		this.setDirection( Math.atan( (this.origin.y - this.end.y ) / (this.origin.x - this.end.x) ) );
		this.checkDirection();
	}


/**
 * Set the new {@link #module} value  and calculate the new value of component [{@link #i}, {@link #j}], 
 * and {@link #end}, this method leaves unchanged {@link #origin} and {@link #direction}
 * @param m double
 */
public void setNewModule(double m)
	{
		this.setModule(m);
		this.setComponentByModule();
		this.setEnd( this.origin.x + this.i , this.origin.y + this.j  );
	
	}

/**
 * Set the new {@link #origin} coordinates  and calculate the new value of component [{@link #i}, {@link #j}], 
 * and {@link Vettore#end}, this method leaves unchanged {@link #module} and {@link #direction}
 * @param o Point
 */
public void setNewOrigin(Point o)
	{
		this.setOrigin(o.x,o.y);
		this.setComponentByModule();
		this.setEnd( this.origin.x + this.i , this.origin.y + this.j  );
	}

/**
 * Set the new {@link #origin} coordinates and calculate the new value of component [{@link #i}, {@link #j}], 
 * and {@link #end}, this method leaves unchanged {@link #module} and {@link #direction}
 * @param x double
 * @param y double
 */
public void setNewOrigin(double x, double y)
	{
		this.setOrigin(x,y);
		this.setComponentByModule();
		this.setEnd( this.origin.x + this.i , this.origin.y + this.j  );
	}

/**
 * Set the new {@link #origin} X coordinate and calculate the new value of component [{@link #i}, {@link #j}], 
 * and {@link #end}, this methods leaves unchanged {@link #module} and {@link #direction}
 * @param x
 */
public void setNewOriginX(double x)
	{
		
		if (JRif)
			if (x<0)
				x=0;
		this.origin.x=x;
		this.setComponentByModule();
		this.setEnd( this.origin.x + this.i , this.origin.y + this.j  );
		
	}

/**
 * Set the new {@link #origin} Y coordinate and calculate the new value of component [{@link #i}, {@link #j}], 
 * and {@link #end}, this method leaves unchanged {@link #module} and {@link #direction}
 * @param y
 */
public void setNewOriginY(double y)
	{
		if (JRif)
			if (y<0)
				y=0;
		this.origin.y=y;
		this.setComponentByModule();
		this.setEnd( this.origin.x + this.i , this.origin.y + this.j  );
		
		
	}

/**
 * Return true if two <code>Vettore</code> has the same {@link #module} and {@link #direction}
 * @param v2 {@link #Vettore}
 * @return boolean
 */
public boolean equalsTo(Vettore v2)
{ 		
	if ( this.module == v2.getModule() && 
		this.getDirectionDegrees()  ==  v2.getDirectionDegrees() )
	    return true;
	else
		return false;
}

/**
 * Return the <code>Vettore</code> {@link #module}
 * @return {@link #module}
 */
public double getModule(){return this.module;}

public String toString()
{ 
	return
	"\n Origin Coordinates: " + this.origin +
	"\n End Coordinates: "+ this.end +
	"\n Component: " + this.i+"i " + this.j +"j " +
	"\n Direction: " + this.direction +" rad; " + (Math.toDegrees(this.direction)) + "°"+
	"\n Module: " + this.module;
	
}

/**
 * Set the precision parameter {@link #eps}, to represents double values
 * @param p double
 */
public void setPrecision(double p)
{
	eps = Math.abs(p);
}

/**
 * Return the precision parameter {@link #eps}, to represents double values
 * @return precision double {@link #eps}
 */
public double getPrecision(){return eps;}


}//END CLASS



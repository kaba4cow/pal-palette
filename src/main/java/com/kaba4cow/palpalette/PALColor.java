package com.kaba4cow.palpalette;

import java.awt.Color;

/**
 * Represents a single color in the PAL palette.
 */
public class PALColor {

	private int red;
	private int green;
	private int blue;

	/**
	 * Creates a {@code PALColor} with RGB values set to 0 (black).
	 */
	public PALColor() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	/**
	 * Retrieves the red component of this color.
	 *
	 * @return the red component
	 */
	public int getRed() {
		return red;
	}

	/**
	 * Sets the red component of this color.
	 *
	 * @param red the red component
	 * 
	 * @return a reference to this object
	 */
	public PALColor setRed(int red) {
		this.red = red;
		return this;
	}

	/**
	 * Retrieves the green component of this color.
	 *
	 * @return the green component
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * Sets the green component of this color.
	 *
	 * @param green the green component
	 * 
	 * @return a reference to this object
	 */
	public PALColor setGreen(int green) {
		this.green = green;
		return this;
	}

	/**
	 * Retrieves the blue component of this color.
	 *
	 * @return the blue component
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * Sets the blue component of this color.
	 *
	 * @param blue the blue component
	 * 
	 * @return a reference to this object
	 */
	public PALColor setBlue(int blue) {
		this.blue = blue;
		return this;
	}

	/**
	 * Sets the RGB components of this color.
	 *
	 * @param red   the red component
	 * @param green the green component
	 * @param blue  the blue component
	 * 
	 * @return a reference to this object
	 */
	public PALColor set(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		return this;
	}

	/**
	 * Copies the RGB components from another {@code PALColor} instance.
	 *
	 * @param color the {@code PALColor} to copy from
	 * 
	 * @return a reference to this object
	 */
	public PALColor set(PALColor color) {
		return set(color.getRed(), color.getGreen(), color.getBlue());
	}

	/**
	 * Copies the RGB components from an AWT {@link Color} instance.
	 *
	 * @param color the {@link Color} to copy from
	 * 
	 * @return a reference to this object
	 */
	public PALColor set(Color color) {
		return set(color.getRed(), color.getGreen(), color.getBlue());
	}

	/**
	 * Converts this {@code PALColor} to an AWT {@link Color} object.
	 *
	 * @return a {@link Color} instance representing the same RGB values
	 */
	public Color toAWTColor() {
		return new Color(red, green, blue);
	}

	@Override
	public String toString() {
		return String.format("PALColor [%s, %s, %s]", red, green, blue);
	}

}

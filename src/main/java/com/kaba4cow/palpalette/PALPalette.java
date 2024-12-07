package com.kaba4cow.palpalette;

import java.awt.Color;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a PAL palette with colors. This class provides functionality to parse and manipulate PAL file data, including
 * reading from {@link Reader} or {@link String} sources.
 */
public class PALPalette {

	private final List<PALColor> colors;

	/**
	 * Creates an empty PAL palette.
	 */
	public PALPalette() {
		this.colors = new ArrayList<>();
	}

	/**
	 * Creates a PAL palette by parsing data from a {@link Reader} source.
	 *
	 * @param source a reader containing the PAL file data
	 * 
	 * @throws IllegalArgumentException if a parsing error occurs
	 * @throws IOException              if an I/O error occurs
	 */
	public PALPalette(Reader source) throws IOException {
		this();
		PALParser.parse(source, this);
	}

	/**
	 * Creates a PAL palette by parsing data from a {@link String} source.
	 *
	 * @param source a string containing the PAL file data
	 * 
	 * @throws IllegalArgumentException if a parsing error occurs
	 * @throws IOException              if an I/O error occurs
	 */
	public PALPalette(String source) throws IOException {
		this();
		PALParser.parse(source, this);
	}

	/**
	 * Retrieves an unmodifiable list of colors in the palette.
	 *
	 * @return an unmodifiable list of {@link PALColor} objects
	 */
	public List<PALColor> getColors() {
		return Collections.unmodifiableList(colors);
	}

	/**
	 * Converts the list of {@link PALColor} objects to a list of {@link Color} objects compatible with the AWT library.
	 *
	 * @return a {@link List} of {@link Color} objects
	 */
	public List<Color> getAWTColors() {
		return colors.stream().map(PALColor::toAWTColor).collect(Collectors.toList());
	}

	/**
	 * Retrieves the color at the specified index in the palette.
	 *
	 * @param index the index of the color to retrieve
	 * 
	 * @return the {@link PALColor} at the specified index
	 */
	public PALColor getColor(int index) {
		return colors.get(index);
	}

	/**
	 * Adds a new color to the palette.
	 *
	 * @param color the {@link PALColor} to add
	 * 
	 * @return a reference to this object
	 */
	public PALPalette addColor(PALColor color) {
		colors.add(color);
		return this;
	}

	/**
	 * Removes a color from the palette by its index.
	 *
	 * @param index the index of the color to remove
	 * 
	 * @return a reference to this object
	 */
	public PALPalette removeColor(int index) {
		colors.remove(index);
		return this;
	}

	/**
	 * Removes a specific color from the palette.
	 *
	 * @param color the {@link PALColor} to remove
	 * 
	 * @return a reference to this object
	 */
	public PALPalette removeColor(PALColor color) {
		colors.remove(color);
		return this;
	}

	/**
	 * Clears all colors from the palette.
	 *
	 * @return a reference to this object
	 */
	public PALPalette clearColors() {
		colors.clear();
		return this;
	}

	/**
	 * Retrieves the number of colors in the palette.
	 *
	 * @return the number of colors in the palette
	 */
	public int getColorCount() {
		return colors.size();
	}

	/**
	 * Converts the palette to a JASC-PAL format string.
	 *
	 * @return a {@link String} representation of the palette in the JASC-PAL format
	 */
	public String toPALString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JASC-PAL\r\n");
		builder.append("0100\r\n");
		builder.append(colors.size()).append("\r\n");
		for (PALColor color : colors)
			builder.append(String.format("%s %s %s\r\n", color.getRed(), color.getGreen(), color.getBlue()));
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("PALPalette [count=%s, colors=%s]", colors.size(), colors);
	}

}

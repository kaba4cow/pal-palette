package com.kaba4cow.palpalette;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Objects;

/**
 * A utility class for reading PAL data from {@link Reader} or strings and converting it to {@link PALPalette} objects.
 */
public class PALParser {

	private PALParser() {}

	/**
	 * Reads the PAL data from the specified {@link Reader} and converts its contents to an {@link PALPalette} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link PALPalette#clearColors()}
	 * 
	 * @param source the {@link Reader} to read the PAL data from
	 * @param target the {@link PALPalette} to convert the PAL data to, or {@code null}
	 * 
	 * @return the {@link PALPalette} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IllegalArgumentException if a parsing error occurs
	 * @throws IOException              if an I/O error occurs
	 */
	public static PALPalette parse(Reader source, PALPalette target) throws IOException {
		BufferedReader reader = new BufferedReader(source);
		String headerString = reader.readLine();
		if (Objects.isNull(headerString) || !headerString.equals("JASC-PAL"))
			throw new IllegalArgumentException("Invalid file format: header is not provided");
		String versionString = reader.readLine();
		if (Objects.isNull(versionString))
			throw new IllegalArgumentException("Invalid file format: version is not provided");
		String colorCountString = reader.readLine();
		if (Objects.isNull(colorCountString))
			throw new IllegalArgumentException("Invalid file format: color count is not provided");
		String line;
		if (Objects.isNull(target))
			target = new PALPalette();
		else
			target.clearColors();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			if (parts.length != 3)
				throw new IllegalArgumentException("Invalid color format");
			PALColor color = new PALColor();
			color.setRed(Integer.parseInt(parts[0]));
			color.setGreen(Integer.parseInt(parts[1]));
			color.setBlue(Integer.parseInt(parts[2]));
			target.addColor(color);
		}
		reader.close();
		return target;
	}

	/**
	 * Reads the PAL data from the specified string and converts its contents to an {@link PALPalette} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link PALPalette#clearColors()}
	 * 
	 * @param source the string to read the PAL data from
	 * @param target the {@link PALPalette} to convert the PAL data to, or {@code null}
	 * 
	 * @return the {@link PALPalette} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IllegalArgumentException if a parsing error occurs
	 * @throws IOException              if an I/O error occurs
	 */
	public static PALPalette parse(String source, PALPalette target) throws IOException {
		return parse(new StringReader(source), target);
	}

}

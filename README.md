# PAL Palette Library

The PAL Palette Library is a Java utility for working with color palettes in the JASC-PAL format. It provides a simple and flexible way to read, manipulate, and write color palettes, with support for both programmatic color management and file I/O.

## Features

- Parse PAL files from various sources (`Reader`, `String`)
- Create and manipulate color palettes programmatically
- Convert between custom `PALColor` and AWT `Color` objects
- Generate PAL file content as a string
- Flexible color management methods

## Usage

### Creating a Palette

```java
PALPalette palette = new PALPalette();

palette.addColor(new PALColor().set(255, 0, 0))
       .addColor(new PALColor().set(0, 255, 0))
       .addColor(new PALColor().set(0, 0, 255));
```

### Reading a PAL File

```java
try (FileReader reader = new FileReader("colors.pal")) {
    PALPalette palette = new PALPalette(reader);
    
    List<PALColor> colors = palette.getColors();
    PALColor firstColor = palette.getColor(0);
}

String pal = "JASC-PAL\r\n0100\r\n3\r\n255 0 0\r\n0 255 0\r\n0 0 255\r\n";
PALPalette palette = new PALPalette(pal);
```

### Converting Colors

```java
List<Color> colors = palette.getAWTColors();

PALColor color = new PALColor().set(Color.ORANGE);
```

### Converting to PAL Format

```java
String pal = palette.toPALString();
```

### Manipulating the Palette

```java
palette.removeColor(0);

palette.clearColors();

int colorCount = palette.getColorCount();
```

## Error Handling

- `IOException` for I/O errors
- `IllegalArgumentException` for parsing errors
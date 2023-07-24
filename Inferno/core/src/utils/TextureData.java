package utils;

/**
 * Store for texture data - textures in column, row, width & height
 */
public class TextureData {
    private final short texturesInColumn;
    private final short texturesInRow;
    private final short textureWidth;
    private final short textureHeight;
    private final String src;

    // constructor
    public TextureData(short texturesInColumn, short texturesInRow, short textureWidth, short textureHeight, String src) {
        this.texturesInColumn = texturesInColumn;
        this.texturesInRow = texturesInRow;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.src = src;
    }

    // getters
    public short getTextureHeight() {
        return textureHeight;
    }

    public short getTexturesInColumn() {
        return texturesInColumn;
    }

    public short getTexturesInRow() {
        return texturesInRow;
    }

    public short getTextureWidth() {
        return textureWidth;
    }

    public String getSrc() {
        return src;
    }
}


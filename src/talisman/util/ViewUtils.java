package talisman.util;

import talisman.model.board.TalismanCellType;
import talisman.model.cards.CardType;

/**
 * Utility class for generic view related constants and functions.
 * 
 * @author Alberto Arduini
 *
 */
public final class ViewUtils {
    /**
     * The path to the images folder.
     */
    public static final String RESOURCES_PATH = "res/";
    /**
     * The path to the images folder.
     */
    public static final String IMAGES_PATH = "imgs/";
    /**
     * The path to the cells images folder.
     */
    public static final String CELLS_IMAGE_PATH = ViewUtils.IMAGES_PATH + "cells/";
    /**
     * The path to the cards images folder.
     */
    public static final String CARDS_IMAGE_PATH = ViewUtils.IMAGES_PATH + "cards/";

    /**
     * The path to the "image not found" image file as a resource path.
     */
    public static final String NO_IMAGE_NAME = "noimage";
    /**
     * The path to the "image not found" image file as a resource path.
     */
    public static final String DEV_PAWN_IMAGE_NAME = "player_pawn";

    private ViewUtils() {
    }

    /**
     * Constructs the path to a cell image by its properties.
     * 
     * @param type     the type of cell
     * @param name     the name of the cell
     * @param resource should the path start with the resource folder?
     * @return the generated path
     */
    public static String getPathToCell(final TalismanCellType type, final String name, final boolean resource) {
        String path = ViewUtils.CELLS_IMAGE_PATH + type.toString() + "_" + name + ".png";
        if (resource) {
            path = ViewUtils.RESOURCES_PATH + path;
        }
        return path;
    }

    public static String getPathToCard(final CardType type, final String name, final boolean resource) {
        String path = ViewUtils.CARDS_IMAGE_PATH + type.toString() + "_" + name + ".png";
        if (resource) {
            path = ViewUtils.RESOURCES_PATH + path;
        }
        return path;
    }

    /**
     * Gets a developer placeholder texture by its name.
     * 
     * @param imageName the image name
     * @param resource  should the path start with the resource folder?
     * @return the image path
     */
    public static String getDevImagePath(final String imageName, final boolean resource) {
        return ViewUtils.getDevImagePath(imageName, ".png", resource);
    }

    /**
     * Gets a developer placeholder texture by its name and extension.
     * 
     * @param imageName the image name
     * @param extension the image file extension
     * @param resource  should the path start with the resource folder?
     * @return the image path
     */
    public static String getDevImagePath(final String imageName, final String extension, final boolean resource) {
        String path = ViewUtils.IMAGES_PATH + "dev/" + imageName + extension;
        if (resource) {
            path = ViewUtils.RESOURCES_PATH + path;
        }
        return path;
    }
}

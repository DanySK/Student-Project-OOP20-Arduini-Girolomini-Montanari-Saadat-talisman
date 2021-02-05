package talisman.util;

import talisman.model.board.TalismanCellType;

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
    public static final String RESOURCES_PATH = "res//";
    /**
     * The path to the images folder.
     */
    public static final String IMAGES_PATH = "imgs/";
    /**
     * The path to the cells images folder.
     */
    public static final String CELLS_IMAGE_PATH = ViewUtils.IMAGES_PATH + "cells/";
    /**
     * The path to the "image not found" image file as a resource path.
     */
    public static final String NO_IMAGE_PATH = ViewUtils.IMAGES_PATH + "dev/noimage.png";

    private ViewUtils() {
    }

    public static String getPathToCell(final TalismanCellType type, final String name, final boolean resource) {
        String path = ViewUtils.CELLS_IMAGE_PATH + type.toString() + "_" + name + ".png";
        if (resource) {
            path = ViewUtils.RESOURCES_PATH + path;
        }
        return path;
    }
}

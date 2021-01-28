package talisman.model.board;

/**
 * The type of ambient a cell has
 * 
 * @author Alberto Arduini
 *
 */
public enum TalismanCellType {
	/**
	 * The cell contains a monster
	 */
	MONSTER,
	/**
	 * The cell contains a generic ambient (forest, desert, etc.)
	 */
	BIOME, 
	/**
	 * The cell contains a specific ambient (town, cave, etc.)
	 */
	ZONE,
}

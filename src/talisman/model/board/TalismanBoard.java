package talisman.model.board;

import java.util.*;
import java.util.stream.*;

import talisman.util.*;

/**
 * Implements a board for talisman
 * 
 * @author Alberto Arduini
 */
public class TalismanBoard implements PopulatedBoard<TalismanBoardSection, TalismanBoardCell, TalismanBoardPawn> {
	private final List<TalismanBoardSection> sections;
	private final List<TalismanBoardPawn> characterPawns;
	private final Map<TalismanBoardPawn, Pair<Integer, Integer>> pawnPositions;
	/**
	 * Creates a new talisman board
	 * @param sections the sections that the board contains
	 * @param characterPawns the player pawns
	 */
	public TalismanBoard(final List<TalismanBoardSection> sections, final  List<TalismanBoardPawn> characterPawns) {
		super();
		this.sections = sections;
		this.characterPawns = characterPawns;
		this.pawnPositions = this.characterPawns.stream().collect(Collectors.toMap(p -> p, p -> new Pair<>(0, 0)));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TalismanBoardSection getSection(int index) {
		return this.sections.get(index);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void movePawnTo(int playerIndex, int cell) {
		Pair<Integer, Integer> oldPosition = this.pawnPositions.get(this.getPawn(playerIndex));
		this.pawnPositions.replace(this.getPawn(playerIndex), new Pair<>(oldPosition.getX(), cell));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changePawnSection(int playerIndex, int section, int cell) {
		this.pawnPositions.replace(this.getPawn(playerIndex), new Pair<>(section, cell));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TalismanBoardPawn getPawn(int playerIndex) {
		return this.characterPawns.get(playerIndex);
	}
}

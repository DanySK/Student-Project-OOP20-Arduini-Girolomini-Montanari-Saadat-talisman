package talisman.model.board;

public interface PopulatedBoard<S extends BoardSection<C>, C extends BoardCell, P extends BoardPawn> extends Board<S, C> {
	void movePawnTo(final int playerIndex, final int cell);
	void changePawnSection(final int playerIndex, final int section, final int cell);
	P getPawn(final int playerIndex);
}

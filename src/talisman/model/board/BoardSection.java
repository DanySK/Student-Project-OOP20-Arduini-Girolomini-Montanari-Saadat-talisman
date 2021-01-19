package talisman.model.board;

public interface BoardSection<C extends BoardCell> {
	C getCell(int index);
	int getCellPosition(C cell);
}

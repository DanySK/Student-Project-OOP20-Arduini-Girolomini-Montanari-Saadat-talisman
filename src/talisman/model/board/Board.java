package talisman.model.board;

public interface Board <S extends BoardSection<C>, C extends BoardCell> {
	C getCell(int section, int index);
	S getSection(int index);
}

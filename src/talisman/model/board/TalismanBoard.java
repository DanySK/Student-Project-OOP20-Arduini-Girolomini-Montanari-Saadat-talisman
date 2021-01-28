package talisman.model.board;

public class TalismanBoard implements PopulatedBoard<TalismanBoardSection, TalismanBoardCell, TalismanBoardPawn> {
	@Override
	public TalismanBoardCell getCell(int section, int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TalismanBoardSection getSection(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void movePawnTo(int playerIndex, int cell) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changePawnSection(int playerIndex, int section, int cell) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TalismanBoardPawn getPawn(int playerIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}

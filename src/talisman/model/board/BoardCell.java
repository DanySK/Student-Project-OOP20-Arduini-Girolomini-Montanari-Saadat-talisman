package talisman.model.board;

import java.io.Serializable;

public interface BoardCell extends Serializable {
	String getImagePath();
	String getText();
}

package talisman.model.quests;

public class DeliverObject {

    private QuestObjectType objectType;

    public DeliverObject(QuestObjectType objectType){

        this.objectType = objectType;
    }

    public DeliverObject() {

        this.objectType = QuestObjectType.getRandom();
    }

    public QuestObjectType getObjectType(){

        return objectType;
    }

    public String toString(){

        return objectType.toString();
    }

}

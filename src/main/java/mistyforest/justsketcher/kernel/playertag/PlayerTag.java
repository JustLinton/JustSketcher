package mistyforest.justsketcher.kernel.playertag;

import mistyforest.justsketcher.kernel.UIDManager;
import mistyforest.justsketcher.kernel.actiontag.ActionTag;
import mistyforest.justsketcher.kernel.eventtag.EventTag;

import java.util.ArrayList;

public class PlayerTag {
    private String UID;

    private ArrayList<PlayerProps> detailTags;
    private ArrayList<PlayerTag> parentTags;
    private ArrayList<EventTag> eventTags;
    private ArrayList<ActionTag> actionTags;
    private String label;

    public PlayerTag(){
        detailTags=new ArrayList<>();
        eventTags=new ArrayList<>();
        actionTags=new ArrayList<>();
        parentTags=new ArrayList<>();
    }

    public PlayerTag(String label_, ArrayList<PlayerProps> detailTags_, ArrayList<EventTag> eventTags_, ArrayList<ActionTag> actionTags_){
        UID=UIDManager.uidGen();

        detailTags=detailTags_;
        eventTags=eventTags_;
        actionTags=actionTags_;
        parentTags=new ArrayList<>();
        label=label_;
    }

    public static PlayerTag readTag(String input){
        return new PlayerTag();
    }

    public ArrayList<ActionTag> getActionTags() {
        return actionTags;
    }

    public ArrayList<EventTag> getEventTags() {
        return eventTags;
    }

    public ArrayList<PlayerTag> getParentTags() {
        return parentTags;
    }

    public String getLabel() {
        return label;
    }

    public String getUID() {
        return UID;
    }
}

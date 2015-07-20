package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/7/19.
 */

@Entity
@Table(name="Tag_Notes")
public class Tag_Notes extends Model {
    @Required
    public int tagId;
    @Required
    public int noteId;
    public Tag_Notes(){}
    public Tag_Notes(int tagId,int noteId){
        this.noteId = noteId;
        this.tagId = tagId;
    }

}

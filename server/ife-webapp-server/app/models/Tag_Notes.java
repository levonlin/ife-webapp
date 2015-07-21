package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 *标签-笔记表
 *
 * Created by G-bgyl on 2015/7/19.
 */

@Entity
@Table(name="Tag_Notes")
public class Tag_Notes extends Model {
	/**
	 *标签编号（标签表的主键）
	 */
	@column(name = "tagId")
    @Required
    public int tagId;
	
	/**
	 *笔记编号（笔记表的主键）
	 */
	@column(name = "noteId")
    @Required
    public int noteId;
	
    public Tag_Notes(){}
    public Tag_Notes(int tagId,int noteId){
        this.noteId = noteId;
        this.tagId = tagId;
    }

}

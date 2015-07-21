package models;

import com.sun.org.apache.xpath.internal.operations.*;
import com.sun.org.apache.xpath.internal.operations.String;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 *��ǩ��
 *
 * Created by G-bgyl on 2015/7/19.
 */

@Entity
@Table(name="Tag")
public class Tag extends Model {

	/**
	 *��ǩ��
	 */
	@column(name = "tagName")
    @Required
    public String tagName;

    public Tag(){}
    public Tag(String tagName){
        this.tagName = tagName;
    }

}

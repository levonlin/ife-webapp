package models;

import com.sun.org.apache.xpath.internal.operations.*;
import com.sun.org.apache.xpath.internal.operations.String;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/7/19.
 */

@Entity
@Table(name="Tag")
public class Tag extends Model {

    @Required
    public String tagName;//��ǩ��

    public Tag(){}
    public Tag(String tagName){
        this.tagName = tagName;
    }

}

package models;

import play.data.validation.Required;
import play.db.jpa.Model;

//import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * �ʼǷ����
 *
 * Created by G-bgyl on 2015/7/19.
 */


@Entity
@Table(name="Category")
public class Category extends Model {
	
	/**
	 * �ʼ�����
	*/
	@column(name = "noteCategoryName")
    @Required
    public String noteCategoryName;

    public Category(){

    }

    public Category(String noteCategoryName) {
        this.noteCategoryName = noteCategoryName;
    }
}


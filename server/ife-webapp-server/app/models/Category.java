package models;

import play.data.validation.Required;
import play.db.jpa.Model;

//import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/7/19.
 */


@Entity
@Table(name="Category")
public class Category extends Model {
    @Required
    public String noteCategoryName;//± º«¿‡–Õ

    public Category(){

    }

    public Category(String noteCategoryName) {
        this.noteCategoryName = noteCategoryName;
    }
}


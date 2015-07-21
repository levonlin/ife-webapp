package models;

import java.sql.*;
import java.util.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.String;
import play.db.jpa.*;
import play.data.validation.*;

/**
 *
 * 笔记表
 *
 * Created by G-bgyl on 2015/7/19.
 */

@Entity
@Table(name="Notes")
public class Notes extends Model {
	/**
	 *题目
	 */
	@column(name = "noteTitle")
    @Required
    public String noteTitle;
	
	/**
	 *正文
	 */
	@column(name = "noteContent")
    @Required
    public String noteContent;
	
	/**
	 *作者编号（User表的主键）
	 */
	@column(name = "userId")
    @Required
    public String userId;
	
	/**
	 *发布时间
	 */
	@column(name = "noteTime")
    @Required
    public Date noteTime;

	/**
	 *标签名
	 */
	@column(name = "tagName")
    public String tagName;
	
	/**
	 *笔记类型
	 */
	@column(name = "noteCategoryName")
    @Required
    public String noteCategoryName;
	
	/**
	 *笔记类型编号
	 */
	@column(name = "categoryId")
    @Required
    public int categoryId;

    public Notes(){

    }
    public Notes(String noteTitle,String noteContent,String userId,Date noteTime, String tagName,String noteCategoryName,int categoryId){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.userId = userId;
        this.noteTime = noteTime;
        this.tagName = tagName;
        this.noteCategoryName = noteCategoryName;
        this.categoryId = categoryId;
    }

}

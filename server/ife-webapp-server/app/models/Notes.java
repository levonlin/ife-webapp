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
 * �ʼǱ�
 *
 * Created by G-bgyl on 2015/7/19.
 */

@Entity
@Table(name="Notes")
public class Notes extends Model {
	/**
	 *��Ŀ
	 */
	@column(name = "noteTitle")
    @Required
    public String noteTitle;
	
	/**
	 *����
	 */
	@column(name = "noteContent")
    @Required
    public String noteContent;
	
	/**
	 *���߱�ţ�User���������
	 */
	@column(name = "userId")
    @Required
    public String userId;
	
	/**
	 *����ʱ��
	 */
	@column(name = "noteTime")
    @Required
    public Date noteTime;

	/**
	 *��ǩ��
	 */
	@column(name = "tagName")
    public String tagName;
	
	/**
	 *�ʼ�����
	 */
	@column(name = "noteCategoryName")
    @Required
    public String noteCategoryName;
	
	/**
	 *�ʼ����ͱ��
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

package models;

import java.sql.*;
import java.util.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.String;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="Notes")
public class Notes extends Model {

    @Required
    public String noteTitle;//��Ŀ
    @Required
    public String noteContent;//����
    @Required
    public String userId;//���߱�ţ�User���������
    @Required
    public Date noteTime;//����ʱ��

    public String tagName;//��ǩ��tag���������
    @Required
    public String noteCategoryName;//�ʼ�����
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

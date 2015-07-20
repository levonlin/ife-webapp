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
    public String noteTitle;//题目
    @Required
    public String noteContent;//正文
    @Required
    public String userId;//作者编号（User表的主键）
    @Required
    public Date noteTime;//发布时间

    public String tagName;//标签（tag表的主键）
    @Required
    public String noteCategoryName;//笔记类型
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

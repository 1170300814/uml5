package com.yanzhao.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.yanzhao.exception.bookNotExist;
import com.yanzhao.exception.bookNum;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Service
public class book implements bookapi{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private boolean checkBookExist(String bookname){
        List list=jdbcTemplate.queryForList("select bookname from books ");
        for(int i =0;i<list.size();i++)
        {
            Map bookmap= (Map) list.get(i);
            if(bookname.equals(bookmap.get("bookname"))){
                return true;
            }
        }
        return false;
    }

    private boolean checkBookNum(String bookname){
        String sql="select booknumm from books where bookname="+bookname;
        int num=jdbcTemplate.queryForObject(sql,Integer.class);
        if (num>0){
            return true;
        }
        return false;
    }

    private  void checkexist(String bookname) throws bookNotExist{
        if(checkBookExist(bookname)){

        }else {
            throw new bookNotExist("书不存在");
        }
    }

    private  void checknum(String bookname) throws bookNum{
        if(checkBookNum(bookname)){

        }else {
            throw new bookNum("书数量不够");
        }
    }
    @Override
    public void bookbeborrowed(String bookname,String username) {
        try {
            checkexist(bookname);
            checknum(bookname);
            String sql="select booknumm from books where bookname="+bookname;
            int num=jdbcTemplate.queryForObject(sql,Integer.class);
            num--;
            jdbcTemplate.update("update books set booknum=? where bookname=?",num,bookname);
            String sql2="select bookborrowed from users where username="+username;
            String borrowsbooks=jdbcTemplate.queryForObject(sql2,String.class);
            borrowsbooks+=bookname+";";
            jdbcTemplate.update("update users set bookborrowed=? where username=?",borrowsbooks,username);
            System.out.println("成功借书");
        }catch (bookNotExist e){
            System.out.println(e);
        }catch (bookNum e){
            System.out.println(e);
        }


    }

    @Override
    public void bookbeback(String bookname,String username) {

        try {
            checkexist(bookname);
            String sql="select booknumm from books where bookname="+bookname;
            int num=jdbcTemplate.queryForObject(sql,Integer.class);
            num++;
            jdbcTemplate.update("update books set booknum=? where bookname=?",num,bookname);
            String sql2="select bookborrowed from users where username="+username;
            String borrowsbooks=jdbcTemplate.queryForObject(sql2,String.class);
            String[] temp=borrowsbooks.split(";");
            for (int i=0;i<temp.length;i++){
                if(temp[i].equals(bookname)){
                    temp[i]="";
                }
            }
            String finalbook="";
            for (int i=0;i<temp.length;i++){
                finalbook+=temp[i]+";";
            }
            jdbcTemplate.update("update users set bookborrowed=?; where username=?",finalbook,username);
            System.out.println("成功还书");
        }catch (bookNotExist e){
            System.out.println(e);
        }
    }
}

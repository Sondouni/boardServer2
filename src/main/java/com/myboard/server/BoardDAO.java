package com.myboard.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static int updBoard(BoardVO param){
        int result = 0;
        Connection con = null;
        PreparedStatement pre = null;
        String sql = " UPDATE t_board "+
                " SET title=?, writer =? , ctnt = ? "+
                " where iboard = ? ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setString(1,param.getTitle());
            pre.setString(2,param.getWriter());
            pre.setString(3,param.getCtnt());
            pre.setInt(4,param.getIboard());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return result;
    }
    public static int delBoard(BoardVO param){
        int result = 0;
        Connection con = null;
        PreparedStatement pre = null;
        String sql = " DELETE FROM t_board WHERE iboard = ? ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setInt(1,param.getIboard());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return result;
    }

    public static int insBoard(BoardVO param){
        int result= 0;
        Connection con = null;
        PreparedStatement pre = null;
        String sql = " INSERT INTO t_board " +
                " (title,ctnt,writer) " +
                " Values " +
                " (?,?,?) ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setString(1,param.getTitle());
            pre.setString(2,param.getCtnt());
            pre.setString(3,param.getWriter());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return result;
    }
    public static List<BoardVO> selBoardList() {
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_board ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DButils.close(con,pre,rs);
        }
        return list;
    }
    public static BoardVO selBoard(BoardVO param){
        BoardVO ivo = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_board WHERE iboard = ? ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setInt(1,param.getIboard());
            rs = pre.executeQuery();
            if(rs.next()){
                ivo = new BoardVO();
                ivo.setIboard(rs.getInt("iboard"));
                ivo.setTitle(rs.getString("title"));
                ivo.setCtnt(rs.getString("ctnt"));
                ivo.setWriter(rs.getString("writer"));
                ivo.setRdt(rs.getString("rdt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre,rs);
        }
        return ivo;
    }
}

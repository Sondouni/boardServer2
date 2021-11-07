package com.myboard.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upd")
public class UpdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Gson gson = new Gson();
        BoardVO vv =  gson.fromJson(Utils.getJson(req),BoardVO.class);
        int result = BoardDAO.updBoard(vv);
        //todo 실험해보기
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Gson gson = new Gson();
        BoardVO vv =  gson.fromJson(Utils.getJson(req),BoardVO.class);
        int result = BoardDAO.updBoard(vv);
    }
}

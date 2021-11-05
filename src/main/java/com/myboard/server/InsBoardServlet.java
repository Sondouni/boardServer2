package com.myboard.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ins")
public class InsBoardServlet extends HttpServlet {
    private int result;
    private ResultVO rvo;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        rvo.setResult(result);
        PrintWriter out = res.getWriter();
        out.print(new Gson().toJson(rvo));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String json = Utils.getJson(req);
        Gson gson = new Gson();
        BoardVO vo = gson.fromJson(json,BoardVO.class);
        result = BoardDAO.insBoard(vo);
        rvo.setResult(result);
        PrintWriter out = res.getWriter();
        out.print(rvo);

    }
}

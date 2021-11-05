package com.myboard.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class SelBoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain; charset=UTF-8");
        res.setCharacterEncoding("UTF-8");

        List<BoardVO> list = BoardDAO.selBoardList();
        PrintWriter out = res.getWriter();
        out.println(new Gson().toJson(list));
    }
}

package com.qyl.controller.before;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-10-29 18:42
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class ValidateCodeController {
    private final char code[]  ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9'};
    private static final int WIDTH=129;
    private static final int HEIGHT=44;
    private static final int LENGTH=4;
    @RequestMapping("/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response){
        //设置响应报头信息
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        //设置相应的MIME类型
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Font myFont = new Font("Arail",Font.TRUETYPE_FONT,35);
        Graphics g = image.getGraphics();
        Random rd = new Random();
        //设置背景颜色
        g.setColor(new Color(205,205,205));
        g.fillRect(0,0,WIDTH,HEIGHT);
        //设置字体
        g.setFont(myFont);
        //画边框
        g.drawRect(0,0,WIDTH-1,HEIGHT-1);
        //随机产生的验证码
        String result="";
        for(int i = 0 ; i < LENGTH; i++){
            result += code[rd.nextInt(code.length)];
        }
        HttpSession se = request.getSession();
        se.setAttribute("code",result);
        //画验证码
        for(int i = 0 ; i < result.length();i++){
            g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt( 200)));
            g.drawString(result.charAt(i)+"",23*i+1,40);
        }
        //随机产生两个干扰线
        for(int i = 0 ; i < 2 ; i++){
            g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt(200)));
            int x1 = rd.nextInt(WIDTH);
            int x2 = rd.nextInt(WIDTH);
            int y1 = rd.nextInt(LENGTH);
            int y2 = rd.nextInt(LENGTH);
            g.drawLine(x1,y1,x2,y2);
        }
        //释放图形资源
        g.dispose();
        try{
            OutputStream os = response.getOutputStream();
            //输出图象到页面
            ImageIO.write(image,"JPEG",os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
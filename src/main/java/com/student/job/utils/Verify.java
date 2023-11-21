package com.student.job.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Verify  {
	//把随机生成的验证码图片对应的答案存入session域，并命名为vCode
	public static void getVerify(HttpServletRequest request  ,HttpServletResponse response) throws IOException{
		
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		VerifyCode.output(image, response.getOutputStream());
		request.getSession().setAttribute("vCode", vc.getText());
	}
	
}

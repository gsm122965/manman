package org.yhxz.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;



/**
 * Servlet implementation class Sample
 */
/*
@WebServlet("/Sample")
*/
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;
	String sToken = "5XaQ8cG6x2pULd";//���Token��������ɣ����Ǳ������ҵ���ϵ���ͬ
	String sCorpID = "wxd35235b57cbf6705";//����������ҵ�ŵ�CorpID
	String sEncodingAESKey = "jWmYm7qjusnxu65ZRjGtBxmz3KA1tkAj3ykkR6q2B2C";
    /**
     * Default constructor. 
     */
    public Sample() {
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

    	// ΢�ż���ǩ�� 
    	String sVerifyMsgSig = request.getParameter("msg_signature");
    	// ʱ���
    	String sVerifyTimeStamp = request.getParameter("timestamp");
    	// �����
    	String sVerifyNonce = request.getParameter("nonce");
    	// ����ַ���
    	String sVerifyEchoStr = request.getParameter("echostr");
    	String sEchoStr; //��Ҫ���ص�����
    	PrintWriter out = response.getWriter();  
    	WXBizMsgCrypt wxcpt;
    	try {
    	wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
    	sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,sVerifyNonce, sVerifyEchoStr);
    	// ��֤URL�ɹ�����sEchoStr����
    	out.print(sEchoStr);  
    	} catch (AesException e1) {
    	e1.printStackTrace();
    	}
    	}

    	/**
    	 * ����΢�ŷ�������������Ϣ
    	 */
    	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO ��Ϣ�Ľ��ա�������Ӧ
    	}

    }


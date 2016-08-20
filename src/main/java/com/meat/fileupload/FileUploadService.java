package com.meat.fileupload;

/*package com.hungry.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.json.me.JSONException;
import org.json.me.JSONObject;
import org.springframework.stereotype.Service;

import com.eelectrikals.payment.PaymentGatewayController;



@Service
public final class FileUploadService {
	protected static Logger logger = Logger.getLogger("service"+FileUploadService.class);


	public String create(String deed,HttpServletRequest request){
		Validate.notNull(deed, "deed Object shouldn't be null");

		ServletContext servletContext = request.getSession().getServletContext();
		System.out.println("scont"+servletContext);
		logger.info("scont"+servletContext);
		String relativeWebPath = "resources/images/";
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		//File file = new File(absoluteDiskPath, "imagetosave.jpg");

		logger.info("real path"+absoluteDiskPath);
		   String  i="123";

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(deed);

			String d=jsonObject.getString("deedPhoto");
			String[] str_array = d.split(",");
			String stringa = str_array[0];
			String stringb = str_array[1];

			ServletContext servletContext = request.getSession().getServletContext();
			String relativeWebPath = "img/image.png";
			String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
			//File file = new File(absoluteDiskPath, "imagetosave.jpg");

logger.info("real path"+absoluteDiskPath);

			 String workingDir = System.getProperty("user.dir");
			   System.out.println("Current working directory : " + workingDir);

			 try{
		           // FileOutputStream fos = new FileOutputStream("F:/V/"+jsonObject.getString("deedPhoto"));
		            System.out.println("hai path"+"F:/V/images/"+jsonObject.getString("deedPhoto"));

		            byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(stringb);
		           // File of = new File("F:/V/images/"+"_"+"thumb"+"_"+i+"_"+"ram.jpeg");
		          // File of = new File(absoluteDiskPath+"/"+"_"+"thumb"+"_"+i+"_"+"ram.jpeg");
		           String loc="C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/images/";


				File of = new File(loc+i+"_"+"ram.jpeg");

		           // File of = new File("http://localhost:8080/64deeds/html/"+"_"+"thumb"+"_"+ randomString(PASSWORD_LENGTH)+"_"+"ram.jpeg");



		            FileOutputStream osf = new FileOutputStream(of);
		            osf.write(btDataFile);
		            osf.flush();


		        }catch(Exception e){
		            e.printStackTrace();
		        }


			 System.out.println("hai da"+"F:/V/images/"+jsonObject.getString("deedPhoto"));


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//deed1=deedDAO.create(deed1);
		String deed1="sucess";


		return deed1.toString();
	}


}
 */
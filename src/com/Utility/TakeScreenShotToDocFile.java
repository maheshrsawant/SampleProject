package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class TakeScreenShotToDocFile {

	public static String DocPATH = System.getProperty("user.dir") +"/test-output/ExtendReports/FailureScreenShotsDocument.doc";
	
    public static void captureScreenShotInDoc() {
        try {

            XWPFDocument docx = new XWPFDocument();
            XWPFRun run = docx.createParagraph().createRun();
            FileOutputStream out = new FileOutputStream(DocPATH);

            for(int i=0; i<TestNGCreation.failureScreenshotpath.length; i++)
            {
	            if(TestNGCreation.failureScreenshotpath[i]!=null)	
	            {
		            captureScreenShot(docx, run, out, TestNGCreation.failureScreenshotpath[i], TestNGCreation.stringInDocument[i]);
		            TimeUnit.SECONDS.sleep(1);
	            }
	            else
	            	continue;
	         
            }

            docx.write(out);
            out.flush();
            out.close();
            docx.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out, String path, String text) throws Exception {

        try {
			InputStream pic = new FileInputStream(path);
			run.addBreak();
			run.setText(text);
			run.setFontSize(13);
			run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, path, Units.toEMU(530), Units.toEMU(300));
			pic.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Screenshot path not found");
		}
	
    }

	public static void getMemory() {
		// TODO Auto-generated method stub
    	Runtime runtime = Runtime.getRuntime();
    	long freeMemory = runtime.freeMemory();
 
    	System.out.println("Free Memory: "+freeMemory);

	}

}
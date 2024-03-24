package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileUtil {
	
	//파일 업로드 
	//HttpServletRequest = 클라이언트가 서버로 보낸 요청
	public static String uploadFile(HttpServletRequest req, String sDirectory) 
			throws ServletException, IOException {
		//Part 객체를 통해 서버로 전송된 파일명 읽어오기 
		Part part = req.getPart("ofile");					
		 
		//Part 객체의 헤더값 중 content-disposition 읽어오기
		//content-disposition attachment : 파일 저장하도록 요청
		//content-disposition inline : 파일 페이지내에서 보이도록 요청
        String partHeader = part.getHeader("content-disposition");
        //content-disposition형식 => form-data; name="여기선ofile(input Name)"; filename="파일명.jpg"
        System.out.println("partHeader="+ partHeader);
         
        //헤더값에서 파일명 잘라내기
        //filename= 기준으로 두 개로 분할 
        //"filename=" 이 부분은 어디에도 포함안됨
        String[] phArr = partHeader.split("filename=");
        String originalFileName = phArr[1].trim().replace("\"", "");
		
		//전송된 파일 이름이 비어있지 않다면 디렉토리에 저장
        //File.separator 파일 경로의 구분자를 나타내는 문자열
		if (!originalFileName.isEmpty()) {				
			part.write(sDirectory+ File.separator +originalFileName);
		}
		 
		//원본 파일명 반환
		return originalFileName;			
	}
	 
	//파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		//원본파일의 확장자 잘라내기
		String ext = fileName.substring(fileName.lastIndexOf("."));
		//날짜 및 시간을 통해 파일명 생성
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		//"날짜_시간.확장자" 형태의 새로운 파일명 생성
		String newFileName = now + ext;  

		//기존 파일명을 새로운 파일명으로 변경
		File oldFile = new File(sDirectory + File.separator + fileName);
	    File newFile = new File(sDirectory + File.separator + newFileName);
	    oldFile.renameTo(newFile);
	    
	    //변경된 파일명 반환
	    return newFileName;
	}
	
	
	//multiple 속성 추가로 2개 이상의 파일 업로드
		public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory)
				throws ServletException, IOException {
			//파일명 저장을 위한 컬렉션 생성
			ArrayList<String> listFileName = new ArrayList<>();
		
			//Part 객체를 통해 서버로 전송된 파일명 읽어오기 
			Collection<Part> parts = req.getParts();
			for(Part part : parts) {
				//파일이 아니라면 업로드의 대상이 아니므로 무시
				if(!part.getName().equals("ofile"))
					continue;	
				
				//Part 객체의 헤더값 중 content-disposition 읽어오기 
		        String partHeader = part.getHeader("content-disposition");
		        //출력결과 => form-data; name="attachedFile"; filename="파일명.jpg"
		        System.out.println("partHeader="+ partHeader);
		        
		        //헤더값에서 파일명 잘라내기
		        String[] phArr = partHeader.split("filename=");
		        String originalFileName = phArr[1].trim().replace("\"", "");
				
				//전송된 파일이 있다면 디렉토리에 저장
				if (!originalFileName.isEmpty()) {				
					part.write(sDirectory+ File.separator +originalFileName);
				}
				
				//컬렉션에 추가
				listFileName.add(originalFileName);
			}
		
			//원본 파일명 반환
			return listFileName;			
		}
}

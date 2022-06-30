package com.humintec.poc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.humintec.poc.dto.BoardDTO;


@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "C:\\Users\\220302_humintec\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\humintecMVC\\src\\main\\webapp\\resources\\img\\"; // 파일이 저장될 위치
	
	public List<Map<String, Object>> parseInsertFileInfo(BoardDTO boardDTO, 
			MultipartHttpServletRequest mpRequest) throws Exception{
		
		/*
			Iterator은 데이터들의 집합체? 에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
			List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
			Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
		*/
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String orgfilename = null;
		String originalFileExtension = null;
		String stofilename = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int bno = boardDTO.getBno();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				orgfilename = multipartFile.getOriginalFilename();
				originalFileExtension = orgfilename.substring(orgfilename.lastIndexOf("."));
				stofilename = getRandomString() + originalFileExtension;
				
				file = new File(filePath + stofilename);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("BNO", bno);
				listMap.put("ORGFILENAME", orgfilename);
				listMap.put("STOFILENAME", stofilename);
				listMap.put("FILESIZE", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
	public List<Map<String, Object>> parseUpdateFileInfo(BoardDTO boardDTO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception{ 
		Iterator<String> iterator = mpRequest.getFileNames();
		MultipartFile multipartFile = null; 
		String orgfilename = null; 
		String originalFileExtension = null; 
		String stofilename = null; 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null; 
		int bno = boardDTO.getBno();
		while(iterator.hasNext()){ 
			multipartFile = mpRequest.getFile(iterator.next()); 
			if(multipartFile.isEmpty() == false){ 
				orgfilename = multipartFile.getOriginalFilename(); 
				originalFileExtension = orgfilename.substring(orgfilename.lastIndexOf(".")); 
				stofilename = getRandomString() + originalFileExtension; 
				multipartFile.transferTo(new File(filePath + stofilename)); 
				listMap = new HashMap<String,Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("BNO", bno); 
				listMap.put("ORGFILENAME", orgfilename);
				listMap.put("STOFILENAME", stofilename); 
				listMap.put("FILESIZE", multipartFile.getSize()); 
				list.add(listMap); 
			} 
		}
		if(files != null && fileNames != null){ 
			for(int i = 0; i<fileNames.length; i++) {
					listMap = new HashMap<String,Object>();
                    listMap.put("IS_NEW", "N");
					listMap.put("FNO", files[i]); 
					list.add(listMap); 
			}
		}
		return list; 
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
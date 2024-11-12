package kdt.fullstack.project.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kdt.fullstack.project.domain.BoxOfficeDTO;
import kdt.fullstack.project.domain.DetailDTO;
import kdt.fullstack.project.domain.MovieDto;
import kdt.fullstack.project.service.Project_Service;



@RestController
@RequestMapping("/mv")
@CrossOrigin(origins = "http://localhost:3000") 
public class Project_ctrl {
    
    @Autowired
    private Project_Service project_Service;

    @Value("${openApi.boxKey}")
    private String boxKey;
    @Value("${openApi.boxUrl}")
    private String boxUrl;
    @Value("${openApi.search}")
    private String search;
    @Value("${openApi.code}")
    private String code;
    @Value("${openApi.weeklyBox}")
    private String weeklyBox;

    @Value("${openApi.posterKey}")
    private String  posterKey;
    @Value("${openApi.posterUrl}")
    private String  posterUrl;
    @Value("${openApi.dataType}")
    private String dataType ;
    
    @PostMapping("/specifics")
    public ResponseEntity<Object> specifics(@RequestBody String input){

        StringBuilder title = new StringBuilder(input);
        if(title.length()>0){
            title.deleteCharAt(input.length()-1);
        }

        System.out.println(title);

        String requsetURL =posterUrl+"&detail=Y&title="+title+"&ServiceKey="+posterKey;
        String comUrl =boxUrl+code+"key="+boxKey+"&movieNm="+title;

        System.out.println(requsetURL);
        System.out.println(comUrl);

        HttpURLConnection http = null ;
        InputStream       stream = null ;
        String            result = null;
        List<MovieDto>    list = null;

        try {
            URL url = new URL(requsetURL);
            http = (HttpURLConnection)url.openConnection();
            System.out.println("http connection = " + http);
            
            int code = http.getResponseCode();
            System.out.println("http response code = " + code);
            if(code == 200){
                stream = http.getInputStream();
                result = readString(stream);
                list = project_Service.parsingJson(result);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (http != null) {
                http.disconnect();  // 연결 해제
            }
        }

        System.out.println("final result list = "+list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/details")
    public ResponseEntity<Object> getDetails(@RequestBody DetailDTO data) {
        System.out.println(data);

        String title = data.getTitle().replaceAll("\\s+", "");
        String encodedTitle = null;
        try {
            encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } 

        String release = data.getRelease();
        String requsetURL =posterUrl+"&detail=Y&title="+encodedTitle+"&releaseDts="+release+"&ServiceKey="+posterKey;
        
        System.out.println(requsetURL);

        HttpURLConnection detail_http = null ;
        InputStream       detail_stream = null ;
        String            detail_result = null;
        MovieDto    detail_list = null;

        try {
            URL detail_url = new URL(requsetURL);
            detail_http = (HttpURLConnection)detail_url.openConnection();
            System.out.println("http connection = " + detail_http);
            
            int detail_code = detail_http.getResponseCode();
            System.out.println("http response code = " + detail_code);
            // if(detail_code == 200){
                detail_stream = detail_http.getInputStream();
                detail_result = readString(detail_stream);
                detail_list = project_Service.parsingJson_details(detail_result);
            // } else {

            // }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (detail_http != null) {
                detail_http.disconnect();  // 연결 해제
            }
        }

        System.out.println("final result list = "+detail_list);
        return new ResponseEntity<>(detail_list, HttpStatus.OK);
    }
    
    @GetMapping("/boxOffice")
    public ResponseEntity<Object> getBoxOffice() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String boxOfficeURL =boxUrl+weeklyBox+"key="+boxKey+"&weekGb=0&targetDt="+oneWeekAgo.format(formatter);
        System.out.println("boxOfficeList >>> "+ boxOfficeURL);

        HttpURLConnection box_http = null ;
        InputStream       box_stream = null ;
        String            box_result = null;
        List<BoxOfficeDTO>    box_list = null;

        try {
            URL url = new URL(boxOfficeURL);
            box_http = (HttpURLConnection)url.openConnection();
            System.out.println("http connection = " + box_http);
            
            int code = box_http.getResponseCode();
            System.out.println("http response code = " + code);
            if(code == 200){
                box_stream = box_http.getInputStream();
                box_result = readString(box_stream);
                box_list = project_Service.parsingJson_BoxOffice(box_result);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (box_http != null) {
                box_http.disconnect();  // 연결 해제
            }
        }

        // System.out.println("final result list = "+box_list);
        return new ResponseEntity<>(box_list, HttpStatus.OK);
    }

    @PutMapping("/slides")
    public ResponseEntity<Object> Slides(@RequestParam(value = "title")      String title,
                                         @RequestParam(value = "releaseDts") String releaseDts) {

        String SlideUrl =posterUrl+"&detail=Y&title="+title+"&releaseDts"+releaseDts+"&ServiceKey="+posterKey;
        System.out.println(SlideUrl);
        return null;
    }
    
    

    public String readString(InputStream stream) throws IOException{
        System.out.println("readString");
        BufferedReader br = new BufferedReader( new InputStreamReader(stream, "UTF-8") ) ;  
        String input = null;
        StringBuilder result = new StringBuilder();
        while( (input = br.readLine() ) != null){
            result.append(input + "\n\r");
        }
        br.close();
        return result.toString();
    }
}

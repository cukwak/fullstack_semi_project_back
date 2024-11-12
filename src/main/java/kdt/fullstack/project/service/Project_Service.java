
package kdt.fullstack.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kdt.fullstack.project.domain.BoxItems;
import kdt.fullstack.project.domain.BoxOfficeDTO;
import kdt.fullstack.project.domain.Items;
import kdt.fullstack.project.domain.MovieDto;

@Service
public class Project_Service {
    public List<MovieDto> parsingJson(String str){

        ObjectMapper mapper = new ObjectMapper();

        List<MovieDto> list = null;
        try {
            Items items = mapper.readValue(str, Items.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+items);
            System.out.println("");
            list = items.getItems();
            System.out.println("service parsing json items ," + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    };


    public List<BoxOfficeDTO> parsingJson_BoxOffice(String str){

        ObjectMapper mapper = new ObjectMapper();
        

        List<BoxOfficeDTO> list = null;
        try {
            BoxItems boxItems = mapper.readValue(str, BoxItems.class);
            System.out.println("");
            list = boxItems.getBoxItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public MovieDto parsingJson_details(String str){

        ObjectMapper mapper = new ObjectMapper();

        List<MovieDto> list = null;
        MovieDto mvdt = null;
        try {
            Items items = mapper.readValue(str, Items.class);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+items);
            System.out.println("");
            list = items.getItems();
            mvdt = list.get(0);
            System.out.println("service parsing json items ," + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mvdt;
    };


}
